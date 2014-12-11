package io.jeffrey.world.math;

/**
 * Very simple immutable class to represent a vector/point in two space
 *
 * @author jeffrey
 *
 */
public class Vector2X {

    /**
     * the x-coordinate
     */
    public final double x;

    /**
     * the y-coordinate
     */
    public final double y;

    /**
     * @param x
     *            coordinate
     * @param y
     *            coordinate
     */
    public Vector2X(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
}
