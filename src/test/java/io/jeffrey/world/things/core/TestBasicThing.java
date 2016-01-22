package io.jeffrey.world.things.core;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestBasicThing extends WorldTestFramework {

  @Test
  public void verifyTransformPresent() {
    final BasicThing thing = new BasicThing(makeSimpleContainer(), emptyData());
    assertTrue(thing.transform() instanceof StandardTransform);
  }
}
