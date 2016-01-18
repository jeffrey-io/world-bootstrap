package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditBoolean;

public class EditingPart implements Part {
  public final EditBoolean  locked;
  public final EditBoolean  selected;
  
  public EditingPart(final LinkedDataMap data) {
    locked = data.getBoolean("locked", false);
    selected = data.getBoolean("selected", false);
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
