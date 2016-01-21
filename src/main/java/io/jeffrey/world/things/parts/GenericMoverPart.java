package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.behaviors.HasMover;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;

public class GenericMoverPart implements Part, HasMover {

  private final PositionPart position;
  private final RotationPart rotation;

  public GenericMoverPart(final PositionPart position, final RotationPart rotation) {
    this.position = position;
    this.rotation = rotation;
  }

  @Override
  public void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    interactions.add(new ThingMover(event, position, rotation));
  }

}
