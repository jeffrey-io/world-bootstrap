package io.jeffrey.world.things.core;

/**
 * Informs how to snap coordinates onto their respective grid (or other thing)
 *
 * @author jeffrey
 */
public interface Snap {

  /**
   * @return the snapped x coordinate
   */
  public double x(double x);

  /**
   * @return the snapped y coordinate
   */
  public double y(double y);
}
