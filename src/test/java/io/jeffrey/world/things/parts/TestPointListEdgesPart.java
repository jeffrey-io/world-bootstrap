package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.points.list.Property;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

public class TestPointListEdgesPart extends WorldTestFramework {

  @Test
  public void verify() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6", Property.Looped);
    final PointListEdgesPart part = new PointListEdgesPart(list, new IdentityTransform());
    final double[] edges = part.getWorldSpaceEdges();
    assertEquals(1.0, edges[0]);
    assertEquals(2.0, edges[1]);
    assertEquals(3.0, edges[2]);
    assertEquals(4.0, edges[3]);
    assertEquals(3.0, edges[4]);
    assertEquals(4.0, edges[5]);
    assertEquals(5.0, edges[6]);
    assertEquals(6.0, edges[7]);
    assertEquals(5.0, edges[8]);
    assertEquals(6.0, edges[9]);
    assertEquals(1.0, edges[10]);
    assertEquals(2.0, edges[11]);
  }
}
