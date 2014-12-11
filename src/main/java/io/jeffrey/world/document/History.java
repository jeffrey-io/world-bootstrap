package io.jeffrey.world.document;

import io.jeffrey.world.things.core.ThingCore;
import io.jeffrey.zer.edits.Edit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

/**
 * Very simple history of changes
 *
 * @author jeffrey
 *
 */
public class History {

    public static class Change {
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
    }

    public static class Transition {
        private final boolean                 keep;
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

        public void doRedo() {
            final Map<String, Edit> links = thing.getLinks(false);
            for (final Entry<String, String> task : redo.entrySet()) {
                links.get(task.getKey()).set(task.getValue());
            }
        }

        public void doUndo() {
            final Map<String, Edit> links = thing.getLinks(false);
            for (final Entry<String, String> task : undo.entrySet()) {
                links.get(task.getKey()).set(task.getValue());
            }
        }
    }

    public static class Watch {
        private final HashMap<String, String> before;
        private final ThingCore               thing;

        public Watch(final ThingCore thing) {
            this.thing = thing;
            before = new HashMap<String, String>();
            thing.saveTo(before);
        }

        public Transition commit() {
            final HashMap<String, String> after = new HashMap<String, String>();
            thing.saveTo(after);
            final Transition t = new Transition(thing, before, after);
            if (!t.keep) {
                return null;
            }
            return t;
        }
    }

    private final Stack<Change>          applied;
    private final Stack<Change>          changes;

    private String                       focusOn = "";
    private final HashMap<String, Watch> watching;

    public History() {
        changes = new Stack<>();
        applied = new Stack<>();
        watching = new HashMap<String, History.Watch>();
    }

    public void abort() {
        watching.clear();
    }

    public boolean canRedo() {
        return applied.size() > 0;
    }

    public boolean canUndo() {
        return changes.size() > 0;
    }

    public void capture() {
        final HashSet<Transition> transitions = new HashSet<History.Transition>();
        for (final Watch watch : watching.values()) {
            final Transition t = watch.commit();
            if (t != null) {
                transitions.add(t);
            }
        }
        if (transitions.size() > 0) {
            changes.push(new Change(transitions));
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

    public void redo() {
        if (applied.size() > 0) {
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
        if (changes.size() > 0) {
            final Change c = changes.pop();
            c.undo();
            applied.push(c);
        }
    }
}
