package io.jeffrey.world.things.behaviors;

import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

/**
 * Denotes whether or not the item is selectable or not
 * 
 * @author jeffrey
 */
public interface IsSelectable {

  public static enum ContainmentCheck {
    CloseEnoughToMaintainSelection, ExactlyInside
  }

  /**
   * does the thing contain the given point
   * 
   * @param x
   *          the x coordinate to check
   * @param y
   *          the y coodinate to check
   * @param check
   *          how well should we check
   * @return true if the point satisfies the containment check
   */
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