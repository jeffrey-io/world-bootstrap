package io.jeffrey.world.things.core;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;

public abstract class EdgedThing extends Thing {

    protected EdgedThing(Document document, ThingData node) {
        super(document, node);
    }

    public abstract double[] edges();
}
