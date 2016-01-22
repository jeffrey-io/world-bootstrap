package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestEventedPoint2 extends WorldTestFramework {

  @Test
  public void verifyPropagation() {
    final SelectablePoint2 point = new SelectablePoint2(1, 2);
    final HasUpdateMock mock = new HasUpdateMock();
    final EventedPoint2 evPoint = new EventedPoint2(point, mock);
    mock.assertUpdateCallsMadeEquals(0);
    evPoint.setChange(4, 5);
    assertEquals(5, point.x);
    assertEquals(7, point.y);
    mock.assertUpdateCallsMadeEquals(1);
    evPoint.reset();
    assertEquals(1, point.x);
    assertEquals(2, point.y);
    mock.assertUpdateCallsMadeEquals(2);
  }
}
