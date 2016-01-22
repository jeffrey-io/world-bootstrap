package io.jeffrey.world.things;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTTurtle extends WorldTestFramework {
  @Test
  public void construct() {
    new TTurtle(makeSimpleContainer(), emptyData());
  }
}
