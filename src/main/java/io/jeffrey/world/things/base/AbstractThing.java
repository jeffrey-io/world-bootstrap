package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;

public class AbstractThing {
  protected final LinkedDataMap                  data;
  protected final Document                       document;
  private final HashMap<String, ArrayList<Part>> parts;

  public AbstractThing(final Document document, final ThingData node) {
    this.document = document;
    data = new LinkedDataMap(node);
    parts = new HashMap<>();
  }

  public <T, O> Set<O> collect(final Class<T> clazz, final Function<T, Collection<O>> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(part -> {
      if (part.getClass().isInstance(clazz)) {
        result.addAll(collector.apply((T) part));
      }
    });
    return result;
  }

  public Set<String> getActionsAvailable() {
    final TreeSet<String> actions = new TreeSet<>();
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        part.list(actions);
      }
    }
    return actions;
  }

  public SharedActionSpace invokeAction(final String action) {
    final SharedActionSpace sharedActionSpace = new SharedActionSpace();
    walk(part -> part.act(action, sharedActionSpace));
    return sharedActionSpace;
  }

  protected synchronized <T extends Part> void register(final String key, final T part) {
    ArrayList<Part> subkey = parts.get(key);
    if (subkey == null) {
      subkey = new ArrayList<>();
      parts.put(key, subkey);
    }
    if (part.unique() && subkey.size() != 0) {
      throw new IllegalStateException("there is already a part defined for " + key);
    }
    subkey.add(part);
  }

  public void update() {
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        part.update();
      }
    }
  }

  public void walk(final Consumer<Part> consumer) {
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        consumer.accept(part);
      }
    }
  }

  @SuppressWarnings("unchecked")
  public <T extends Part> void walk(final String key, final Consumer<T> consumer) {
    final ArrayList<Part> subkey = parts.get(key);
    if (subkey == null) {
      return; // we are done, nothing to do
    }
    for (final Part p : subkey) {
      consumer.accept((T) p);
    }
  }
}
