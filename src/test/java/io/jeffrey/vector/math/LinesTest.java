package io.jeffrey.vector.math;

import io.jeffrey.vector.CommonVectorTestingBase;
import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;

import org.junit.Assert;
import org.junit.Test;

public class LinesTest extends CommonVectorTestingBase {

    @Test
    public void testColinearDegenerative() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(5, 5);
        reg.set_1(10, 10);
        reg.set_2(5, 5);
        Assert.assertFalse(Lines.colinear_Destructive(reg, false));
        Assert.assertTrue(Lines.colinear_Destructive(reg, true));

        reg.set_0(5, 5);
        reg.set_1(5, 5);
        reg.set_2(10, 10);
        Assert.assertFalse(Lines.colinear_Destructive(reg, false));
        Assert.assertTrue(Lines.colinear_Destructive(reg, true));
    }

    @Test
    public void testColinearNo() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(5, 5);
        reg.set_1(10, 10);
        reg.set_2(10, 15);
        Assert.assertFalse(Lines.colinear_Destructive(reg, false));
    }

    @Test
    public void testColinearYes() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(5, 5);
        reg.set_1(10, 10);
        reg.set_2(15, 15);
        Assert.assertTrue(Lines.colinear_Destructive(reg, false));
    }

    @Test
    public void testCoverage() {
        new Lines();
    }

    @Test
    public void testEndCap() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(5, 20);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(Math.sqrt(10 * 10 + 5 * 5), distance);
        assertEquals(0, reg.x_0);
        assertEquals(10, reg.y_0);
    }

    @Test
    public void testIntersectionOfLines() {
        final VectorRegister6 reg = new VectorRegister6();
        reg.set_0(0, 0);
        reg.set_1(1, 1);
        reg.set_2(1, 0);
        reg.set_3(0, 1);
        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, true, true));
        assertEquals(0.5, reg.x_0);
        assertEquals(0.5, reg.y_0);
        reg.set_0(0, 0);
        reg.set_1(1, 1.2);
        reg.set_2(1 + 0.2, 0.2);
        reg.set_3(0.2, 1);
        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, true, true));
        assertEquals(0.58, reg.x_0);
        assertEquals(0.696, reg.y_0);

        reg.set_0(0, 0);
        reg.set_1(1, 1.2);
        reg.set_2(0.6, 0.8);
        reg.set_3(0.2, 1);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, true, true));

        reg.set_0(0, 0);
        reg.set_1(1, 1.2);
        reg.set_2(0.6, 0.8);
        reg.set_3(0.2, 1);

        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, false, false));
        assertEquals(0.6470588235294118, reg.x_0);
        assertEquals(0.7764705882352941, reg.y_0);
        reg.set_0(5, 0);
        reg.set_1(6, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, false, false));
        assertEquals(0.0, reg.x_0);
        assertEquals(0.0, reg.y_0);
        reg.set_0(5, 0);
        reg.set_1(6, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, true, true));

        reg.set_0(-1, 0);
        reg.set_1(1, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, false, false));
        assertEquals(0.0, reg.x_0);
        assertEquals(0.0, reg.y_0);
        reg.set_0(-1, 0);
        reg.set_1(1, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertTrue(Lines.doLinesIntersect_Destructively(reg, true, false));
        assertEquals(0.0, reg.x_0);
        assertEquals(0.0, reg.y_0);
        reg.set_0(-1, 0);
        reg.set_1(1, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, false, true));
        assertEquals(0.0, reg.x_0);
        assertEquals(0.0, reg.y_0);
        reg.set_0(-1, 0);
        reg.set_1(1, 0);
        reg.set_2(0, 5);
        reg.set_3(0, 6);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, true, true));
    }

    @Test
    public void testNoEndCapLine() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(5, 20);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(Math.sqrt(5 * 5), distance);
        assertEquals(0, reg.x_0);
        assertEquals(20, reg.y_0);
    }

    @Test
    public void testNoStartCapLine() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(-5, -10);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(Math.sqrt(5 * 5), distance);
        assertEquals(0, reg.x_0);
        assertEquals(-10, reg.y_0);
    }

    @Test
    public void testParallel() {
        final VectorRegister6 reg = new VectorRegister6();
        reg.set_0(0, 0);
        reg.set_1(1, 1);
        reg.set_2(0 + 2, 0 + 2);
        reg.set_3(1 + 2, 1 + 2);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, true, true));
        reg.set_0(0, 0);
        reg.set_1(1, 1);
        reg.set_2(0 + 2, 0 + 2);
        reg.set_3(1 + 2, 1 + 2);
        Assert.assertFalse(Lines.doLinesIntersect_Destructively(reg, false, false));
    }

    @Test
    public void testScenario1Line() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(5, 5);
        reg.set_1(10, 10);
        reg.set_2(7.5 + 2, 7.5 - 2);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(Math.sqrt(2 * 2 + 2 * 2), distance);
        assertEquals(7.5, reg.x_0);
        assertEquals(7.5, reg.y_0);
    }

    @Test
    public void testScenario1Segment() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(5, 5);
        reg.set_1(10, 10);
        reg.set_2(7.5 + 2, 7.5 - 2);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(Math.sqrt(2 * 2 + 2 * 2), distance);
        assertEquals(7.5, reg.x_0);
        assertEquals(7.5, reg.y_0);
    }

    @Test
    public void testScenario2Line() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(10, 0);
        reg.set_2(5, 4);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(4, distance);
        assertEquals(5, reg.x_0);
        assertEquals(0, reg.y_0);
    }

    @Test
    public void testScenario2Segment() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(10, 0);
        reg.set_2(5, 4);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(4, distance);
        assertEquals(5, reg.x_0);
        assertEquals(0, reg.y_0);
    }

    @Test
    public void testScenario3Line() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(4, 5);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(4, distance);
        assertEquals(0, reg.x_0);
        assertEquals(5, reg.y_0);
    }

    @Test
    public void testScenario3Segment() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(4, 5);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(4, distance);
        assertEquals(0, reg.x_0);
        assertEquals(5, reg.y_0);
    }

    @Test
    public void testStartCap() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 10);
        reg.set_2(-5, -10);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(Math.sqrt(10 * 10 + 5 * 5), distance);
        assertEquals(0, reg.x_0);
        assertEquals(0, reg.y_0);
    }

    @Test
    public void testUnableToComplyLine() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 0);
        reg.set_2(-5, -10);

        final double distance = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        assertEquals(-1, distance);
    }

    @Test
    public void testUnableToComplySegment() {
        final VectorRegister3 reg = new VectorRegister3();
        reg.set_0(0, 0);
        reg.set_1(0, 0);
        reg.set_2(-5, -10);

        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        assertEquals(-1, distance);
    }
}
