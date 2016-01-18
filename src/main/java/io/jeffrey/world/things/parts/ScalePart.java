package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;

public class ScalePart implements Part {
  public final EditBoolean aspect;
  public final EditBoolean lock;
  public final EditDouble  x;
  public final EditDouble  y;

  public ScalePart(final LinkedDataMap data) {
    x = data.getDouble("sx", 1.0);
    y = data.getDouble("sy", 1.0);
    lock = data.getBoolean("slock", false);
    aspect = data.getBoolean("aspect", true);
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
