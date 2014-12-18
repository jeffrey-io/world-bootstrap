package io.jeffrey.world.document.history;

import io.jeffrey.world.things.core.ThingCore;

import java.util.HashMap;

public class Watch {
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