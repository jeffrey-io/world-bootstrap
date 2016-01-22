package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.interactions.ThingInteraction.Order;
import io.jeffrey.zer.AdjustedMouseEvent;

public class TestThingInteraction extends WorldTestFramework {

  private ThingInteraction minimalThing(final Order order) {
    return new ThingInteraction() {

      @Override
      public void cancel() {
      }

      @Override
      public void moved(final AdjustedMouseEvent event) {
      }

      @Override
      public Order order() {
        return order;
      }
    };
  }

  @Test
  public void sanityCheckOrdering() {
    final Order a = Order.SingleOfThing;
    final Order b = Order.WorldLevel;
    final ThingInteraction ta = minimalThing(a);
    final ThingInteraction tb = minimalThing(b);
    assertTrue(ta.compareTo(tb) > 0);
    assertTrue(tb.compareTo(ta) < 0);
    assertTrue(ta.compareTo(ta) == 0);
    assertTrue(tb.compareTo(tb) == 0);
  }
}
