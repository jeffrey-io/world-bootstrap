package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;

public class UriPart implements Part {
  public final EditString  uri;
  public final EditBoolean urilock;

  public UriPart(final String prefix, final LinkedDataMap data) {
    uri = data.getString(prefix + "uri", "");
    urilock = data.getBoolean(prefix + "lock", false);
  }
}
