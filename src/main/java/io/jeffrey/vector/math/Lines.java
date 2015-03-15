package io.jeffrey.vector.math;

import io.jeffrey.vector.VectorRegister1;
import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;

/**
 * Easy math around dealing with lines
 *
 * @author jeffrey
 */
public class Lines {
    /**
     * are the three vectors colinear when written as a line [V0],[V1],V[2]
     *
     * @param reg
     *            the register banks
     * @param resultIfZeroLengthInvolved
     *            if either the vectors touch each other (you either have a problem with your data, or you want to return true)
     * @return are the three vectors colinear
     */
    public static boolean colinear_Destructive(final VectorRegister3 reg, final boolean resultIfZeroLengthInvolved) {
        reg.sub_0_from_1();
        reg.sub_0_from_2();
        if (!reg.normalize_1()) {
            return resultIfZeroLengthInvolved;
        }
        if (!reg.normalize_2()) {
            return resultIfZeroLengthInvolved;
        }
        return Math.abs(1 - reg.dot_1_2()) < VectorRegister1.ZERO_LIMIT;
    }

    /**
     *
     * [V2] | | [V0] ---------------*-------------- [V1] | | [V3]
     */
    public static boolean doLinesIntersect_Destructively(final VectorRegister6 reg, final boolean segmentA, final boolean segmentB) {
        // Solve:

        // V0 * A + V1 * (1 - A) = V2 * B + V3 * ( 1 - B )
        // (V0 - V1) * A + V1 = (V2 - V3) * B + V3
        // (V0 - V1) * A - (V2 - V3) * B = V3 - V1
        // --(V0 - V1) * A + -(V2 - V3) *B = -(V1 - V3)

        // X = V0 - V1
        // Y = V2 - V3
        // Z = V1 - V3

        // --X A + -Y B = -C --> -X A + Y B = C
        reg.copy_from_0_to_4();
        reg.copy_from_1_to_5();
        reg.sub_1_from_0();
        reg.mult_0_by(-1);
        reg.sub_3_from_2();
        reg.sub_3_from_1();
        // V0 A + V2 B = V 1
        if (reg.invert_0_2()) {
            reg.transform_1_by_0_2();
            reg.mult_4_by(reg.x_1);
            reg.mult_5_by(1.0 - reg.x_1);
            reg.add_5_to_4();
            reg.copy_from_4_to_0();
            final boolean checkA = segmentA && reg.x_1 >= 0 && reg.x_1 <= 1 || !segmentA;
            final boolean checkB = segmentB && reg.y_1 >= 0 && reg.y_1 <= 1 || !segmentB;
            return checkA && checkB;
        } else {
            return false;
        }
    }

    /**
     * ---------[V0] ------------[V0']-------------- [V1]----------- | | [V2]
     *
     * Find the distance between the given vector 2 and the line formed by vectors 0 and 1.
     *
     * @param reg
     *            the register bank
     * @return return the distance from [V2] and [V0'] where [V0']
     */
    public static double minimalDistanceV2toLineContainingV0V1_Destructive(final VectorRegister3 reg) {
        reg.sub_0_from_1();
        reg.sub_0_from_2();
        if (!reg.normalize_1()) {
            return -1;
        }
        final double lambda = reg.dot_1_2();
        reg.mult_1_by(lambda);
        reg.add_1_to_0();
        reg.sub_1_from_2();
        return reg.length_2();
    }

    /**
     * [V0] ------------[V0']-------------- [V1] | | [V2]
     *
     * Find the distance between the given vector 2 and the line formed by vectors 0 and 1.
     *
     * @param reg
     *            the register bank
     * @return return the distance from [V2] and [V0'] where [V0']
     */
    public static double minimalDistanceV2toLineSegmentV0V1_Destructive(final VectorRegister3 reg) {
        reg.sub_0_from_1();
        reg.sub_0_from_2();
        if (reg.is_1_zero()) {
            return -1;
        }
        final double len = reg.length_1();
        reg.div_1_by(len);
        double lambda = reg.dot_1_2();
        if (lambda < 0) {
            lambda = 0;
        } else if (lambda > len) {
            lambda = len;
        }
        reg.mult_1_by(lambda);
        reg.add_1_to_0();
        reg.sub_1_from_2();
        return reg.length_2();
    }
}
