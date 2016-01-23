package io.jeffrey.world.things.parts;

import java.util.HashSet;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;

public class TestRotationPart extends WorldTestFramework {
  @Test
  public void sanityCheck() {
    final LinkedDataMap data = emptyData();
    final RotationPart rotation = new RotationPart(data);

    rotation.angle(90);
    assertEquals(90, rotation.angle());

    assertEquals(0, rotation.cx);
    assertEquals(1, rotation.cy);

    final HashSet<String> actions = new HashSet<>();
    rotation.listActions(actions);
    assertEquals(1, actions.size());
    assertEquals("reset_angle", actions.iterator().next());

    rotation.invokeAction("reset_angle", null);
    assertEquals(1, rotation.cx);
    assertEquals(0, rotation.cy);

    rotation.invokeAction("noop", null);

  }

}
