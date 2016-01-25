package io.jeffrey.world.things.points.list;

import java.util.List;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.edits.EditString;

public class TestSelectablePoint2List extends WorldTestFramework {

  private class SegmentAssertionModel {
    private final SelectablePoint2List   list;
    private final List<SelectablePoint2> points;

    private SegmentAssertionModel(final Property... properties) {
      list = listOf("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18", properties);
      points = listOf(list);
    }

    public void expect(final SegmentSelectMode mode, final String expected) {
      final StringBuilder sb = new StringBuilder();
      for (final SelectablePoint2[] segment : list.getSelectedSegments(mode)) {
        sb.append(segment.length);
        char prefix = '=';
        for (final SelectablePoint2 p : segment) {
          sb.append(prefix).append(p.cachedIndex);
          prefix = ',';
        }
        sb.append(';');
      }
      final String actual = sb.toString();
      assertEquals(expected, actual);
    }

    public SegmentAssertionModel select(final int... indicies) {
      for (final int index : indicies) {
        points.get(index).selected = true;
      }
      return this;
    }
  }

  private SegmentAssertionModel beginSAM(final Property... properties) {
    return new SegmentAssertionModel(properties);
  }

  @Test
  public void getSelectedSegmentsHead() {
    beginSAM().select(0, 1).expect(SegmentSelectMode.SelectedOnly, "2=0,1;");
    beginSAM().select(0, 1).expect(SegmentSelectMode.SelectedAndBoundary, "3=0,1,2;");
    beginSAM(Property.Looped).select(0, 1).expect(SegmentSelectMode.SelectedOnly, "2=0,1;");
    beginSAM(Property.Looped).select(0, 1).expect(SegmentSelectMode.SelectedAndBoundary, "4=8,0,1,2;");
    beginSAM().select(0, 1, 2).expect(SegmentSelectMode.SelectedOnly, "3=0,1,2;");
    beginSAM().select(0, 1, 2).expect(SegmentSelectMode.SelectedAndBoundary, "4=0,1,2,3;");
    beginSAM(Property.Looped).select(0, 1, 2).expect(SegmentSelectMode.SelectedOnly, "3=0,1,2;");
    beginSAM(Property.Looped).select(0, 1, 2).expect(SegmentSelectMode.SelectedAndBoundary, "5=8,0,1,2,3;");
  }

  @Test
  public void getSelectedSegmentsHeadAndTail() {
    beginSAM(Property.Looped).select(0, 1, 6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "5=6,7,8,0,1;");
    beginSAM().select(0, 1, 6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "2=0,1;3=6,7,8;");
    beginSAM(Property.Looped).select(0, 1, 6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "7=5,6,7,8,0,1,2;");
    beginSAM().select(0, 1, 6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "3=0,1,2;4=5,6,7,8;");
  }

  @Test
  public void getSelectedSegmentsMiddle() {
    beginSAM().select(1, 2, 3, 5, 6).expect(SegmentSelectMode.SelectedOnly, "3=1,2,3;2=5,6;");
    beginSAM().select(1, 2, 3, 5, 6).expect(SegmentSelectMode.SelectedAndBoundary, "5=0,1,2,3,4;4=4,5,6,7;");
    beginSAM(Property.Looped).select(1, 2, 3, 5, 6).expect(SegmentSelectMode.SelectedOnly, "3=1,2,3;2=5,6;");
    beginSAM(Property.Looped).select(1, 2, 3, 5, 6).expect(SegmentSelectMode.SelectedAndBoundary, "5=0,1,2,3,4;4=4,5,6,7;");
  }

  @Test
  public void getSelectedSegmentsNothingSelected() {
    beginSAM(Property.Looped).select().expect(SegmentSelectMode.SelectedOnly, "");
    beginSAM().select().expect(SegmentSelectMode.SelectedOnly, "");
    beginSAM(Property.Looped).select().expect(SegmentSelectMode.SelectedAndBoundary, "");
    beginSAM().select().expect(SegmentSelectMode.SelectedAndBoundary, "");
  }

  @Test
  public void getSelectedSegmentsTail() {
    beginSAM().select(7, 8).expect(SegmentSelectMode.SelectedOnly, "2=7,8;");
    beginSAM().select(7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "3=6,7,8;");
    beginSAM(Property.Looped).select(7, 8).expect(SegmentSelectMode.SelectedOnly, "2=7,8;");
    beginSAM(Property.Looped).select(7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "4=6,7,8,0;");
    beginSAM().select(6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "3=6,7,8;");
    beginSAM().select(6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "4=5,6,7,8;");
    beginSAM(Property.Looped).select(6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "3=6,7,8;");
    beginSAM(Property.Looped).select(6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "5=5,6,7,8,0;");
  }

  @Test
  public void getSelectedSegmentsWithEverythingSelected() {
    beginSAM(Property.Looped).select(0, 1, 2, 3, 4, 5, 6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "11=8,0,1,2,3,4,5,6,7,8,0;");
    beginSAM().select(0, 1, 2, 3, 4, 5, 6, 7, 8).expect(SegmentSelectMode.SelectedOnly, "9=0,1,2,3,4,5,6,7,8;");
    beginSAM(Property.Looped).select(0, 1, 2, 3, 4, 5, 6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "11=8,0,1,2,3,4,5,6,7,8,0;");
    beginSAM().select(0, 1, 2, 3, 4, 5, 6, 7, 8).expect(SegmentSelectMode.SelectedAndBoundary, "9=0,1,2,3,4,5,6,7,8;");
  }

  @Test
  public void getSelectedSegmentsWithNoSegments() {
    beginSAM(Property.Looped).select(0, 2, 4, 6).expect(SegmentSelectMode.SelectedOnly, "");
    beginSAM().select(1, 3, 5, 7).expect(SegmentSelectMode.SelectedOnly, "");
    beginSAM(Property.Looped).select(1, 5).expect(SegmentSelectMode.SelectedAndBoundary, "");
    beginSAM().select(1, 7).expect(SegmentSelectMode.SelectedAndBoundary, "");
  }

  private SelectablePoint2List listOf(final EditString points, final Property... properties) {
    return new SelectablePoint2List(points, properties);
  }

  private SelectablePoint2List listOf(final String points, final Property... properties) {
    return new SelectablePoint2List(new EditString("points", points), properties);
  }

  @Test
  public void testAddition() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6");
    final PointAddition add = new PointAddition();
    final SelectablePoint2 a = new SelectablePoint2(-10, -9);
    a.cachedIndex = 0;
    add.denote(a);
    final SelectablePoint2 b = new SelectablePoint2(3.5, 3.5);
    b.cachedIndex = 2;
    add.denote(b);
    final SelectablePoint2 c = new SelectablePoint2(9, 10);
    c.cachedIndex = 3;
    add.denote(c);
    list.apply(add);
    assertEquals("-10.0,-9.0,1.0,2.0,3.0,4.0,3.5,3.5,5.0,6.0,9.0,10.0", list.toString());
  }

  @Test
  public void testMultipleRemoves() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6,7,8,9,10");
    final IndexRemoval rem = new IndexRemoval();
    rem.denote(1);
    rem.denote(2);
    rem.denote(3);
    list.apply(rem);
    assertEquals("1.0,2.0,9.0,10.0", list.toString());
  }

  @Test
  public void testRemoval() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6");
    final IndexRemoval rem = new IndexRemoval();
    rem.denote(1);
    try {
      rem.denote(1);
      fail();
    } catch (final IllegalArgumentException iae) {
    }
    list.apply(rem);
    assertEquals("1.0,2.0,5.0,6.0", list.toString());
  }

  @Test
  public void verifyDownstream() {
    final EditString es = new EditString("points", "1,2");
    final SelectablePoint2List list = listOf(es);
    assertEquals(1.0, list.iterator().next().x);
    es.value("2.000,-1");
    assertEquals(2.0, list.iterator().next().x);
    assertEquals(-1.0, list.iterator().next().y);
  }

  @Test
  public void verifyEdgesLooped() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6", Property.Looped);
    final List<SelectablePoint2[]> edges = listOf(list.getSelectableEdges());
    final double[] edges2 = list.getThingSpaceEdges();
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
    final SelectablePoint2List list = listOf("1,2,3,4,5,6");
    final List<SelectablePoint2[]> edges = listOf(list.getSelectableEdges());
    final double[] edges2 = list.getThingSpaceEdges();
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
  public void verifyFinite() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6", Property.Looped, Property.Finite);
    try {
      list.apply(new IndexRemoval());
      fail();
    } catch (final IllegalArgumentException iae) {

    }
    try {
      list.apply(new PointAddition());
      fail();
    } catch (final IllegalArgumentException iae) {

    }
  }

  @Test
  public void verifyListUnpackAndIteration() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6");
    assertEquals(3, list.size());
    assertEquals(3, list.getNumberSelectablePoints());
    assertEquals("1.0,2.0,3.0,4.0,5.0,6.0", list.toString());
  }

  @Test
  public void verifyMutation() {
    final SelectablePoint2List list = listOf("1,2,3,4,5,6", Property.Looped);
    assertEquals(3, list.size());
    assertEquals(3, list.getNumberSelectablePoints());
    list.set("1,2,3,4");
    assertEquals(2, list.size());
    assertEquals("1.0,2.0,3.0,4.0", list.toString());
  }

  @Test
  public void verifyUpstream() {
    final EditString es = new EditString("points", "1,2,3,4,5,6");
    final SelectablePoint2List list = listOf(es);
    list.iterator().next().x += 1;
    assertEquals("1,2,3,4,5,6", es.value());
    list.informPointsChanged();
    assertEquals("2.0,2.0,3.0,4.0,5.0,6.0", es.value());
  }

}
