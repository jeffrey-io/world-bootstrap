package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestColorPart extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    final PartHelper helper = new PartHelper();
    final ColorPart colorPart = new ColorPart("food", helper.newLinkedDataMap());
    colorPart.color.set("ccc");
    helper.assertWritten("food_color", "ccc");
  }
}
