package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;

public abstract class UriPart implements Part {
  public final EditString  uri;
  public final EditBoolean urilock;

  public UriPart(final String prefix, final LinkedDataMap data) {
    uri = data.getString(prefix + "uri", "");
    urilock = data.getBoolean(prefix + "lock", false);

    uri.subscribe((from, to) -> {
      try {
        update();
      } catch (final Exception e) {
        uri.set(from);
      }
    });
  }

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }
}
