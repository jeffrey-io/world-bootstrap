package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.interactions.SelectionSolver;
import io.jeffrey.zer.AdjustedMouseEvent;

public interface HasSelectionByPoint {

  public void buildSelectionSolver(SelectionSolver solver);
}
