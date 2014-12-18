package io.jeffrey.world.things.polygon.actions;

import io.jeffrey.world.things.polygon.PointAddition;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

import java.util.Random;

/**
 * Split an edge in two
 *
 * @author jeffrey
 *
 */
public class EdgeSplit {
    /**
     * @param chain
     *            what to act on
     * @param asLoop
     *            is it a loop
     */
    public static void perform(final PointChain chain, final boolean asLoop, final boolean randomly) {
        final Random rng = new Random();
        final PointAddition adder = new PointAddition();
        for (final SelectablePoint2[] segment : chain.selectedSegments(asLoop)) {
            for (int j = 0; j < segment.length - 1; j++) {
                double factorB = 0.5;
                if (randomly) {
                    factorB = rng.nextDouble();
                }
                final double nfactor = 1.0 - factorB;
                final SelectablePoint2 p1 = segment[j];
                final SelectablePoint2 p2 = segment[j + 1];
                final SelectablePoint2 newPoint = new SelectablePoint2(p1.x * factorB + p2.x * nfactor, p1.y * factorB + p2.y * nfactor);
                newPoint.cachedIndex = p1.cachedIndex + 1;
                newPoint.selected = true;
                adder.denote(newPoint);
            }
        }
        chain.apply(adder);
    }
}