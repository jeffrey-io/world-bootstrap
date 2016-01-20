package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasMover;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.polygon.PairEventPoint2Mover;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.EditBoolean;

public class EdgeMover implements Part, HasMover {

  private final Document           document;
  private final HasSelectableEdges edges;
  private final EditBoolean        lock;
  private final Transform          transform;
  private final HasUpdate          update;

  public EdgeMover(final Document document, final Transform transform, final HasSelectableEdges edges, final EditBoolean lock, final HasUpdate update) {
    this.document = document;
    this.transform = transform;
    this.edges = edges;
    this.lock = lock;
    this.update = update;
  }

  @Override
  public void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
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
        reg.set_2(event.position.x_0, event.position.y_0);
        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        if (distance > 0) {
          if (event.doodadDistance(reg.x_0, reg.y_0) <= document.edgeWidthSize) {
            begin.selected = true;
            end.selected = true;
            interactions.add(new PairEventPoint2Mover(new EventedPoint2(begin, update), new EventedPoint2(end, update), event));
            return;
          }
        }
      }
    }
  }
}
