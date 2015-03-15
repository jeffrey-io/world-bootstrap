package io.jeffrey.vector.math;

import io.jeffrey.vector.VectorRegister6;

/**
 * Math for dealing with polygons
 */
public class Polygons {

    /**
     *
     * @param x
     *            the x coordinate of the point to check
     * @param y
     *            the y coordinate of the point to check
     * @param coordinates
     *            the coordinates (x0, y0, x1, y1, ....) defining the polygon
     * @param temp
     *            a temporary register where math can be done
     * @return
     */
    public static boolean pointIn(final double x, final double y, final double[] coordinates, final VectorRegister6 temp) {
        final int n = coordinates.length;
        int count = 0;
        double m = coordinates[0];
        for (int k = 0; k < n; k++) {
            m = Math.max(coordinates[k], m);
        }
        m += 1;
        for (int k = 0; k + 1 < n; k += 2) {
            temp.set_0(coordinates[k], coordinates[k + 1]);
            temp.set_1(coordinates[(k + 2) % n], coordinates[(k + 3) % n]);
            temp.set_2(x, y);
            temp.set_3(m, m);
            if (Lines.doLinesIntersect_Destructively(temp, true, true)) {
                count++;
            }
        }
        return count % 2 == 1;
    }
}
