package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.RoundingSnap;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;

public class TestThingMover extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final PositionPart position = new PositionPart(data, new RoundingSnap());
    final RotationPart rotation = new RotationPart(data);
    final EditingPart editing = new EditingPart(data);
    position.x(1);
    position.y(2);
    mouse.go(2.5, 3.5);
    final ThingMover mover = new ThingMover(mouse.get(), position, rotation, editing);
    mouse.add(mover);
    assertEquals(1, position.x());
    assertEquals(2, position.y());
    mouse.move(3.2, 3.9);
    assertEquals(4, position.x());
    assertEquals(6, position.y());
    assertFalse(editing.selected.value());
    mover.select();
    assertTrue(editing.selected.value());
    mover.cancel();
    assertEquals(1, position.x());
    assertEquals(2, position.y());
  }

  @Test
  public void verifyWithRotation() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final PositionPart position = new PositionPart(data, new RoundingSnap());
    final EditingPart editing = new EditingPart(data);
    position.x(1);
    position.y(2);
    mouse.go(2.5, 3.5);
    final ThingMover mover = new ThingMover(mouse.get(), position, null, editing);
    mouse.add(mover);
    assertEquals(1, position.x());
    assertEquals(2, position.y());
    mouse.move(3.2, 3.9);
    assertEquals(4, position.x());
    assertEquals(6, position.y());
    assertFalse(editing.selected.value());
    mover.select();
    assertTrue(editing.selected.value());
    mover.cancel();
    assertEquals(1, position.x());
    assertEquals(2, position.y());
  }
}
