package io.jeffrey.world.things.points.list.actions;

import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.IndexRemoval;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

/**
 * Collapse vertices by removing selected interior vertices
 *
 * @author jeffrey
 */
public class EdgeCollapseKeepEnds {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain, final boolean asLoop) {
    final IndexRemoval remover = new IndexRemoval();
    for (final SelectablePoint2[] segments : chain.selectedSegments(asLoop)) {
      for (int j = 1; j < segments.length - 1; j++) {
        remover.denote(segments[j].cachedIndex);
      }
    }
    chain.apply(remover);
  }
}
