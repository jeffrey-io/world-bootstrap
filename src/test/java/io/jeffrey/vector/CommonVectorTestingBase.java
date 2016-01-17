package io.jeffrey.vector;

import org.junit.Assert;

public class CommonVectorTestingBase {
    protected static void assertEquals(final double x, final double y) {
        assertZero(x - y);
    }

    protected static void assertZero(final double x) {
        Assert.assertTrue(Math.abs(x) < 1E-10);
    }
}
