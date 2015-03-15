package io.jeffrey.vector.math;

import io.jeffrey.vector.VectorRegister4;

/**
 * Math around dealing with triangles
 *
 * @author jeffrey
 */
public class Triangles {

    /**
     * V0 -------- V1 \ / \ *V3 / \ / \ / V2
     *
     *
     *
     * @param reg
     *            vector register with V{0,1,2} the vertices of the triangle and V3 is the point to see if it is within
     * @return if V3 is in the triangle defined by V0, V1, V2
     */
    public static boolean pointInsideTriangle_Destructively(final VectorRegister4 reg) {
        reg.sub_0_from_1();
        reg.sub_0_from_2();
        reg.sub_0_from_3();
        if (reg.invert_1_2()) {
            reg.transform_3_by_1_2();
            return reg.x_3 >= 0 && reg.y_3 >= 0 && reg.x_3 + reg.y_3 <= 1;
        } else {
            return false;
        }
    }
}
