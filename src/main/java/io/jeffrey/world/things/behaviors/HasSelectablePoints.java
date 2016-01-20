package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.points.SelectablePoint2;

public interface HasSelectablePoints extends Iterable<SelectablePoint2> {
  public abstract int getNumberSelectablePoints();
}
