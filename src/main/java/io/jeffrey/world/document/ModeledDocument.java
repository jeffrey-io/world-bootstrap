package io.jeffrey.world.document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;

import io.jeffrey.world.document.history.History;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.zer.Notifications;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.plugin.Model;

/**
 * Stores all the data for the document, and provides mechanisms for interacting with the data for scripting
 *
 * @author jeffrey
 *
 */
public class ModeledDocument implements Model {
  private final Map<String, Map<String, Edit>>  cachedModel;
  public final Map<String, MetaClass>           classes;
  public final History                          history;
  public final Map<String, LayerProperties>     layers;
  protected final ObjectMapper                  mapper = new ObjectMapper();

  public final Notifications                    notifications;
  public final Map<String, Map<String, String>> templates;

  protected final ArrayList<Thing>              things;

  public ModeledDocument() {
    history = new History();
    classes = new TreeMap<>();
    things = new ArrayList<>();
    layers = new TreeMap<>();
    layers.put("_", new LayerProperties("_", "Foreground"));
    classes.put("_", new MetaClass("_", "Default"));
    cachedModel = new HashMap<String, Map<String, Edit>>();
    notifications = new Notifications();
    templates = new HashMap<String, Map<String, String>>();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void begin() {
    cachedModel.clear();
    for (final Thing thing : things) {
      history.register(thing);
      cachedModel.put(thing.id(), thing.getLinks(false));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void end() {
    cachedModel.clear();
    history.capture();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getJson(final String query) {
    try {
      final List<Query> parsed = Query.parse(query);
      Map<String, Map<String, Edit>> result = cachedModel;
      boolean expectingSingleton = true;
      for (final Query part : parsed) {
        if (!part.singleton) {
          expectingSingleton = false;
        }
        result = part.applyAsFilter(result);
      }
      return jsonify(result, expectingSingleton);
    } catch (final Exception failure) {
      notifications.println(failure, "unable to perform query:", query);
      throw new RuntimeException(failure);
    }
  }

  @Override
  public String invokeAndReturnJson(final String query, final String method) {
    try {
      Collection<Thing> result = things;
      final List<Query> parsed = Query.parse(query);
      for (final Query part : parsed) {
        result = part.applyAsFilter(result);
      }
      final HashMap<String, Object> toJson = new HashMap<>();
      for (final Thing thing : result) {
        toJson.put(thing.id(), thing.invoke(method));
      }
      return mapper.writeValueAsString(toJson);
    } catch (final Exception failure) {
      notifications.println(failure, "unable to perform query:", query);
      throw new RuntimeException(failure);
    }
  }

  /**
   * Helper function to convert the state of the filter into a JSON string
   */
  private String jsonify(final Map<String, Map<String, Edit>> data, final boolean expectingSingleton) throws Exception {
    final Map<String, Map<String, String>> resolved = new HashMap<String, Map<String, String>>();
    for (final Entry<String, Map<String, Edit>> entry : data.entrySet()) {
      final HashMap<String, String> newValue = new HashMap<String, String>();
      for (final Entry<String, Edit> entry2 : entry.getValue().entrySet()) {
        newValue.put(entry2.getKey(), entry2.getValue().getAsText());
      }
      resolved.put(entry.getKey(), newValue);
    }

    if (resolved.size() == 0) {
      return "null";
    }

    if (resolved.size() == 1 && expectingSingleton) {
      final Map<String, String> singleton = resolved.values().iterator().next();
      if (singleton.size() == 1) {
        return mapper.writeValueAsString(singleton.values().iterator().next());
      } else {
        return mapper.writeValueAsString(singleton);
      }
    }

    return mapper.writeValueAsString(resolved);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void put(final String query, final String value) {
    final List<Query> parsed = Query.parse(query);
    Map<String, Map<String, Edit>> result = cachedModel;
    for (final Query part : parsed) {
      result = part.applyAsFilter(result);
    }
    for (final Map<String, Edit> items : result.values()) {
      for (final Edit ed : items.values()) {
        ed.set(value);
      }
    }
  }
}
