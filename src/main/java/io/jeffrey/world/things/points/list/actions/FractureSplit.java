package io.jeffrey.world.things.points.list.actions;

import java.util.Random;

import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import io.jeffrey.world.things.points.list.changes.PointAddition;

/**
 * Introduce a bit of randomness
 *
 * @author jeffrey
 */
public class FractureSplit {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain, final boolean asLoop) {
    final Random rng = new Random();
    final VectorRegister8 reg = new VectorRegister8();
    reg.set_5(0, -1);

    final PointAddition adder = new PointAddition();
    for (final SelectablePoint2[] segment : chain.selectedSegments(asLoop)) {
      for (int j = 0; j < segment.length - 1; j++) {
        final SelectablePoint2 p1 = segment[j];
        final SelectablePoint2 p2 = segment[j + 1];

        reg.zero_out_7();
        reg.set_0(p1.x, p1.y);
        reg.set_1(p2.x, p2.y);

        // bisect
        reg.add_0_to_7();
        reg.add_1_to_7();
        reg.div_7_by(2.0);

        // find normal
        reg.copy_from_1_to_6();
        reg.sub_0_from_6();

        final double l = reg.length_6() / Math.sqrt(13) * (rng.nextDouble() - 0.5);
        ;

        reg.normalize_6();
        reg.complex_mult_5_6();
        reg.mult_6_by(l);
        reg.add_6_to_7();

        final SelectablePoint2 newPoint = new SelectablePoint2(reg.x_7, reg.y_7);
        newPoint.cachedIndex = p1.cachedIndex + 1;
        newPoint.selected = true;
        adder.denote(newPoint);
      }
    }
    chain.apply(adder);
  }
}
