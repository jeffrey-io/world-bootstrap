package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditDouble;

public class PositionPart implements Part {
  public final EditDouble x;
  public final EditDouble y;

  public PositionPart(final LinkedDataMap data) {
    x = data.getDouble("x", 0.0);
    y = data.getDouble("y", 0.0);
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
    // no-op
  }
}
