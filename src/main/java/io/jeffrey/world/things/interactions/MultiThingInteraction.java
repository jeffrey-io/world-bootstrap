package io.jeffrey.world.things.interactions;

import java.util.ArrayList;
import java.util.Collections;

import io.jeffrey.zer.AdjustedMouseEvent;

public class MultiThingInteraction extends ThingInteraction {

  private final ArrayList<ThingInteraction> interactions;

  public MultiThingInteraction(final ArrayList<ThingInteraction> interactions) {
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

  @Override
  public void select() {
    for (final ThingInteraction ti : interactions) {
      ti.select();
    }
  }

}
