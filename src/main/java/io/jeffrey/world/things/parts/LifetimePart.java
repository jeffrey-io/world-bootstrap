package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;

public class LifetimePart implements Part {
  protected final EditBoolean deleted;
  public final EditBoolean    locklock;

  public LifetimePart(final LinkedDataMap data) {
    deleted = data.getBoolean("deleted", false);
    locklock = data.getBoolean("locklock", false);
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
    if ("undelete".equals(action)) {
      deleted.value(false);
    }
    if ("deleted".equals(action)) {
      deleted.value(true);
    }
  }

  public void delete() {
    deleted.value(true);
  }

  public boolean isDeleted() {
    return deleted.value();
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
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

  @Override
  public void update() {
  }

}
