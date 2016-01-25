package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestRule extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    assertEquals(Rule.AlreadySelectedFacetAndPointPreserves, Rule.valueOf("AlreadySelectedFacetAndPointPreserves"));
  }
}
