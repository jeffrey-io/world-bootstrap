package io.jeffrey.world.things.base.parts;

import io.jeffrey.world.things.base.Part;

public class MetadataPart implements Part {

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void update() {
  }
}
