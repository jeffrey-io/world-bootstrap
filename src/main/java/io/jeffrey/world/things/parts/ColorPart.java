package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;

public class ColorPart implements Part {
  public final EditString  color;
  public final EditBoolean lock;

  public ColorPart(final String prefix, final LinkedDataMap data) {
    color = data.getString(prefix + "_color", "blue");
    lock = data.getBoolean(prefix + "_lock", false);
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public void list(final Set<String> actionsAvailable) {

  }

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void update() {
  }
}
