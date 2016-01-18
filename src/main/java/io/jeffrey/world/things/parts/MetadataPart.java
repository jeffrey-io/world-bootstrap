package io.jeffrey.world.things.parts;

import java.util.HashMap;
import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditString;

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

  public Edit metadataOf(final String key, final String defaultValue) {
    final EditString ed = metadata.get(key);
    if (ed == null) {
      return new EditString(prefix + key, defaultValue) {
        @Override
        public boolean setByText(final String txt) {
          metadata.put(key, data.getString(prefix + key, txt));
          return super.setByText(txt);
        };
      };
    }
    return ed;
  }

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void update() {
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {

  }

}