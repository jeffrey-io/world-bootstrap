package io.jeffrey.world.things.parts;

import java.util.HashSet;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;

public class TestScalePart extends WorldTestFramework {

  @Test
  public void sanityCheck() {
    final LinkedDataMap data = emptyData();
    final ScalePart scale = new ScalePart(data);
    scale.sx(4);
    assertEquals(4, scale.sx());
    scale.sy(6);
    assertEquals(6, scale.sy());
    final HashSet<String> actions = new HashSet<>();
    scale.listActions(actions);
    assertEquals(1, actions.size());
    assertEquals("normalize_scale", actions.iterator().next());
    scale.invokeAction("normalize_scale", null);
    assertEquals(5, scale.sx());
    assertEquals(5, scale.sy());
    scale.invokeAction("noop", null);
  }
}
