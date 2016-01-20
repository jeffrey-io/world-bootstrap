package io.jeffrey.world.things.interactions;

import java.util.ArrayList;
import java.util.Collections;

import io.jeffrey.zer.AdjustedMouseEvent;

public class MultiThingInteraction extends ThingInteraction {

  private final ArrayList<ThingInteraction> interactions;
  private final Order                       order;

  public MultiThingInteraction(final ArrayList<ThingInteraction> interactions) {
    if (interactions.size() == 0) {
      throw new IllegalStateException();
    }
    if (interactions.size() == 1) {
      this.interactions = interactions;
      order = interactions.get(0).order();
    } else {
      Collections.sort(interactions);
      final boolean allSame = interactions.get(0) == interactions.get(interactions.size() - 1);
      if (allSame) {
        this.interactions = interactions;
        order = interactions.get(0).order();
      } else {
        final ArrayList<ThingInteraction> next = new ArrayList<>();
        Order lastOrder = Order.ThingLevel;
        System.out.println("PICKING:");
        for (final ThingInteraction ti : interactions) {
          System.out.println("TI:" + ti.getClass() + "/" + ti.order());
          if (ti.order() != lastOrder) {
            next.clear();
            lastOrder = ti.order();
          }
          next.add(ti);
        }
        this.interactions = next;
        order = lastOrder;
      }
    }
  }

  @Override
  public void cancel() {
    for (final ThingInteraction interaction : interactions) {
      interaction.cancel();
    }
  }

  @Override
  public void moved(final AdjustedMouseEvent event) {
    for (final ThingInteraction interaction : interactions) {
      interaction.moved(event);
    }
  }

  @Override
  public Order order() {
    return order;
  }

}
