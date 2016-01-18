package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.base.ControlDoodad;

public interface HasControlDoodadsInWorldSpace {

  /**
   * @return the control doodads in the world space
   */
  public ControlDoodad[] getDoodadsInWorldSpace();
}
