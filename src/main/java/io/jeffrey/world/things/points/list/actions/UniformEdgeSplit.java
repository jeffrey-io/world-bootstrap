package io.jeffrey.world.things.points.list.actions;

import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.PointAddition;
import io.jeffrey.world.things.points.list.SegmentSelectMode;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

public class UniformEdgeSplit {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain) {
    double distance = 0;
    int c = 0;
    for (final SelectablePoint2[] segment : chain.getSelectedSegments(SegmentSelectMode.SelectedOnly)) {
      for (int k = 0; k < segment.length - 1; k++) {
        final double dx = segment[k + 1].x - segment[k].x;
        final double dy = segment[k + 1].y - segment[k].y;
        distance += Math.sqrt(dx * dx + dy * dy);
        c++;
      }
    }
    if (c > 0) {
      distance /= c;
      final PointAddition adder = new PointAddition();
      for (final SelectablePoint2[] segment : chain.getSelectedSegments(SegmentSelectMode.SelectedOnly)) {
        for (int j = 0; j < segment.length - 1; j++) {
          final SelectablePoint2 p1 = segment[j];
          final SelectablePoint2 p2 = segment[j + 1];
          final double dx = p2.x - p1.x;
          final double dy = p2.y - p1.y;
          final double local = Math.sqrt(dx * dx + dy * dy);
          if (local > distance) {
            final SelectablePoint2 newPoint = new SelectablePoint2((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
            newPoint.cachedIndex = p1.cachedIndex + 1;
            newPoint.selected = true;
            adder.denote(newPoint);
          }
        }
        c++;
      }
      chain.apply(adder);
    }
  }
}
