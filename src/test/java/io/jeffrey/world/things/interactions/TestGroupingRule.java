package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestGroupingRule extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    assertEquals(GroupingRule.Set, GroupingRule.valueOf("Set"));
  }
}
