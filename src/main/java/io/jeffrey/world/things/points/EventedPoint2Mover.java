package io.jeffrey.world.things.points;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * update an point by moving it by some difference
 *
 * @author jeffrey
 */
public class EventedPoint2Mover implements ThingInteraction {

  private final double        ix;
  private final double        iy;
  private final EventedPoint2 point;

  /**
   * @param point
   *          the vertex to move
   * @param initial
   *          the initial event in thing space
   */
  public EventedPoint2Mover(final EventedPoint2 point, final AdjustedMouseEvent initial) {
    this.point = point;
    ix = initial.position.x_1;
    iy = initial.position.y_1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    point.reset();
  }

  @Override
  public void commit() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    point.setChange(event.position.x_1 - ix, event.position.y_1 - iy);
  }

  @Override
  public void select() {
    point.data.selected = true;
  }
}
