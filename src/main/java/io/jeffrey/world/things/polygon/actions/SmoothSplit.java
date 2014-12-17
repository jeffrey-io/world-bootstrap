package io.jeffrey.world.things.polygon.actions;

import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.polygon.PointAddition;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

/**
 * This will attempt to smooth the polygon
 *
 * @author jeffrey
 *
 */
public class SmoothSplit {
    /**
     * @param chain
     *            what to act on
     * @param asLoop
     *            is it a loop
     */
    public static void perform(final PointChain chain, final boolean asLoop) {
        final VectorRegister8 temp = new VectorRegister8();
        final PointAddition adder = new PointAddition();
        for (final SelectablePoint2[] segment : chain.selectedSegments(asLoop)) {
            for (int j = 1; j < segment.length - 2; j++) {
                final SelectablePoint2 p1 = segment[j - 1];
                final SelectablePoint2 p2 = segment[j + 0];
                final SelectablePoint2 p3 = segment[j + 1];
                final SelectablePoint2 p4 = segment[j + 2];
                temp.set_0(p1.x, p1.y);
                temp.set_1(p2.x, p2.y);
                temp.set_2(p3.x, p3.y);
                temp.set_3(p4.x, p4.y);
                if (Lines.doLinesIntersect_Destructively(temp, false, false)) {
                    temp.set_1((p2.x + p3.x) / 2.0, (p2.y + p3.y) / 2.0);
                    temp.add_1_to_0();
                    temp.div_0_by(2);
                    temp.add_1_to_0();
                    temp.div_0_by(2);
                    final SelectablePoint2 newPoint = new SelectablePoint2(temp.x_0, temp.y_0);
                    newPoint.cachedIndex = p2.cachedIndex + 1;
                    newPoint.selected = true;
                    adder.denote(newPoint);
                }
            }
        }
        chain.apply(adder);
    }
}
