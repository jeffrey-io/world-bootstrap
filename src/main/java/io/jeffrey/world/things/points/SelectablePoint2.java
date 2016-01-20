package io.jeffrey.world.things.points;

/**
 * a very simple mutable point in two space
 *
 * @author jeffrey
 */
public class SelectablePoint2 {
  /**
   * was the point already selected; this enables selection caching
   */
  public boolean alreadySelected = false;

  /**
   * a cached index for consumers to use for optimization
   */
  public int     cachedIndex;

  /**
   * is the point selected
   */
  public boolean selected        = false;

  /**
   * the x coordinate
   */
  public double  x;

  /**
   * the y coordinate
   */
  public double  y;

  /**
   * @param x
   *          the x coordinate
   * @param y
   *          the y coordinate
   */
  public SelectablePoint2(final double x, final double y) {
    this.x = x;
    this.y = y;
    cachedIndex = -1;
    selected = false;
  }
}