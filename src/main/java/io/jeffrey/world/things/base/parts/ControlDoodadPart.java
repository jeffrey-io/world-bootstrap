package io.jeffrey.world.things.base.parts;

import io.jeffrey.world.things.base.Part;

public abstract class ControlDoodadPart implements Part {
  @Override
  public boolean unique() {
    return false;
  }  
}
