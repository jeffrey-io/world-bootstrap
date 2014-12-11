package io.jeffrey.world.things.polygon;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Add a bunch of points
 *
 * @author jeffrey
 *
 */
public class PointAddition {

    private final ArrayList<SelectablePoint2> additions = new ArrayList<SelectablePoint2>();

    /**
     * @param pnt
     *            the point we wish to add (the cacheIndex will tell us where to add it)
     */
    public void denote(final SelectablePoint2 pnt) {
        additions.add(pnt);
    }

    /**
     * insert all the denoted points
     *
     * @param points
     *            where the points will go
     */
    public void insert(final ArrayList<SelectablePoint2> points) {
        additions.sort(new Comparator<SelectablePoint2>() {
            @Override
            public int compare(final SelectablePoint2 o1, final SelectablePoint2 o2) {
                return o2.cachedIndex - o1.cachedIndex;
            }
        });
        for (final SelectablePoint2 p : additions) {
            points.add(p.cachedIndex, p);
        }
    }
}
