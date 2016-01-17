package io.jeffrey.vector;

import org.junit.Assert;
import org.junit.Test;

public class GeneratedVectorRegister3Test extends CommonVectorTestingBase {

    @Test
    public void testALGEBRA_0_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(1, 2);
        x.set_0(3, 5);
        x.mult_0_by(4);
        assertEquals(12, x.x_0);
        assertEquals(20, x.y_0);
        x.div_0_by(2);
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        x.add_2_to_0();
        assertEquals(7, x.x_0);
        assertEquals(12, x.y_0);
        x.sub_2_from_0();
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        assertEquals(6 + 2 * 10, x.dot_2_0());
        x.set_0(1, 2);
    }

    @Test
    public void testALGEBRA_1_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(1, 2);
        x.set_1(3, 5);
        x.mult_1_by(4);
        assertEquals(12, x.x_1);
        assertEquals(20, x.y_1);
        x.div_1_by(2);
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        x.add_2_to_1();
        assertEquals(7, x.x_1);
        assertEquals(12, x.y_1);
        x.sub_2_from_1();
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        assertEquals(6 + 2 * 10, x.dot_2_1());
        x.set_1(1, 2);
    }

    @Test
    public void testALGEBRA_2_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_0(1, 2);
        x.set_2(3, 5);
        x.mult_2_by(4);
        assertEquals(12, x.x_2);
        assertEquals(20, x.y_2);
        x.div_2_by(2);
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        x.add_0_to_2();
        assertEquals(7, x.x_2);
        assertEquals(12, x.y_2);
        x.sub_0_from_2();
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        assertEquals(6 + 2 * 10, x.dot_0_2());
        x.set_2(1, 2);
    }

    @Test
    public void testALGEBRA_2_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_1(1, 2);
        x.set_2(3, 5);
        x.mult_2_by(4);
        assertEquals(12, x.x_2);
        assertEquals(20, x.y_2);
        x.div_2_by(2);
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        x.add_1_to_2();
        assertEquals(7, x.x_2);
        assertEquals(12, x.y_2);
        x.sub_1_from_2();
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        assertEquals(6 + 2 * 10, x.dot_1_2());
        x.set_2(1, 2);
    }

    @Test
    public void testANGLES_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2_by_angle(0.5);
        assertEquals(0.8775825618903728, x.x_2);
        assertEquals(0.479425538604203, x.y_2);
        x.set_2_by_angle(1.5);
        assertEquals(0.0707372016677029, x.x_2);
        assertEquals(0.9974949866040544, x.y_2);
        x.set_2_by_angle(2.5);
        assertEquals(-0.8011436155469337, x.x_2);
        assertEquals(0.5984721441039564, x.y_2);
        double u, v;
        for (double theta = 0; theta < 7; theta += 0.1) {
            x.set_2_by_angle(theta);
            final double omega = x.angle_2();
            u = x.x_2;
            v = x.y_2;
            x.set_2_by_angle(omega);
            assertEquals(u, x.x_2);
            assertEquals(v, x.y_2);
        }
    }

    @Test
    public void testCOMPLEX_0_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_0(3, 5);
        x.set_2(1, 2);
        x.complex_mult_2_0();
        assertEquals(3 - 10, x.x_0);
        assertEquals(5 + 6, x.y_0);
    }

    @Test
    public void testCOMPLEX_1_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_1(3, 5);
        x.set_2(1, 2);
        x.complex_mult_2_1();
        assertEquals(3 - 10, x.x_1);
        assertEquals(5 + 6, x.y_1);
    }

    @Test
    public void testCOMPLEX_2_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        x.set_0(1, 2);
        x.complex_mult_0_2();
        assertEquals(3 - 10, x.x_2);
        assertEquals(5 + 6, x.y_2);
    }

    @Test
    public void testCOMPLEX_2_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        x.set_1(1, 2);
        x.complex_mult_1_2();
        assertEquals(3 - 10, x.x_2);
        assertEquals(5 + 6, x.y_2);
    }

    @Test
    public void testCOMPLEX_CONJ_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.conjugate_2();
        assertEquals(3, x.x_2);
        assertEquals(-5, x.y_2);
    }

    @Test
    public void testCOPY_0_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_0(3, 5);
        x.set_2(1, 2);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.copy_from_2_to_0();
        assertEquals(1, x.x_0);
        assertEquals(2, x.y_0);
    }

    @Test
    public void testCOPY_1_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_1(3, 5);
        x.set_2(1, 2);
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        x.copy_from_2_to_1();
        assertEquals(1, x.x_1);
        assertEquals(2, x.y_1);
    }

    @Test
    public void testCOPY_2_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        x.set_0(1, 2);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.copy_from_0_to_2();
        assertEquals(1, x.x_2);
        assertEquals(2, x.y_2);
    }

    @Test
    public void testCOPY_2_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        x.set_1(1, 2);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.copy_from_1_to_2();
        assertEquals(1, x.x_2);
        assertEquals(2, x.y_2);
    }

    @Test
    public void testEXTRACT_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.set_2(-1, -2);
        x.extract_2(data, 0);
        x.extract_2(data, 5);
        x.extract_2(data, 8);
        assertEquals(-1, data[0]);
        assertEquals(-2, data[1]);
        assertEquals(2, data[2]);
        assertEquals(3, data[3]);
        assertEquals(4, data[4]);
        assertEquals(-1, data[5]);
        assertEquals(-2, data[6]);
        assertEquals(7, data[7]);
        assertEquals(-1, data[8]);
        assertEquals(-2, data[9]);
    }

    @Test
    public void testINJECT_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.inject_2(data, 0);
        assertEquals(0, x.x_2);
        assertEquals(1, x.y_2);
        x.inject_2(data, 6);
        assertEquals(6, x.x_2);
        assertEquals(7, x.y_2);
        x.inject_2(data, 8);
        assertEquals(8, x.x_2);
        assertEquals(9, x.y_2);
    }

    @Test
    public void testIS_ZERO_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        Assert.assertFalse(x.is_2_zero());
        x.set_2(0, 5);
        assertEquals(0, x.x_2);
        assertEquals(5, x.y_2);
        Assert.assertFalse(x.is_2_zero());
        x.set_2(3, 0);
        assertEquals(3, x.x_2);
        assertEquals(0, x.y_2);
        Assert.assertFalse(x.is_2_zero());
        x.set_2(0, 0);
        assertEquals(0, x.x_2);
        assertEquals(0, x.y_2);
        Assert.assertTrue(x.is_2_zero());
    }

    @Test
    public void testMATRIX_0_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_0_2(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        assertEquals(1 * 4 - 2 * 3, x.det_0_2());
        assertEquals(-(1 * 4 - 2 * 3), x.det_2_0());
        x.set_1(-1, 5);
        x.transform_1_by_0_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        Assert.assertTrue(x.invert_0_2());
        assertEquals(-2, x.x_0);
        assertEquals(1.5, x.y_0);
        assertEquals(1, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.transpose_0_2();
        assertEquals(-2, x.x_0);
        assertEquals(1, x.y_0);
        assertEquals(1.5, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.set_matrix_0_2(1, 2, 1, 2);
        Assert.assertFalse(x.invert_0_2());
        assertEquals(0, x.det_0_2());
    }

    @Test
    public void testMATRIX_1_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_1_2(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        assertEquals(1 * 4 - 2 * 3, x.det_1_2());
        assertEquals(-(1 * 4 - 2 * 3), x.det_2_1());
        x.set_0(-1, 5);
        x.transform_0_by_1_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        Assert.assertTrue(x.invert_1_2());
        assertEquals(-2, x.x_1);
        assertEquals(1.5, x.y_1);
        assertEquals(1, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.transpose_1_2();
        assertEquals(-2, x.x_1);
        assertEquals(1, x.y_1);
        assertEquals(1.5, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.set_matrix_1_2(1, 2, 1, 2);
        Assert.assertFalse(x.invert_1_2());
        assertEquals(0, x.det_1_2());
    }

    @Test
    public void testMATRIX_2_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_2_0(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        assertEquals(1 * 4 - 2 * 3, x.det_2_0());
        assertEquals(-(1 * 4 - 2 * 3), x.det_0_2());
        x.set_1(-1, 5);
        x.transform_1_by_2_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        Assert.assertTrue(x.invert_2_0());
        assertEquals(-2, x.x_2);
        assertEquals(1.5, x.y_2);
        assertEquals(1, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.transpose_2_0();
        assertEquals(-2, x.x_2);
        assertEquals(1, x.y_2);
        assertEquals(1.5, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.set_matrix_2_0(1, 2, 1, 2);
        Assert.assertFalse(x.invert_2_0());
        assertEquals(0, x.det_2_0());
    }

    @Test
    public void testMATRIX_2_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_2_1(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        assertEquals(1 * 4 - 2 * 3, x.det_2_1());
        assertEquals(-(1 * 4 - 2 * 3), x.det_1_2());
        x.set_0(-1, 5);
        x.transform_0_by_2_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        Assert.assertTrue(x.invert_2_1());
        assertEquals(-2, x.x_2);
        assertEquals(1.5, x.y_2);
        assertEquals(1, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.transpose_2_1();
        assertEquals(-2, x.x_2);
        assertEquals(1, x.y_2);
        assertEquals(1.5, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.set_matrix_2_1(1, 2, 1, 2);
        Assert.assertFalse(x.invert_2_1());
        assertEquals(0, x.det_2_1());
    }

    @Test
    public void testMATRIX_TRANSFORM_0_1_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_0_1(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_0_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_2_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_0_2(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_1(-1, 5);
        x.transform_1_by_0_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_0_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_1_0(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_1_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_2_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_1_2(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_0(-1, 5);
        x.transform_0_by_1_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_0_1() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_2_0(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_2_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_1_0() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_matrix_2_1(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_0(-1, 5);
        x.transform_0_by_2_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testPYTHAGOREAN_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        assertEquals(Math.sqrt(3 * 3 + 5 * 5), x.length_2());
        Assert.assertTrue(x.normalize_2());
        assertEquals(1, x.length_2());
        assertEquals(3 / Math.sqrt(3 * 3 + 5 * 5), x.x_2);
        assertEquals(5 / Math.sqrt(3 * 3 + 5 * 5), x.y_2);
        x.set_2(0, 0);
        Assert.assertFalse(x.normalize_2());
    }

    @Test
    public void testSET_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_2(3, 5);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        assertEquals(0, x.x_0);
        assertEquals(0, x.y_0);
        assertEquals(0, x.x_1);
        assertEquals(0, x.y_1);
    }

    @Test
    public void testZERO_2() throws Exception {
        final VectorRegister3 x = new VectorRegister3();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.set_1(3, 5);
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        x.set_2(3, 5);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.zero_out_2();
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        Assert.assertFalse(x.is_0_zero());
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        Assert.assertFalse(x.is_1_zero());
        assertEquals(0, x.x_2);
        assertEquals(0, x.y_2);
        Assert.assertTrue(x.is_2_zero());
    }
}
