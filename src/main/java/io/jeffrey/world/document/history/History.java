package io.jeffrey.world.document.history;

import io.jeffrey.world.things.core.ThingCore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Very simple history of changes
 *
 * @author jeffrey
 *
 */
public class History {

    private final Stack<Change>          applied;
    private final Stack<Change>          changes;

    private String                       focusOn = "";
    private final HashMap<String, Watch> watching;

    public History() {
        changes = new Stack<>();
        applied = new Stack<>();
        watching = new HashMap<String, Watch>();
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
        final HashSet<Transition> transitions = new HashSet<Transition>();
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
            applied.clear(); // TODO: indicate that we are branching
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
