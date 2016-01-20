package io.jeffrey.world.things.behaviors;

public interface HasInternalStateThatMayNeedManualUpdating {
  /**
   * data has changed, refresh it
   */
  public void updateInternalState();
}
