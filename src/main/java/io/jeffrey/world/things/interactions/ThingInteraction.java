package io.jeffrey.world.things.interactions;

import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * a mouse interaction on a thing
 *
 * @author jeffrey
 */
public abstract class ThingInteraction {
  /**
   * abort the interaction
   */
  public abstract void cancel();

  /**
   * the mouse has moved
   *
   * @param event
   *          the event in the thing space
   */
  public abstract void moved(AdjustedMouseEvent event);

  public abstract void select();
}
