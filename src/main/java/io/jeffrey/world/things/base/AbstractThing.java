package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

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
