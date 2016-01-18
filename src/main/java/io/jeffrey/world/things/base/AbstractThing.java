package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;

public class AbstractThing {
  protected final Document document;
  protected final LinkedDataMap data;
  private final HashMap<String, ArrayList<Part>> parts;
  

  public AbstractThing(Document document, final ThingData node) {
    this.document = document;
    this.data = new LinkedDataMap(node);
    this.parts = new HashMap<>();
  }
  
  protected synchronized <T extends Part> void register(String key, T part) {
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

  @SuppressWarnings("unchecked")
  public <T extends Part> void walk(String key, Consumer<T> consumer) {
    ArrayList<Part> subkey = parts.get(key);
    if (subkey == null) {
      return; // we are done, nothing to do
    }
    for (Part p : subkey) {
      consumer.accept((T) p);
    }
  }
}
