package io.jeffrey.world.things.interactions;

import java.util.Collection;

import io.jeffrey.zer.AdjustedMouseEvent;

public class MultiThingInteraction implements ThingInteraction {

  private final Collection<ThingInteraction> interactions;

  public MultiThingInteraction(final Collection<ThingInteraction> interactions) {
    this.interactions = interactions;
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

}
