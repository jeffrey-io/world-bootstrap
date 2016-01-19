package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.history.HistoryEditTrap;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.IdentityPart;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.ObjectDataMap;

public class AbstractThing {
  protected final LinkedDataMap                  data;

  public final Document                          document;
  protected final EditingPart                    editing;
  protected final IdentityPart                   identity;
  private final HashMap<String, ArrayList<Part>> parts;
  private long                                   sequencer;

  /**
   * @param document
   *          the owner of all things
   * @param node
   *          where the data lives
   */
  public AbstractThing(final Document document, final ObjectDataMap node) {
    this.document = document;
    data = new LinkedDataMap(node);
    parts = new HashMap<>();
    identity = new IdentityPart(data);
    register("identity", identity);
    editing = new EditingPart(data);
    register("editing", editing);
    sequencer = 0;
  }

  @SuppressWarnings("unchecked")
  public <T> Set<T> collect(final Class<T> clazz) {
    final HashSet<T> result = new HashSet<>();
    walk(part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.add((T) part);
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collect(final Class<T> clazz, final Function<T, O> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.add(collector.apply((T) part));
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T> Set<T> collect(final String key, final Class<T> clazz) {
    final HashSet<T> result = new HashSet<>();
    walk(key, part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.add((T) part);
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collect(final String key, final Class<T> clazz, final Function<T, O> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(key, part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.add(collector.apply((T) part));
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collectAndMerge(final Class<T> clazz, final Function<T, Collection<O>> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.addAll(collector.apply((T) part));
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collectAndMerge(final String key, final Class<T> clazz, final Function<T, Collection<O>> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(key, part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        result.addAll(collector.apply((T) part));
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collectAndMergeOverArray(final Class<T> clazz, final Function<T, O[]> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        for (final O o : collector.apply((T) part)) {
          result.add(o);
        }
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T, O> Set<O> collectAndMergeOverArray(final String key, final Class<T> clazz, final Function<T, O[]> collector) {
    final HashSet<O> result = new HashSet<>();
    walk(key, part -> {
      if (clazz.isAssignableFrom(part.getClass())) {
        for (final O o : collector.apply((T) part)) {
          result.add(o);
        }
      }
    });
    return result;
  }

  @SuppressWarnings("unchecked")
  public <T> T first(final Class<T> clazz) {
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        if (clazz.isAssignableFrom(part.getClass())) {
          return (T) part;
        }
      }
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public <T> T first(final String key, final Class<T> clazz) {
    final ArrayList<Part> list = parts.get(key);
    if (list == null) {
      return null;
    }
    for (final Part part : list) {
      if (clazz.isAssignableFrom(part.getClass())) {
        return (T) part;
      }
    }
    return null;
  }

  /**
   * @return all actions available given the current state of the thing
   */
  public Set<String> getActionsAvailable() {
    final TreeSet<String> actions = new TreeSet<>();
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        part.list(actions);
      }
    }
    return actions;
  }

  /**
   * @return the unique id for the things
   */
  public String getID() {
    return identity.getID();
  }

  /**
   * @param withHistory
   *          if true, then any changes will be captured to the history
   * @return a map containing a model of the data that will allow for editing
   */
  public Map<String, Edit> getLinks(final boolean withHistory) {
    if (withHistory) {
      final HashMap<String, Edit> actualLinks = new HashMap<>();
      for (final Entry<String, Edit> link : data.getLinks().entrySet()) {
        actualLinks.put(link.getKey(), new HistoryEditTrap(link.getValue(), document.history, this));
      }
      return actualLinks;
    } else {
      return data.getLinks();
    }
  }

  /**
   * @return the metaclass; this allows for scripting to find this thing
   */
  public String getMetaclass() {
    return identity.metaclass.value();
  }

  /**
   * @return the name of the item
   */
  public String getName() {
    return identity.name.value();
  }

  /**
   * @return a sequencer to be able to know if there are new things in the image
   */
  public long getSequencer() {
    return sequencer;
  }

  /**
   * perform the given action
   *
   * @param action
   *          the action to perform
   * @param withHistory
   *          should the results be record to history
   * @return
   */
  public SharedActionSpace invokeAction(final String action, final boolean withHistory) {
    if (withHistory) {
      document.history.register(this);
    }
    final SharedActionSpace sharedActionSpace = new SharedActionSpace();
    walk(part -> part.act(action, sharedActionSpace));
    if (withHistory) {
      document.history.capture();
    }
    return sharedActionSpace;
  }

  /**
   * add the part to the thing
   *
   * @param key
   *          the keyspace for the thing (there may be multiple parts per key)
   * @param part
   *          the part
   */
  protected synchronized <T extends Part> void register(final String key, final T part) {
    sequencer++;
    ArrayList<Part> subkey = parts.get(key);
    if (subkey == null) {
      subkey = new ArrayList<>();
      parts.put(key, subkey);
    }
    subkey.add(part);
  }

  /**
   * save the data from things thing to the given map
   *
   * @param object
   *          the data container
   */
  public void saveTo(final Map<String, String> object) {
    final Map<String, Edit> myLinks = data.getLinks();
    for (final String key : myLinks.keySet()) {
      object.put(key, myLinks.get(key).getAsText());
    }
  }

  /**
   * @return is the thing selected?
   */
  public boolean selected() {
    return editing.selected.value();
  }

  /**
   * invoke update on all the parts
   */
  public void update() {
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        part.update();
      }
    }
  }

  /**
   * apply the consumer to every part
   *
   * @param consumer
   *          the consumer that will touch every part
   */
  public void walk(final Consumer<Part> consumer) {
    for (final ArrayList<Part> list : parts.values()) {
      for (final Part part : list) {
        consumer.accept(part);
      }
    }
  }

  /**
   * apply the consumer to only parts in the given key
   *
   * @param key
   *          the keyspace to walk
   * @param consumer
   *          the consumer that will touch every part in the given keyspace
   */
  public void walk(final String key, final Consumer<Part> consumer) {
    final ArrayList<Part> subkey = parts.get(key);
    if (subkey == null) {
      return; // we are done, nothing to do
    }
    for (final Part p : subkey) {
      consumer.accept(p);
    }
  }
}
