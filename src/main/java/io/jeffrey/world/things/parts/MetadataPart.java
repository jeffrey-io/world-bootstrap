package io.jeffrey.world.things.parts;

import java.util.HashMap;

import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;

public class MetadataPart implements Part {
  private final LinkedDataMap              data;
  public final HashMap<String, EditString> metadata;
  private final String                     prefix;

  public MetadataPart(final String prefix, final LinkedDataMap data) {
    this.data = data;
    this.prefix = prefix;
    metadata = new HashMap<>();
    for (final String key : data.fields()) {
      if (key.startsWith(prefix)) {
        metadata.put(key.substring(prefix.length()), data.getString(key, null));
      }
    }
  }

  public EditString metadataOf(final String key, final String defaultValue) {
    EditString ed = metadata.get(key);
    if (ed == null) {
      ed = data.getString(prefix + key, defaultValue);
      metadata.put(key, ed);
    }
    return ed;
  }

}
