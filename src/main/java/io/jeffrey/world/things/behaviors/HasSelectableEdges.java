package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.points.SelectablePoint2;

public interface HasSelectableEdges {
  public Iterable<SelectablePoint2[]> getSelectableEdges();
}
