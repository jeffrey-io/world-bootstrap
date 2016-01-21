package io.jeffrey.world.things.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.behaviors.HasEdgesInWorldSpace;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

public class PointListEdgesPart implements Part, HasEdgesInWorldSpace {

  private final SelectablePoint2List list;
  private final Transform            transform;

  public PointListEdgesPart(final SelectablePoint2List list, final Transform transform) {
    this.list = list;
    this.transform = transform;
  }

  @Override
  public double[] getWorldSpaceEdges() {
    final double[] values = list.getThingSpaceEdges();
    final VectorRegister3 W = new VectorRegister3();
    for (int k = 0; k < values.length; k += 2) {
      W.set_0(values[k], values[k + 1]);
      transform.writeToWorldSpace(W);
      W.extract_1(values, k);
    }
    return values;
  }
}
