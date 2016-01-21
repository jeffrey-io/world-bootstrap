package io.jeffrey.world.things.points.list.actions;

import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.IndexRemoval;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

public class DeleteVertices {
  /**
   * @param chain
   *          what to act on
   * @param asLoop
   *          is it a loop
   */
  public static void perform(final SelectablePoint2List chain) {
    final IndexRemoval remover = new IndexRemoval();
    for (final SelectablePoint2 p : chain) {
      if (p.selected) {
        remover.denote(p.cachedIndex);
      }
    }
    chain.apply(remover);
  }
}
