package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestEditEventedPoint2 extends WorldTestFramework {

  @Test
  public void sanityCheckXEditing() {
    SelectablePoint2 point = new SelectablePoint2(1, 2);
    HasUpdateMock mock = new HasUpdateMock();
    EventedPoint2 evPoint = new EventedPoint2(point, mock);
    EditEventedPoint2 edit = new EditEventedPoint2(-1, evPoint, true);
    assertEquals("-1", edit.name());
    assertEquals("1.0", edit.getAsText());
    assertFalse(edit.setByText("foo"));
    assertEquals("1.0", edit.getAsText());
    assertTrue(edit.setByText("4"));
    assertEquals(4.0, point.x);
    assertEquals("4.0", edit.getAsText());
  }
  
  @Test
  public void sanityCheckYEditing() {
    SelectablePoint2 point = new SelectablePoint2(1, 2);
    HasUpdateMock mock = new HasUpdateMock();
    EventedPoint2 evPoint = new EventedPoint2(point, mock);
    EditEventedPoint2 edit = new EditEventedPoint2(-2, evPoint, false);
    assertEquals("-2", edit.name());
    assertEquals("2.0", edit.getAsText());
    assertFalse(edit.setByText("foo"));
    assertEquals("2.0", edit.getAsText());
    assertTrue(edit.setByText("7"));
    assertEquals(7.0, point.y);
    assertEquals("7.0", edit.getAsText());
  }
}
