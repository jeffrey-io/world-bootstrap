package io.jeffrey.world.things.polygon.actions;

import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.polygon.IndexRemoval;
import io.jeffrey.world.things.polygon.PointChain;

public class DeleteVertices {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final PointChain chain, final boolean asLoop) {
    final IndexRemoval remover = new IndexRemoval();
    for (final SelectablePoint2 p : chain) {
      if (p.selected) {
        remover.denote(p.cachedIndex);
      }
    }
    chain.apply(remover);
  }
}
