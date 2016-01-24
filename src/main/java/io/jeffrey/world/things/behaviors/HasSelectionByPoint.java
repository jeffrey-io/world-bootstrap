package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.interactions.InteractionSelectionSolver;

public interface HasSelectionByPoint {

  public boolean buildSelectionSolver(InteractionSelectionSolver solver);
}
