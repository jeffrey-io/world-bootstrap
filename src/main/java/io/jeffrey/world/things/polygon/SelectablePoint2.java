package io.jeffrey.world.things.polygon;

/**
 * a very simple mutable point in two space
 *
 * @author jeffrey
 */
public class SelectablePoint2 {
    /**
     * a cached index for consumers to use for optimization
     */
    public int     cachedIndex;

    /**
     * was the point already selected
     */
    public boolean alreadySelected = false;
    
    /**
     * is the point selected
     */
    public boolean selected = false;

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
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public SelectablePoint2(final double x, final double y) {
        this.x = x;
        this.y = y;
        cachedIndex = -1;
        selected = false;
    }
}