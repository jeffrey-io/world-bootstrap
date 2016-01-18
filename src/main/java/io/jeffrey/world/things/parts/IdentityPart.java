package io.jeffrey.world.things.parts;

import java.util.UUID;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditString;

public class IdentityPart implements Part {
  private final EditString id;
  public final EditString  name;
  private final EditString type;
  public final EditString   metaclass;

  public IdentityPart(final LinkedDataMap data) {
    id = data.getString("id", UUID.randomUUID().toString());
    type = data.getString("_type", null);
    name = data.getString("name", "Unnamed");
    metaclass = data.getString("metaclass", "_");
  }
  
  public String getType() {
    return type.getAsText();
  }

  public String getID() {
    return id.getAsText();
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
