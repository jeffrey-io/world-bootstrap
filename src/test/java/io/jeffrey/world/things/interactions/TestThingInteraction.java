package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.zer.AdjustedMouseEvent;

public class TestThingInteraction extends WorldTestFramework {

  private ThingInteraction minimalThing() {
    return new ThingInteraction() {

      @Override
      public void cancel() {
      }

      @Override
      public void moved(final AdjustedMouseEvent event) {
      }

      @Override
      public void select() {
      }
    };
  }

  @Test
  public void sanityCheckOrdering() {
  }
}
