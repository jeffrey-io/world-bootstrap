package io.jeffrey.world.things.interactions;

import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * move the entire thing
 *
 * @author jeffrey
 */
public class ThingMover implements ThingInteraction {

  private final double       angle;

  private final double       ix;
  private final double       iy;
  private final PositionPart position;
  private final RotationPart rotation;
  private final double       x;
  private final double       y;

  /**
   * @param initial
   *          the initial event in the thing space
   */
  public ThingMover(final AdjustedMouseEvent initial, final PositionPart position, final RotationPart rotation) {
    x = position.x();
    y = position.y();
    ix = initial.position.x_0;
    iy = initial.position.y_0;
    angle = rotation.angle();
    this.position = position;
    this.rotation = rotation;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    position.x(x);
    position.y(y);
    rotation.angle(angle);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    position.x(x + event.position.x_0 - ix);
    position.y(y + event.position.y_0 - iy);
    rotation.angle(angle);
  }

}
