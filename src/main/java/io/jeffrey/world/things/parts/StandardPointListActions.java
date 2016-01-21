package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import io.jeffrey.world.things.points.list.actions.CleanEdges;
import io.jeffrey.world.things.points.list.actions.ColinearReduction;
import io.jeffrey.world.things.points.list.actions.DeleteVertices;
import io.jeffrey.world.things.points.list.actions.EdgeCollapseAll;
import io.jeffrey.world.things.points.list.actions.EdgeCollapseKeepEnds;
import io.jeffrey.world.things.points.list.actions.EdgeErode;
import io.jeffrey.world.things.points.list.actions.EdgeSplit;
import io.jeffrey.world.things.points.list.actions.FractureSplit;
import io.jeffrey.world.things.points.list.actions.NormalGrowth;
import io.jeffrey.world.things.points.list.actions.SmoothSplit;
import io.jeffrey.world.things.points.list.actions.Springize;
import io.jeffrey.world.things.points.list.actions.UniformEdgeSplit;

public class StandardPointListActions implements Part, HasActions {

  private final SelectablePoint2List list;

  public StandardPointListActions(final SelectablePoint2List list) {
    this.list = list;
  }

  /**
   * Perform the given action on the point chain
   *
   * @param action
   *          the action to execute
   * @param looped
   *          should the chain be treated as a loop
   * @param document
   *          the owning document
   * @param thing
   *          the things
   * @return true if the cache needs to be updated becauses the points where updated
   */
  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    final boolean looped = list.looped;
    if ("edge.colinear".equals(action)) {
      ColinearReduction.perform(list, looped);
    } else if ("color.seek".equals(action)) {
      // NormalGrowth.seekColor(thing, document, this, looped);
    } else if ("normal.contract".equals(action)) {
      NormalGrowth.contract(list, looped);
    } else if ("random.normal.contract".equals(action)) {
      NormalGrowth.contractRandomly(list, looped);
    } else if ("normal.growth".equals(action)) {
      NormalGrowth.expand(list, looped);
    } else if ("random.normal.growth".equals(action)) {
      NormalGrowth.expandRandomly(list, looped);
    } else if ("edge.uniform".equals(action)) {
      UniformEdgeSplit.perform(list, looped);
    } else if ("edge.erode".equals(action)) {
      EdgeErode.perform(list, looped);
    } else if ("edge.split".equals(action)) {
      EdgeSplit.perform(list, looped, false);
    } else if ("edge.fracture".equals(action)) {
      FractureSplit.perform(list, looped);
    } else if ("edge.smooth".equals(action)) {
      SmoothSplit.perform(list, looped);
    } else if ("edge.split.random".equals(action)) {
      EdgeSplit.perform(list, looped, true);
    } else if ("edge.collapse.1".equals(action)) {
      EdgeCollapseKeepEnds.perform(list, looped);
    } else if ("edge.collapse.2".equals(action)) {
      EdgeCollapseAll.perform(list, looped);
    } else if ("clean.edges".equals(action)) {
      CleanEdges.perform(list, looped);
    } else if ("delete.vertices".equals(action)) {
      DeleteVertices.perform(list, looped);
    } else if ("springize".equals(action)) {
      Springize.perform(list, looped);
    }
  }

  /**
   * Based on what is selected, what actions are available
   *
   * @param actions
   *          the actions available
   * @param asLoop
   *          should the chain work as a loop
   */

  @Override
  public void listActions(final Set<String> actions) {
    if (list.finite) {
      return;
    }
    boolean canSplit = false;
    final int n = list.size();
    final int m = list.looped ? n : n - 1;
    boolean canDeleteVertices = false;
    for (int k = 0; k < m && !canSplit; k++) {
      final SelectablePoint2 p1 = list.at(k);
      final SelectablePoint2 p2 = k + 1 < n ? list.at(k + 1) : list.at(0);
      if (p1.selected || p2.selected) {
        canDeleteVertices = true;
      }
      if (p1.selected && p2.selected) {
        canSplit = true;
      }
    }
    if (canSplit) {
      actions.add("edge.split");
      actions.add("edge.split.random");
      actions.add("edge.erode");
      actions.add("edge.collapse.1");
      actions.add("edge.collapse.2");
      actions.add("edge.fracture");
      actions.add("edge.smooth");
      actions.add("edge.uniform");
      actions.add("edge.colinear");
      actions.add("color.seek");
      actions.add("clean.edges");
      actions.add("normal.growth");
      actions.add("random.normal.growth");
      actions.add("normal.contract");
      actions.add("random.normal.contract");
      actions.add("springize");
    }
    if (canDeleteVertices) {
      actions.add("delete.vertices");
    }
  }

}
