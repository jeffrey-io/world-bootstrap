package io.jeffrey.world.things.points;

import io.jeffrey.world.data.Edit;

/**
 * a linke to a vertex value in a point
 *
 * @author jeffrey
 */
public class EditEventedPoint2 implements Edit {
  private final boolean       isEditingX;
  private final String        name;
  private final EventedPoint2 point;
  private final double        value;

  /**
   * @param index
   *          the index of the point
   * @param point
   *          the vertex we are editing
   * @param isEditingX
   *          are we editing the x coordinate as opposed to the y coordinate
   */
  public EditEventedPoint2(final int index, final EventedPoint2 point, final boolean isEditingX) {
    name = Integer.toString(index);
    this.point = point;
    this.isEditingX = isEditingX;
    value = isEditingX ? point.initialX : point.initialY;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAsText() {
    if (isEditingX) {
      return Double.toString(point.data.x);
    } else {
      return Double.toString(point.data.y);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean setByText(final String z) {
    try {
      final double nv = Double.parseDouble(z);
      if (isEditingX) {
        point.setChange(nv - value, 0);
      } else {
        point.setChange(0, nv - value);
      }
      return true;
    } catch (final NumberFormatException nfe) {
      return false;
    }
  }
}