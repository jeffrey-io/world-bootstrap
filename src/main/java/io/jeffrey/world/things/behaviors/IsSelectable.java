package io.jeffrey.world.things.behaviors;

import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public interface IsSelectable {

  public static enum ContainmentCheck {
    CloseEnoughToMaintainSelection, ExactlyInside
  }

  public boolean contains(final double x, final double y, ContainmentCheck check);

  /**
   * @param polygon
   *          the shape test
   * @param mode
   *          the mode of selection
   * @return does the given polygon (selection pattern) intersect the given
   */
  public boolean selectionIntersect(final Polygon polygon, final Mode mode);

}
