package io.jeffrey.vector;

/** a register bank that contains 2 vectors along with all possible operations */
public class VectorRegister2 extends VectorRegister1 {
  public double x_1;
  public double y_1;

  public VectorRegister2() {
    x_0 = 0.0;
    y_0 = 0.0;
    x_1 = 0.0;
    y_1 = 0.0;
  }

  /** add the 1 and 0 together and store the result to the 1 vector */
  public void add_0_to_1() {
    x_1 += x_0;
    y_1 += y_0;
  }

  /** add the 0 and 1 together and store the result to the 0 vector */
  public void add_1_to_0() {
    x_0 += x_1;
    y_0 += y_1;
  }

  /** return the angle (via atan2) of the 1 vector */
  public double angle_1() {
    return Math.atan2(y_1, x_1);
  }

  /** multiply via complex numbers the 1 and 0 together and store the result to the 1 vector */
  public void complex_mult_0_1() {
    final double t = x_1 * x_0 - y_1 * y_0;
    y_1 = x_1 * y_0 + y_1 * x_0;
    x_1 = t;
  }

  /** multiply via complex numbers the 0 and 1 together and store the result to the 0 vector */
  public void complex_mult_1_0() {
    final double t = x_0 * x_1 - y_0 * y_1;
    y_0 = x_0 * y_1 + y_0 * x_1;
    x_0 = t;
  }

  /** treat vector 1 as a complex number and conjugate it */
  public void conjugate_1() {
    y_1 *= -1;
  }

  /** copy the 0 vector into the 1 vector */
  public void copy_from_0_to_1() {
    x_1 = x_0;
    y_1 = y_0;
  }

  /** copy the 1 vector into the 0 vector */
  public void copy_from_1_to_0() {
    x_0 = x_1;
    y_0 = y_1;
  }

  /** find the determinate of the 2x2 matrix formed by vector 0 and vector 1 where the vectors are columns */
  public double det_0_1() {
    return x_0 * y_1 - y_0 * x_1;
  }

  /** find the determinate of the 2x2 matrix formed by vector 1 and vector 0 where the vectors are columns */
  public double det_1_0() {
    return x_1 * y_0 - y_1 * x_0;
  }

  /** divide vector 1 by the given scalar */
  public void div_1_by(final double s) {
    x_1 /= s;
    y_1 /= s;
  }

  /** return the dot product between the 1 and 0 vectors */
  public double dot_0_1() {
    return x_1 * x_0 + y_1 * y_0;
  }

  /** return the dot product between the 0 and 1 vectors */
  public double dot_1_0() {
    return x_0 * x_1 + y_0 * y_1;
  }

  /** extract the 1-vector into the given output array starting at the given offset */
  public void extract_1(final double[] output, final int offset) {
    output[offset + 0] = x_1;
    output[offset + 1] = y_1;
  }

  /** inject the given input starting at the given offset into the 1-vector */
  public void inject_1(final double[] input, final int offset) {
    x_1 = input[offset + 0];
    y_1 = input[offset + 1];
  }

  /** invert the 2x2 matrix formed by vector 0 and vector 1 where the vectors are columns */
  public boolean invert_0_1() {
    final double t = x_0;
    double invdet = x_0 * y_1 - y_0 * x_1;
    if (Math.abs(invdet) < ZERO_LIMIT) {
      return false;
    }
    invdet = 1.0 / invdet;
    x_1 *= -1 * invdet;
    y_0 *= -1 * invdet;
    x_0 = y_1 * invdet;
    y_1 = t * invdet;
    return true;
  }

  /** invert the 2x2 matrix formed by vector 1 and vector 0 where the vectors are columns */
  public boolean invert_1_0() {
    final double t = x_1;
    double invdet = x_1 * y_0 - y_1 * x_0;
    if (Math.abs(invdet) < ZERO_LIMIT) {
      return false;
    }
    invdet = 1.0 / invdet;
    x_0 *= -1 * invdet;
    y_1 *= -1 * invdet;
    x_1 = y_0 * invdet;
    y_0 = t * invdet;
    return true;
  }

  /** is the 1-vector the origin */
  public boolean is_1_zero() {
    if (Math.abs(x_1) < ZERO_LIMIT && Math.abs(y_1) < ZERO_LIMIT) {
      return true;
    }
    return false;
  }

  /** compute and return the length of vector 1 */
  public double length_1() {
    double d = 0.0;
    d += x_1 * x_1;
    d += y_1 * y_1;
    return Math.sqrt(d);
  }

  /** multiply vector 1 by the given scalar */
  public void mult_1_by(final double s) {
    x_1 *= s;
    y_1 *= s;
  }

  /** normalize the 1-vector if it is not the origin */
  public boolean normalize_1() {
    double d = 0.0;
    d += x_1 * x_1;
    d += y_1 * y_1;
    if (Math.abs(d) < ZERO_LIMIT) {
      return false;
    }
    d = Math.sqrt(d);
    d = 1.0 / d;
    x_1 *= d;
    y_1 *= d;
    return true;
  }

  /** return the dot product between the 1 and 0 vectors */
  public double planer_cross_at_zero_0_1() {
    return x_0 * y_1 - y_0 * x_1;
  }

  /** return the dot product between the 0 and 1 vectors */
  public double planer_cross_at_zero_1_0() {
    return x_1 * y_0 - y_1 * x_0;
  }

  /** set the 1-vector to the given (x,y) */
  public void set_1(final double x, final double y) {
    x_1 = x;
    y_1 = y;
  }

  /** set the 1 vector to the complex number corresponding to the given angle */
  public void set_1_by_angle(final double theta) {
    x_1 = Math.cos(theta);
    y_1 = Math.sin(theta);
  }

  /** set the matrixed form by the 0 vector and 1 vector (by column) */
  public void set_matrix_0_1(final double x0, final double y0, final double x1, final double y1) {
    x_0 = x0;
    y_0 = y0;
    x_1 = x1;
    y_1 = y1;
  }

  /** set the matrixed form by the 1 vector and 0 vector (by column) */
  public void set_matrix_1_0(final double x0, final double y0, final double x1, final double y1) {
    x_1 = x0;
    y_1 = y0;
    x_0 = x1;
    y_0 = y1;
  }

  /** subtract the 1 and 0 together and store the result to the 1 vector */
  public void sub_0_from_1() {
    x_1 -= x_0;
    y_1 -= y_0;
  }

  /** subtract the 0 and 1 together and store the result to the 0 vector */
  public void sub_1_from_0() {
    x_0 -= x_1;
    y_0 -= y_1;
  }

  /** transpose the matrix formed by vector 0 and vector 1 where the vectors are columns */
  public void transpose_0_1() {
    final double t = y_0;
    y_0 = x_1;
    x_1 = t;
  }

  /** transpose the matrix formed by vector 1 and vector 0 where the vectors are columns */
  public void transpose_1_0() {
    final double t = y_1;
    y_1 = x_0;
    x_0 = t;
  }

  /** set the 1-vector to the (0,0) */
  public void zero_out_1() {
    x_1 = 0.0;
    y_1 = 0.0;
  }
}
