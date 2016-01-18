package io.jeffrey.world.things.base.parts;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
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
}
