package io.jeffrey.world.document.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.world.things.core.AbstractThing;

/**
 * An atomic group change
 *
 * @author jeffrey
 */
public class Change {
  public static Change fromJsonNode(final JsonNode node, final Map<String, AbstractThing> lookup) {
    final JsonNode changesPacked = node.get("changes");
    final JsonNode alternatePacked = node.get("alternate");
    final Set<Transition> transitions = new HashSet<>();
    for (int k = 0; k < changesPacked.size(); k++) {
      transitions.add(Transition.fromJsonNode(changesPacked.get(k), lookup));
    }
    final Change result = new Change(transitions);
    for (int k = 0; k < alternatePacked.size(); k++) {
      final ChangeStack alt = new ChangeStack();
      alt.load(alternatePacked.get(k), lookup);
      result.branch(alt);
    }
    return result;
  }

  private final ArrayList<ChangeStack> alternate;

  private final Set<Transition>        changes;

  public Change(final Set<Transition> changes) {
    this.changes = changes;
    alternate = new ArrayList<ChangeStack>();
  }

  public void branch(final ChangeStack old) {
    alternate.add(old);
  }

  public Map<String, Object> pack() {
    final Map<String, Object> packed = new HashMap<String, Object>();
    final ArrayList<Map<String, Object>> packedChanges = new ArrayList<>();
    for (final Transition t : changes) {
      final Map<String, Object> tpacked = t.pack();
      if (tpacked != null) {
        packedChanges.add(tpacked);
      }
    }
    packed.put("changes", packedChanges);
    final ArrayList<ArrayList<Object>> packedAlternate = new ArrayList<ArrayList<Object>>();
    for (final ChangeStack cs : alternate) {
      packedAlternate.add(cs.pack());
    }
    packed.put("alternate", packedAlternate);
    return packed;
  }

  public void redo() {
    for (final Transition t : changes) {
      t.doRedo();
    }
  }

  public void undo() {
    for (final Transition t : changes) {
      t.doUndo();
    }
  }
}