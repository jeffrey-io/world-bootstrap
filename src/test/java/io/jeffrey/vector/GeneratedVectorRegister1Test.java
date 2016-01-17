package io.jeffrey.vector;

import org.junit.Assert;
import org.junit.Test;

public class GeneratedVectorRegister1Test extends CommonVectorTestingBase {

    @Test
    public void testANGLES_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0_by_angle(0.5);
        assertEquals(0.8775825618903728, x.x_0);
        assertEquals(0.479425538604203, x.y_0);
        x.set_0_by_angle(1.5);
        assertEquals(0.0707372016677029, x.x_0);
        assertEquals(0.9974949866040544, x.y_0);
        x.set_0_by_angle(2.5);
        assertEquals(-0.8011436155469337, x.x_0);
        assertEquals(0.5984721441039564, x.y_0);
        double u, v;
        for (double theta = 0; theta < 7; theta += 0.1) {
            x.set_0_by_angle(theta);
            final double omega = x.angle_0();
            u = x.x_0;
            v = x.y_0;
            x.set_0_by_angle(omega);
            assertEquals(u, x.x_0);
            assertEquals(v, x.y_0);
        }
    }

    @Test
    public void testCOMPLEX_CONJ_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.conjugate_0();
        assertEquals(3, x.x_0);
        assertEquals(-5, x.y_0);
    }

    @Test
    public void testEXTRACT_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.set_0(-1, -2);
        x.extract_0(data, 0);
        x.extract_0(data, 5);
        x.extract_0(data, 8);
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
    public void testINJECT_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        final double[] data = new double[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        x.inject_0(data, 0);
        assertEquals(0, x.x_0);
        assertEquals(1, x.y_0);
        x.inject_0(data, 6);
        assertEquals(6, x.x_0);
        assertEquals(7, x.y_0);
        x.inject_0(data, 8);
        assertEquals(8, x.x_0);
        assertEquals(9, x.y_0);
    }

    @Test
    public void testIS_ZERO_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        Assert.assertFalse(x.is_0_zero());
        x.set_0(0, 5);
        assertEquals(0, x.x_0);
        assertEquals(5, x.y_0);
        Assert.assertFalse(x.is_0_zero());
        x.set_0(3, 0);
        assertEquals(3, x.x_0);
        assertEquals(0, x.y_0);
        Assert.assertFalse(x.is_0_zero());
        x.set_0(0, 0);
        assertEquals(0, x.x_0);
        assertEquals(0, x.y_0);
        Assert.assertTrue(x.is_0_zero());
    }

    @Test
    public void testPYTHAGOREAN_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0(3, 5);
        assertEquals(Math.sqrt(3 * 3 + 5 * 5), x.length_0());
        Assert.assertTrue(x.normalize_0());
        assertEquals(1, x.length_0());
        assertEquals(3 / Math.sqrt(3 * 3 + 5 * 5), x.x_0);
        assertEquals(5 / Math.sqrt(3 * 3 + 5 * 5), x.y_0);
        x.set_0(0, 0);
        Assert.assertFalse(x.normalize_0());
    }

    @Test
    public void testSET_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
    }

    @Test
    public void testZERO_0() throws Exception {
        final VectorRegister1 x = new VectorRegister1();
        x.set_0(3, 5);
        assertEquals(3, x.x_0);
        assertEquals(5, x.y_0);
        x.zero_out_0();
        assertEquals(0, x.x_0);
        assertEquals(0, x.y_0);
        Assert.assertTrue(x.is_0_zero());
    }
}
