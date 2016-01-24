package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver.Rule;
import io.jeffrey.world.things.interactions.ThingMover;

public class GenericMoverPart implements Part, HasSelectionByPoint {

  private final EditingPart  editing;
  private final PositionPart position;
  private final RotationPart rotation;

  public GenericMoverPart(final PositionPart position, final RotationPart rotation, final EditingPart editing) {
    this.position = position;
    this.rotation = rotation;
    this.editing = editing;
  }

  @Override
  public boolean buildSelectionSolver(final InteractionSelectionSolver solver) {
    if (editing.selected.value()) {
      solver.propose(Rule.AlreadySelectedItemButNotInvolved, () -> new ThingMover(solver.event, position, rotation, editing));
      return true;
    }
    return false;
  }
}
