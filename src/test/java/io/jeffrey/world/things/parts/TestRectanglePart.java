package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.parts.RectanglePart.DoodadControls;

public class TestRectanglePart extends WorldTestFramework {

  @Test
  public void verify() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.All);
    rectangle.set(0, 1, 3, 4);
    assertFalse(rectangle.contains(-1, -1));
    assertTrue(rectangle.contains(2, 2));
    assertEquals(8, rectangle.getDoodadsInThingSpace().length);
  }

}
