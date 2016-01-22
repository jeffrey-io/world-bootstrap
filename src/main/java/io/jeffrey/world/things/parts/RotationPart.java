package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;

public class RotationPart implements Part, HasActions, HasUpdate {
  private static final double DEGREES_TO_RADIANS = 0.0174532925;

  public final EditDouble     angle;
  protected double            cx                 = 1.0;
  protected double            cy                 = 0.0;
  public final EditBoolean    lock;

  public RotationPart(final LinkedDataMap data) {
    angle = data.getDouble("angle", 0.0);
    angle.subscribe((t, u) -> update());
    lock = data.getBoolean("alock", false);
    update();
  }

  /**
   * @return the current angle (in degrees)
   */
  public double angle() {
    return angle.value();
  }

  /**
   * @param angle
   *          the new angle value (in degrees)
   */
  public void angle(final double angle) {
    this.angle.value(angle);
  }

  public double cachedComplexX() {
    return cx;
  }

  public double cachedComplexY() {
    return cy;
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("reset_angle".equals(action)) {
      angle(0);
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    actionsAvailable.add("reset_angle");
  }

  @Override
  public void update() {
    double rads = DEGREES_TO_RADIANS * angle.value();
    cx = Math.cos(rads);
    cy = Math.sin(rads);
  }

}
