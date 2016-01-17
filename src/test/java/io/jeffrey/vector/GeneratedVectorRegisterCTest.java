package io.jeffrey.vector;

import org.junit.Assert;
import org.junit.Test;

public class GeneratedVectorRegisterCTest extends CommonVectorTestingBase {

    @Test
    public void testALGEBRA_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_0(3, 5);
        x.mult_0_by(4);
        assertEquals(12, x.x_0);
        assertEquals(20, x.y_0);
        x.div_0_by(2);
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        x.add_11_to_0();
        assertEquals(7, x.x_0);
        assertEquals(12, x.y_0);
        x.sub_11_from_0();
        assertEquals(6, x.x_0);
        assertEquals(10, x.y_0);
        assertEquals(6 + 2 * 10, x.dot_11_0());
        x.set_0(1, 2);
    }

    @Test
    public void testALGEBRA_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_1(3, 5);
        x.mult_1_by(4);
        assertEquals(12, x.x_1);
        assertEquals(20, x.y_1);
        x.div_1_by(2);
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        x.add_11_to_1();
        assertEquals(7, x.x_1);
        assertEquals(12, x.y_1);
        x.sub_11_from_1();
        assertEquals(6, x.x_1);
        assertEquals(10, x.y_1);
        assertEquals(6 + 2 * 10, x.dot_11_1());
        x.set_1(1, 2);
    }

    @Test
    public void testALGEBRA_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_10(3, 5);
        x.mult_10_by(4);
        assertEquals(12, x.x_10);
        assertEquals(20, x.y_10);
        x.div_10_by(2);
        assertEquals(6, x.x_10);
        assertEquals(10, x.y_10);
        x.add_11_to_10();
        assertEquals(7, x.x_10);
        assertEquals(12, x.y_10);
        x.sub_11_from_10();
        assertEquals(6, x.x_10);
        assertEquals(10, x.y_10);
        assertEquals(6 + 2 * 10, x.dot_11_10());
        x.set_10(1, 2);
    }

    @Test
    public void testALGEBRA_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_0(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_0_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_0_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_0_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_1(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_1_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_1_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_1_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_10(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_10_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_10_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_10_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_2(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_2_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_2_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_2_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_3(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_3_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_3_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_3_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_4(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_4_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_4_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_4_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_5(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_5_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_5_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_5_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_6(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_6_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_6_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_6_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_7(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_7_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_7_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_7_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_8(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_8_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_8_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_8_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_9(1, 2);
        x.set_11(3, 5);
        x.mult_11_by(4);
        assertEquals(12, x.x_11);
        assertEquals(20, x.y_11);
        x.div_11_by(2);
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        x.add_9_to_11();
        assertEquals(7, x.x_11);
        assertEquals(12, x.y_11);
        x.sub_9_from_11();
        assertEquals(6, x.x_11);
        assertEquals(10, x.y_11);
        assertEquals(6 + 2 * 10, x.dot_9_11());
        x.set_11(1, 2);
    }

    @Test
    public void testALGEBRA_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_2(3, 5);
        x.mult_2_by(4);
        assertEquals(12, x.x_2);
        assertEquals(20, x.y_2);
        x.div_2_by(2);
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        x.add_11_to_2();
        assertEquals(7, x.x_2);
        assertEquals(12, x.y_2);
        x.sub_11_from_2();
        assertEquals(6, x.x_2);
        assertEquals(10, x.y_2);
        assertEquals(6 + 2 * 10, x.dot_11_2());
        x.set_2(1, 2);
    }

    @Test
    public void testALGEBRA_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_3(3, 5);
        x.mult_3_by(4);
        assertEquals(12, x.x_3);
        assertEquals(20, x.y_3);
        x.div_3_by(2);
        assertEquals(6, x.x_3);
        assertEquals(10, x.y_3);
        x.add_11_to_3();
        assertEquals(7, x.x_3);
        assertEquals(12, x.y_3);
        x.sub_11_from_3();
        assertEquals(6, x.x_3);
        assertEquals(10, x.y_3);
        assertEquals(6 + 2 * 10, x.dot_11_3());
        x.set_3(1, 2);
    }

    @Test
    public void testALGEBRA_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_4(3, 5);
        x.mult_4_by(4);
        assertEquals(12, x.x_4);
        assertEquals(20, x.y_4);
        x.div_4_by(2);
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        x.add_11_to_4();
        assertEquals(7, x.x_4);
        assertEquals(12, x.y_4);
        x.sub_11_from_4();
        assertEquals(6, x.x_4);
        assertEquals(10, x.y_4);
        assertEquals(6 + 2 * 10, x.dot_11_4());
        x.set_4(1, 2);
    }

    @Test
    public void testALGEBRA_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_5(3, 5);
        x.mult_5_by(4);
        assertEquals(12, x.x_5);
        assertEquals(20, x.y_5);
        x.div_5_by(2);
        assertEquals(6, x.x_5);
        assertEquals(10, x.y_5);
        x.add_11_to_5();
        assertEquals(7, x.x_5);
        assertEquals(12, x.y_5);
        x.sub_11_from_5();
        assertEquals(6, x.x_5);
        assertEquals(10, x.y_5);
        assertEquals(6 + 2 * 10, x.dot_11_5());
        x.set_5(1, 2);
    }

    @Test
    public void testALGEBRA_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_6(3, 5);
        x.mult_6_by(4);
        assertEquals(12, x.x_6);
        assertEquals(20, x.y_6);
        x.div_6_by(2);
        assertEquals(6, x.x_6);
        assertEquals(10, x.y_6);
        x.add_11_to_6();
        assertEquals(7, x.x_6);
        assertEquals(12, x.y_6);
        x.sub_11_from_6();
        assertEquals(6, x.x_6);
        assertEquals(10, x.y_6);
        assertEquals(6 + 2 * 10, x.dot_11_6());
        x.set_6(1, 2);
    }

    @Test
    public void testALGEBRA_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_7(3, 5);
        x.mult_7_by(4);
        assertEquals(12, x.x_7);
        assertEquals(20, x.y_7);
        x.div_7_by(2);
        assertEquals(6, x.x_7);
        assertEquals(10, x.y_7);
        x.add_11_to_7();
        assertEquals(7, x.x_7);
        assertEquals(12, x.y_7);
        x.sub_11_from_7();
        assertEquals(6, x.x_7);
        assertEquals(10, x.y_7);
        assertEquals(6 + 2 * 10, x.dot_11_7());
        x.set_7(1, 2);
    }

    @Test
    public void testALGEBRA_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_8(3, 5);
        x.mult_8_by(4);
        assertEquals(12, x.x_8);
        assertEquals(20, x.y_8);
        x.div_8_by(2);
        assertEquals(6, x.x_8);
        assertEquals(10, x.y_8);
        x.add_11_to_8();
        assertEquals(7, x.x_8);
        assertEquals(12, x.y_8);
        x.sub_11_from_8();
        assertEquals(6, x.x_8);
        assertEquals(10, x.y_8);
        assertEquals(6 + 2 * 10, x.dot_11_8());
        x.set_8(1, 2);
    }

    @Test
    public void testALGEBRA_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(1, 2);
        x.set_9(3, 5);
        x.mult_9_by(4);
        assertEquals(12, x.x_9);
        assertEquals(20, x.y_9);
        x.div_9_by(2);
        assertEquals(6, x.x_9);
        assertEquals(10, x.y_9);
        x.add_11_to_9();
        assertEquals(7, x.x_9);
        assertEquals(12, x.y_9);
        x.sub_11_from_9();
        assertEquals(6, x.x_9);
        assertEquals(10, x.y_9);
        assertEquals(6 + 2 * 10, x.dot_11_9());
        x.set_9(1, 2);
    }

    @Test
    public void testANGLES_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11_by_angle(0.5);
        assertEquals(0.8775825618903728, x.x_11);
        assertEquals(0.479425538604203, x.y_11);
        x.set_11_by_angle(1.5);
        assertEquals(0.0707372016677029, x.x_11);
        assertEquals(0.9974949866040544, x.y_11);
        x.set_11_by_angle(2.5);
        assertEquals(-0.8011436155469337, x.x_11);
        assertEquals(0.5984721441039564, x.y_11);
        double u, v;
        for (double theta = 0; theta < 7; theta += 0.1) {
            x.set_11_by_angle(theta);
            final double omega = x.angle_11();
            u = x.x_11;
            v = x.y_11;
            x.set_11_by_angle(omega);
            assertEquals(u, x.x_11);
            assertEquals(v, x.y_11);
        }
    }

    @Test
    public void testCOMPLEX_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_0(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_0();
        assertEquals(3 - 10, x.x_0);
        assertEquals(5 + 6, x.y_0);
    }

    @Test
    public void testCOMPLEX_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_1(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_1();
        assertEquals(3 - 10, x.x_1);
        assertEquals(5 + 6, x.y_1);
    }

    @Test
    public void testCOMPLEX_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_10(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_10();
        assertEquals(3 - 10, x.x_10);
        assertEquals(5 + 6, x.y_10);
    }

    @Test
    public void testCOMPLEX_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_0(1, 2);
        x.complex_mult_0_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_1(1, 2);
        x.complex_mult_1_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_10(1, 2);
        x.complex_mult_10_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_2(1, 2);
        x.complex_mult_2_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_3(1, 2);
        x.complex_mult_3_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_4(1, 2);
        x.complex_mult_4_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_5(1, 2);
        x.complex_mult_5_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_6(1, 2);
        x.complex_mult_6_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_7(1, 2);
        x.complex_mult_7_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_8(1, 2);
        x.complex_mult_8_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_9(1, 2);
        x.complex_mult_9_11();
        assertEquals(3 - 10, x.x_11);
        assertEquals(5 + 6, x.y_11);
    }

    @Test
    public void testCOMPLEX_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_2(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_2();
        assertEquals(3 - 10, x.x_2);
        assertEquals(5 + 6, x.y_2);
    }

    @Test
    public void testCOMPLEX_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_3(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_3();
        assertEquals(3 - 10, x.x_3);
        assertEquals(5 + 6, x.y_3);
    }

    @Test
    public void testCOMPLEX_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_4(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_4();
        assertEquals(3 - 10, x.x_4);
        assertEquals(5 + 6, x.y_4);
    }

    @Test
    public void testCOMPLEX_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_5(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_5();
        assertEquals(3 - 10, x.x_5);
        assertEquals(5 + 6, x.y_5);
    }

    @Test
    public void testCOMPLEX_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_6(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_6();
        assertEquals(3 - 10, x.x_6);
        assertEquals(5 + 6, x.y_6);
    }

    @Test
    public void testCOMPLEX_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_7(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_7();
        assertEquals(3 - 10, x.x_7);
        assertEquals(5 + 6, x.y_7);
    }

    @Test
    public void testCOMPLEX_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_8(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_8();
        assertEquals(3 - 10, x.x_8);
        assertEquals(5 + 6, x.y_8);
    }

    @Test
    public void testCOMPLEX_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_9(3, 5);
        x.set_11(1, 2);
        x.complex_mult_11_9();
        assertEquals(3 - 10, x.x_9);
        assertEquals(5 + 6, x.y_9);
    }

    @Test
    public void testCOMPLEX_CONJ_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.conjugate_11();
        assertEquals(3, x.x_11);
        assertEquals(-5, x.y_11);
    }

    @Test
    public void testCOPY_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_0(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.copy_from_11_to_0();
        assertEquals(1, x.x_0);
        assertEquals(2, x.y_0);
    }

    @Test
    public void testCOPY_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_1(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_1);
        assertEquals(5, x.y_1);
        x.copy_from_11_to_1();
        assertEquals(1, x.x_1);
        assertEquals(2, x.y_1);
    }

    @Test
    public void testCOPY_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_10(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_10);
        assertEquals(5, x.y_10);
        x.copy_from_11_to_10();
        assertEquals(1, x.x_10);
        assertEquals(2, x.y_10);
    }

    @Test
    public void testCOPY_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_0(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_0_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_1(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_1_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_10(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_10_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_2(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_2_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_3(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_3_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_4(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_4_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_5(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_5_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_6(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_6_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_7(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_7_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_8(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_8_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        x.set_9(1, 2);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.copy_from_9_to_11();
        assertEquals(1, x.x_11);
        assertEquals(2, x.y_11);
    }

    @Test
    public void testCOPY_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_2(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_2);
        assertEquals(5, x.y_2);
        x.copy_from_11_to_2();
        assertEquals(1, x.x_2);
        assertEquals(2, x.y_2);
    }

    @Test
    public void testCOPY_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_3(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_3);
        assertEquals(5, x.y_3);
        x.copy_from_11_to_3();
        assertEquals(1, x.x_3);
        assertEquals(2, x.y_3);
    }

    @Test
    public void testCOPY_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_4(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        x.copy_from_11_to_4();
        assertEquals(1, x.x_4);
        assertEquals(2, x.y_4);
    }

    @Test
    public void testCOPY_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_5(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_5);
        assertEquals(5, x.y_5);
        x.copy_from_11_to_5();
        assertEquals(1, x.x_5);
        assertEquals(2, x.y_5);
    }

    @Test
    public void testCOPY_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_6(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_6);
        assertEquals(5, x.y_6);
        x.copy_from_11_to_6();
        assertEquals(1, x.x_6);
        assertEquals(2, x.y_6);
    }

    @Test
    public void testCOPY_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_7(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_7);
        assertEquals(5, x.y_7);
        x.copy_from_11_to_7();
        assertEquals(1, x.x_7);
        assertEquals(2, x.y_7);
    }

    @Test
    public void testCOPY_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_8(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_8);
        assertEquals(5, x.y_8);
        x.copy_from_11_to_8();
        assertEquals(1, x.x_8);
        assertEquals(2, x.y_8);
    }

    @Test
    public void testCOPY_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_9(3, 5);
        x.set_11(1, 2);
        assertEquals(3, x.x_9);
        assertEquals(5, x.y_9);
        x.copy_from_11_to_9();
        assertEquals(1, x.x_9);
        assertEquals(2, x.y_9);
    }

    @Test
    public void testEXTRACT_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.set_11(-1, -2);
        x.extract_11(data, 0);
        x.extract_11(data, 5);
        x.extract_11(data, 8);
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
    public void testINJECT_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.inject_11(data, 0);
        assertEquals(0, x.x_11);
        assertEquals(1, x.y_11);
        x.inject_11(data, 6);
        assertEquals(6, x.x_11);
        assertEquals(7, x.y_11);
        x.inject_11(data, 8);
        assertEquals(8, x.x_11);
        assertEquals(9, x.y_11);
    }

    @Test
    public void testIS_ZERO_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        Assert.assertFalse(x.is_11_zero());
        x.set_11(0, 5);
        assertEquals(0, x.x_11);
        assertEquals(5, x.y_11);
        Assert.assertFalse(x.is_11_zero());
        x.set_11(3, 0);
        assertEquals(3, x.x_11);
        assertEquals(0, x.y_11);
        Assert.assertFalse(x.is_11_zero());
        x.set_11(0, 0);
        assertEquals(0, x.x_11);
        assertEquals(0, x.y_11);
        Assert.assertTrue(x.is_11_zero());
    }

    @Test
    public void testMATRIX_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_0_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_0());
        x.set_1(-1, 5);
        x.transform_1_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_0_11());
        assertEquals(-2, x.x_0);
        assertEquals(1.5, x.y_0);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_0_11();
        assertEquals(-2, x.x_0);
        assertEquals(1, x.y_0);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_0_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_0_11());
        assertEquals(0, x.det_0_11());
    }

    @Test
    public void testMATRIX_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_1_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_1());
        x.set_0(-1, 5);
        x.transform_0_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_1_11());
        assertEquals(-2, x.x_1);
        assertEquals(1.5, x.y_1);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_1_11();
        assertEquals(-2, x.x_1);
        assertEquals(1, x.y_1);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_1_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_1_11());
        assertEquals(0, x.det_1_11());
    }

    @Test
    public void testMATRIX_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_10_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_10());
        x.set_0(-1, 5);
        x.transform_0_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        Assert.assertTrue(x.invert_10_11());
        assertEquals(-2, x.x_10);
        assertEquals(1.5, x.y_10);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_10_11();
        assertEquals(-2, x.x_10);
        assertEquals(1, x.y_10);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_10_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_10_11());
        assertEquals(0, x.det_10_11());
    }

    @Test
    public void testMATRIX_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        assertEquals(1 * 4 - 2 * 3, x.det_11_0());
        assertEquals(-(1 * 4 - 2 * 3), x.det_0_11());
        x.set_1(-1, 5);
        x.transform_1_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_0());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.transpose_11_0();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_0);
        assertEquals(-0.5, x.y_0);
        x.set_matrix_11_0(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_0());
        assertEquals(0, x.det_11_0());
    }

    @Test
    public void testMATRIX_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        assertEquals(1 * 4 - 2 * 3, x.det_11_1());
        assertEquals(-(1 * 4 - 2 * 3), x.det_1_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_1());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.transpose_11_1();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_1);
        assertEquals(-0.5, x.y_1);
        x.set_matrix_11_1(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_1());
        assertEquals(0, x.det_11_1());
    }

    @Test
    public void testMATRIX_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        assertEquals(1 * 4 - 2 * 3, x.det_11_10());
        assertEquals(-(1 * 4 - 2 * 3), x.det_10_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        Assert.assertTrue(x.invert_11_10());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_10);
        assertEquals(-0.5, x.y_10);
        x.transpose_11_10();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_10);
        assertEquals(-0.5, x.y_10);
        x.set_matrix_11_10(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_10());
        assertEquals(0, x.det_11_10());
    }

    @Test
    public void testMATRIX_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        assertEquals(1 * 4 - 2 * 3, x.det_11_2());
        assertEquals(-(1 * 4 - 2 * 3), x.det_2_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_2());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.transpose_11_2();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_2);
        assertEquals(-0.5, x.y_2);
        x.set_matrix_11_2(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_2());
        assertEquals(0, x.det_11_2());
    }

    @Test
    public void testMATRIX_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        assertEquals(1 * 4 - 2 * 3, x.det_11_3());
        assertEquals(-(1 * 4 - 2 * 3), x.det_3_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_3());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_3);
        assertEquals(-0.5, x.y_3);
        x.transpose_11_3();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_3);
        assertEquals(-0.5, x.y_3);
        x.set_matrix_11_3(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_3());
        assertEquals(0, x.det_11_3());
    }

    @Test
    public void testMATRIX_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        assertEquals(1 * 4 - 2 * 3, x.det_11_4());
        assertEquals(-(1 * 4 - 2 * 3), x.det_4_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_5(-1, 5);
        x.transform_5_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_4());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.transpose_11_4();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_4);
        assertEquals(-0.5, x.y_4);
        x.set_matrix_11_4(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_4());
        assertEquals(0, x.det_11_4());
    }

    @Test
    public void testMATRIX_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        assertEquals(1 * 4 - 2 * 3, x.det_11_5());
        assertEquals(-(1 * 4 - 2 * 3), x.det_5_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_6(-1, 5);
        x.transform_6_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_5());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_5);
        assertEquals(-0.5, x.y_5);
        x.transpose_11_5();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_5);
        assertEquals(-0.5, x.y_5);
        x.set_matrix_11_5(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_5());
        assertEquals(0, x.det_11_5());
    }

    @Test
    public void testMATRIX_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        assertEquals(1 * 4 - 2 * 3, x.det_11_6());
        assertEquals(-(1 * 4 - 2 * 3), x.det_6_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_7(-1, 5);
        x.transform_7_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_6());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_6);
        assertEquals(-0.5, x.y_6);
        x.transpose_11_6();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_6);
        assertEquals(-0.5, x.y_6);
        x.set_matrix_11_6(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_6());
        assertEquals(0, x.det_11_6());
    }

    @Test
    public void testMATRIX_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        assertEquals(1 * 4 - 2 * 3, x.det_11_7());
        assertEquals(-(1 * 4 - 2 * 3), x.det_7_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_8(-1, 5);
        x.transform_8_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_7());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_7);
        assertEquals(-0.5, x.y_7);
        x.transpose_11_7();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_7);
        assertEquals(-0.5, x.y_7);
        x.set_matrix_11_7(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_7());
        assertEquals(0, x.det_11_7());
    }

    @Test
    public void testMATRIX_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        assertEquals(1 * 4 - 2 * 3, x.det_11_8());
        assertEquals(-(1 * 4 - 2 * 3), x.det_8_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_9(-1, 5);
        x.transform_9_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_8());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_8);
        assertEquals(-0.5, x.y_8);
        x.transpose_11_8();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_8);
        assertEquals(-0.5, x.y_8);
        x.set_matrix_11_8(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_8());
        assertEquals(0, x.det_11_8());
    }

    @Test
    public void testMATRIX_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        assertEquals(1 * 4 - 2 * 3, x.det_11_9());
        assertEquals(-(1 * 4 - 2 * 3), x.det_9_11());
        x.set_0(-1, 5);
        x.transform_0_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_10(-1, 5);
        x.transform_10_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_11_9());
        assertEquals(-2, x.x_11);
        assertEquals(1.5, x.y_11);
        assertEquals(1, x.x_9);
        assertEquals(-0.5, x.y_9);
        x.transpose_11_9();
        assertEquals(-2, x.x_11);
        assertEquals(1, x.y_11);
        assertEquals(1.5, x.x_9);
        assertEquals(-0.5, x.y_9);
        x.set_matrix_11_9(1, 2, 1, 2);
        Assert.assertFalse(x.invert_11_9());
        assertEquals(0, x.det_11_9());
    }

    @Test
    public void testMATRIX_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_2_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_2());
        x.set_0(-1, 5);
        x.transform_0_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_2_11());
        assertEquals(-2, x.x_2);
        assertEquals(1.5, x.y_2);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_2_11();
        assertEquals(-2, x.x_2);
        assertEquals(1, x.y_2);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_2_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_2_11());
        assertEquals(0, x.det_2_11());
    }

    @Test
    public void testMATRIX_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_3_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_3());
        x.set_0(-1, 5);
        x.transform_0_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_3_11());
        assertEquals(-2, x.x_3);
        assertEquals(1.5, x.y_3);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_3_11();
        assertEquals(-2, x.x_3);
        assertEquals(1, x.y_3);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_3_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_3_11());
        assertEquals(0, x.det_3_11());
    }

    @Test
    public void testMATRIX_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_4_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_4());
        x.set_0(-1, 5);
        x.transform_0_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_5(-1, 5);
        x.transform_5_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_4_11());
        assertEquals(-2, x.x_4);
        assertEquals(1.5, x.y_4);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_4_11();
        assertEquals(-2, x.x_4);
        assertEquals(1, x.y_4);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_4_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_4_11());
        assertEquals(0, x.det_4_11());
    }

    @Test
    public void testMATRIX_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_5_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_5());
        x.set_0(-1, 5);
        x.transform_0_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_6(-1, 5);
        x.transform_6_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_5_11());
        assertEquals(-2, x.x_5);
        assertEquals(1.5, x.y_5);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_5_11();
        assertEquals(-2, x.x_5);
        assertEquals(1, x.y_5);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_5_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_5_11());
        assertEquals(0, x.det_5_11());
    }

    @Test
    public void testMATRIX_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_6_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_6());
        x.set_0(-1, 5);
        x.transform_0_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_7(-1, 5);
        x.transform_7_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_6_11());
        assertEquals(-2, x.x_6);
        assertEquals(1.5, x.y_6);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_6_11();
        assertEquals(-2, x.x_6);
        assertEquals(1, x.y_6);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_6_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_6_11());
        assertEquals(0, x.det_6_11());
    }

    @Test
    public void testMATRIX_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_7_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_7());
        x.set_0(-1, 5);
        x.transform_0_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_8(-1, 5);
        x.transform_8_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_7_11());
        assertEquals(-2, x.x_7);
        assertEquals(1.5, x.y_7);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_7_11();
        assertEquals(-2, x.x_7);
        assertEquals(1, x.y_7);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_7_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_7_11());
        assertEquals(0, x.det_7_11());
    }

    @Test
    public void testMATRIX_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_8_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_8());
        x.set_0(-1, 5);
        x.transform_0_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_9(-1, 5);
        x.transform_9_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_8_11());
        assertEquals(-2, x.x_8);
        assertEquals(1.5, x.y_8);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_8_11();
        assertEquals(-2, x.x_8);
        assertEquals(1, x.y_8);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_8_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_8_11());
        assertEquals(0, x.det_8_11());
    }

    @Test
    public void testMATRIX_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        assertEquals(1 * 4 - 2 * 3, x.det_9_11());
        assertEquals(-(1 * 4 - 2 * 3), x.det_11_9());
        x.set_0(-1, 5);
        x.transform_0_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
        x.set_10(-1, 5);
        x.transform_10_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
        Assert.assertTrue(x.invert_9_11());
        assertEquals(-2, x.x_9);
        assertEquals(1.5, x.y_9);
        assertEquals(1, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.transpose_9_11();
        assertEquals(-2, x.x_9);
        assertEquals(1, x.y_9);
        assertEquals(1.5, x.x_11);
        assertEquals(-0.5, x.y_11);
        x.set_matrix_9_11(1, 2, 1, 2);
        Assert.assertFalse(x.invert_9_11());
        assertEquals(0, x.det_9_11());
    }

    @Test
    public void testMATRIX_TRANSFORM_0_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_1(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_0_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_10(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_0_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_11(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_0_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_2(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_0_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_3(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_0_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_4(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_0_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_5(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_0_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_6(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_0_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_7(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_0_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_8(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_0_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_0_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_0_9(1, 3, 2, 4);
        assertEquals(1, x.x_0);
        assertEquals(3, x.y_0);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_0_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_0(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_1_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_10(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_1_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_11(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_1_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_2(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_1_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_3(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_1_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_4(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_1_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_5(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_1_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_6(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_1_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_7(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_1_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_8(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_1_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_1_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_1_9(1, 3, 2, 4);
        assertEquals(1, x.x_1);
        assertEquals(3, x.y_1);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_1_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_0(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_10_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_1(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_10_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_11(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_10_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_2(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_10_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_3(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_10_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_4(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_10_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_5(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_10_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_6(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_10_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_7(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_10_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_8(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_10_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_10_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_10_9(1, 3, 2, 4);
        assertEquals(1, x.x_10);
        assertEquals(3, x.y_10);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_10_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_1(-1, 5);
        x.transform_1_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_10(-1, 5);
        x.transform_10_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_2(-1, 5);
        x.transform_2_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_3(-1, 5);
        x.transform_3_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_4(-1, 5);
        x.transform_4_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_5(-1, 5);
        x.transform_5_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_6(-1, 5);
        x.transform_6_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_7(-1, 5);
        x.transform_7_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_8(-1, 5);
        x.transform_8_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_0_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_0(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_9(-1, 5);
        x.transform_9_by_11_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_0(-1, 5);
        x.transform_0_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_10(-1, 5);
        x.transform_10_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_2(-1, 5);
        x.transform_2_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_3(-1, 5);
        x.transform_3_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_4(-1, 5);
        x.transform_4_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_5(-1, 5);
        x.transform_5_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_6(-1, 5);
        x.transform_6_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_7(-1, 5);
        x.transform_7_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_8(-1, 5);
        x.transform_8_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_1_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_1(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_9(-1, 5);
        x.transform_9_by_11_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_0(-1, 5);
        x.transform_0_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_1(-1, 5);
        x.transform_1_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_2(-1, 5);
        x.transform_2_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_3(-1, 5);
        x.transform_3_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_4(-1, 5);
        x.transform_4_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_5(-1, 5);
        x.transform_5_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_6(-1, 5);
        x.transform_6_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_7(-1, 5);
        x.transform_7_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_8(-1, 5);
        x.transform_8_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_10_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_10(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_9(-1, 5);
        x.transform_9_by_11_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_0(-1, 5);
        x.transform_0_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_1(-1, 5);
        x.transform_1_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_10(-1, 5);
        x.transform_10_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_3(-1, 5);
        x.transform_3_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_4(-1, 5);
        x.transform_4_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_5(-1, 5);
        x.transform_5_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_6(-1, 5);
        x.transform_6_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_7(-1, 5);
        x.transform_7_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_8(-1, 5);
        x.transform_8_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_2_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_2(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_9(-1, 5);
        x.transform_9_by_11_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_0(-1, 5);
        x.transform_0_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_1(-1, 5);
        x.transform_1_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_10(-1, 5);
        x.transform_10_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_2(-1, 5);
        x.transform_2_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_4(-1, 5);
        x.transform_4_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_5(-1, 5);
        x.transform_5_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_6(-1, 5);
        x.transform_6_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_7(-1, 5);
        x.transform_7_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_8(-1, 5);
        x.transform_8_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_3_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_3(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_9(-1, 5);
        x.transform_9_by_11_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_0(-1, 5);
        x.transform_0_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_1(-1, 5);
        x.transform_1_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_10(-1, 5);
        x.transform_10_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_2(-1, 5);
        x.transform_2_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_3(-1, 5);
        x.transform_3_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_5(-1, 5);
        x.transform_5_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_6(-1, 5);
        x.transform_6_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_7(-1, 5);
        x.transform_7_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_8(-1, 5);
        x.transform_8_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_4_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_4(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_9(-1, 5);
        x.transform_9_by_11_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_0(-1, 5);
        x.transform_0_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_1(-1, 5);
        x.transform_1_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_10(-1, 5);
        x.transform_10_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_2(-1, 5);
        x.transform_2_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_3(-1, 5);
        x.transform_3_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_4(-1, 5);
        x.transform_4_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_6(-1, 5);
        x.transform_6_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_7(-1, 5);
        x.transform_7_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_8(-1, 5);
        x.transform_8_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_5_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_5(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_9(-1, 5);
        x.transform_9_by_11_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_0(-1, 5);
        x.transform_0_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_1(-1, 5);
        x.transform_1_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_10(-1, 5);
        x.transform_10_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_2(-1, 5);
        x.transform_2_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_3(-1, 5);
        x.transform_3_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_4(-1, 5);
        x.transform_4_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_5(-1, 5);
        x.transform_5_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_7(-1, 5);
        x.transform_7_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_8(-1, 5);
        x.transform_8_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_6_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_6(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_9(-1, 5);
        x.transform_9_by_11_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_0(-1, 5);
        x.transform_0_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_1(-1, 5);
        x.transform_1_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_10(-1, 5);
        x.transform_10_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_2(-1, 5);
        x.transform_2_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_3(-1, 5);
        x.transform_3_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_4(-1, 5);
        x.transform_4_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_5(-1, 5);
        x.transform_5_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_6(-1, 5);
        x.transform_6_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_8(-1, 5);
        x.transform_8_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_7_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_7(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_9(-1, 5);
        x.transform_9_by_11_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_0(-1, 5);
        x.transform_0_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_1(-1, 5);
        x.transform_1_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_10(-1, 5);
        x.transform_10_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_2(-1, 5);
        x.transform_2_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_3(-1, 5);
        x.transform_3_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_4(-1, 5);
        x.transform_4_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_5(-1, 5);
        x.transform_5_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_6(-1, 5);
        x.transform_6_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_7(-1, 5);
        x.transform_7_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_8_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_8(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_9(-1, 5);
        x.transform_9_by_11_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_0(-1, 5);
        x.transform_0_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_1(-1, 5);
        x.transform_1_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_10(-1, 5);
        x.transform_10_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_2(-1, 5);
        x.transform_2_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_3(-1, 5);
        x.transform_3_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_4(-1, 5);
        x.transform_4_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_5(-1, 5);
        x.transform_5_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_6(-1, 5);
        x.transform_6_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_7(-1, 5);
        x.transform_7_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_11_9_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_11_9(1, 3, 2, 4);
        assertEquals(1, x.x_11);
        assertEquals(3, x.y_11);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_8(-1, 5);
        x.transform_8_by_11_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_0(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_2_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_1(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_2_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_10(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_2_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_11(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_2_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_3(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_2_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_4(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_2_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_5(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_2_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_6(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_2_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_7(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_2_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_8(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_2_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_2_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_2_9(1, 3, 2, 4);
        assertEquals(1, x.x_2);
        assertEquals(3, x.y_2);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_2_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_0(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_3_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_1(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_3_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_10(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_3_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_11(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_3_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_2(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_3_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_4(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_3_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_5(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_3_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_6(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_3_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_7(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_3_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_8(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_3_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_3_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_3_9(1, 3, 2, 4);
        assertEquals(1, x.x_3);
        assertEquals(3, x.y_3);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_3_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_0(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_4_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_1(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_4_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_10(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_4_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_11(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_4_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_2(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_4_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_3(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_4_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_5(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_4_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_6(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_4_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_7(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_4_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_8(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_4_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_4_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_4_9(1, 3, 2, 4);
        assertEquals(1, x.x_4);
        assertEquals(3, x.y_4);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_4_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_0(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_5_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_1(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_5_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_10(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_5_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_11(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_5_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_2(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_5_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_3(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_5_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_4(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_5_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_6(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_5_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_7(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_5_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_8(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_5_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_5_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_5_9(1, 3, 2, 4);
        assertEquals(1, x.x_5);
        assertEquals(3, x.y_5);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_5_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_0(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_6_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_1(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_6_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_10(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_6_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_11(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_6_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_2(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_6_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_3(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_6_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_4(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_6_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_5(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_6_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_7(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_6_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_8(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_6_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_6_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_6_9(1, 3, 2, 4);
        assertEquals(1, x.x_6);
        assertEquals(3, x.y_6);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_6_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_0(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_7_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_1(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_7_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_10(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_7_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_11(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_7_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_2(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_7_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_3(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_7_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_4(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_7_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_5(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_7_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_6(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_7_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_8(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_7_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_7_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_7_9(1, 3, 2, 4);
        assertEquals(1, x.x_7);
        assertEquals(3, x.y_7);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_7_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_0(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_8_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_1(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_8_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_10(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_8_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_11_9() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_11(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_9(-1, 5);
        x.transform_9_by_8_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_9);
        assertEquals(-1 * 3 + 5 * 4, x.y_9);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_2(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_8_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_3(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_8_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_4(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_8_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_5(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_8_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_6(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_8_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_7(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_8_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_8_9_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_8_9(1, 3, 2, 4);
        assertEquals(1, x.x_8);
        assertEquals(3, x.y_8);
        assertEquals(2, x.x_9);
        assertEquals(4, x.y_9);
        x.set_11(-1, 5);
        x.transform_11_by_8_9();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_0_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_0(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_0);
        assertEquals(4, x.y_0);
        x.set_11(-1, 5);
        x.transform_11_by_9_0();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_1_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_1(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_1);
        assertEquals(4, x.y_1);
        x.set_11(-1, 5);
        x.transform_11_by_9_1();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_10_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_10(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_10);
        assertEquals(4, x.y_10);
        x.set_11(-1, 5);
        x.transform_11_by_9_10();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_0() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_0(-1, 5);
        x.transform_0_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_0);
        assertEquals(-1 * 3 + 5 * 4, x.y_0);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_1() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_1(-1, 5);
        x.transform_1_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_1);
        assertEquals(-1 * 3 + 5 * 4, x.y_1);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_10() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_10(-1, 5);
        x.transform_10_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_10);
        assertEquals(-1 * 3 + 5 * 4, x.y_10);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_2() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_2(-1, 5);
        x.transform_2_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_2);
        assertEquals(-1 * 3 + 5 * 4, x.y_2);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_3() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_3(-1, 5);
        x.transform_3_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_3);
        assertEquals(-1 * 3 + 5 * 4, x.y_3);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_4() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_4(-1, 5);
        x.transform_4_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_4);
        assertEquals(-1 * 3 + 5 * 4, x.y_4);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_5() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_5(-1, 5);
        x.transform_5_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_5);
        assertEquals(-1 * 3 + 5 * 4, x.y_5);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_6() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_6(-1, 5);
        x.transform_6_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_6);
        assertEquals(-1 * 3 + 5 * 4, x.y_6);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_7() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_7(-1, 5);
        x.transform_7_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_7);
        assertEquals(-1 * 3 + 5 * 4, x.y_7);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_11_8() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_11(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_11);
        assertEquals(4, x.y_11);
        x.set_8(-1, 5);
        x.transform_8_by_9_11();
        assertEquals(-1 * 1 + 5 * 2, x.x_8);
        assertEquals(-1 * 3 + 5 * 4, x.y_8);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_2_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_2(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_2);
        assertEquals(4, x.y_2);
        x.set_11(-1, 5);
        x.transform_11_by_9_2();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_3_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_3(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_3);
        assertEquals(4, x.y_3);
        x.set_11(-1, 5);
        x.transform_11_by_9_3();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_4_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_4(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_4);
        assertEquals(4, x.y_4);
        x.set_11(-1, 5);
        x.transform_11_by_9_4();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_5_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_5(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_5);
        assertEquals(4, x.y_5);
        x.set_11(-1, 5);
        x.transform_11_by_9_5();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_6_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_6(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_6);
        assertEquals(4, x.y_6);
        x.set_11(-1, 5);
        x.transform_11_by_9_6();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_7_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_7(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_7);
        assertEquals(4, x.y_7);
        x.set_11(-1, 5);
        x.transform_11_by_9_7();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testMATRIX_TRANSFORM_9_8_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_matrix_9_8(1, 3, 2, 4);
        assertEquals(1, x.x_9);
        assertEquals(3, x.y_9);
        assertEquals(2, x.x_8);
        assertEquals(4, x.y_8);
        x.set_11(-1, 5);
        x.transform_11_by_9_8();
        assertEquals(-1 * 1 + 5 * 2, x.x_11);
        assertEquals(-1 * 3 + 5 * 4, x.y_11);
    }

    @Test
    public void testPYTHAGOREAN_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        assertEquals(Math.sqrt(3 * 3 + 5 * 5), x.length_11());
        Assert.assertTrue(x.normalize_11());
        assertEquals(1, x.length_11());
        assertEquals(3 / Math.sqrt(3 * 3 + 5 * 5), x.x_11);
        assertEquals(5 / Math.sqrt(3 * 3 + 5 * 5), x.y_11);
        x.set_11(0, 0);
        Assert.assertFalse(x.normalize_11());
    }

    @Test
    public void testSET_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
        x.set_11(3, 5);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        assertEquals(0, x.x_0);
        assertEquals(0, x.y_0);
        assertEquals(0, x.x_1);
        assertEquals(0, x.y_1);
        assertEquals(0, x.x_2);
        assertEquals(0, x.y_2);
        assertEquals(0, x.x_3);
        assertEquals(0, x.y_3);
        assertEquals(0, x.x_4);
        assertEquals(0, x.y_4);
        assertEquals(0, x.x_5);
        assertEquals(0, x.y_5);
        assertEquals(0, x.x_6);
        assertEquals(0, x.y_6);
        assertEquals(0, x.x_7);
        assertEquals(0, x.y_7);
        assertEquals(0, x.x_8);
        assertEquals(0, x.y_8);
        assertEquals(0, x.x_9);
        assertEquals(0, x.y_9);
        assertEquals(0, x.x_10);
        assertEquals(0, x.y_10);
    }

    @Test
    public void testZERO_11() throws Exception {
        final VectorRegisterC x = new VectorRegisterC();
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
        x.set_5(3, 5);
        assertEquals(3, x.x_5);
        assertEquals(5, x.y_5);
        x.set_6(3, 5);
        assertEquals(3, x.x_6);
        assertEquals(5, x.y_6);
        x.set_7(3, 5);
        assertEquals(3, x.x_7);
        assertEquals(5, x.y_7);
        x.set_8(3, 5);
        assertEquals(3, x.x_8);
        assertEquals(5, x.y_8);
        x.set_9(3, 5);
        assertEquals(3, x.x_9);
        assertEquals(5, x.y_9);
        x.set_10(3, 5);
        assertEquals(3, x.x_10);
        assertEquals(5, x.y_10);
        x.set_11(3, 5);
        assertEquals(3, x.x_11);
        assertEquals(5, x.y_11);
        x.zero_out_11();
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
        assertEquals(3, x.x_4);
        assertEquals(5, x.y_4);
        Assert.assertFalse(x.is_4_zero());
        assertEquals(3, x.x_5);
        assertEquals(5, x.y_5);
        Assert.assertFalse(x.is_5_zero());
        assertEquals(3, x.x_6);
        assertEquals(5, x.y_6);
        Assert.assertFalse(x.is_6_zero());
        assertEquals(3, x.x_7);
        assertEquals(5, x.y_7);
        Assert.assertFalse(x.is_7_zero());
        assertEquals(3, x.x_8);
        assertEquals(5, x.y_8);
        Assert.assertFalse(x.is_8_zero());
        assertEquals(3, x.x_9);
        assertEquals(5, x.y_9);
        Assert.assertFalse(x.is_9_zero());
        assertEquals(3, x.x_10);
        assertEquals(5, x.y_10);
        Assert.assertFalse(x.is_10_zero());
        assertEquals(0, x.x_11);
        assertEquals(0, x.y_11);
        Assert.assertTrue(x.is_11_zero());
    }
}
