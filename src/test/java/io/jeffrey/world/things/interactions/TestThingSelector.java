package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.EditingPart;

public class TestThingSelector extends WorldTestFramework {

  @Test
  public void verify() {
    LinkedDataMap data = data();
    SimulatedMouse mouse = new SimulatedMouse();
    EditingPart editing = new EditingPart(data);
    ThingSelector selector = new ThingSelector(editing);
    mouse.add(selector);
    mouse.move(1, 1);
    selector.cancel();
    assertFalse(editing.selected.value());
    selector.select();
    assertTrue(editing.selected.value());
  }
}
