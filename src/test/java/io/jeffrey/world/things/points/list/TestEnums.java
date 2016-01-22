package io.jeffrey.world.things.points.list;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestEnums extends WorldTestFramework {

  @Test
  public void verifySelectedAndBoundary() {
    assertEquals(SegmentSelectMode.SelectedAndBoundary, SegmentSelectMode.valueOf("SelectedAndBoundary"));
    assertEquals("SelectedAndBoundary", SegmentSelectMode.SelectedAndBoundary.toString());
  }

  @Test
  public void verityProperty() {
    assertEquals(Property.Finite, Property.valueOf("Finite"));
    assertEquals("Finite", Property.Finite.toString());
  }
}
