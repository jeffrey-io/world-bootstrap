package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.ScalePart;

public class TestThingScaler extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final ScalePart scale = new ScalePart(data);
    final EditingPart editing = new EditingPart(data);
    mouse.move(1, 1);
    final ThingScaler scaler = new ThingScaler(mouse.get(), new IdentityTransform(), scale, editing);
    mouse.add(scaler);
    assertEquals(1.0, scale.sx());
    assertEquals(1.0, scale.sy());
    mouse.move(10, 10);
    assertEquals(11.0, scale.sx());
    assertEquals(11.0, scale.sy());
    mouse.move(-5, -5);
    assertEquals(6.0, scale.sx());
    assertEquals(6.0, scale.sy());
    scaler.commit();
    scaler.cancel();
    assertEquals(1.0, scale.sx());
    assertEquals(1.0, scale.sy());
    scaler.select();
    assertTrue(editing.selected.value());
  }
}
