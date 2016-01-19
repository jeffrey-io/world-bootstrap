package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.base.ControlDoodad;

/**
 * Denotes whether or not a thing has control doodads in the world space
 *
 * @author jeffrey
 */
public interface HasControlDoodadsInWorldSpace {

  /**
   * @return the control doodads in the world space
   */
  public ControlDoodad[] getDoodadsInWorldSpace();
}
