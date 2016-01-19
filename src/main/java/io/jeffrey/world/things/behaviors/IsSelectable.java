package io.jeffrey.world.things.behaviors;

import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

/**
 * Denotes whether or not the item is selectable or not
 *
 * @author jeffrey
 */
public interface IsSelectable {
  /**
   * does the thing contain the given point
   *
   * @param x
   *          the x coordinate to check
   * @param y
   *          the y coordinate to check
   * @param check
   *          how well should we check
   * @return true if the point satisfies the containment check
   */
  public boolean contains(final double x, final double y);

  /**
   * does the given mouse event preserve the existing selection
   * 
   * @param event
   *          the mouse even
   * @return whether or not the event will not mess with existing selection
   */
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event);

  /**
   * @param polygon
   *          the shape test
   * @param mode
   *          the mode of selection
   * @return does the given polygon (selection pattern) intersect the given
   */
  public boolean selectionIntersect(final Polygon polygon, final Mode mode);

}
