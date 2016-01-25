package io.jeffrey.world.things.points;

import io.jeffrey.world.things.behaviors.HasSelectablePoints;
import io.jeffrey.world.things.interactions.ThingCommitmentHook;

public class SelectablePointsCommitment extends ThingCommitmentHook {

  private final HasSelectablePoints points;

  public SelectablePointsCommitment(final HasSelectablePoints points) {
    this.points = points;
  }

  @Override
  public void commit() {
    points.informPointsChanged();
  }
}
