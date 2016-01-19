package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.base.ControlDoodad;

/**
 * Declares whether or not something has control doodads in the thing space.
 * 
 * @author jeffrey
 */
public interface HasControlDoodadsInThingSpace {
  /**
   * @return all the doodads in thing/target space
   */
  public ControlDoodad[] getDoodadsInThingSpace();
}
