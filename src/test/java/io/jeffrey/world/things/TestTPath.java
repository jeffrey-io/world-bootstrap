package io.jeffrey.world.things;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTPath extends WorldTestFramework {
  @Test
  public void construct() {
    new TPath(makeSimpleContainer(), emptyData());
  }
}
