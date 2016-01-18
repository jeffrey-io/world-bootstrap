package io.jeffrey.world.things.parts;

import java.util.Set;
import java.util.UUID;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditString;

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

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  public String getID() {
    return id.getAsText();
  }

  public String getType() {
    return type.getAsText();
  }

  @Override
  public void list(final Set<String> actionsAvailable) {

  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }
}
