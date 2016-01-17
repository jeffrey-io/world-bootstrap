package io.jeffrey.vector;

import org.junit.Assert;
import org.junit.Test;

public class GeneratedVectorRegister5Test extends CommonVectorTestingBase {

    @Test
    public void testALGEBRA_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(1, 2);
        x.set_0(3, 5);
        x.mult_0_by(4);
        assertEquals(12, x.x_0);
        assertEquals(20, x.y_0);
        x.div_0_by(2);
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        x.add_4_to_0();
        assertEquals(7, x.x_0);
        assertEquals(12, x.y_0);
        x.sub_4_from_0();
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        assertEquals(6 + 2 * 10, x.dot_4_0());
        x.set_0(1, 2);
    }

    @Test
    public void testALGEBRA_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(1, 2);
        x.set_1(3, 5);
        x.mult_1_by(4);
        assertEquals(12, x.x_1);
        assertEquals(20, x.y_1);
        x.div_1_by(2);
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        x.add_4_to_1();
        assertEquals(7, x.x_1);
        assertEquals(12, x.y_1);
        x.sub_4_from_1();
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        assertEquals(6 + 2 * 10, x.dot_4_1());
        x.set_1(1, 2);
    }

    @Test
    public void testALGEBRA_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(1, 2);
        x.set_2(3, 5);
        x.mult_2_by(4);
        assertEquals(12, x.x_2);
        assertEquals(20, x.y_2);
        x.div_2_by(2);
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        x.add_4_to_2();
        assertEquals(7, x.x_2);
        assertEquals(12, x.y_2);
        x.sub_4_from_2();
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        assertEquals(6 + 2 * 10, x.dot_4_2());
        x.set_2(1, 2);
    }

    @Test
    public void testALGEBRA_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(1, 2);
        x.set_3(3, 5);
        x.mult_3_by(4);
        assertEquals(12, x.x_3);
        assertEquals(20, x.y_3);
        x.div_3_by(2);
        assertEquals(6, x.x_3);
        assertEquals(10, x.y_3);
        x.add_4_to_3();
        assertEquals(7, x.x_3);
        assertEquals(12, x.y_3);
        x.sub_4_from_3();
        assertEquals(6, x.x_3);
        assertEquals(10, x.y_3);
        assertEquals(6 + 2 * 10, x.dot_4_3());
        x.set_3(1, 2);
    }

    @Test
    public void testALGEBRA_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_0(1, 2);
        x.set_4(3, 5);
        x.mult_4_by(4);
        assertEquals(12, x.x_4);
        assertEquals(20, x.y_4);
        x.div_4_by(2);
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        x.add_0_to_4();
        assertEquals(7, x.x_4);
        assertEquals(12, x.y_4);
        x.sub_0_from_4();
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        assertEquals(6 + 2 * 10, x.dot_0_4());
        x.set_4(1, 2);
    }

    @Test
    public void testALGEBRA_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_1(1, 2);
        x.set_4(3, 5);
        x.mult_4_by(4);
        assertEquals(12, x.x_4);
        assertEquals(20, x.y_4);
        x.div_4_by(2);
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        x.add_1_to_4();
        assertEquals(7, x.x_4);
        assertEquals(12, x.y_4);
        x.sub_1_from_4();
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        assertEquals(6 + 2 * 10, x.dot_1_4());
        x.set_4(1, 2);
    }

    @Test
    public void testALGEBRA_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_2(1, 2);
        x.set_4(3, 5);
        x.mult_4_by(4);
        assertEquals(12, x.x_4);
        assertEquals(20, x.y_4);
        x.div_4_by(2);
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        x.add_2_to_4();
        assertEquals(7, x.x_4);
        assertEquals(12, x.y_4);
        x.sub_2_from_4();
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        assertEquals(6 + 2 * 10, x.dot_2_4());
        x.set_4(1, 2);
    }

    @Test
    public void testALGEBRA_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_3(1, 2);
        x.set_4(3, 5);
        x.mult_4_by(4);
        assertEquals(12, x.x_4);
        assertEquals(20, x.y_4);
        x.div_4_by(2);
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        x.add_3_to_4();
        assertEquals(7, x.x_4);
        assertEquals(12, x.y_4);
        x.sub_3_from_4();
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        assertEquals(6 + 2 * 10, x.dot_3_4());
        x.set_4(1, 2);
    }

    @Test
    public void testANGLES_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4_by_angle(0.5);
        assertEquals(0.8775825618903728, x.x_4);
        assertEquals(0.479425538604203, x.y_4);
        x.set_4_by_angle(1.5);
        assertEquals(0.0707372016677029, x.x_4);
        assertEquals(0.9974949866040544, x.y_4);
        x.set_4_by_angle(2.5);
        assertEquals(-0.8011436155469337, x.x_4);
        assertEquals(0.5984721441039564, x.y_4);
        double u, v;
        for (double theta = 0; theta < 7; theta += 0.1) {
            x.set_4_by_angle(theta);
            final double omega = x.angle_4();
            u = x.x_4;
            v = x.y_4;
            x.set_4_by_angle(omega);
            assertEquals(u, x.x_4);
            assertEquals(v, x.y_4);
        }
    }

    @Test
    public void testCOMPLEX_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_0(3, 5);
        x.set_4(1, 2);
        x.complex_mult_4_0();
        assertEquals(3 - 10, x.x_0);
        assertEquals(5 + 6, x.y_0);
    }

    @Test
    public void testCOMPLEX_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_1(3, 5);
        x.set_4(1, 2);
        x.complex_mult_4_1();
        assertEquals(3 - 10, x.x_1);
        assertEquals(5 + 6, x.y_1);
    }

    @Test
    public void testCOMPLEX_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_2(3, 5);
        x.set_4(1, 2);
        x.complex_mult_4_2();
        assertEquals(3 - 10, x.x_2);
        assertEquals(5 + 6, x.y_2);
    }

    @Test
    public void testCOMPLEX_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_3(3, 5);
        x.set_4(1, 2);
        x.complex_mult_4_3();
        assertEquals(3 - 10, x.x_3);
        assertEquals(5 + 6, x.y_3);
    }

    @Test
    public void testCOMPLEX_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_0(1, 2);
        x.complex_mult_0_4();
        assertEquals(3 - 10, x.x_4);
        assertEquals(5 + 6, x.y_4);
    }

    @Test
    public void testCOMPLEX_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_1(1, 2);
        x.complex_mult_1_4();
        assertEquals(3 - 10, x.x_4);
        assertEquals(5 + 6, x.y_4);
    }

    @Test
    public void testCOMPLEX_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_2(1, 2);
        x.complex_mult_2_4();
        assertEquals(3 - 10, x.x_4);
        assertEquals(5 + 6, x.y_4);
    }

    @Test
    public void testCOMPLEX_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_3(1, 2);
        x.complex_mult_3_4();
        assertEquals(3 - 10, x.x_4);
        assertEquals(5 + 6, x.y_4);
    }

    @Test
    public void testCOMPLEX_CONJ_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.conjugate_4();
        assertEquals(3, x.x_4);
        assertEquals(-5, x.y_4);
    }

    @Test
    public void testCOPY_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_0(3, 5);
        x.set_4(1, 2);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.copy_from_4_to_0();
        assertEquals(1, x.x_0);
        assertEquals(2, x.y_0);
    }

    @Test
    public void testCOPY_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_1(3, 5);
        x.set_4(1, 2);
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        x.copy_from_4_to_1();
        assertEquals(1, x.x_1);
        assertEquals(2, x.y_1);
    }

    @Test
    public void testCOPY_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_2(3, 5);
        x.set_4(1, 2);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.copy_from_4_to_2();
        assertEquals(1, x.x_2);
        assertEquals(2, x.y_2);
    }

    @Test
    public void testCOPY_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_3(3, 5);
        x.set_4(1, 2);
        assertEquals(3, x.x_3);
        assertEquals(5, x.y_3);
        x.copy_from_4_to_3();
        assertEquals(1, x.x_3);
        assertEquals(2, x.y_3);
    }

    @Test
    public void testCOPY_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_0(1, 2);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.copy_from_0_to_4();
        assertEquals(1, x.x_4);
        assertEquals(2, x.y_4);
    }

    @Test
    public void testCOPY_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_1(1, 2);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.copy_from_1_to_4();
        assertEquals(1, x.x_4);
        assertEquals(2, x.y_4);
    }

    @Test
    public void testCOPY_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_2(1, 2);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.copy_from_2_to_4();
        assertEquals(1, x.x_4);
        assertEquals(2, x.y_4);
    }

    @Test
    public void testCOPY_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        x.set_3(1, 2);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.copy_from_3_to_4();
        assertEquals(1, x.x_4);
        assertEquals(2, x.y_4);
    }

    @Test
    public void testEXTRACT_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.set_4(-1, -2);
        x.extract_4(data, 0);
        x.extract_4(data, 5);
        x.extract_4(data, 8);
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
    public void testINJECT_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.inject_4(data, 0);
        assertEquals(0, x.x_4);
        assertEquals(1, x.y_4);
        x.inject_4(data, 6);
        assertEquals(6, x.x_4);
        assertEquals(7, x.y_4);
        x.inject_4(data, 8);
        assertEquals(8, x.x_4);
        assertEquals(9, x.y_4);
    }

    @Test
    public void testIS_ZERO_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        Assert.assertFalse(x.is_4_zero());
        x.set_4(0, 5);
        assertEquals(0, x.x_4);
        assertEquals(5, x.y_4);
        Assert.assertFalse(x.is_4_zero());
        x.set_4(3, 0);
        assertEquals(3, x.x_4);
        assertEquals(0, x.y_4);
        Assert.assertFalse(x.is_4_zero());
        x.set_4(0, 0);
        assertEquals(0, x.x_4);
        assertEquals(0, x.y_4);
        Assert.assertTrue(x.is_4_zero());
    }

    @Test
    public void testMATRIX_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_4(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        assertEquals(1 * 4 - 2 * 3, x.det_0_4());
        assertEquals(-(1 * 4 - 2 * 3), x.det_4_0());
        x.set_1(-1, 5);
        x.transform_1_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_0_4());
        assertEquals(-2, x.x_0);
        assertEquals(1.5, x.y_0);
        assertEquals(1, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.transpose_0_4();
        assertEquals(-2, x.x_0);
        assertEquals(1, x.y_0);
        assertEquals(1.5, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.set_matrix_0_4(1, 2, 1, 2);
        Assert.assertFalse(x.invert_0_4());
        assertEquals(0, x.det_0_4());
    }

    @Test
    public void testMATRIX_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_4(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        assertEquals(1 * 4 - 2 * 3, x.det_1_4());
        assertEquals(-(1 * 4 - 2 * 3), x.det_4_1());
        x.set_0(-1, 5);
        x.transform_0_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_1_4());
        assertEquals(-2, x.x_1);
        assertEquals(1.5, x.y_1);
        assertEquals(1, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.transpose_1_4();
        assertEquals(-2, x.x_1);
        assertEquals(1, x.y_1);
        assertEquals(1.5, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.set_matrix_1_4(1, 2, 1, 2);
        Assert.assertFalse(x.invert_1_4());
        assertEquals(0, x.det_1_4());
    }

    @Test
    public void testMATRIX_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_4(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        assertEquals(1 * 4 - 2 * 3, x.det_2_4());
        assertEquals(-(1 * 4 - 2 * 3), x.det_4_2());
        x.set_0(-1, 5);
        x.transform_0_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_2_4());
        assertEquals(-2, x.x_2);
        assertEquals(1.5, x.y_2);
        assertEquals(1, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.transpose_2_4();
        assertEquals(-2, x.x_2);
        assertEquals(1, x.y_2);
        assertEquals(1.5, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.set_matrix_2_4(1, 2, 1, 2);
        Assert.assertFalse(x.invert_2_4());
        assertEquals(0, x.det_2_4());
    }

    @Test
    public void testMATRIX_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_4(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        assertEquals(1 * 4 - 2 * 3, x.det_3_4());
        assertEquals(-(1 * 4 - 2 * 3), x.det_4_3());
        x.set_0(-1, 5);
        x.transform_0_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        Assert.assertTrue(x.invert_3_4());
        assertEquals(-2, x.x_3);
        assertEquals(1.5, x.y_3);
        assertEquals(1, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.transpose_3_4();
        assertEquals(-2, x.x_3);
        assertEquals(1, x.y_3);
        assertEquals(1.5, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.set_matrix_3_4(1, 2, 1, 2);
        Assert.assertFalse(x.invert_3_4());
        assertEquals(0, x.det_3_4());
    }

    @Test
    public void testMATRIX_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_0(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        assertEquals(1 * 4 - 2 * 3, x.det_4_0());
        assertEquals(-(1 * 4 - 2 * 3), x.det_0_4());
        x.set_1(-1, 5);
        x.transform_1_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_4_0());
        assertEquals(-2, x.x_4);
        assertEquals(1.5, x.y_4);
        assertEquals(1, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.transpose_4_0();
        assertEquals(-2, x.x_4);
        assertEquals(1, x.y_4);
        assertEquals(1.5, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.set_matrix_4_0(1, 2, 1, 2);
        Assert.assertFalse(x.invert_4_0());
        assertEquals(0, x.det_4_0());
    }

    @Test
    public void testMATRIX_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_1(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        assertEquals(1 * 4 - 2 * 3, x.det_4_1());
        assertEquals(-(1 * 4 - 2 * 3), x.det_1_4());
        x.set_0(-1, 5);
        x.transform_0_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_4_1());
        assertEquals(-2, x.x_4);
        assertEquals(1.5, x.y_4);
        assertEquals(1, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.transpose_4_1();
        assertEquals(-2, x.x_4);
        assertEquals(1, x.y_4);
        assertEquals(1.5, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.set_matrix_4_1(1, 2, 1, 2);
        Assert.assertFalse(x.invert_4_1());
        assertEquals(0, x.det_4_1());
    }

    @Test
    public void testMATRIX_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_2(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        assertEquals(1 * 4 - 2 * 3, x.det_4_2());
        assertEquals(-(1 * 4 - 2 * 3), x.det_2_4());
        x.set_0(-1, 5);
        x.transform_0_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        Assert.assertTrue(x.invert_4_2());
        assertEquals(-2, x.x_4);
        assertEquals(1.5, x.y_4);
        assertEquals(1, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.transpose_4_2();
        assertEquals(-2, x.x_4);
        assertEquals(1, x.y_4);
        assertEquals(1.5, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.set_matrix_4_2(1, 2, 1, 2);
        Assert.assertFalse(x.invert_4_2());
        assertEquals(0, x.det_4_2());
    }

    @Test
    public void testMATRIX_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_3(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        assertEquals(1 * 4 - 2 * 3, x.det_4_3());
        assertEquals(-(1 * 4 - 2 * 3), x.det_3_4());
        x.set_0(-1, 5);
        x.transform_0_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        Assert.assertTrue(x.invert_4_3());
        assertEquals(-2, x.x_4);
        assertEquals(1.5, x.y_4);
        assertEquals(1, x.x_3);
        assertEquals(-0.5, x.y_3);
        x.transpose_4_3();
        assertEquals(-2, x.x_4);
        assertEquals(1, x.y_4);
        assertEquals(1.5, x.x_3);
        assertEquals(-0.5, x.y_3);
        x.set_matrix_4_3(1, 2, 1, 2);
        Assert.assertFalse(x.invert_4_3());
        assertEquals(0, x.det_4_3());
    }

    @Test
    public void testMATRIX_TRANSFORM_0_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_1(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_4(-1, 5);
        x.transform_4_by_0_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_2(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_0_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_3(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_0_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_4(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_1(-1, 5);
        x.transform_1_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_4(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_2(-1, 5);
        x.transform_2_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_0_4(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_3(-1, 5);
        x.transform_3_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_0(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_4(-1, 5);
        x.transform_4_by_1_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_2(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_1_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_3(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_1_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_4(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_0(-1, 5);
        x.transform_0_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_4(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_2(-1, 5);
        x.transform_2_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_1_4(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_3(-1, 5);
        x.transform_3_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_0(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_4(-1, 5);
        x.transform_4_by_2_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_1(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_4(-1, 5);
        x.transform_4_by_2_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_3_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_3(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_2_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_4(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_0(-1, 5);
        x.transform_0_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_4(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_1(-1, 5);
        x.transform_1_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_4_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_2_4(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_3(-1, 5);
        x.transform_3_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_0_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_0(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_4(-1, 5);
        x.transform_4_by_3_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_1_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_1(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_4(-1, 5);
        x.transform_4_by_3_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_2_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_2(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_3_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_4_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_4(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_0(-1, 5);
        x.transform_0_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_4_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_4(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_1(-1, 5);
        x.transform_1_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_4_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_3_4(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_2(-1, 5);
        x.transform_2_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_0_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_0(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_0_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_0(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_0_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_0(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_3(-1, 5);
        x.transform_3_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_1_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_1(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_0(-1, 5);
        x.transform_0_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_1_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_1(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_1_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_1(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_2_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_2(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_0(-1, 5);
        x.transform_0_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_2_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_2(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_1(-1, 5);
        x.transform_1_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_2_3() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_2(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_3_0() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_3(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_0(-1, 5);
        x.transform_0_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_3_1() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_3(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_1(-1, 5);
        x.transform_1_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_3_2() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_matrix_4_3(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_2(-1, 5);
        x.transform_2_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testPYTHAGOREAN_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        assertEquals(Math.sqrt(3 * 3 + 5 * 5), x.length_4());
        Assert.assertTrue(x.normalize_4());
        assertEquals(1, x.length_4());
        assertEquals(3 / Math.sqrt(3 * 3 + 5 * 5), x.x_4);
        assertEquals(5 / Math.sqrt(3 * 3 + 5 * 5), x.y_4);
        x.set_4(0, 0);
        Assert.assertFalse(x.normalize_4());
    }

    @Test
    public void testSET_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_4(3, 5);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        assertEquals(0, x.x_0);
        assertEquals(0, x.y_0);
        assertEquals(0, x.x_1);
        assertEquals(0, x.y_1);
        assertEquals(0, x.x_2);
        assertEquals(0, x.y_2);
        assertEquals(0, x.x_3);
        assertEquals(0, x.y_3);
    }

    @Test
    public void testZERO_4() throws Exception {
        final VectorRegister5 x = new VectorRegister5();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.set_1(3, 5);
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        x.set_2(3, 5);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.set_3(3, 5);
        assertEquals(3, x.x_3);
        assertEquals(5, x.y_3);
        x.set_4(3, 5);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.zero_out_4();
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        Assert.assertFalse(x.is_0_zero());
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        Assert.assertFalse(x.is_1_zero());
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        Assert.assertFalse(x.is_2_zero());
        assertEquals(3, x.x_3);
        assertEquals(5, x.y_3);
        Assert.assertFalse(x.is_3_zero());
        assertEquals(0, x.x_4);
        assertEquals(0, x.y_4);
        Assert.assertTrue(x.is_4_zero());
    }
}
