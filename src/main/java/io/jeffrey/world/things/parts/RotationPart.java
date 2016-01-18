package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;

public class RotationPart implements Part {
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

  @Override
  public void act(String action, SharedActionSpace space) {
    if ("reset.angle".equals(action)) {
      angle(0);
    }
  }

  public double cachedComplexX() {
    return cx;
  }

  public double cachedComplexY() {
    return cy;
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
    cx = Math.cos(DEGREES_TO_RADIANS * angle.value());
    cy = Math.sin(DEGREES_TO_RADIANS * angle.value());
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

  @Override
  public void list(Set<String> actionsAvailable) {
    actionsAvailable.add("reset.angle");
  }

}
