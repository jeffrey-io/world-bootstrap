package io.jeffrey.world.document.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.world.things.core.AbstractThing;

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

  public void focus(final String name, final AbstractThing thing) {
    final String sanityName = name + ":" + thing.getID();
    if (watching.containsKey(thing.getID())) {
      if (sanityName.equals(focusOn)) {
        return;
      }
    }
    focusOn = sanityName;
    if (watching.size() > 0) {
      capture();
    }
    watching.put(thing.getID(), new Watch(thing));
  }

  public void load(final JsonNode node, final Map<String, AbstractThing> lookup) {
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

  public void register(final AbstractThing thing) {
    if (watching.containsKey(thing.getID())) {
      return;
    }
    watching.put(thing.getID(), new Watch(thing));
  }

  public void undo() {
    if (changes.available()) {
      final Change c = changes.pop();
      c.undo();
      applied.push(c);
    }
  }
}
