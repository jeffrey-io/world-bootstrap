package io.jeffrey.world.things.parts;

import org.junit.Test;

public class TestColorPart {

  @Test
  public void sanityCheck() {
    final PartHelper helper = new PartHelper();
    final ColorPart colorPart = new ColorPart("food", helper.getLinkedDataMap());
    colorPart.color.set("ccc");
    helper.assertWritten("food_color", "ccc");
  }
}
