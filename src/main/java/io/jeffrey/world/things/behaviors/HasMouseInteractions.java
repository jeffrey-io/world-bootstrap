package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

public interface HasMouseInteractions {

  public ThingInteraction startInteraction(final AdjustedMouseEvent event);
}
