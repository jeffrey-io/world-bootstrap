package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;

public abstract class EdgedThing extends Thing {

  protected EdgedThing(final Document document, final ThingData node) {
    super(document, node);
  }

  public abstract double[] edges();
}
