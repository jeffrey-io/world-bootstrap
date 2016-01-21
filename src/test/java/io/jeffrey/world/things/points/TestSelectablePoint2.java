package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestSelectablePoint2 extends WorldTestFramework {

  @Test
  public void sanityCheckStructuralPropertiesAndInitialConditions() {
    SelectablePoint2 point = new SelectablePoint2(1, 2);
    assertEquals(1, point.x);
    assertEquals(2, point.y);
    assertEquals(-1, point.cachedIndex);
    assertFalse(point.selected);
    assertFalse(point.alreadySelected);
    point.selected = true;
    assertTrue(point.selected);
    assertFalse(point.alreadySelected);
  }
}
