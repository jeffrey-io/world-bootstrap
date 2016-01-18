package io.jeffrey.world.things.base;

/**
 * A doodad is a mechanism for things to emit points of interest to control the thin in question
 *
 * @author jeffrey
 *
 */
public class ControlDoodad {

  public static enum Type {
    PointSelected, // a point under control of the thing that is selected
    PointUnselected, // a point under control of the thing that is not selected
    Rotate, // the doodad to control rotation
    Scale // the doodad to control scale of the thing
  }

  /**
   * The type of the thing
   */
  public Type   type;

  /**
   * the x coordinate position of the doodad in thing space
   */
  public double u;

  /**
   * the y coordinate position of the doodad in thing space
   */
  public double v;

  /**
   * @param type
   *          the type of the doodad
   * @param u
   *          the x coordinate
   * @param v
   *          the y coodinate
   */
  public ControlDoodad(final Type type, final double u, final double v) {
    this.type = type;
    this.u = u;
    this.v = v;
  }
}
