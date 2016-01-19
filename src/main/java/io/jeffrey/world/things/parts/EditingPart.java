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
    } else if ("unlock".equals(action)) {
      locked.value(false);
    } else if ("select".equals(action)) {
      selected.value(true);
    } else if ("unselect".equals(action)) {
      selected.value(false);
    } else if("inverse-selection".equals(action)) {
      selected.value(!selected.value());
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
    } else {
      actionsAvailable.add("select");
    }
  }

  @Override
  public void update() {
  }
}
