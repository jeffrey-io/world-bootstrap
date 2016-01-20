package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

public interface CanBeInteractedWithByMouse {

  public ThingInteraction startInteraction(final AdjustedMouseEvent event);
}
