package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;

public class ColorPart implements Part {
  public final EditString  color;
  public final EditBoolean lock;

  public ColorPart(final String prefix, final LinkedDataMap data) {
    color = data.getString(prefix + "_color", "blue");
    lock = data.getBoolean(prefix + "_lock", false);
  }
}
