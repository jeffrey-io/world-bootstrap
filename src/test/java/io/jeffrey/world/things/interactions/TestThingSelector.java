package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.EditingPart;

public class TestThingSelector extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final EditingPart editing = new EditingPart(data);
    final ThingSelector selector = new ThingSelector(editing);
    mouse.add(selector);
    mouse.move(1, 1);
    selector.cancel();
    assertFalse(editing.selected.value());
    selector.select();
    assertTrue(editing.selected.value());
  }
}
