package io.jeffrey.world.document;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.codehaus.jackson.map.ObjectMapper;

import io.jeffrey.world.WorldData;
import io.jeffrey.world.data.Edit;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.Notifications;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.meta.WorldFileSystem;
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
  public final Container                        container;

  protected final ObjectMapper                  mapper = new ObjectMapper();
  public final Notifications                    notifications;
  public final Map<String, Map<String, String>> templates;

  public ModeledDocument(final Camera camera, final WorldData owner) {
    classes = new TreeMap<>();

    classes.put("_", new MetaClass("_", "Default"));
    cachedModel = new HashMap<String, Map<String, Edit>>();
    notifications = new Notifications();
    templates = new HashMap<String, Map<String, String>>();

    final WorldFileSystem fs = new WorldFileSystem() {
      @Override
      public File find(final String path) {
        final File direct = new File(path);
        if (direct.exists()) {
          return direct;
        }
        return new File(owner.path().resolve(path));
      }

      @Override
      public String normalize(final File input) {
        final String result = owner.path().relativize(input.toURI()).getPath();
        return result;
      }
    };

    container = new Container(camera, fs);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void begin() {
    cachedModel.clear();
    for (final AbstractThing thing : container) {
      container.history.register(thing);
      cachedModel.put(thing.getID(), thing.getLinks(false));
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void end() {
    cachedModel.clear();
    container.history.capture();
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
      Collection<AbstractThing> result = new ArrayList<>();
      for (final AbstractThing thing : container) {
        result.add(thing);
      }
      final List<Query> parsed = Query.parse(query);
      for (final Query part : parsed) {
        result = part.applyAsFilter(result);
      }
      final HashMap<String, Object> toJson = new HashMap<>();
      for (final AbstractThing thing : result) {
        toJson.put(thing.getID(), thing.invokeAction(method, false));
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
        ed.setByText(value);
      }
    }
  }
}
