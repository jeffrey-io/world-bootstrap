package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestColorPart extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    final PartHelper helper = new PartHelper();
    final ColorPart colorPart = new ColorPart("food", "fff", helper.newLinkedDataMap());
    assertEquals("fff", colorPart.color.value());
    colorPart.color.setByText("ccc");
    helper.assertWritten("food_color", "ccc");
    assertNotNull(colorPart.getCachedColor());
    colorPart.color.setByText("dogfood");
    assertNotNull(colorPart.getCachedColor());
  }
}
