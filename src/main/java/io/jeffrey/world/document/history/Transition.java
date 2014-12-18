package io.jeffrey.world.document.history;

import io.jeffrey.world.things.core.ThingCore;
import io.jeffrey.zer.edits.Edit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

public class Transition {
    final boolean                 keep;
    private final HashMap<String, String> redo;
    private final ThingCore               thing;
    private final HashMap<String, String> undo;

    public Transition(final ThingCore thing, final HashMap<String, String> before, final HashMap<String, String> after) {
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

    public Map<String, Object> pack() {
        if (!keep)
            return null;
        HashMap<String, Object> packed = new HashMap<>();
        packed.put("id", thing.id());
        packed.put("undo", undo);
        packed.put("redo", redo);
        return packed;
    }

    public void doRedo() {
        final Map<String, Edit> links = thing.getLinks(false);
        for (final Entry<String, String> task : redo.entrySet()) {
            links.get(task.getKey()).set(task.getValue());
        }
        thing.invalidate();
    }

    public void doUndo() {
        final Map<String, Edit> links = thing.getLinks(false);
        for (final Entry<String, String> task : undo.entrySet()) {
            links.get(task.getKey()).set(task.getValue());
        }
        thing.invalidate();
    }
}