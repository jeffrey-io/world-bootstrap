package io.jeffrey.world.things.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.interactions.PairEventPoint2Mover;
import io.jeffrey.world.things.interactions.SelectionSolver;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.EditBoolean;

public class EdgeMoverPart implements Part, HasSelectionByPoint {

  private final Container          container;
  private final HasSelectableEdges edges;
  private final EditBoolean        lock;
  private final Transform          transform;
  private final HasUpdate          update;

  public EdgeMoverPart(final Container container, final Transform transform, final HasSelectableEdges edges, final EditBoolean lock, final HasUpdate update) {
    this.container = container;
    this.transform = transform;
    this.edges = edges;
    this.lock = lock;
    this.update = update;
  }

  public ThingInteraction startInteraction(final AdjustedMouseEvent event) {
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

        if (begin.selected || end.selected) {
          continue;
        }

        // inject the starting point
        reg.set_0(W.x_1, W.y_1);

        // set where we are
        reg.set_2(event.position.x_0, event.position.y_0);
        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        if (distance > 0) {
          if (event.doodadDistance(reg.x_0, reg.y_0) <= container.edgeWidthSize) {
            return new PairEventPoint2Mover(new EventedPoint2(begin, update), new EventedPoint2(end, update), event);
          }
        }
      }
    }
    return null;
  }

  @Override
  public void buildSelectionSolver(SelectionSolver solver) {

  }
}
