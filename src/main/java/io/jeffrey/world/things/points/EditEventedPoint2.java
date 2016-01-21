package io.jeffrey.world.things.points;

import io.jeffrey.zer.edits.Edit;

/**
 * a linke to a vertex value in a point
 *
 * @author jeffrey
 */
public class EditEventedPoint2 implements Edit {
  private final boolean       isEditingX;
  private final String        name;
  private final double        value;
  private final EventedPoint2 vertex;

  /**
   * @param index
   *          the index of the point
   * @param vertex
   *          the vertex we are editing
   * @param isEditingX
   *          are we editing the x coordinate as opposed to the y coordinate
   */
  public EditEventedPoint2(final int index, final EventedPoint2 vertex, final boolean isEditingX) {
    name = Integer.toString(index);
    this.vertex = vertex;
    this.isEditingX = isEditingX;
    value = isEditingX ? vertex.x : vertex.y;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAsText() {
    return Double.toString(value);
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
        vertex.setChange(nv - value, 0);
      } else {
        vertex.setChange(0, nv - value);
      }
      return true;
    } catch (final NumberFormatException nfe) {
      return false;
    }
  }
}