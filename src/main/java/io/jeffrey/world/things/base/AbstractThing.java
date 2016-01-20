package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.history.HistoryEditTrap;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasInternalStateThatMayNeedManualUpdating;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.IdentityPart;
import io.jeffrey.world.things.parts.LifetimePart;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.ObjectDataMap;

public abstract class AbstractThing {
  private final HashMap<Class<?>, HashSet<Object>> cache;
  protected final LinkedDataMap                    data;
  public final Document                            document;
  public final EditingPart                         editing;
  public final IdentityPart                        identity;
  public final LifetimePart                        lifetime;
  private final ArrayList<Part>                    parts;
  private long                                     sequencer;

  /**
   * @param document
   *          the owner of all things
   * @param node
   *          where the data lives
   */
  public AbstractThing(final Document document, final ObjectDataMap node) {
    this.document = document;
    cache = new HashMap<>();
    data = new LinkedDataMap(node);
    parts = new ArrayList<>();
    identity = new IdentityPart(data);
    register(identity);
    editing = new EditingPart(data);
    register(editing);
    lifetime = new LifetimePart(data);
    register(lifetime);
    sequencer = 0;
  }

  @SuppressWarnings("unchecked")
  public <T> Set<T> collect(final Class<T> clazz) {
    HashSet<Object> cached = cache.get(clazz);
    if (cached == null) {
      final HashSet<Object> result = new HashSet<>();
      for (final Part part : parts) {
        if (clazz.isAssignableFrom(part.getClass())) {
          result.add(part);
        }
      }
      cache.put(clazz, result);
      cached = result;
    }
    return (HashSet<T>) cached;
  }

  public <T, O> Set<O> collect(final Class<T> clazz, final Function<T, O> collector) {
    final HashSet<O> result = new HashSet<>();
    for (final T part : collect(clazz)) {
      result.add(collector.apply(part));
    }
    return result;
  }

  public <T, O> Set<O> collectAndMerge(final Class<T> clazz, final Function<T, Collection<O>> collector) {
    final HashSet<O> result = new HashSet<>();
    for (final T part : collect(clazz)) {
      result.addAll(collector.apply(part));
    }
    return result;
  }

  public <T, O> Set<O> collectAndMergeOverArray(final Class<T> clazz, final Function<T, O[]> collector) {
    final HashSet<O> result = new HashSet<>();
    for (final T part : collect(clazz)) {
      for (final O o : collector.apply(part)) {
        result.add(o);
      }
    }
    return result;
  }

  public <T> T first(final Class<T> clazz) {
    return collect(clazz).iterator().next();
  }

  /**
   * @return all actions available given the current state of the thing
   */
  public Set<String> getActionsAvailable() {
    final TreeSet<String> actions = new TreeSet<>();
    for (final HasActions part : collect(HasActions.class)) {
      part.list(actions);
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
    for (final HasActions part : collect(HasActions.class)) {
      part.act(action, sharedActionSpace);
    }
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
  protected synchronized <T extends Part> void register(final T part) {
    sequencer++;
    parts.add(part);
    cache.clear();
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

  public abstract Transform transform();

  /**
   * invoke update on all the parts
   */
  public void update() {
    for (final HasInternalStateThatMayNeedManualUpdating updatable : collect(HasInternalStateThatMayNeedManualUpdating.class)) {
      updatable.updateInternalState();
    }
  }
}
