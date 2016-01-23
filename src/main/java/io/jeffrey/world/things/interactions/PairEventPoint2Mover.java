package io.jeffrey.world.things.interactions;

import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.EventedPoint2Mover;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * move an edge by itself
 *
 * @author jeffrey
 */
public class PairEventPoint2Mover extends ThingInteraction {
  private final EventedPoint2Mover a;
  private final EventedPoint2Mover b;

  /**
   * @param v0
   *          the first vertex of the edge
   * @param v1
   *          the second vertex of the edge
   * @param initial
   *          the initial event in thing space
   */
  public PairEventPoint2Mover(final EventedPoint2 v0, final EventedPoint2 v1, final AdjustedMouseEvent initial) {
    a = new EventedPoint2Mover(v0, initial);
    b = new EventedPoint2Mover(v1, initial);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    a.cancel();
    b.cancel();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    a.moved(event);
    b.moved(event);
  }

  @Override
  public Order order() {
    return Order.SubsetOfThing;
  }

  @Override
  public void select() {
    a.select();
    b.select();
  }

}
