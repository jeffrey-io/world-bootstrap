package io.jeffrey.vector.math;

import io.jeffrey.vector.VectorRegister4;
import io.jeffrey.vector.VectorRegister6;

import org.junit.Assert;
import org.junit.Test;

public class PolygonsTest {

    @Test
    public void testInside() {
        final VectorRegister4 reg = new VectorRegister4();
        final VectorRegister6 temp = new VectorRegister6();
        for (double x = -0.5; x <= 5; x += 0.1) {
            for (double y = -0.5; y <= 5; y += 0.1) {
                for (int k = 0; k < 1000; k++) {
                    reg.set_0(1, 1);
                    reg.set_1(2, 2);
                    reg.set_2(3, 1);
                    final double[] coordinates = new double[] { 1, 1, 2, 2, 3, 1 };
                    reg.set_3(x, y);
                    final boolean expected = Triangles.pointInsideTriangle_Destructively(reg);
                    final boolean actual = Polygons.pointIn(x, y, coordinates, temp);
                    Assert.assertTrue(expected == actual);
                }
            }
        }

    }
}
