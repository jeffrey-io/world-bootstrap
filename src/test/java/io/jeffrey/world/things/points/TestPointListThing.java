package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.points.list.Property;

public class TestPointListThing extends WorldTestFramework {

  @Test
  public void construct() {
    PointListThing thing;
    thing = new PointListThing(makeSimpleContainer(), emptyData(), Property.Finite);
    assertTrue(thing.list.finite);
    assertFalse(thing.list.looped);
    thing = new PointListThing(makeSimpleContainer(), emptyData(), Property.Looped);
    assertFalse(thing.list.finite);
    assertTrue(thing.list.looped);
    thing = new PointListThing(makeSimpleContainer(), emptyData(), Property.Looped, Property.Finite);
    assertTrue(thing.list.finite);
    assertTrue(thing.list.looped);
  }

  @Test
  public void verifyUnselectPropagates() {
    PointListThing thing;
    thing = new PointListThing(makeSimpleContainer(), emptyData(), Property.Finite);
    thing.editing.selected.value(true);
    thing.list.iterator().next().selected = true;
    thing.editing.selected.value(false);
    assertFalse(thing.list.iterator().next().selected);
    thing.editing.selected.value(false);
  }

}
