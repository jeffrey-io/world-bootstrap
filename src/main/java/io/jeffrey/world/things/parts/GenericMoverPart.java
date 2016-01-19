package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.HasMover;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;

public class GenericMoverPart implements Part, HasMover {

  private final PositionPart position;
  private final RotationPart rotation;
  
  public GenericMoverPart(PositionPart position, RotationPart rotation) {
    this.position = position;
    this.rotation = rotation;
  }
  
  @Override
  public void iterateMovers(Set<ThingInteraction> interactions, AdjustedMouseEvent event) {
    interactions.add(new ThingMover(event, position, rotation));
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
  }
}
