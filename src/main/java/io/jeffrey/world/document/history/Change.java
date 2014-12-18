package io.jeffrey.world.document.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An atomic group change
 *
 * @author jeffrey
 */
public class Change {
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