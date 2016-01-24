package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;

public class TestEventedPoint2Mover extends WorldTestFramework {
  @Test
  public void verifyEventing() {
    final SelectablePoint2 point = new SelectablePoint2(1, 2);
    final HasUpdateMock mock = new HasUpdateMock();
    final EventedPoint2 evPoint = new EventedPoint2(point, mock);
    final SimulatedMouse mouse = new SimulatedMouse();
    final EventedPoint2Mover mover = new EventedPoint2Mover(evPoint, mouse.get());
    mouse.add(mover);
    mock.assertUpdateCallsMadeEquals(0);
    mouse.move(7, 8);
    assertEquals(8, point.x);
    assertEquals(10, point.y);
    mock.assertUpdateCallsMadeEquals(1);
    mover.cancel();
    assertEquals(1, point.x);
    assertEquals(2, point.y);
    mock.assertUpdateCallsMadeEquals(2);
    point.selected = false;
    mover.select();
    assertTrue(point.selected);
  }
}
