package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.data.EditBoolean;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;

public class EditingPart implements Part, HasActions {
  public final EditBoolean locked;
  public final EditBoolean selected;

  public EditingPart(final LinkedDataMap data) {
    locked = data.getBoolean("locked", false);
    selected = data.getBoolean("selected", false);
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("lock".equals(action)) {
      locked.value(true);
    } else if ("unlock".equals(action)) {
      locked.value(false);
    } else if ("select".equals(action)) {
      selected.value(true);
    } else if ("unselect".equals(action)) {
      selected.value(false);
    } else if ("inverse_selection".equals(action)) {
      selected.value(!selected.value());
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
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
    actionsAvailable.add("inverse_selection");

  }
}
