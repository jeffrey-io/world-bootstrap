package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestIdentityPart extends WorldTestFramework {

  @Test
  public void verifyAccessors() {
    final IdentityPart identity = new IdentityPart(data());
    assertTrue(identity.getID() instanceof String);
    assertTrue(identity.getID().length() > 12);
    assertNull(identity.getType());
  }

  @Test
  public void verifyPullFromMap() {
    final IdentityPart identity = new IdentityPart(data("id", "cake", "_type", "ty"));
    assertEquals("cake", identity.getID());
    assertEquals("ty", identity.getType());
  }
}
