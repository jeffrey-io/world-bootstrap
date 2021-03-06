package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.RoundingSnap;

public class TestPositionPart extends WorldTestFramework {
  @Test
  public void sanityCheck() {
    final LinkedDataMap data = data();
    final PositionPart position = new PositionPart(data, new RoundingSnap());

    position.x(1.2);
    assertEquals(1, position.x());
    position.y(2.7);
    assertEquals(3, position.y());
    position.move(2, 7);
    assertEquals(3, position.x());
    assertEquals(10, position.y());
  }
}
