package io.jeffrey.world.document.history;

import java.util.ArrayList;
import java.util.Map;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.core__old_defunct.ThingCore;

/**
 * This mimics the needed contract for Stack<Change> but supports random reading and packing
 *
 * @author jeffrey
 */
public class ChangeStack {

  public final ArrayList<Change> changes;

  public ChangeStack() {
    changes = new ArrayList<Change>();
  }

  public boolean available() {
    return changes.size() > 0;
  }

  public void clear() {
    changes.clear();
  }

  public ChangeStack clearAndCopy() {
    final ChangeStack copy = new ChangeStack();
    for (final Change c : changes) {
      copy.push(c);
    }
    changes.clear();
    return copy;
  }

  public void load(final JsonNode node, final Map<String, AbstractThing> lookup) {
    if (node == null) {
      return;
    }
    changes.clear();
    for (int cK = 0; cK < node.size(); cK++) {
      changes.add(Change.fromJsonNode(node.get(cK), lookup));
    }
  }

  public ArrayList<Object> pack() {
    final ArrayList<Object> packed = new ArrayList<Object>();
    for (final Change c : changes) {
      packed.add(c.pack());
    }
    return packed;
  }

  public Change pop() {
    return changes.remove(changes.size() - 1);
  }

  public void push(final Change change) {
    changes.add(change);
  }
}
