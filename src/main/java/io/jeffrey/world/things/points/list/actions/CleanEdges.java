package io.jeffrey.world.things.points.list.actions;

import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.PointAddition;
import io.jeffrey.world.things.points.list.SegmentSelectMode;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

public class CleanEdges {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain) {
    final VectorRegister6 reg = new VectorRegister6();

    final PointAddition adder = new PointAddition();
    for (final SelectablePoint2[] segment : chain.getSelectedSegments(SegmentSelectMode.SelectedOnly)) {
      for (int j = 0; j + 1 < segment.length; j++) {

        for (final SelectablePoint2[] line : chain.getSelectableEdges()) {

          // self
          if (line[0].cachedIndex == segment[j].cachedIndex) {
            continue;
          }

          // prior
          if (line[1].cachedIndex == segment[j].cachedIndex) {
            continue;
          }

          // next
          if (line[0].cachedIndex == segment[j + 1].cachedIndex) {
            continue;
          }

          reg.set_0(segment[j].x, segment[j].y);
          reg.set_1(segment[j + 1].x, segment[j + 1].y);
          reg.set_2(line[0].x, line[0].y);
          reg.set_3(line[1].x, line[1].y);
          if (Lines.doLinesIntersect_Destructively(reg, true, true)) {
            segment[j + 1].x = (reg.x_0 + segment[j].x) / 2.0;
            segment[j + 1].y = (reg.y_0 + segment[j].y) / 2.0;

          }

        }
      }
    }
    chain.apply(adder);
  }
}
