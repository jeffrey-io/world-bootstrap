package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestEnforcersPart extends WorldTestFramework {

  @Test
  public void verify() {
    assertEquals(0, new EnforcersPart().getGuideLineEnforcers().size());
    assertEquals(1, new EnforcersPart(new NoOpGuidelineEnforcer()).getGuideLineEnforcers().size());
  }
}
