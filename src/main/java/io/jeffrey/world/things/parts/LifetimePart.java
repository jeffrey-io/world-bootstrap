package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.data.EditBoolean;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;

public class LifetimePart implements Part, HasActions {
  protected final EditBoolean deleted;
  public final EditBoolean    locklock;

  public LifetimePart(final LinkedDataMap data) {
    deleted = data.getBoolean("deleted", false);
    locklock = data.getBoolean("locklock", false);
  }

  public void delete() {
    deleted.value(true);
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("undelete".equals(action)) {
      deleted.value(false);
    }
    if ("delete".equals(action)) {
      deleted.value(true);
    }
  }

  public boolean isDeleted() {
    return deleted.value();
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    if (!locklock.value()) {
      actionsAvailable.add("templatize");
    }
    if (deleted.value()) {
      actionsAvailable.add("undelete");
    } else {
      actionsAvailable.add("delete");
    }
  }

  public void undelete() {
    deleted.value(false);
  }

}
