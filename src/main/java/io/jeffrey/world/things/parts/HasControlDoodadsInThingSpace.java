package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.base.ControlDoodad;

public interface HasControlDoodadsInThingSpace {
  /**
   * @return all the doodads in thing/target space
   */
  public ControlDoodad[] getDoodadsInThingSpace();
}
