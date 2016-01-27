package io.jeffrey.world.things.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.world.things.interactions.Rule;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.edits.EditBoolean;

public class MoveByEdgePart implements Part, HasSelectionByPoint {

  private final Container          container;
  private final HasSelectableEdges edges;
  private final EditingPart        editing;
  private final EditBoolean        lock;
  private final PositionPart       position;
  private final RotationPart       rotation;
  private final Transform          transform;

  public MoveByEdgePart(final Container container, final Transform transform, final HasSelectableEdges edges, final EditBoolean lock, final EditingPart editing, final PositionPart position, final RotationPart rotation) {
    this.container = container;
    this.transform = transform;
    this.edges = edges;
    this.lock = lock;
    this.editing = editing;
    this.position = position;
    this.rotation = rotation;
  }

  @Override
  public boolean buildSelectionSolver(final InteractionSelectionSolver solver) {
    final boolean selected = editing.selected.value();

    final VectorRegister3 W = new VectorRegister3();
    if (!lock.value()) {
      final VectorRegister3 reg = new VectorRegister3();
      for (final SelectablePoint2[] line : edges.getSelectableEdges()) {

        // transform the starting point to a temporary place
        final SelectablePoint2 begin = line[0];
        W.set_0(begin.x, begin.y);
        transform.writeToWorldSpace(W);

        // transform the endpoint directly
        final SelectablePoint2 end = line[1];
        reg.set_0(end.x, end.y);
        transform.writeToWorldSpace(reg);

        // inject the starting point
        reg.set_0(W.x_1, W.y_1);

        // set where we are
        reg.set_2(solver.event.position.x_0, solver.event.position.y_0);
        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        if (distance >= 0) {
          if (solver.event.doodadDistance(reg.x_0, reg.y_0) <= container.edgeWidthSize) {
            Rule rule = Rule.NotAlreadySelectedAndPointIsInItem;
            if (selected || begin.selected && end.selected) {
              rule = Rule.AlreadySelectedItemAndPointPreserves;
            }
            solver.propose(rule, () -> {
              return new ThingMover(solver.event, position, rotation, editing);
            });
            return true;
          }
        }
      }
    }
    return false;
  }

}
