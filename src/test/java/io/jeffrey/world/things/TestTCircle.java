package io.jeffrey.world.things;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTCircle extends WorldTestFramework {

  @Test
  public void construct() {
    new TCircle(makeSimpleContainer(), data());
  }
}
