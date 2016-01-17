package io.jeffrey.vector.math;

import io.jeffrey.vector.VectorRegister4;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class TrianglesTest {

    @Test
    public void testInside() {
        final VectorRegister4 reg = new VectorRegister4();
        final Random rng = new Random();
        for (int k = 0; k < 10000; k++) {
            reg.set_0(1, 1);
            reg.set_1(2, 2);
            reg.set_2(3, 1);
            final double a = rng.nextDouble();
            final double b = rng.nextDouble() * (1 - a);
            reg.set_3(1 + a * 1 + 2 * b, 1 + a);
            final boolean result = Triangles.pointInsideTriangle_Destructively(reg);
            Assert.assertTrue(result);
        }
        int m = 1;
        for (int k = 0; k < 10000; k++) {
            m *= -1;
            reg.set_0(1, 1);
            reg.set_1(2, 2);
            reg.set_2(3, 1);
            final double a = rng.nextDouble();
            final double b = rng.nextDouble() * (1 - a);
            reg.set_3(3 * m + a * 1 + 2 * b, 3 * m + a);
            final boolean result = Triangles.pointInsideTriangle_Destructively(reg);
            Assert.assertFalse(result);
        }
    }
}
