package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.RotationPart;

public class TestThingRotater extends WorldTestFramework {
  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final RotationPart rotation = new RotationPart(data);
    final EditingPart editing = new EditingPart(data);
    final ThingRotater rotater = new ThingRotater(mouse.get(), new IdentityTransform(), rotation, editing);
    mouse.add(rotater);
    assertEquals(0, rotation.angle());
    mouse.move(1, 1);
    assertEquals(-45, rotation.angle());
    rotater.cancel();
    assertEquals(0, rotation.angle());
    rotater.commit();
    rotater.select();
    assertTrue(editing.selected.value());
  }

  @Test
  public void verifyLock() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final RotationPart rotation = new RotationPart(data);
    final EditingPart editing = new EditingPart(data);
    final ThingRotater rotater = new ThingRotater(mouse.get(), new IdentityTransform(), rotation, editing);
    mouse.add(rotater);
    mouse.altdown = true;
    assertEquals(0, rotation.angle());
    mouse.move(10, 30);
    assertEquals(-75.0, rotation.angle());
    rotater.cancel();
    assertEquals(0, rotation.angle());
    rotater.commit();
    rotater.select();
    assertTrue(editing.selected.value());
  }
}
