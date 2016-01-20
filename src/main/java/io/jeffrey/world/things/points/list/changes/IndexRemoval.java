package io.jeffrey.world.things.points.list.changes;

import java.util.ArrayList;

import io.jeffrey.world.things.points.SelectablePoint2;

/**
 * Remove a bunch of points from a Point chain easily
 *
 * @author jeffrey
 */
public class IndexRemoval {
  private final ArrayList<Integer> removes = new ArrayList<Integer>();

  /**
   * denote the given index is as good as dead
   *
   * @param index
   *          which index we wish to remove
   */
  public void denote(final int index) {
    if (removes.contains(index)) {
      throw new IllegalArgumentException("We have already marked " + index + " for removal");
    }
    removes.add(index);
  }

  /**
   * remove all denoted indices
   *
   * @param points
   */
  public void removeAll(final ArrayList<SelectablePoint2> points) {
    removes.sort((o1, o2) -> o2 - o1);
    for (final int k : removes) {
      points.remove(k);
    }
    removes.clear();
  }
}
