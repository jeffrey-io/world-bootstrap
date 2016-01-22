package io.jeffrey.world.things;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTPolygon extends WorldTestFramework {
  @Test
  public void construct() {
    new TPolygon(makeSimpleContainer(), emptyData());
  }
}
