package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestSingleColorEmitterPart extends WorldTestFramework {

  @Test
  public void verify() {
    final ColorPart color = new ColorPart("prefix", "ccc", data());
    final IsSelectableMock mock = new IsSelectableMock();
    final SingleColorEmitterPart emitter = new SingleColorEmitterPart(color, mock);
    assertNull(emitter.queryTargetColor(0, 0));
    mock.containmentReturnValue = true;
    assertNotNull(emitter.queryTargetColor(0, 0));
  }
}
