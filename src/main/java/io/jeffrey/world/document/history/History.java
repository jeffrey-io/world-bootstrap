package io.jeffrey.world.document.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.world.things.core.ThingCore;

/**
 * Very simple history of changes
 *
 * @author jeffrey
 */
public class History {

  private final ChangeStack            applied;
  private final ChangeStack            changes;

  private String                       focusOn = "";
  private final HashMap<String, Watch> watching;

  public History() {
    applied = new ChangeStack();
    changes = new ChangeStack();
    watching = new HashMap<String, Watch>();
  }

  public void abort() {
    watching.clear();
  }

  public boolean canRedo() {
    return applied.available();
  }

  public boolean canUndo() {
    return changes.available();
  }

  public void capture() {
    final HashSet<Transition> transitions = new HashSet<Transition>();
    for (final Watch watch : watching.values()) {
      final Transition t = watch.commit();
      if (t != null) {
        transitions.add(t);
      }
    }
    if (transitions.size() > 0) {
      final Change change = new Change(transitions);
      changes.push(change);
      change.branch(applied.clearAndCopy());
    }
    watching.clear();
  }

  public void focus(final String name, final ThingCore thing) {
    final String sanityName = name + ":" + thing.id();
    if (watching.containsKey(thing.id())) {
      if (sanityName.equals(focusOn)) {
        return;
      }
    }
    focusOn = sanityName;
    if (watching.size() > 0) {
      capture();
    }
    watching.put(thing.id(), new Watch(thing));
  }

  public void load(final JsonNode node, final Map<String, ThingCore> lookup) {
    applied.clear();
    changes.clear();
    focusOn = "";
    watching.clear();
    applied.load(node.get("applied"), lookup);
    changes.load(node.get("changes"), lookup);
  }

  public Map<String, Object> pack() {
    final HashMap<String, Object> packed = new HashMap<String, Object>();
    packed.put("applied", applied.pack());
    packed.put("changes", changes.pack());
    return packed;
  }

  public void redo() {
    if (applied.available()) {
      final Change c = applied.pop();
      c.redo();
      changes.push(c);
    }
  }

  public void register(final ThingCore thing) {
    if (watching.containsKey(thing.id())) {
      return;
    }
    watching.put(thing.id(), new Watch(thing));
  }

  public void undo() {
    if (changes.available()) {
      final Change c = changes.pop();
      c.undo();
      applied.push(c);
    }
  }
}
