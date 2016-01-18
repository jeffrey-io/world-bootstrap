package io.jeffrey.world.things.base.parts;

import io.jeffrey.world.things.base.Part;

public abstract class EdgesPart implements Part {

  public abstract double[] edges();

  @Override
  public boolean unique() {
    return false;
  }
}
