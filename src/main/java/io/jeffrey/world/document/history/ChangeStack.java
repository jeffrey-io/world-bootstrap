package io.jeffrey.world.document.history;

import java.util.ArrayList;

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

    public ChangeStack clearAndCopy() {
        final ChangeStack copy = new ChangeStack();
        for (final Change c : changes) {
            copy.push(c);
        }
        changes.clear();
        return copy;
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
