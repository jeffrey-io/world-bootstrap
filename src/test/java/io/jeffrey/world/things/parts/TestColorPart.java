package io.jeffrey.world.things.parts;

import org.junit.Test;

public class TestColorPart {

  @Test
  public void sanityCheck() {
    PartHelper helper = new PartHelper();
    ColorPart colorPart = new ColorPart("food", helper.getLinkedDataMap());
    colorPart.color.set("ccc");
    helper.assertWritten("food_color", "ccc");
  }
}
