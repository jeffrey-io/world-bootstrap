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
  private final EventedPoint2 vertex;

  /**
   * @param vertex
   *          the vertex to move
   * @param initial
   *          the initial event in thing space
   */
  public EventedPoint2Mover(final EventedPoint2 vertex, final AdjustedMouseEvent initial) {
    this.vertex = vertex;
    ix = initial.position.x_1;
    iy = initial.position.y_1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    vertex.reset();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    vertex.setChange(event.position.x_1 - ix, event.position.y_1 - iy);
  }

}
