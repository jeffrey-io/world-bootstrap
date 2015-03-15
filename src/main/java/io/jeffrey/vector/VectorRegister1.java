package io.jeffrey.vector;

/** a register bank that contains 1 vectors along with all possible operations */
public class VectorRegister1 {
    public static final double ZERO_LIMIT = 1E-14;
    public double              x_0;
    public double              y_0;

    public VectorRegister1() {
        x_0 = 0.0;
        y_0 = 0.0;
    }

    /** return the angle (via atan2) of the 0 vector */
    public double angle_0() {
        return Math.atan2(y_0, x_0);
    }

    /** treat vector 0 as a complex number and conjugate it */
    public void conjugate_0() {
        y_0 *= -1;
    }

    /** divide vector 0 by the given scalar */
    public void div_0_by(final double s) {
        x_0 /= s;
        y_0 /= s;
    }

    /** extract the 0-vector into the given output array starting at the given offset */
    public void extract_0(final double[] output, final int offset) {
        output[offset + 0] = x_0;
        output[offset + 1] = y_0;
    }

    /** inject the given input starting at the given offset into the 0-vector */
    public void inject_0(final double[] input, final int offset) {
        x_0 = input[offset + 0];
        y_0 = input[offset + 1];
    }

    /** is the 0-vector the origin */
    public boolean is_0_zero() {
        if (Math.abs(x_0) < ZERO_LIMIT && Math.abs(y_0) < ZERO_LIMIT) {
            return true;
        }
        return false;
    }

    /** compute and return the length of vector 0 */
    public double length_0() {
        double d = 0.0;
        d += x_0 * x_0;
        d += y_0 * y_0;
        return Math.sqrt(d);
    }

    /** multiply vector 0 by the given scalar */
    public void mult_0_by(final double s) {
        x_0 *= s;
        y_0 *= s;
    }

    /** normalize the 0-vector if it is not the origin */
    public boolean normalize_0() {
        double d = 0.0;
        d += x_0 * x_0;
        d += y_0 * y_0;
        if (Math.abs(d) < ZERO_LIMIT) {
            return false;
        }
        d = Math.sqrt(d);
        d = 1.0 / d;
        x_0 *= d;
        y_0 *= d;
        return true;
    }

    /** set the 0-vector to the given (x,y) */
    public void set_0(final double x, final double y) {
        x_0 = x;
        y_0 = y;
    }

    /** set the 0 vector to the complex number corresponding to the given angle */
    public void set_0_by_angle(final double theta) {
        x_0 = Math.cos(theta);
        y_0 = Math.sin(theta);
    }

    /** set the 0-vector to the (0,0) */
    public void zero_out_0() {
        x_0 = 0.0;
        y_0 = 0.0;
    }
}
