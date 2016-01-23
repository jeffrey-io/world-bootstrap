package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.interactions.SelectionSolver;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;

public class GenericMoverPart implements Part, HasSelectionByPoint {

  private final PositionPart position;
  private final RotationPart rotation;
  private final EditingPart editing;

  public GenericMoverPart(final PositionPart position, final RotationPart rotation, EditingPart editing) {
    this.position = position;
    this.rotation = rotation;
    this.editing = editing;
  }


  public void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    interactions.add(new ThingMover(event, position, rotation));
  }

  @Override
  public void buildSelectionSolver(SelectionSolver solver) {

  }
}
