package io.jeffrey.world.document.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Change {
    private final Set<Transition> changes;

    public Change(final Set<Transition> changes) {
        this.changes = changes;
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

    public Map<String, Object> pack() {
        Map<String, Object> packed = new HashMap<String, Object>();
        ArrayList<Map<String, Object>> packedChanges = new ArrayList<>();
        for (Transition t : changes) {
            Map<String, Object> tpacked = t.pack();
            if (tpacked != null)
                packedChanges.add(tpacked);
        }
        packed.put("changes", packedChanges);
        return packed;
    }
}