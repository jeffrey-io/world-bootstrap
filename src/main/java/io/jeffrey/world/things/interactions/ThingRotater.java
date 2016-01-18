package io.jeffrey.world.things.interactions;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * rotate the entire thing
 *
 * @author jeffrey
 */
public class ThingRotater implements ThingInteraction {
  private static final double   RADIANS_TO_DEGREES = 57.2957795;
  private final double          angle;
  private final VectorRegister3 origin;
  private final double          startingAngle;
  private final Thing           thing;
  private final RotationPart    rotation;

  /**
   * @param initial
   *          the initial event in the thing space
   */
  public ThingRotater(final AdjustedMouseEvent initial, RotationPart rotation) {
    thing = (Thing) initial.userdata;
    origin = new VectorRegister8();
    origin.zero_out_0();
    thing.writeToWorld(origin);
    angle = rotation.angle();
    startingAngle = rotation.angle() + RADIANS_TO_DEGREES * Math.atan2(initial.position.y_0 - origin.y_1, initial.position.x_0 - origin.x_1);
    this.rotation = rotation;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    rotation.angle(angle);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    final double rads = Math.atan2(event.position.y_0 - origin.y_1, event.position.x_0 - origin.x_1);
    double nangle = startingAngle - rads * RADIANS_TO_DEGREES;

    if (event.altdown) {
      nangle = Math.floor(nangle / 7.5) * 7.5;
    }
    rotation.angle(nangle);
  }

}
