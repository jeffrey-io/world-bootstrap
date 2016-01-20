package io.jeffrey.world.things.behaviors;

import javafx.scene.paint.Color;

public interface HasColorsToEmit {
  public Color queryTargetColor(final double x, final double y);
}
