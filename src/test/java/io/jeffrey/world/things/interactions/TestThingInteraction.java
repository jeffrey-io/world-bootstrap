package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.interactions.ThingInteraction.Order;
import io.jeffrey.zer.AdjustedMouseEvent;

public class TestThingInteraction extends WorldTestFramework {

  @Test
  public void sanityCheckOrdering() {
    Order a = Order.SingleOfThing;
    Order b = Order.WorldLevel;
    ThingInteraction ta = minimalThing(a);
    ThingInteraction tb = minimalThing(b);
    assertTrue(ta.compareTo(tb) > 0);
    assertTrue(tb.compareTo(ta) < 0);
    assertTrue(ta.compareTo(ta) == 0);
    assertTrue(tb.compareTo(tb) == 0);
  }
  
  private ThingInteraction minimalThing(final Order order) {
    return new ThingInteraction() {
      
      @Override
      public Order order() {
        return order;
      }
      
      @Override
      public void moved(AdjustedMouseEvent event) {
      }
      
      @Override
      public void cancel() {
      }
    };
  }
}
