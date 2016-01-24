package io.jeffrey.world.things.parts;

import java.util.ArrayList;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.world.things.interactions.MultiThingInteraction;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver.Rule;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingSelector;
import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.EventedPoint2Mover;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.edits.EditBoolean;

public class EdgeMoverPart implements Part, HasSelectionByPoint {

  private final Container          container;
  private final HasSelectableEdges edges;
  private final EditingPart        editing;
  private final EditBoolean        lock;
  private final Transform          transform;
  private final HasUpdate          update;

  public EdgeMoverPart(final Container container, final Transform transform, final HasSelectableEdges edges, final EditBoolean lock, final HasUpdate update, final EditingPart editing) {
    this.container = container;
    this.transform = transform;
    this.edges = edges;
    this.lock = lock;
    this.update = update;
    this.editing = editing;
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
        if (distance > 0) {
          if (solver.event.doodadDistance(reg.x_0, reg.y_0) <= container.edgeWidthSize) {
            Rule rule = Rule.NotAlreadySelectedAndPointIsInSubset;
            if (selected || begin.selected && end.selected) {
              rule = Rule.AlreadySelectedSubsetAndPointPreserves;
            }
            solver.propose(rule, () -> {
              ArrayList<ThingInteraction> its = new ArrayList<>();
              begin.selected = true;
              end.selected = true;
              its.add(new EventedPoint2Mover(new EventedPoint2(begin, update), solver.event));
              its.add(new EventedPoint2Mover(new EventedPoint2(end, update), solver.event));
              its.add(new ThingSelector(editing));
              return new MultiThingInteraction(its);
            });
            return true;
          }
        }
      }
    }
    return false;
  }
}
