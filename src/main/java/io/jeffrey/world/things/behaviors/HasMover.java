package io.jeffrey.world.things.behaviors;

import java.util.Set;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

public interface HasMover {
  public void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event);
}
