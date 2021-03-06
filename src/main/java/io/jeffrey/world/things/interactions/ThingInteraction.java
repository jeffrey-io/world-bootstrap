package io.jeffrey.world.things.interactions;

import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * a mouse interaction on a thing
 *
 * @author jeffrey
 */
public interface ThingInteraction {
  /**
   * abort the interaction
   */
  public void cancel();

  public void commit();

  /**
   * the mouse has moved
   *
   * @param event
   *          the event in the thing space
   */
  public void moved(AdjustedMouseEvent event);

  public void select();
}
