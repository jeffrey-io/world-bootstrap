package io.jeffrey.world.things.points.list;

import java.util.List;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.SelectablePoint2List.Property;
import io.jeffrey.world.things.points.list.changes.IndexRemoval;
import io.jeffrey.world.things.points.list.changes.PointAddition;

public class TestSelectablePoint2List extends WorldTestFramework {

  @Test
  public void verifyListUnpackAndIteration() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6");
    assertEquals(3, list.size());
    assertEquals(3, list.getNumberSelectablePoints());
    assertEquals("1.0,2.0,3.0,4.0,5.0,6.0", list.toString());
  }

  @Test
  public void verifyMutation() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6", Property.Looped);
    assertEquals(3, list.size());
    assertEquals(3, list.getNumberSelectablePoints());
    list.set("1,2,3,4");
    assertEquals(2, list.size());
    assertEquals("1.0,2.0,3.0,4.0", list.toString());
  }
  
  @Test
  public void verifyEdgesLooped() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6", Property.Looped);
    List<SelectablePoint2[]> edges = listOf(list.getSelectableEdges());
    double[] edges2 = list.getThingSpaceEdges();
    assertEquals(12, edges2.length);
    assertEquals(3, edges.size());
    assertEquals(1, edges.get(0)[0].x);
    assertEquals(2, edges.get(0)[0].y);
    assertEquals(3, edges.get(0)[1].x);
    assertEquals(4, edges.get(0)[1].y);
    assertEquals(3, edges.get(1)[0].x);
    assertEquals(4, edges.get(1)[0].y);
    assertEquals(5, edges.get(1)[1].x);
    assertEquals(6, edges.get(1)[1].y);
    assertEquals(5, edges.get(2)[0].x);
    assertEquals(6, edges.get(2)[0].y);
    assertEquals(1, edges.get(2)[1].x);
    assertEquals(2, edges.get(2)[1].y);
    assertEquals(1, edges2[0]);
    assertEquals(2, edges2[1]);
    assertEquals(3, edges2[2]);
    assertEquals(4, edges2[3]);
    assertEquals(3, edges2[4]);
    assertEquals(4, edges2[5]);
    assertEquals(5, edges2[6]);
    assertEquals(6, edges2[7]);
    assertEquals(5, edges2[8]);
    assertEquals(6, edges2[9]);
    assertEquals(1, edges2[10]);
    assertEquals(2, edges2[11]);
  }
  
  @Test
  public void verifyEdgesPath() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6");
    List<SelectablePoint2[]> edges = listOf(list.getSelectableEdges());
    double[] edges2 = list.getThingSpaceEdges();
    assertEquals(8, edges2.length);
    assertEquals(2, edges.size());
    assertEquals(1, edges.get(0)[0].x);
    assertEquals(2, edges.get(0)[0].y);
    assertEquals(3, edges.get(0)[1].x);
    assertEquals(4, edges.get(0)[1].y);
    assertEquals(3, edges.get(1)[0].x);
    assertEquals(4, edges.get(1)[0].y);
    assertEquals(5, edges.get(1)[1].x);
    assertEquals(6, edges.get(1)[1].y);

    assertEquals(1, edges2[0]);
    assertEquals(2, edges2[1]);
    assertEquals(3, edges2[2]);
    assertEquals(4, edges2[3]);
    assertEquals(3, edges2[4]);
    assertEquals(4, edges2[5]);
    assertEquals(5, edges2[6]);
    assertEquals(6, edges2[7]);
  }

  @Test
  public void testAddition() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6");
    PointAddition add = new PointAddition();
    SelectablePoint2 a = new SelectablePoint2(-10, -9);
    a.cachedIndex = 0;
    add.denote(a);
    SelectablePoint2 b = new SelectablePoint2(3.5, 3.5);
    b.cachedIndex = 2;
    add.denote(b);
    SelectablePoint2 c = new SelectablePoint2(9, 10);
    c.cachedIndex = 3;
    add.denote(c);
    list.apply(add);
    assertEquals("-10.0,-9.0,1.0,2.0,3.0,4.0,3.5,3.5,5.0,6.0,9.0,10.0", list.toString());
  }


  @Test
  public void testRemoval() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6");
    IndexRemoval rem = new IndexRemoval();
    rem.denote(1);
    try {
      rem.denote(1);
    } catch (IllegalArgumentException iae) {
    }
    list.apply(rem);
    assertEquals("1.0,2.0,5.0,6.0", list.toString());
  }
  
  @Test
  public void testMultipleRemoves() {
    SelectablePoint2List list = new SelectablePoint2List("1,2,3,4,5,6,7,8,9,10");
    IndexRemoval rem = new IndexRemoval();
    rem.denote(1);
    rem.denote(2);
    rem.denote(3);
    list.apply(rem);
    assertEquals("1.0,2.0,9.0,10.0", list.toString());
  }

}
