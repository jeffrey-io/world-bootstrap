package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;

public class EditingPart implements Part {
  public final EditBoolean locked;
  public final EditBoolean selected;

  public EditingPart(final LinkedDataMap data) {
    locked = data.getBoolean("locked", false);
    selected = data.getBoolean("selected", false);
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
    if ("lock".equals(action)) {
      locked.value(true);
    }
    if ("unlock".equals(action)) {
      locked.value(false);
    }
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
    if (locked.value()) {
      actionsAvailable.add("unlock");
    } else {
      actionsAvailable.add("lock");
    }
    if (selected.value()) {
      actionsAvailable.add("unselect");
    }
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
