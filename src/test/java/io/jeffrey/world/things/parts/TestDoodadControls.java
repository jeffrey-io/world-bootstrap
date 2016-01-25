package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestDoodadControls extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    assertEquals(DoodadControls.All, DoodadControls.valueOf("All"));
  }
}
