package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.zer.AdjustedMouseEvent;

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

  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event);

  /**
   * @param polygon
   *          the shape test
   * @param mode
   *          the mode of selection
   * @return does the given polygon (selection pattern) intersect the given
   */
  public boolean selectionIntersect(SelectionModel model);
}
