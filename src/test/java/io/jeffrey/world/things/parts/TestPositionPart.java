package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.RoundingSnap;

public class TestPositionPart extends WorldTestFramework {
  @Test
  public void sanityCheck() {
    LinkedDataMap data = emptyData();
    PositionPart position = new PositionPart(data, new RoundingSnap());
    
    position.x(1.2);
    assertEquals(1, position.x());
    position.y(2.7);
    assertEquals(3, position.y());
  }
}
