package io.jeffrey.world.things.polygon;

import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * move an edge by itself
 *
 * @author jeffrey
 */
public class EdgeMover implements ThingInteraction {
  private final VertexMover a;
  private final VertexMover b;

  /**
   * @param v0
   *          the first vertex of the edge
   * @param v1
   *          the second vertex of the edge
   * @param initial
   *          the initial event in thing space
   */
  public EdgeMover(final Vertex v0, final Vertex v1, final AdjustedMouseEvent initial) {
    a = new VertexMover(v0, initial);
    b = new VertexMover(v1, initial);
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
}
