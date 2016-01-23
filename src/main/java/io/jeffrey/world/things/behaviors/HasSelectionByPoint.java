package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.interactions.SelectionSolver;

public interface HasSelectionByPoint {

  public boolean buildSelectionSolver(SelectionSolver solver);
}
