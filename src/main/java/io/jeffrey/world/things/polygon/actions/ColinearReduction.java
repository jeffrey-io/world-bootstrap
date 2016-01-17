package io.jeffrey.world.things.polygon.actions;

import io.jeffrey.world.things.polygon.IndexRemoval;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

/**
 * Algorithm to remove vertices that are not needed
 *
 * @author jeffrey
 */
public class ColinearReduction {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final PointChain chain, final boolean asLoop) {
    final IndexRemoval remover = new IndexRemoval();
    for (final SelectablePoint2[] segment : chain.selectedSegments(asLoop)) {
      for (int k = 1; k < segment.length - 1; k++) {
        double dx0 = segment[k].x - segment[k - 1].x;
        double dy0 = segment[k].y - segment[k - 1].y;
        double dx1 = segment[k + 1].x - segment[k - 1].x;
        double dy1 = segment[k + 1].y - segment[k - 1].y;
        final double len0 = Math.sqrt(dx0 * dx0 + dy0 * dy0);
        final double len1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);
        dx0 /= len0;
        dy0 /= len0;
        dx1 /= len1;
        dy1 /= len1;
        final double dp = dx0 * dx1 + dy0 * dy1;
        if (Math.abs(dp - 1) < 1E-8) {
          remover.denote(segment[k].cachedIndex);
        }
      }
    }
    chain.apply(remover);
  }
}
