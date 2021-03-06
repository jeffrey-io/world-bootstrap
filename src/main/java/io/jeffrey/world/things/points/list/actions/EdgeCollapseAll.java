package io.jeffrey.world.things.points.list.actions;

import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.IndexRemoval;
import io.jeffrey.world.things.points.list.SegmentSelectMode;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

/**
 * Collapse all selected and connected vertices down to a single vertex by averaging them up
 *
 * @author jeffrey
 */
public class EdgeCollapseAll {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain) {
    final IndexRemoval remover = new IndexRemoval();
    for (final SelectablePoint2[] segments : chain.getSelectedSegments(SegmentSelectMode.SelectedOnly)) {
      for (int j = 1; j < segments.length; j++) {
        segments[0].x += segments[j].x;
        segments[0].y += segments[j].y;
        remover.denote(segments[j].cachedIndex);
      }
      segments[0].x /= segments.length;
      segments[0].y /= segments.length;
    }
    chain.apply(remover);
  }
}
