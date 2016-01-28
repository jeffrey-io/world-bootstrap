package io.jeffrey.world.things.parts;

import java.util.UUID;

import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;

public class IdentityPart implements Part {
  private final EditString id;
  public final EditString  metaclass;
  public final EditString  name;
  private final EditString type;

  public IdentityPart(final LinkedDataMap data) {
    id = data.getString("id", UUID.randomUUID().toString());
    type = data.getString("_type", null);
    name = data.getString("name", "Unnamed");
    metaclass = data.getString("metaclass", "_");
  }

  public String getID() {
    return id.getAsText();
  }

  public String getType() {
    return type.getAsText();
  }

}
