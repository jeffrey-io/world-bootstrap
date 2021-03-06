package io.jeffrey.world.document.history;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.world.data.Edit;
import io.jeffrey.world.things.core.AbstractThing;

/**
 * A transition on a single object
 *
 * @author jeffrey
 */
public class Transition {
  public static Transition fromJsonNode(final JsonNode node, final Map<String, AbstractThing> lookup) {
    final String id = node.get("id").asText();
    return new Transition(true, lookup.get(id), mapOf(node.get("redo")), mapOf(node.get("undo")));
  }

  private static HashMap<String, String> mapOf(final JsonNode node) {
    final HashMap<String, String> map = new HashMap<>();
    final Iterator<Entry<String, JsonNode>> it = node.getFields();
    while (it.hasNext()) {
      final Entry<String, JsonNode> entry = it.next();
      map.put(entry.getKey(), entry.getValue().asText());
    }
    return map;
  }

  final boolean                         keep;
  private final HashMap<String, String> redo;

  private final AbstractThing           thing;

  private final HashMap<String, String> undo;

  public Transition(final AbstractThing thing, final HashMap<String, String> before, final HashMap<String, String> after) {
    this.thing = thing;
    undo = new HashMap<String, String>();
    redo = new HashMap<String, String>();
    final HashSet<String> keys = new HashSet<>();
    keys.addAll(before.keySet());
    keys.addAll(after.keySet());
    for (final String key : keys) {
      final String valueBefore = before.get(key);
      final String valueAfter = after.get(key);
      if (valueBefore == null && valueAfter == null) {
        // no change, ignore
        continue;
      } else if (valueBefore == null || valueAfter == null) {
        // one of them is null, so we want this
      } else if (valueBefore.equals(valueAfter)) {
        continue;
      }
      undo.put(key, valueBefore);
      redo.put(key, valueAfter);
    }
    keep = undo.size() > 0 || redo.size() > 0;
  }

  private Transition(final boolean keep, final AbstractThing thing, final HashMap<String, String> redo, final HashMap<String, String> undo) {
    this.keep = keep;
    this.thing = thing;
    this.redo = redo;
    this.undo = undo;
  }

  public void doRedo() {
    final Map<String, Edit> links = thing.getLinks(false);
    for (final Entry<String, String> task : redo.entrySet()) {
      links.get(task.getKey()).setByText(task.getValue());
    }
  }

  public void doUndo() {
    final Map<String, Edit> links = thing.getLinks(false);
    for (final Entry<String, String> task : undo.entrySet()) {
      links.get(task.getKey()).setByText(task.getValue());
    }
  }

  public Map<String, Object> pack() {
    if (!keep) {
      return null;
    }
    final HashMap<String, Object> packed = new HashMap<>();
    packed.put("id", thing.getID());
    packed.put("undo", undo);
    packed.put("redo", redo);
    return packed;
  }
}