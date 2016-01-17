package io.jeffrey.world.things.polygon;

import io.jeffrey.zer.edits.Edit;

/**
 * a linke to a vertex value in a point
 *
 * @author jeffrey
 */
public class EditVertex extends Edit {
  private final boolean isEditingX;
  private final String  name;
  private final double  value;
  private final Vertex  vertex;

  /**
   * @param index
   *          the index of the point
   * @param vertex
   *          the vertex we are editing
   * @param isEditingX
   *          are we editing the x coordinate as opposed to the y coordinate
   */
  public EditVertex(final int index, final Vertex vertex, final boolean isEditingX) {
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
        vertex.update(nv - value, 0);
      } else {
        vertex.update(0, nv - value);
      }
      return true;
    } catch (final NumberFormatException nfe) {
      return false;
    }
  }
}