package io.jeffrey.world.things.interactions;

import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * a mouse interaction on a thing
 *
 * @author jeffrey
 */
public abstract class ThingInteraction implements Comparable<ThingInteraction> {

  public static enum Order {
    SingleOfThing(2), SubsetOfThing(1), ThingLevel(0);

    private final int ordinal;

    private Order(final int ordinal) {
      this.ordinal = ordinal;
    }
  }

  /**
   * abort the interaction
   */
  public abstract void cancel();

  @Override
  public int compareTo(final ThingInteraction o) {
    return order().ordinal - o.order().ordinal;
  }

  /**
   * the mouse has moved
   *
   * @param event
   *          the event in the thing space
   */
  public abstract void moved(AdjustedMouseEvent event);

  public abstract Order order();
}
