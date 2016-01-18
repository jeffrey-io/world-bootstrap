package io.jeffrey.world.things.base.parts;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditBoolean;

public class LifetimePart implements Part {
  protected final EditBoolean deleted;
  public final EditBoolean locklock;
  
  public LifetimePart(final LinkedDataMap data) {
    deleted = data.getBoolean("deleted", false);
    locklock = data.getBoolean("locklock", false);
  }

  public void delete() {
    deleted.value(true);
  }

  public boolean isDeleted() {
    return deleted.value();
  }

  public void undelete() {
    deleted.value(false);
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
