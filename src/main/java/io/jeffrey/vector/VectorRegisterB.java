package io.jeffrey.vector;

/** a register bank that contains 11 vectors along with all possible operations */
public class VectorRegisterB extends VectorRegisterA {
    public double x_10;
    public double y_10;

    public VectorRegisterB() {
        x_10 = 0.0;
        y_10 = 0.0;
    }

    /** add the 10 and 0 together and store the result to the 10 vector */
    public void add_0_to_10() {
        x_10 += x_0;
        y_10 += y_0;
    }

    /** add the 10 and 1 together and store the result to the 10 vector */
    public void add_1_to_10() {
        x_10 += x_1;
        y_10 += y_1;
    }

    /** add the 0 and 10 together and store the result to the 0 vector */
    public void add_10_to_0() {
        x_0 += x_10;
        y_0 += y_10;
    }

    /** add the 1 and 10 together and store the result to the 1 vector */
    public void add_10_to_1() {
        x_1 += x_10;
        y_1 += y_10;
    }

    /** add the 2 and 10 together and store the result to the 2 vector */
    public void add_10_to_2() {
        x_2 += x_10;
        y_2 += y_10;
    }

    /** add the 3 and 10 together and store the result to the 3 vector */
    public void add_10_to_3() {
        x_3 += x_10;
        y_3 += y_10;
    }

    /** add the 4 and 10 together and store the result to the 4 vector */
    public void add_10_to_4() {
        x_4 += x_10;
        y_4 += y_10;
    }

    /** add the 5 and 10 together and store the result to the 5 vector */
    public void add_10_to_5() {
        x_5 += x_10;
        y_5 += y_10;
    }

    /** add the 6 and 10 together and store the result to the 6 vector */
    public void add_10_to_6() {
        x_6 += x_10;
        y_6 += y_10;
    }

    /** add the 7 and 10 together and store the result to the 7 vector */
    public void add_10_to_7() {
        x_7 += x_10;
        y_7 += y_10;
    }

    /** add the 8 and 10 together and store the result to the 8 vector */
    public void add_10_to_8() {
        x_8 += x_10;
        y_8 += y_10;
    }

    /** add the 9 and 10 together and store the result to the 9 vector */
    public void add_10_to_9() {
        x_9 += x_10;
        y_9 += y_10;
    }

    /** add the 10 and 2 together and store the result to the 10 vector */
    public void add_2_to_10() {
        x_10 += x_2;
        y_10 += y_2;
    }

    /** add the 10 and 3 together and store the result to the 10 vector */
    public void add_3_to_10() {
        x_10 += x_3;
        y_10 += y_3;
    }

    /** add the 10 and 4 together and store the result to the 10 vector */
    public void add_4_to_10() {
        x_10 += x_4;
        y_10 += y_4;
    }

    /** add the 10 and 5 together and store the result to the 10 vector */
    public void add_5_to_10() {
        x_10 += x_5;
        y_10 += y_5;
    }

    /** add the 10 and 6 together and store the result to the 10 vector */
    public void add_6_to_10() {
        x_10 += x_6;
        y_10 += y_6;
    }

    /** add the 10 and 7 together and store the result to the 10 vector */
    public void add_7_to_10() {
        x_10 += x_7;
        y_10 += y_7;
    }

    /** add the 10 and 8 together and store the result to the 10 vector */
    public void add_8_to_10() {
        x_10 += x_8;
        y_10 += y_8;
    }

    /** add the 10 and 9 together and store the result to the 10 vector */
    public void add_9_to_10() {
        x_10 += x_9;
        y_10 += y_9;
    }

    /** return the angle (via atan2) of the 10 vector */
    public double angle_10() {
        return Math.atan2(y_10, x_10);
    }

    /** multiply via complex numbers the 10 and 0 together and store the result to the 10 vector */
    public void complex_mult_0_10() {
        final double t = x_10 * x_0 - y_10 * y_0;
        y_10 = x_10 * y_0 + y_10 * x_0;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 1 together and store the result to the 10 vector */
    public void complex_mult_1_10() {
        final double t = x_10 * x_1 - y_10 * y_1;
        y_10 = x_10 * y_1 + y_10 * x_1;
        x_10 = t;
    }

    /** multiply via complex numbers the 0 and 10 together and store the result to the 0 vector */
    public void complex_mult_10_0() {
        final double t = x_0 * x_10 - y_0 * y_10;
        y_0 = x_0 * y_10 + y_0 * x_10;
        x_0 = t;
    }

    /** multiply via complex numbers the 1 and 10 together and store the result to the 1 vector */
    public void complex_mult_10_1() {
        final double t = x_1 * x_10 - y_1 * y_10;
        y_1 = x_1 * y_10 + y_1 * x_10;
        x_1 = t;
    }

    /** multiply via complex numbers the 2 and 10 together and store the result to the 2 vector */
    public void complex_mult_10_2() {
        final double t = x_2 * x_10 - y_2 * y_10;
        y_2 = x_2 * y_10 + y_2 * x_10;
        x_2 = t;
    }

    /** multiply via complex numbers the 3 and 10 together and store the result to the 3 vector */
    public void complex_mult_10_3() {
        final double t = x_3 * x_10 - y_3 * y_10;
        y_3 = x_3 * y_10 + y_3 * x_10;
        x_3 = t;
    }

    /** multiply via complex numbers the 4 and 10 together and store the result to the 4 vector */
    public void complex_mult_10_4() {
        final double t = x_4 * x_10 - y_4 * y_10;
        y_4 = x_4 * y_10 + y_4 * x_10;
        x_4 = t;
    }

    /** multiply via complex numbers the 5 and 10 together and store the result to the 5 vector */
    public void complex_mult_10_5() {
        final double t = x_5 * x_10 - y_5 * y_10;
        y_5 = x_5 * y_10 + y_5 * x_10;
        x_5 = t;
    }

    /** multiply via complex numbers the 6 and 10 together and store the result to the 6 vector */
    public void complex_mult_10_6() {
        final double t = x_6 * x_10 - y_6 * y_10;
        y_6 = x_6 * y_10 + y_6 * x_10;
        x_6 = t;
    }

    /** multiply via complex numbers the 7 and 10 together and store the result to the 7 vector */
    public void complex_mult_10_7() {
        final double t = x_7 * x_10 - y_7 * y_10;
        y_7 = x_7 * y_10 + y_7 * x_10;
        x_7 = t;
    }

    /** multiply via complex numbers the 8 and 10 together and store the result to the 8 vector */
    public void complex_mult_10_8() {
        final double t = x_8 * x_10 - y_8 * y_10;
        y_8 = x_8 * y_10 + y_8 * x_10;
        x_8 = t;
    }

    /** multiply via complex numbers the 9 and 10 together and store the result to the 9 vector */
    public void complex_mult_10_9() {
        final double t = x_9 * x_10 - y_9 * y_10;
        y_9 = x_9 * y_10 + y_9 * x_10;
        x_9 = t;
    }

    /** multiply via complex numbers the 10 and 2 together and store the result to the 10 vector */
    public void complex_mult_2_10() {
        final double t = x_10 * x_2 - y_10 * y_2;
        y_10 = x_10 * y_2 + y_10 * x_2;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 3 together and store the result to the 10 vector */
    public void complex_mult_3_10() {
        final double t = x_10 * x_3 - y_10 * y_3;
        y_10 = x_10 * y_3 + y_10 * x_3;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 4 together and store the result to the 10 vector */
    public void complex_mult_4_10() {
        final double t = x_10 * x_4 - y_10 * y_4;
        y_10 = x_10 * y_4 + y_10 * x_4;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 5 together and store the result to the 10 vector */
    public void complex_mult_5_10() {
        final double t = x_10 * x_5 - y_10 * y_5;
        y_10 = x_10 * y_5 + y_10 * x_5;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 6 together and store the result to the 10 vector */
    public void complex_mult_6_10() {
        final double t = x_10 * x_6 - y_10 * y_6;
        y_10 = x_10 * y_6 + y_10 * x_6;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 7 together and store the result to the 10 vector */
    public void complex_mult_7_10() {
        final double t = x_10 * x_7 - y_10 * y_7;
        y_10 = x_10 * y_7 + y_10 * x_7;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 8 together and store the result to the 10 vector */
    public void complex_mult_8_10() {
        final double t = x_10 * x_8 - y_10 * y_8;
        y_10 = x_10 * y_8 + y_10 * x_8;
        x_10 = t;
    }

    /** multiply via complex numbers the 10 and 9 together and store the result to the 10 vector */
    public void complex_mult_9_10() {
        final double t = x_10 * x_9 - y_10 * y_9;
        y_10 = x_10 * y_9 + y_10 * x_9;
        x_10 = t;
    }

    /** treat vector 10 as a complex number and conjugate it */
    public void conjugate_10() {
        y_10 *= -1;
    }

    /** copy the 0 vector into the 10 vector */
    public void copy_from_0_to_10() {
        x_10 = x_0;
        y_10 = y_0;
    }

    /** copy the 1 vector into the 10 vector */
    public void copy_from_1_to_10() {
        x_10 = x_1;
        y_10 = y_1;
    }

    /** copy the 10 vector into the 0 vector */
    public void copy_from_10_to_0() {
        x_0 = x_10;
        y_0 = y_10;
    }

    /** copy the 10 vector into the 1 vector */
    public void copy_from_10_to_1() {
        x_1 = x_10;
        y_1 = y_10;
    }

    /** copy the 10 vector into the 2 vector */
    public void copy_from_10_to_2() {
        x_2 = x_10;
        y_2 = y_10;
    }

    /** copy the 10 vector into the 3 vector */
    public void copy_from_10_to_3() {
        x_3 = x_10;
        y_3 = y_10;
    }

    /** copy the 10 vector into the 4 vector */
    public void copy_from_10_to_4() {
        x_4 = x_10;
        y_4 = y_10;
    }

    /** copy the 10 vector into the 5 vector */
    public void copy_from_10_to_5() {
        x_5 = x_10;
        y_5 = y_10;
    }

    /** copy the 10 vector into the 6 vector */
    public void copy_from_10_to_6() {
        x_6 = x_10;
        y_6 = y_10;
    }

    /** copy the 10 vector into the 7 vector */
    public void copy_from_10_to_7() {
        x_7 = x_10;
        y_7 = y_10;
    }

    /** copy the 10 vector into the 8 vector */
    public void copy_from_10_to_8() {
        x_8 = x_10;
        y_8 = y_10;
    }

    /** copy the 10 vector into the 9 vector */
    public void copy_from_10_to_9() {
        x_9 = x_10;
        y_9 = y_10;
    }

    /** copy the 2 vector into the 10 vector */
    public void copy_from_2_to_10() {
        x_10 = x_2;
        y_10 = y_2;
    }

    /** copy the 3 vector into the 10 vector */
    public void copy_from_3_to_10() {
        x_10 = x_3;
        y_10 = y_3;
    }

    /** copy the 4 vector into the 10 vector */
    public void copy_from_4_to_10() {
        x_10 = x_4;
        y_10 = y_4;
    }

    /** copy the 5 vector into the 10 vector */
    public void copy_from_5_to_10() {
        x_10 = x_5;
        y_10 = y_5;
    }

    /** copy the 6 vector into the 10 vector */
    public void copy_from_6_to_10() {
        x_10 = x_6;
        y_10 = y_6;
    }

    /** copy the 7 vector into the 10 vector */
    public void copy_from_7_to_10() {
        x_10 = x_7;
        y_10 = y_7;
    }

    /** copy the 8 vector into the 10 vector */
    public void copy_from_8_to_10() {
        x_10 = x_8;
        y_10 = y_8;
    }

    /** copy the 9 vector into the 10 vector */
    public void copy_from_9_to_10() {
        x_10 = x_9;
        y_10 = y_9;
    }

    /** find the determinate of the 2x2 matrix formed by vector 0 and vector 10 where the vectors are columns */
    public double det_0_10() {
        return x_0 * y_10 - y_0 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 1 and vector 10 where the vectors are columns */
    public double det_1_10() {
        return x_1 * y_10 - y_1 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 0 where the vectors are columns */
    public double det_10_0() {
        return x_10 * y_0 - y_10 * x_0;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 1 where the vectors are columns */
    public double det_10_1() {
        return x_10 * y_1 - y_10 * x_1;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 2 where the vectors are columns */
    public double det_10_2() {
        return x_10 * y_2 - y_10 * x_2;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 3 where the vectors are columns */
    public double det_10_3() {
        return x_10 * y_3 - y_10 * x_3;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 4 where the vectors are columns */
    public double det_10_4() {
        return x_10 * y_4 - y_10 * x_4;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 5 where the vectors are columns */
    public double det_10_5() {
        return x_10 * y_5 - y_10 * x_5;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 6 where the vectors are columns */
    public double det_10_6() {
        return x_10 * y_6 - y_10 * x_6;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 7 where the vectors are columns */
    public double det_10_7() {
        return x_10 * y_7 - y_10 * x_7;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 8 where the vectors are columns */
    public double det_10_8() {
        return x_10 * y_8 - y_10 * x_8;
    }

    /** find the determinate of the 2x2 matrix formed by vector 10 and vector 9 where the vectors are columns */
    public double det_10_9() {
        return x_10 * y_9 - y_10 * x_9;
    }

    /** find the determinate of the 2x2 matrix formed by vector 2 and vector 10 where the vectors are columns */
    public double det_2_10() {
        return x_2 * y_10 - y_2 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 3 and vector 10 where the vectors are columns */
    public double det_3_10() {
        return x_3 * y_10 - y_3 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 4 and vector 10 where the vectors are columns */
    public double det_4_10() {
        return x_4 * y_10 - y_4 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 5 and vector 10 where the vectors are columns */
    public double det_5_10() {
        return x_5 * y_10 - y_5 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 6 and vector 10 where the vectors are columns */
    public double det_6_10() {
        return x_6 * y_10 - y_6 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 7 and vector 10 where the vectors are columns */
    public double det_7_10() {
        return x_7 * y_10 - y_7 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 8 and vector 10 where the vectors are columns */
    public double det_8_10() {
        return x_8 * y_10 - y_8 * x_10;
    }

    /** find the determinate of the 2x2 matrix formed by vector 9 and vector 10 where the vectors are columns */
    public double det_9_10() {
        return x_9 * y_10 - y_9 * x_10;
    }

    /** divide vector 10 by the given scalar */
    public void div_10_by(final double s) {
        x_10 /= s;
        y_10 /= s;
    }

    /** return the dot product between the 10 and 0 vectors */
    public double dot_0_10() {
        return x_10 * x_0 + y_10 * y_0;
    }

    /** return the dot product between the 10 and 1 vectors */
    public double dot_1_10() {
        return x_10 * x_1 + y_10 * y_1;
    }

    /** return the dot product between the 0 and 10 vectors */
    public double dot_10_0() {
        return x_0 * x_10 + y_0 * y_10;
    }

    /** return the dot product between the 1 and 10 vectors */
    public double dot_10_1() {
        return x_1 * x_10 + y_1 * y_10;
    }

    /** return the dot product between the 2 and 10 vectors */
    public double dot_10_2() {
        return x_2 * x_10 + y_2 * y_10;
    }

    /** return the dot product between the 3 and 10 vectors */
    public double dot_10_3() {
        return x_3 * x_10 + y_3 * y_10;
    }

    /** return the dot product between the 4 and 10 vectors */
    public double dot_10_4() {
        return x_4 * x_10 + y_4 * y_10;
    }

    /** return the dot product between the 5 and 10 vectors */
    public double dot_10_5() {
        return x_5 * x_10 + y_5 * y_10;
    }

    /** return the dot product between the 6 and 10 vectors */
    public double dot_10_6() {
        return x_6 * x_10 + y_6 * y_10;
    }

    /** return the dot product between the 7 and 10 vectors */
    public double dot_10_7() {
        return x_7 * x_10 + y_7 * y_10;
    }

    /** return the dot product between the 8 and 10 vectors */
    public double dot_10_8() {
        return x_8 * x_10 + y_8 * y_10;
    }

    /** return the dot product between the 9 and 10 vectors */
    public double dot_10_9() {
        return x_9 * x_10 + y_9 * y_10;
    }

    /** return the dot product between the 10 and 2 vectors */
    public double dot_2_10() {
        return x_10 * x_2 + y_10 * y_2;
    }

    /** return the dot product between the 10 and 3 vectors */
    public double dot_3_10() {
        return x_10 * x_3 + y_10 * y_3;
    }

    /** return the dot product between the 10 and 4 vectors */
    public double dot_4_10() {
        return x_10 * x_4 + y_10 * y_4;
    }

    /** return the dot product between the 10 and 5 vectors */
    public double dot_5_10() {
        return x_10 * x_5 + y_10 * y_5;
    }

    /** return the dot product between the 10 and 6 vectors */
    public double dot_6_10() {
        return x_10 * x_6 + y_10 * y_6;
    }

    /** return the dot product between the 10 and 7 vectors */
    public double dot_7_10() {
        return x_10 * x_7 + y_10 * y_7;
    }

    /** return the dot product between the 10 and 8 vectors */
    public double dot_8_10() {
        return x_10 * x_8 + y_10 * y_8;
    }

    /** return the dot product between the 10 and 9 vectors */
    public double dot_9_10() {
        return x_10 * x_9 + y_10 * y_9;
    }

    /** extract the 10-vector into the given output array starting at the given offset */
    public void extract_10(final double[] output, final int offset) {
        output[offset + 0] = x_10;
        output[offset + 1] = y_10;
    }

    /** inject the given input starting at the given offset into the 10-vector */
    public void inject_10(final double[] input, final int offset) {
        x_10 = input[offset + 0];
        y_10 = input[offset + 1];
    }

    /** invert the 2x2 matrix formed by vector 0 and vector 10 where the vectors are columns */
    public boolean invert_0_10() {
        final double t = x_0;
        double invdet = x_0 * y_10 - y_0 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_0 *= -1 * invdet;
        x_0 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 1 and vector 10 where the vectors are columns */
    public boolean invert_1_10() {
        final double t = x_1;
        double invdet = x_1 * y_10 - y_1 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_1 *= -1 * invdet;
        x_1 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 0 where the vectors are columns */
    public boolean invert_10_0() {
        final double t = x_10;
        double invdet = x_10 * y_0 - y_10 * x_0;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_0 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_0 * invdet;
        y_0 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 1 where the vectors are columns */
    public boolean invert_10_1() {
        final double t = x_10;
        double invdet = x_10 * y_1 - y_10 * x_1;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_1 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_1 * invdet;
        y_1 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 2 where the vectors are columns */
    public boolean invert_10_2() {
        final double t = x_10;
        double invdet = x_10 * y_2 - y_10 * x_2;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_2 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_2 * invdet;
        y_2 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 3 where the vectors are columns */
    public boolean invert_10_3() {
        final double t = x_10;
        double invdet = x_10 * y_3 - y_10 * x_3;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_3 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_3 * invdet;
        y_3 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 4 where the vectors are columns */
    public boolean invert_10_4() {
        final double t = x_10;
        double invdet = x_10 * y_4 - y_10 * x_4;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_4 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_4 * invdet;
        y_4 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 5 where the vectors are columns */
    public boolean invert_10_5() {
        final double t = x_10;
        double invdet = x_10 * y_5 - y_10 * x_5;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_5 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_5 * invdet;
        y_5 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 6 where the vectors are columns */
    public boolean invert_10_6() {
        final double t = x_10;
        double invdet = x_10 * y_6 - y_10 * x_6;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_6 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_6 * invdet;
        y_6 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 7 where the vectors are columns */
    public boolean invert_10_7() {
        final double t = x_10;
        double invdet = x_10 * y_7 - y_10 * x_7;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_7 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_7 * invdet;
        y_7 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 8 where the vectors are columns */
    public boolean invert_10_8() {
        final double t = x_10;
        double invdet = x_10 * y_8 - y_10 * x_8;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_8 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_8 * invdet;
        y_8 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 10 and vector 9 where the vectors are columns */
    public boolean invert_10_9() {
        final double t = x_10;
        double invdet = x_10 * y_9 - y_10 * x_9;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_9 *= -1 * invdet;
        y_10 *= -1 * invdet;
        x_10 = y_9 * invdet;
        y_9 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 2 and vector 10 where the vectors are columns */
    public boolean invert_2_10() {
        final double t = x_2;
        double invdet = x_2 * y_10 - y_2 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_2 *= -1 * invdet;
        x_2 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 3 and vector 10 where the vectors are columns */
    public boolean invert_3_10() {
        final double t = x_3;
        double invdet = x_3 * y_10 - y_3 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_3 *= -1 * invdet;
        x_3 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 4 and vector 10 where the vectors are columns */
    public boolean invert_4_10() {
        final double t = x_4;
        double invdet = x_4 * y_10 - y_4 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_4 *= -1 * invdet;
        x_4 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 5 and vector 10 where the vectors are columns */
    public boolean invert_5_10() {
        final double t = x_5;
        double invdet = x_5 * y_10 - y_5 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_5 *= -1 * invdet;
        x_5 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 6 and vector 10 where the vectors are columns */
    public boolean invert_6_10() {
        final double t = x_6;
        double invdet = x_6 * y_10 - y_6 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_6 *= -1 * invdet;
        x_6 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 7 and vector 10 where the vectors are columns */
    public boolean invert_7_10() {
        final double t = x_7;
        double invdet = x_7 * y_10 - y_7 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_7 *= -1 * invdet;
        x_7 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 8 and vector 10 where the vectors are columns */
    public boolean invert_8_10() {
        final double t = x_8;
        double invdet = x_8 * y_10 - y_8 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_8 *= -1 * invdet;
        x_8 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** invert the 2x2 matrix formed by vector 9 and vector 10 where the vectors are columns */
    public boolean invert_9_10() {
        final double t = x_9;
        double invdet = x_9 * y_10 - y_9 * x_10;
        if (Math.abs(invdet) < ZERO_LIMIT) {
            return false;
        }
        invdet = 1.0 / invdet;
        x_10 *= -1 * invdet;
        y_9 *= -1 * invdet;
        x_9 = y_10 * invdet;
        y_10 = t * invdet;
        return true;
    }

    /** is the 10-vector the origin */
    public boolean is_10_zero() {
        if (Math.abs(x_10) < ZERO_LIMIT && Math.abs(y_10) < ZERO_LIMIT) {
            return true;
        }
        return false;
    }

    /** compute and return the length of vector 10 */
    public double length_10() {
        double d = 0.0;
        d += x_10 * x_10;
        d += y_10 * y_10;
        return Math.sqrt(d);
    }

    /** multiply vector 10 by the given scalar */
    public void mult_10_by(final double s) {
        x_10 *= s;
        y_10 *= s;
    }

    /** normalize the 10-vector if it is not the origin */
    public boolean normalize_10() {
        double d = 0.0;
        d += x_10 * x_10;
        d += y_10 * y_10;
        if (Math.abs(d) < ZERO_LIMIT) {
            return false;
        }
        d = Math.sqrt(d);
        d = 1.0 / d;
        x_10 *= d;
        y_10 *= d;
        return true;
    }

    /** set the 10-vector to the given (x,y) */
    public void set_10(final double x, final double y) {
        x_10 = x;
        y_10 = y;
    }

    /** set the 10 vector to the complex number corresponding to the given angle */
    public void set_10_by_angle(final double theta) {
        x_10 = Math.cos(theta);
        y_10 = Math.sin(theta);
    }

    /** set the matrixed form by the 0 vector and 10 vector (by column) */
    public void set_matrix_0_10(final double x0, final double y0, final double x1, final double y1) {
        x_0 = x0;
        y_0 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 1 vector and 10 vector (by column) */
    public void set_matrix_1_10(final double x0, final double y0, final double x1, final double y1) {
        x_1 = x0;
        y_1 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 10 vector and 0 vector (by column) */
    public void set_matrix_10_0(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_0 = x1;
        y_0 = y1;
    }

    /** set the matrixed form by the 10 vector and 1 vector (by column) */
    public void set_matrix_10_1(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_1 = x1;
        y_1 = y1;
    }

    /** set the matrixed form by the 10 vector and 2 vector (by column) */
    public void set_matrix_10_2(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_2 = x1;
        y_2 = y1;
    }

    /** set the matrixed form by the 10 vector and 3 vector (by column) */
    public void set_matrix_10_3(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_3 = x1;
        y_3 = y1;
    }

    /** set the matrixed form by the 10 vector and 4 vector (by column) */
    public void set_matrix_10_4(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_4 = x1;
        y_4 = y1;
    }

    /** set the matrixed form by the 10 vector and 5 vector (by column) */
    public void set_matrix_10_5(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_5 = x1;
        y_5 = y1;
    }

    /** set the matrixed form by the 10 vector and 6 vector (by column) */
    public void set_matrix_10_6(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_6 = x1;
        y_6 = y1;
    }

    /** set the matrixed form by the 10 vector and 7 vector (by column) */
    public void set_matrix_10_7(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_7 = x1;
        y_7 = y1;
    }

    /** set the matrixed form by the 10 vector and 8 vector (by column) */
    public void set_matrix_10_8(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_8 = x1;
        y_8 = y1;
    }

    /** set the matrixed form by the 10 vector and 9 vector (by column) */
    public void set_matrix_10_9(final double x0, final double y0, final double x1, final double y1) {
        x_10 = x0;
        y_10 = y0;
        x_9 = x1;
        y_9 = y1;
    }

    /** set the matrixed form by the 2 vector and 10 vector (by column) */
    public void set_matrix_2_10(final double x0, final double y0, final double x1, final double y1) {
        x_2 = x0;
        y_2 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 3 vector and 10 vector (by column) */
    public void set_matrix_3_10(final double x0, final double y0, final double x1, final double y1) {
        x_3 = x0;
        y_3 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 4 vector and 10 vector (by column) */
    public void set_matrix_4_10(final double x0, final double y0, final double x1, final double y1) {
        x_4 = x0;
        y_4 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 5 vector and 10 vector (by column) */
    public void set_matrix_5_10(final double x0, final double y0, final double x1, final double y1) {
        x_5 = x0;
        y_5 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 6 vector and 10 vector (by column) */
    public void set_matrix_6_10(final double x0, final double y0, final double x1, final double y1) {
        x_6 = x0;
        y_6 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 7 vector and 10 vector (by column) */
    public void set_matrix_7_10(final double x0, final double y0, final double x1, final double y1) {
        x_7 = x0;
        y_7 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 8 vector and 10 vector (by column) */
    public void set_matrix_8_10(final double x0, final double y0, final double x1, final double y1) {
        x_8 = x0;
        y_8 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** set the matrixed form by the 9 vector and 10 vector (by column) */
    public void set_matrix_9_10(final double x0, final double y0, final double x1, final double y1) {
        x_9 = x0;
        y_9 = y0;
        x_10 = x1;
        y_10 = y1;
    }

    /** subtract the 10 and 0 together and store the result to the 10 vector */
    public void sub_0_from_10() {
        x_10 -= x_0;
        y_10 -= y_0;
    }

    /** subtract the 10 and 1 together and store the result to the 10 vector */
    public void sub_1_from_10() {
        x_10 -= x_1;
        y_10 -= y_1;
    }

    /** subtract the 0 and 10 together and store the result to the 0 vector */
    public void sub_10_from_0() {
        x_0 -= x_10;
        y_0 -= y_10;
    }

    /** subtract the 1 and 10 together and store the result to the 1 vector */
    public void sub_10_from_1() {
        x_1 -= x_10;
        y_1 -= y_10;
    }

    /** subtract the 2 and 10 together and store the result to the 2 vector */
    public void sub_10_from_2() {
        x_2 -= x_10;
        y_2 -= y_10;
    }

    /** subtract the 3 and 10 together and store the result to the 3 vector */
    public void sub_10_from_3() {
        x_3 -= x_10;
        y_3 -= y_10;
    }

    /** subtract the 4 and 10 together and store the result to the 4 vector */
    public void sub_10_from_4() {
        x_4 -= x_10;
        y_4 -= y_10;
    }

    /** subtract the 5 and 10 together and store the result to the 5 vector */
    public void sub_10_from_5() {
        x_5 -= x_10;
        y_5 -= y_10;
    }

    /** subtract the 6 and 10 together and store the result to the 6 vector */
    public void sub_10_from_6() {
        x_6 -= x_10;
        y_6 -= y_10;
    }

    /** subtract the 7 and 10 together and store the result to the 7 vector */
    public void sub_10_from_7() {
        x_7 -= x_10;
        y_7 -= y_10;
    }

    /** subtract the 8 and 10 together and store the result to the 8 vector */
    public void sub_10_from_8() {
        x_8 -= x_10;
        y_8 -= y_10;
    }

    /** subtract the 9 and 10 together and store the result to the 9 vector */
    public void sub_10_from_9() {
        x_9 -= x_10;
        y_9 -= y_10;
    }

    /** subtract the 10 and 2 together and store the result to the 10 vector */
    public void sub_2_from_10() {
        x_10 -= x_2;
        y_10 -= y_2;
    }

    /** subtract the 10 and 3 together and store the result to the 10 vector */
    public void sub_3_from_10() {
        x_10 -= x_3;
        y_10 -= y_3;
    }

    /** subtract the 10 and 4 together and store the result to the 10 vector */
    public void sub_4_from_10() {
        x_10 -= x_4;
        y_10 -= y_4;
    }

    /** subtract the 10 and 5 together and store the result to the 10 vector */
    public void sub_5_from_10() {
        x_10 -= x_5;
        y_10 -= y_5;
    }

    /** subtract the 10 and 6 together and store the result to the 10 vector */
    public void sub_6_from_10() {
        x_10 -= x_6;
        y_10 -= y_6;
    }

    /** subtract the 10 and 7 together and store the result to the 10 vector */
    public void sub_7_from_10() {
        x_10 -= x_7;
        y_10 -= y_7;
    }

    /** subtract the 10 and 8 together and store the result to the 10 vector */
    public void sub_8_from_10() {
        x_10 -= x_8;
        y_10 -= y_8;
    }

    /** subtract the 10 and 9 together and store the result to the 10 vector */
    public void sub_9_from_10() {
        x_10 -= x_9;
        y_10 -= y_9;
    }

    /** transform the 0 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_0_by_1_10() {
        final double t = x_1 * x_0 + x_10 * y_0;
        y_0 = y_1 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_0_by_10_1() {
        final double t = x_10 * x_0 + x_1 * y_0;
        y_0 = y_10 * x_0 + y_1 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_0_by_10_2() {
        final double t = x_10 * x_0 + x_2 * y_0;
        y_0 = y_10 * x_0 + y_2 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_0_by_10_3() {
        final double t = x_10 * x_0 + x_3 * y_0;
        y_0 = y_10 * x_0 + y_3 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_0_by_10_4() {
        final double t = x_10 * x_0 + x_4 * y_0;
        y_0 = y_10 * x_0 + y_4 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_0_by_10_5() {
        final double t = x_10 * x_0 + x_5 * y_0;
        y_0 = y_10 * x_0 + y_5 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_0_by_10_6() {
        final double t = x_10 * x_0 + x_6 * y_0;
        y_0 = y_10 * x_0 + y_6 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_0_by_10_7() {
        final double t = x_10 * x_0 + x_7 * y_0;
        y_0 = y_10 * x_0 + y_7 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_0_by_10_8() {
        final double t = x_10 * x_0 + x_8 * y_0;
        y_0 = y_10 * x_0 + y_8 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_0_by_10_9() {
        final double t = x_10 * x_0 + x_9 * y_0;
        y_0 = y_10 * x_0 + y_9 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_0_by_2_10() {
        final double t = x_2 * x_0 + x_10 * y_0;
        y_0 = y_2 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_0_by_3_10() {
        final double t = x_3 * x_0 + x_10 * y_0;
        y_0 = y_3 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_0_by_4_10() {
        final double t = x_4 * x_0 + x_10 * y_0;
        y_0 = y_4 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_0_by_5_10() {
        final double t = x_5 * x_0 + x_10 * y_0;
        y_0 = y_5 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_0_by_6_10() {
        final double t = x_6 * x_0 + x_10 * y_0;
        y_0 = y_6 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_0_by_7_10() {
        final double t = x_7 * x_0 + x_10 * y_0;
        y_0 = y_7 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_0_by_8_10() {
        final double t = x_8 * x_0 + x_10 * y_0;
        y_0 = y_8 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 0 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_0_by_9_10() {
        final double t = x_9 * x_0 + x_10 * y_0;
        y_0 = y_9 * x_0 + y_10 * y_0;
        x_0 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_1_by_0_10() {
        final double t = x_0 * x_1 + x_10 * y_1;
        y_1 = y_0 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_1_by_10_0() {
        final double t = x_10 * x_1 + x_0 * y_1;
        y_1 = y_10 * x_1 + y_0 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_1_by_10_2() {
        final double t = x_10 * x_1 + x_2 * y_1;
        y_1 = y_10 * x_1 + y_2 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_1_by_10_3() {
        final double t = x_10 * x_1 + x_3 * y_1;
        y_1 = y_10 * x_1 + y_3 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_1_by_10_4() {
        final double t = x_10 * x_1 + x_4 * y_1;
        y_1 = y_10 * x_1 + y_4 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_1_by_10_5() {
        final double t = x_10 * x_1 + x_5 * y_1;
        y_1 = y_10 * x_1 + y_5 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_1_by_10_6() {
        final double t = x_10 * x_1 + x_6 * y_1;
        y_1 = y_10 * x_1 + y_6 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_1_by_10_7() {
        final double t = x_10 * x_1 + x_7 * y_1;
        y_1 = y_10 * x_1 + y_7 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_1_by_10_8() {
        final double t = x_10 * x_1 + x_8 * y_1;
        y_1 = y_10 * x_1 + y_8 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_1_by_10_9() {
        final double t = x_10 * x_1 + x_9 * y_1;
        y_1 = y_10 * x_1 + y_9 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_1_by_2_10() {
        final double t = x_2 * x_1 + x_10 * y_1;
        y_1 = y_2 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_1_by_3_10() {
        final double t = x_3 * x_1 + x_10 * y_1;
        y_1 = y_3 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_1_by_4_10() {
        final double t = x_4 * x_1 + x_10 * y_1;
        y_1 = y_4 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_1_by_5_10() {
        final double t = x_5 * x_1 + x_10 * y_1;
        y_1 = y_5 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_1_by_6_10() {
        final double t = x_6 * x_1 + x_10 * y_1;
        y_1 = y_6 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_1_by_7_10() {
        final double t = x_7 * x_1 + x_10 * y_1;
        y_1 = y_7 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_1_by_8_10() {
        final double t = x_8 * x_1 + x_10 * y_1;
        y_1 = y_8 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 1 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_1_by_9_10() {
        final double t = x_9 * x_1 + x_10 * y_1;
        y_1 = y_9 * x_1 + y_10 * y_1;
        x_1 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 1 vectors as columns */
    public void transform_10_by_0_1() {
        final double t = x_0 * x_10 + x_1 * y_10;
        y_10 = y_0 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 2 vectors as columns */
    public void transform_10_by_0_2() {
        final double t = x_0 * x_10 + x_2 * y_10;
        y_10 = y_0 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 3 vectors as columns */
    public void transform_10_by_0_3() {
        final double t = x_0 * x_10 + x_3 * y_10;
        y_10 = y_0 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 4 vectors as columns */
    public void transform_10_by_0_4() {
        final double t = x_0 * x_10 + x_4 * y_10;
        y_10 = y_0 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 5 vectors as columns */
    public void transform_10_by_0_5() {
        final double t = x_0 * x_10 + x_5 * y_10;
        y_10 = y_0 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 6 vectors as columns */
    public void transform_10_by_0_6() {
        final double t = x_0 * x_10 + x_6 * y_10;
        y_10 = y_0 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 7 vectors as columns */
    public void transform_10_by_0_7() {
        final double t = x_0 * x_10 + x_7 * y_10;
        y_10 = y_0 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 8 vectors as columns */
    public void transform_10_by_0_8() {
        final double t = x_0 * x_10 + x_8 * y_10;
        y_10 = y_0 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 0 and 9 vectors as columns */
    public void transform_10_by_0_9() {
        final double t = x_0 * x_10 + x_9 * y_10;
        y_10 = y_0 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 0 vectors as columns */
    public void transform_10_by_1_0() {
        final double t = x_1 * x_10 + x_0 * y_10;
        y_10 = y_1 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 2 vectors as columns */
    public void transform_10_by_1_2() {
        final double t = x_1 * x_10 + x_2 * y_10;
        y_10 = y_1 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 3 vectors as columns */
    public void transform_10_by_1_3() {
        final double t = x_1 * x_10 + x_3 * y_10;
        y_10 = y_1 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 4 vectors as columns */
    public void transform_10_by_1_4() {
        final double t = x_1 * x_10 + x_4 * y_10;
        y_10 = y_1 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 5 vectors as columns */
    public void transform_10_by_1_5() {
        final double t = x_1 * x_10 + x_5 * y_10;
        y_10 = y_1 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 6 vectors as columns */
    public void transform_10_by_1_6() {
        final double t = x_1 * x_10 + x_6 * y_10;
        y_10 = y_1 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 7 vectors as columns */
    public void transform_10_by_1_7() {
        final double t = x_1 * x_10 + x_7 * y_10;
        y_10 = y_1 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 8 vectors as columns */
    public void transform_10_by_1_8() {
        final double t = x_1 * x_10 + x_8 * y_10;
        y_10 = y_1 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 1 and 9 vectors as columns */
    public void transform_10_by_1_9() {
        final double t = x_1 * x_10 + x_9 * y_10;
        y_10 = y_1 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 0 vectors as columns */
    public void transform_10_by_2_0() {
        final double t = x_2 * x_10 + x_0 * y_10;
        y_10 = y_2 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 1 vectors as columns */
    public void transform_10_by_2_1() {
        final double t = x_2 * x_10 + x_1 * y_10;
        y_10 = y_2 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 3 vectors as columns */
    public void transform_10_by_2_3() {
        final double t = x_2 * x_10 + x_3 * y_10;
        y_10 = y_2 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 4 vectors as columns */
    public void transform_10_by_2_4() {
        final double t = x_2 * x_10 + x_4 * y_10;
        y_10 = y_2 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 5 vectors as columns */
    public void transform_10_by_2_5() {
        final double t = x_2 * x_10 + x_5 * y_10;
        y_10 = y_2 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 6 vectors as columns */
    public void transform_10_by_2_6() {
        final double t = x_2 * x_10 + x_6 * y_10;
        y_10 = y_2 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 7 vectors as columns */
    public void transform_10_by_2_7() {
        final double t = x_2 * x_10 + x_7 * y_10;
        y_10 = y_2 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 8 vectors as columns */
    public void transform_10_by_2_8() {
        final double t = x_2 * x_10 + x_8 * y_10;
        y_10 = y_2 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 2 and 9 vectors as columns */
    public void transform_10_by_2_9() {
        final double t = x_2 * x_10 + x_9 * y_10;
        y_10 = y_2 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 0 vectors as columns */
    public void transform_10_by_3_0() {
        final double t = x_3 * x_10 + x_0 * y_10;
        y_10 = y_3 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 1 vectors as columns */
    public void transform_10_by_3_1() {
        final double t = x_3 * x_10 + x_1 * y_10;
        y_10 = y_3 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 2 vectors as columns */
    public void transform_10_by_3_2() {
        final double t = x_3 * x_10 + x_2 * y_10;
        y_10 = y_3 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 4 vectors as columns */
    public void transform_10_by_3_4() {
        final double t = x_3 * x_10 + x_4 * y_10;
        y_10 = y_3 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 5 vectors as columns */
    public void transform_10_by_3_5() {
        final double t = x_3 * x_10 + x_5 * y_10;
        y_10 = y_3 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 6 vectors as columns */
    public void transform_10_by_3_6() {
        final double t = x_3 * x_10 + x_6 * y_10;
        y_10 = y_3 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 7 vectors as columns */
    public void transform_10_by_3_7() {
        final double t = x_3 * x_10 + x_7 * y_10;
        y_10 = y_3 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 8 vectors as columns */
    public void transform_10_by_3_8() {
        final double t = x_3 * x_10 + x_8 * y_10;
        y_10 = y_3 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 3 and 9 vectors as columns */
    public void transform_10_by_3_9() {
        final double t = x_3 * x_10 + x_9 * y_10;
        y_10 = y_3 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 0 vectors as columns */
    public void transform_10_by_4_0() {
        final double t = x_4 * x_10 + x_0 * y_10;
        y_10 = y_4 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 1 vectors as columns */
    public void transform_10_by_4_1() {
        final double t = x_4 * x_10 + x_1 * y_10;
        y_10 = y_4 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 2 vectors as columns */
    public void transform_10_by_4_2() {
        final double t = x_4 * x_10 + x_2 * y_10;
        y_10 = y_4 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 3 vectors as columns */
    public void transform_10_by_4_3() {
        final double t = x_4 * x_10 + x_3 * y_10;
        y_10 = y_4 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 5 vectors as columns */
    public void transform_10_by_4_5() {
        final double t = x_4 * x_10 + x_5 * y_10;
        y_10 = y_4 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 6 vectors as columns */
    public void transform_10_by_4_6() {
        final double t = x_4 * x_10 + x_6 * y_10;
        y_10 = y_4 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 7 vectors as columns */
    public void transform_10_by_4_7() {
        final double t = x_4 * x_10 + x_7 * y_10;
        y_10 = y_4 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 8 vectors as columns */
    public void transform_10_by_4_8() {
        final double t = x_4 * x_10 + x_8 * y_10;
        y_10 = y_4 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 4 and 9 vectors as columns */
    public void transform_10_by_4_9() {
        final double t = x_4 * x_10 + x_9 * y_10;
        y_10 = y_4 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 0 vectors as columns */
    public void transform_10_by_5_0() {
        final double t = x_5 * x_10 + x_0 * y_10;
        y_10 = y_5 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 1 vectors as columns */
    public void transform_10_by_5_1() {
        final double t = x_5 * x_10 + x_1 * y_10;
        y_10 = y_5 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 2 vectors as columns */
    public void transform_10_by_5_2() {
        final double t = x_5 * x_10 + x_2 * y_10;
        y_10 = y_5 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 3 vectors as columns */
    public void transform_10_by_5_3() {
        final double t = x_5 * x_10 + x_3 * y_10;
        y_10 = y_5 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 4 vectors as columns */
    public void transform_10_by_5_4() {
        final double t = x_5 * x_10 + x_4 * y_10;
        y_10 = y_5 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 6 vectors as columns */
    public void transform_10_by_5_6() {
        final double t = x_5 * x_10 + x_6 * y_10;
        y_10 = y_5 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 7 vectors as columns */
    public void transform_10_by_5_7() {
        final double t = x_5 * x_10 + x_7 * y_10;
        y_10 = y_5 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 8 vectors as columns */
    public void transform_10_by_5_8() {
        final double t = x_5 * x_10 + x_8 * y_10;
        y_10 = y_5 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 5 and 9 vectors as columns */
    public void transform_10_by_5_9() {
        final double t = x_5 * x_10 + x_9 * y_10;
        y_10 = y_5 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 0 vectors as columns */
    public void transform_10_by_6_0() {
        final double t = x_6 * x_10 + x_0 * y_10;
        y_10 = y_6 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 1 vectors as columns */
    public void transform_10_by_6_1() {
        final double t = x_6 * x_10 + x_1 * y_10;
        y_10 = y_6 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 2 vectors as columns */
    public void transform_10_by_6_2() {
        final double t = x_6 * x_10 + x_2 * y_10;
        y_10 = y_6 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 3 vectors as columns */
    public void transform_10_by_6_3() {
        final double t = x_6 * x_10 + x_3 * y_10;
        y_10 = y_6 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 4 vectors as columns */
    public void transform_10_by_6_4() {
        final double t = x_6 * x_10 + x_4 * y_10;
        y_10 = y_6 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 5 vectors as columns */
    public void transform_10_by_6_5() {
        final double t = x_6 * x_10 + x_5 * y_10;
        y_10 = y_6 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 7 vectors as columns */
    public void transform_10_by_6_7() {
        final double t = x_6 * x_10 + x_7 * y_10;
        y_10 = y_6 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 8 vectors as columns */
    public void transform_10_by_6_8() {
        final double t = x_6 * x_10 + x_8 * y_10;
        y_10 = y_6 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 6 and 9 vectors as columns */
    public void transform_10_by_6_9() {
        final double t = x_6 * x_10 + x_9 * y_10;
        y_10 = y_6 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 0 vectors as columns */
    public void transform_10_by_7_0() {
        final double t = x_7 * x_10 + x_0 * y_10;
        y_10 = y_7 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 1 vectors as columns */
    public void transform_10_by_7_1() {
        final double t = x_7 * x_10 + x_1 * y_10;
        y_10 = y_7 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 2 vectors as columns */
    public void transform_10_by_7_2() {
        final double t = x_7 * x_10 + x_2 * y_10;
        y_10 = y_7 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 3 vectors as columns */
    public void transform_10_by_7_3() {
        final double t = x_7 * x_10 + x_3 * y_10;
        y_10 = y_7 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 4 vectors as columns */
    public void transform_10_by_7_4() {
        final double t = x_7 * x_10 + x_4 * y_10;
        y_10 = y_7 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 5 vectors as columns */
    public void transform_10_by_7_5() {
        final double t = x_7 * x_10 + x_5 * y_10;
        y_10 = y_7 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 6 vectors as columns */
    public void transform_10_by_7_6() {
        final double t = x_7 * x_10 + x_6 * y_10;
        y_10 = y_7 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 8 vectors as columns */
    public void transform_10_by_7_8() {
        final double t = x_7 * x_10 + x_8 * y_10;
        y_10 = y_7 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 7 and 9 vectors as columns */
    public void transform_10_by_7_9() {
        final double t = x_7 * x_10 + x_9 * y_10;
        y_10 = y_7 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 0 vectors as columns */
    public void transform_10_by_8_0() {
        final double t = x_8 * x_10 + x_0 * y_10;
        y_10 = y_8 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 1 vectors as columns */
    public void transform_10_by_8_1() {
        final double t = x_8 * x_10 + x_1 * y_10;
        y_10 = y_8 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 2 vectors as columns */
    public void transform_10_by_8_2() {
        final double t = x_8 * x_10 + x_2 * y_10;
        y_10 = y_8 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 3 vectors as columns */
    public void transform_10_by_8_3() {
        final double t = x_8 * x_10 + x_3 * y_10;
        y_10 = y_8 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 4 vectors as columns */
    public void transform_10_by_8_4() {
        final double t = x_8 * x_10 + x_4 * y_10;
        y_10 = y_8 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 5 vectors as columns */
    public void transform_10_by_8_5() {
        final double t = x_8 * x_10 + x_5 * y_10;
        y_10 = y_8 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 6 vectors as columns */
    public void transform_10_by_8_6() {
        final double t = x_8 * x_10 + x_6 * y_10;
        y_10 = y_8 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 7 vectors as columns */
    public void transform_10_by_8_7() {
        final double t = x_8 * x_10 + x_7 * y_10;
        y_10 = y_8 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 8 and 9 vectors as columns */
    public void transform_10_by_8_9() {
        final double t = x_8 * x_10 + x_9 * y_10;
        y_10 = y_8 * x_10 + y_9 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 0 vectors as columns */
    public void transform_10_by_9_0() {
        final double t = x_9 * x_10 + x_0 * y_10;
        y_10 = y_9 * x_10 + y_0 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 1 vectors as columns */
    public void transform_10_by_9_1() {
        final double t = x_9 * x_10 + x_1 * y_10;
        y_10 = y_9 * x_10 + y_1 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 2 vectors as columns */
    public void transform_10_by_9_2() {
        final double t = x_9 * x_10 + x_2 * y_10;
        y_10 = y_9 * x_10 + y_2 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 3 vectors as columns */
    public void transform_10_by_9_3() {
        final double t = x_9 * x_10 + x_3 * y_10;
        y_10 = y_9 * x_10 + y_3 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 4 vectors as columns */
    public void transform_10_by_9_4() {
        final double t = x_9 * x_10 + x_4 * y_10;
        y_10 = y_9 * x_10 + y_4 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 5 vectors as columns */
    public void transform_10_by_9_5() {
        final double t = x_9 * x_10 + x_5 * y_10;
        y_10 = y_9 * x_10 + y_5 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 6 vectors as columns */
    public void transform_10_by_9_6() {
        final double t = x_9 * x_10 + x_6 * y_10;
        y_10 = y_9 * x_10 + y_6 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 7 vectors as columns */
    public void transform_10_by_9_7() {
        final double t = x_9 * x_10 + x_7 * y_10;
        y_10 = y_9 * x_10 + y_7 * y_10;
        x_10 = t;
    }

    /** transform the 10 vector by the matrixed formed by the 9 and 8 vectors as columns */
    public void transform_10_by_9_8() {
        final double t = x_9 * x_10 + x_8 * y_10;
        y_10 = y_9 * x_10 + y_8 * y_10;
        x_10 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_2_by_0_10() {
        final double t = x_0 * x_2 + x_10 * y_2;
        y_2 = y_0 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_2_by_1_10() {
        final double t = x_1 * x_2 + x_10 * y_2;
        y_2 = y_1 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_2_by_10_0() {
        final double t = x_10 * x_2 + x_0 * y_2;
        y_2 = y_10 * x_2 + y_0 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_2_by_10_1() {
        final double t = x_10 * x_2 + x_1 * y_2;
        y_2 = y_10 * x_2 + y_1 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_2_by_10_3() {
        final double t = x_10 * x_2 + x_3 * y_2;
        y_2 = y_10 * x_2 + y_3 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_2_by_10_4() {
        final double t = x_10 * x_2 + x_4 * y_2;
        y_2 = y_10 * x_2 + y_4 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_2_by_10_5() {
        final double t = x_10 * x_2 + x_5 * y_2;
        y_2 = y_10 * x_2 + y_5 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_2_by_10_6() {
        final double t = x_10 * x_2 + x_6 * y_2;
        y_2 = y_10 * x_2 + y_6 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_2_by_10_7() {
        final double t = x_10 * x_2 + x_7 * y_2;
        y_2 = y_10 * x_2 + y_7 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_2_by_10_8() {
        final double t = x_10 * x_2 + x_8 * y_2;
        y_2 = y_10 * x_2 + y_8 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_2_by_10_9() {
        final double t = x_10 * x_2 + x_9 * y_2;
        y_2 = y_10 * x_2 + y_9 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_2_by_3_10() {
        final double t = x_3 * x_2 + x_10 * y_2;
        y_2 = y_3 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_2_by_4_10() {
        final double t = x_4 * x_2 + x_10 * y_2;
        y_2 = y_4 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_2_by_5_10() {
        final double t = x_5 * x_2 + x_10 * y_2;
        y_2 = y_5 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_2_by_6_10() {
        final double t = x_6 * x_2 + x_10 * y_2;
        y_2 = y_6 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_2_by_7_10() {
        final double t = x_7 * x_2 + x_10 * y_2;
        y_2 = y_7 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_2_by_8_10() {
        final double t = x_8 * x_2 + x_10 * y_2;
        y_2 = y_8 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 2 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_2_by_9_10() {
        final double t = x_9 * x_2 + x_10 * y_2;
        y_2 = y_9 * x_2 + y_10 * y_2;
        x_2 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_3_by_0_10() {
        final double t = x_0 * x_3 + x_10 * y_3;
        y_3 = y_0 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_3_by_1_10() {
        final double t = x_1 * x_3 + x_10 * y_3;
        y_3 = y_1 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_3_by_10_0() {
        final double t = x_10 * x_3 + x_0 * y_3;
        y_3 = y_10 * x_3 + y_0 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_3_by_10_1() {
        final double t = x_10 * x_3 + x_1 * y_3;
        y_3 = y_10 * x_3 + y_1 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_3_by_10_2() {
        final double t = x_10 * x_3 + x_2 * y_3;
        y_3 = y_10 * x_3 + y_2 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_3_by_10_4() {
        final double t = x_10 * x_3 + x_4 * y_3;
        y_3 = y_10 * x_3 + y_4 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_3_by_10_5() {
        final double t = x_10 * x_3 + x_5 * y_3;
        y_3 = y_10 * x_3 + y_5 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_3_by_10_6() {
        final double t = x_10 * x_3 + x_6 * y_3;
        y_3 = y_10 * x_3 + y_6 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_3_by_10_7() {
        final double t = x_10 * x_3 + x_7 * y_3;
        y_3 = y_10 * x_3 + y_7 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_3_by_10_8() {
        final double t = x_10 * x_3 + x_8 * y_3;
        y_3 = y_10 * x_3 + y_8 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_3_by_10_9() {
        final double t = x_10 * x_3 + x_9 * y_3;
        y_3 = y_10 * x_3 + y_9 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_3_by_2_10() {
        final double t = x_2 * x_3 + x_10 * y_3;
        y_3 = y_2 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_3_by_4_10() {
        final double t = x_4 * x_3 + x_10 * y_3;
        y_3 = y_4 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_3_by_5_10() {
        final double t = x_5 * x_3 + x_10 * y_3;
        y_3 = y_5 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_3_by_6_10() {
        final double t = x_6 * x_3 + x_10 * y_3;
        y_3 = y_6 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_3_by_7_10() {
        final double t = x_7 * x_3 + x_10 * y_3;
        y_3 = y_7 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_3_by_8_10() {
        final double t = x_8 * x_3 + x_10 * y_3;
        y_3 = y_8 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 3 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_3_by_9_10() {
        final double t = x_9 * x_3 + x_10 * y_3;
        y_3 = y_9 * x_3 + y_10 * y_3;
        x_3 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_4_by_0_10() {
        final double t = x_0 * x_4 + x_10 * y_4;
        y_4 = y_0 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_4_by_1_10() {
        final double t = x_1 * x_4 + x_10 * y_4;
        y_4 = y_1 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_4_by_10_0() {
        final double t = x_10 * x_4 + x_0 * y_4;
        y_4 = y_10 * x_4 + y_0 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_4_by_10_1() {
        final double t = x_10 * x_4 + x_1 * y_4;
        y_4 = y_10 * x_4 + y_1 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_4_by_10_2() {
        final double t = x_10 * x_4 + x_2 * y_4;
        y_4 = y_10 * x_4 + y_2 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_4_by_10_3() {
        final double t = x_10 * x_4 + x_3 * y_4;
        y_4 = y_10 * x_4 + y_3 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_4_by_10_5() {
        final double t = x_10 * x_4 + x_5 * y_4;
        y_4 = y_10 * x_4 + y_5 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_4_by_10_6() {
        final double t = x_10 * x_4 + x_6 * y_4;
        y_4 = y_10 * x_4 + y_6 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_4_by_10_7() {
        final double t = x_10 * x_4 + x_7 * y_4;
        y_4 = y_10 * x_4 + y_7 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_4_by_10_8() {
        final double t = x_10 * x_4 + x_8 * y_4;
        y_4 = y_10 * x_4 + y_8 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_4_by_10_9() {
        final double t = x_10 * x_4 + x_9 * y_4;
        y_4 = y_10 * x_4 + y_9 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_4_by_2_10() {
        final double t = x_2 * x_4 + x_10 * y_4;
        y_4 = y_2 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_4_by_3_10() {
        final double t = x_3 * x_4 + x_10 * y_4;
        y_4 = y_3 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_4_by_5_10() {
        final double t = x_5 * x_4 + x_10 * y_4;
        y_4 = y_5 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_4_by_6_10() {
        final double t = x_6 * x_4 + x_10 * y_4;
        y_4 = y_6 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_4_by_7_10() {
        final double t = x_7 * x_4 + x_10 * y_4;
        y_4 = y_7 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_4_by_8_10() {
        final double t = x_8 * x_4 + x_10 * y_4;
        y_4 = y_8 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 4 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_4_by_9_10() {
        final double t = x_9 * x_4 + x_10 * y_4;
        y_4 = y_9 * x_4 + y_10 * y_4;
        x_4 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_5_by_0_10() {
        final double t = x_0 * x_5 + x_10 * y_5;
        y_5 = y_0 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_5_by_1_10() {
        final double t = x_1 * x_5 + x_10 * y_5;
        y_5 = y_1 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_5_by_10_0() {
        final double t = x_10 * x_5 + x_0 * y_5;
        y_5 = y_10 * x_5 + y_0 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_5_by_10_1() {
        final double t = x_10 * x_5 + x_1 * y_5;
        y_5 = y_10 * x_5 + y_1 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_5_by_10_2() {
        final double t = x_10 * x_5 + x_2 * y_5;
        y_5 = y_10 * x_5 + y_2 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_5_by_10_3() {
        final double t = x_10 * x_5 + x_3 * y_5;
        y_5 = y_10 * x_5 + y_3 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_5_by_10_4() {
        final double t = x_10 * x_5 + x_4 * y_5;
        y_5 = y_10 * x_5 + y_4 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_5_by_10_6() {
        final double t = x_10 * x_5 + x_6 * y_5;
        y_5 = y_10 * x_5 + y_6 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_5_by_10_7() {
        final double t = x_10 * x_5 + x_7 * y_5;
        y_5 = y_10 * x_5 + y_7 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_5_by_10_8() {
        final double t = x_10 * x_5 + x_8 * y_5;
        y_5 = y_10 * x_5 + y_8 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_5_by_10_9() {
        final double t = x_10 * x_5 + x_9 * y_5;
        y_5 = y_10 * x_5 + y_9 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_5_by_2_10() {
        final double t = x_2 * x_5 + x_10 * y_5;
        y_5 = y_2 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_5_by_3_10() {
        final double t = x_3 * x_5 + x_10 * y_5;
        y_5 = y_3 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_5_by_4_10() {
        final double t = x_4 * x_5 + x_10 * y_5;
        y_5 = y_4 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_5_by_6_10() {
        final double t = x_6 * x_5 + x_10 * y_5;
        y_5 = y_6 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_5_by_7_10() {
        final double t = x_7 * x_5 + x_10 * y_5;
        y_5 = y_7 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_5_by_8_10() {
        final double t = x_8 * x_5 + x_10 * y_5;
        y_5 = y_8 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 5 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_5_by_9_10() {
        final double t = x_9 * x_5 + x_10 * y_5;
        y_5 = y_9 * x_5 + y_10 * y_5;
        x_5 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_6_by_0_10() {
        final double t = x_0 * x_6 + x_10 * y_6;
        y_6 = y_0 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_6_by_1_10() {
        final double t = x_1 * x_6 + x_10 * y_6;
        y_6 = y_1 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_6_by_10_0() {
        final double t = x_10 * x_6 + x_0 * y_6;
        y_6 = y_10 * x_6 + y_0 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_6_by_10_1() {
        final double t = x_10 * x_6 + x_1 * y_6;
        y_6 = y_10 * x_6 + y_1 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_6_by_10_2() {
        final double t = x_10 * x_6 + x_2 * y_6;
        y_6 = y_10 * x_6 + y_2 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_6_by_10_3() {
        final double t = x_10 * x_6 + x_3 * y_6;
        y_6 = y_10 * x_6 + y_3 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_6_by_10_4() {
        final double t = x_10 * x_6 + x_4 * y_6;
        y_6 = y_10 * x_6 + y_4 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_6_by_10_5() {
        final double t = x_10 * x_6 + x_5 * y_6;
        y_6 = y_10 * x_6 + y_5 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_6_by_10_7() {
        final double t = x_10 * x_6 + x_7 * y_6;
        y_6 = y_10 * x_6 + y_7 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_6_by_10_8() {
        final double t = x_10 * x_6 + x_8 * y_6;
        y_6 = y_10 * x_6 + y_8 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_6_by_10_9() {
        final double t = x_10 * x_6 + x_9 * y_6;
        y_6 = y_10 * x_6 + y_9 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_6_by_2_10() {
        final double t = x_2 * x_6 + x_10 * y_6;
        y_6 = y_2 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_6_by_3_10() {
        final double t = x_3 * x_6 + x_10 * y_6;
        y_6 = y_3 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_6_by_4_10() {
        final double t = x_4 * x_6 + x_10 * y_6;
        y_6 = y_4 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_6_by_5_10() {
        final double t = x_5 * x_6 + x_10 * y_6;
        y_6 = y_5 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_6_by_7_10() {
        final double t = x_7 * x_6 + x_10 * y_6;
        y_6 = y_7 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_6_by_8_10() {
        final double t = x_8 * x_6 + x_10 * y_6;
        y_6 = y_8 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 6 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_6_by_9_10() {
        final double t = x_9 * x_6 + x_10 * y_6;
        y_6 = y_9 * x_6 + y_10 * y_6;
        x_6 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_7_by_0_10() {
        final double t = x_0 * x_7 + x_10 * y_7;
        y_7 = y_0 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_7_by_1_10() {
        final double t = x_1 * x_7 + x_10 * y_7;
        y_7 = y_1 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_7_by_10_0() {
        final double t = x_10 * x_7 + x_0 * y_7;
        y_7 = y_10 * x_7 + y_0 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_7_by_10_1() {
        final double t = x_10 * x_7 + x_1 * y_7;
        y_7 = y_10 * x_7 + y_1 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_7_by_10_2() {
        final double t = x_10 * x_7 + x_2 * y_7;
        y_7 = y_10 * x_7 + y_2 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_7_by_10_3() {
        final double t = x_10 * x_7 + x_3 * y_7;
        y_7 = y_10 * x_7 + y_3 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_7_by_10_4() {
        final double t = x_10 * x_7 + x_4 * y_7;
        y_7 = y_10 * x_7 + y_4 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_7_by_10_5() {
        final double t = x_10 * x_7 + x_5 * y_7;
        y_7 = y_10 * x_7 + y_5 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_7_by_10_6() {
        final double t = x_10 * x_7 + x_6 * y_7;
        y_7 = y_10 * x_7 + y_6 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_7_by_10_8() {
        final double t = x_10 * x_7 + x_8 * y_7;
        y_7 = y_10 * x_7 + y_8 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_7_by_10_9() {
        final double t = x_10 * x_7 + x_9 * y_7;
        y_7 = y_10 * x_7 + y_9 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_7_by_2_10() {
        final double t = x_2 * x_7 + x_10 * y_7;
        y_7 = y_2 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_7_by_3_10() {
        final double t = x_3 * x_7 + x_10 * y_7;
        y_7 = y_3 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_7_by_4_10() {
        final double t = x_4 * x_7 + x_10 * y_7;
        y_7 = y_4 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_7_by_5_10() {
        final double t = x_5 * x_7 + x_10 * y_7;
        y_7 = y_5 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_7_by_6_10() {
        final double t = x_6 * x_7 + x_10 * y_7;
        y_7 = y_6 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_7_by_8_10() {
        final double t = x_8 * x_7 + x_10 * y_7;
        y_7 = y_8 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 7 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_7_by_9_10() {
        final double t = x_9 * x_7 + x_10 * y_7;
        y_7 = y_9 * x_7 + y_10 * y_7;
        x_7 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_8_by_0_10() {
        final double t = x_0 * x_8 + x_10 * y_8;
        y_8 = y_0 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_8_by_1_10() {
        final double t = x_1 * x_8 + x_10 * y_8;
        y_8 = y_1 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_8_by_10_0() {
        final double t = x_10 * x_8 + x_0 * y_8;
        y_8 = y_10 * x_8 + y_0 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_8_by_10_1() {
        final double t = x_10 * x_8 + x_1 * y_8;
        y_8 = y_10 * x_8 + y_1 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_8_by_10_2() {
        final double t = x_10 * x_8 + x_2 * y_8;
        y_8 = y_10 * x_8 + y_2 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_8_by_10_3() {
        final double t = x_10 * x_8 + x_3 * y_8;
        y_8 = y_10 * x_8 + y_3 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_8_by_10_4() {
        final double t = x_10 * x_8 + x_4 * y_8;
        y_8 = y_10 * x_8 + y_4 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_8_by_10_5() {
        final double t = x_10 * x_8 + x_5 * y_8;
        y_8 = y_10 * x_8 + y_5 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_8_by_10_6() {
        final double t = x_10 * x_8 + x_6 * y_8;
        y_8 = y_10 * x_8 + y_6 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_8_by_10_7() {
        final double t = x_10 * x_8 + x_7 * y_8;
        y_8 = y_10 * x_8 + y_7 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 10 and 9 vectors as columns */
    public void transform_8_by_10_9() {
        final double t = x_10 * x_8 + x_9 * y_8;
        y_8 = y_10 * x_8 + y_9 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_8_by_2_10() {
        final double t = x_2 * x_8 + x_10 * y_8;
        y_8 = y_2 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_8_by_3_10() {
        final double t = x_3 * x_8 + x_10 * y_8;
        y_8 = y_3 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_8_by_4_10() {
        final double t = x_4 * x_8 + x_10 * y_8;
        y_8 = y_4 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_8_by_5_10() {
        final double t = x_5 * x_8 + x_10 * y_8;
        y_8 = y_5 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_8_by_6_10() {
        final double t = x_6 * x_8 + x_10 * y_8;
        y_8 = y_6 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_8_by_7_10() {
        final double t = x_7 * x_8 + x_10 * y_8;
        y_8 = y_7 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 8 vector by the matrixed formed by the 9 and 10 vectors as columns */
    public void transform_8_by_9_10() {
        final double t = x_9 * x_8 + x_10 * y_8;
        y_8 = y_9 * x_8 + y_10 * y_8;
        x_8 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 0 and 10 vectors as columns */
    public void transform_9_by_0_10() {
        final double t = x_0 * x_9 + x_10 * y_9;
        y_9 = y_0 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 1 and 10 vectors as columns */
    public void transform_9_by_1_10() {
        final double t = x_1 * x_9 + x_10 * y_9;
        y_9 = y_1 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 0 vectors as columns */
    public void transform_9_by_10_0() {
        final double t = x_10 * x_9 + x_0 * y_9;
        y_9 = y_10 * x_9 + y_0 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 1 vectors as columns */
    public void transform_9_by_10_1() {
        final double t = x_10 * x_9 + x_1 * y_9;
        y_9 = y_10 * x_9 + y_1 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 2 vectors as columns */
    public void transform_9_by_10_2() {
        final double t = x_10 * x_9 + x_2 * y_9;
        y_9 = y_10 * x_9 + y_2 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 3 vectors as columns */
    public void transform_9_by_10_3() {
        final double t = x_10 * x_9 + x_3 * y_9;
        y_9 = y_10 * x_9 + y_3 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 4 vectors as columns */
    public void transform_9_by_10_4() {
        final double t = x_10 * x_9 + x_4 * y_9;
        y_9 = y_10 * x_9 + y_4 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 5 vectors as columns */
    public void transform_9_by_10_5() {
        final double t = x_10 * x_9 + x_5 * y_9;
        y_9 = y_10 * x_9 + y_5 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 6 vectors as columns */
    public void transform_9_by_10_6() {
        final double t = x_10 * x_9 + x_6 * y_9;
        y_9 = y_10 * x_9 + y_6 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 7 vectors as columns */
    public void transform_9_by_10_7() {
        final double t = x_10 * x_9 + x_7 * y_9;
        y_9 = y_10 * x_9 + y_7 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 10 and 8 vectors as columns */
    public void transform_9_by_10_8() {
        final double t = x_10 * x_9 + x_8 * y_9;
        y_9 = y_10 * x_9 + y_8 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 2 and 10 vectors as columns */
    public void transform_9_by_2_10() {
        final double t = x_2 * x_9 + x_10 * y_9;
        y_9 = y_2 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 3 and 10 vectors as columns */
    public void transform_9_by_3_10() {
        final double t = x_3 * x_9 + x_10 * y_9;
        y_9 = y_3 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 4 and 10 vectors as columns */
    public void transform_9_by_4_10() {
        final double t = x_4 * x_9 + x_10 * y_9;
        y_9 = y_4 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 5 and 10 vectors as columns */
    public void transform_9_by_5_10() {
        final double t = x_5 * x_9 + x_10 * y_9;
        y_9 = y_5 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 6 and 10 vectors as columns */
    public void transform_9_by_6_10() {
        final double t = x_6 * x_9 + x_10 * y_9;
        y_9 = y_6 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 7 and 10 vectors as columns */
    public void transform_9_by_7_10() {
        final double t = x_7 * x_9 + x_10 * y_9;
        y_9 = y_7 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transform the 9 vector by the matrixed formed by the 8 and 10 vectors as columns */
    public void transform_9_by_8_10() {
        final double t = x_8 * x_9 + x_10 * y_9;
        y_9 = y_8 * x_9 + y_10 * y_9;
        x_9 = t;
    }

    /** transpose the matrix formed by vector 0 and vector 10 where the vectors are columns */
    public void transpose_0_10() {
        final double t = y_0;
        y_0 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 1 and vector 10 where the vectors are columns */
    public void transpose_1_10() {
        final double t = y_1;
        y_1 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 0 where the vectors are columns */
    public void transpose_10_0() {
        final double t = y_10;
        y_10 = x_0;
        x_0 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 1 where the vectors are columns */
    public void transpose_10_1() {
        final double t = y_10;
        y_10 = x_1;
        x_1 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 2 where the vectors are columns */
    public void transpose_10_2() {
        final double t = y_10;
        y_10 = x_2;
        x_2 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 3 where the vectors are columns */
    public void transpose_10_3() {
        final double t = y_10;
        y_10 = x_3;
        x_3 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 4 where the vectors are columns */
    public void transpose_10_4() {
        final double t = y_10;
        y_10 = x_4;
        x_4 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 5 where the vectors are columns */
    public void transpose_10_5() {
        final double t = y_10;
        y_10 = x_5;
        x_5 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 6 where the vectors are columns */
    public void transpose_10_6() {
        final double t = y_10;
        y_10 = x_6;
        x_6 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 7 where the vectors are columns */
    public void transpose_10_7() {
        final double t = y_10;
        y_10 = x_7;
        x_7 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 8 where the vectors are columns */
    public void transpose_10_8() {
        final double t = y_10;
        y_10 = x_8;
        x_8 = t;
    }

    /** transpose the matrix formed by vector 10 and vector 9 where the vectors are columns */
    public void transpose_10_9() {
        final double t = y_10;
        y_10 = x_9;
        x_9 = t;
    }

    /** transpose the matrix formed by vector 2 and vector 10 where the vectors are columns */
    public void transpose_2_10() {
        final double t = y_2;
        y_2 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 3 and vector 10 where the vectors are columns */
    public void transpose_3_10() {
        final double t = y_3;
        y_3 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 4 and vector 10 where the vectors are columns */
    public void transpose_4_10() {
        final double t = y_4;
        y_4 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 5 and vector 10 where the vectors are columns */
    public void transpose_5_10() {
        final double t = y_5;
        y_5 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 6 and vector 10 where the vectors are columns */
    public void transpose_6_10() {
        final double t = y_6;
        y_6 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 7 and vector 10 where the vectors are columns */
    public void transpose_7_10() {
        final double t = y_7;
        y_7 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 8 and vector 10 where the vectors are columns */
    public void transpose_8_10() {
        final double t = y_8;
        y_8 = x_10;
        x_10 = t;
    }

    /** transpose the matrix formed by vector 9 and vector 10 where the vectors are columns */
    public void transpose_9_10() {
        final double t = y_9;
        y_9 = x_10;
        x_10 = t;
    }

    /** set the 10-vector to the (0,0) */
    public void zero_out_10() {
        x_10 = 0.0;
        y_10 = 0.0;
    }
}
