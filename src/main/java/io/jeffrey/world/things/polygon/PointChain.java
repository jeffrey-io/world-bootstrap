package io.jeffrey.world.things.polygon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.polygon.actions.CleanEdges;
import io.jeffrey.world.things.polygon.actions.ColinearReduction;
import io.jeffrey.world.things.polygon.actions.DeleteVertices;
import io.jeffrey.world.things.polygon.actions.EdgeCollapseAll;
import io.jeffrey.world.things.polygon.actions.EdgeCollapseKeepEnds;
import io.jeffrey.world.things.polygon.actions.EdgeErode;
import io.jeffrey.world.things.polygon.actions.EdgeSplit;
import io.jeffrey.world.things.polygon.actions.FractureSplit;
import io.jeffrey.world.things.polygon.actions.NormalGrowth;
import io.jeffrey.world.things.polygon.actions.SmoothSplit;
import io.jeffrey.world.things.polygon.actions.Springize;
import io.jeffrey.world.things.polygon.actions.UniformEdgeSplit;

public class PointChain implements Iterable<SelectablePoint2> {
  /**
   * convert the list of doubles into a string
   *
   * @param values
   *          the doubles to convert
   * @return a string that is a list of the doubles joined by ','
   */
  public static String pack(final List<Double> values) {
    boolean first = true;
    final StringBuffer pV = new StringBuffer(10 * values.size());
    for (final Double v : values) {
      if (!first) {
        pV.append(",");
      }
      first = false;
      pV.append(v);
    }
    return pV.toString();
  }

  private final ArrayList<SelectablePoint2> points;

  /**
   * @param raw
   *          the serialized form of the points
   */
  public PointChain(final String raw) {
    points = parse(raw);
  }

  /**
   * Perform the given action on the point chain
   *
   * @param action
   *          the action to execute
   * @param asLoop
   *          should the chain be treated as a loop
   * @param document
   *          the owning document
   * @parm thing the things
   * @return true if the cache needs to be updated becauses the points where updated
   */
  public boolean act(final String action, final boolean asLoop, final Document document, final AbstractThing thing) {
    if ("edge.colinear".equals(action)) {
      ColinearReduction.perform(this, asLoop);
      return true;
    }
    if ("color.seek".equals(action)) {
      NormalGrowth.seekColor(thing, document, this, asLoop);
      return true;
    }

    if ("normal.contract".equals(action)) {
      NormalGrowth.contract(this, asLoop);
      return true;
    }
    if ("random.normal.contract".equals(action)) {
      NormalGrowth.contractRandomly(this, asLoop);
      return true;
    }

    if ("normal.growth".equals(action)) {
      NormalGrowth.expand(this, asLoop);
      return true;
    }
    if ("random.normal.growth".equals(action)) {
      NormalGrowth.expandRandomly(this, asLoop);
      return true;
    }
    if ("edge.uniform".equals(action)) {
      UniformEdgeSplit.perform(this, asLoop);
      return true;
    }
    if ("edge.erode".equals(action)) {
      EdgeErode.perform(this, asLoop);
      return true;
    }
    if ("edge.split".equals(action)) {
      EdgeSplit.perform(this, asLoop, false);
      return true;
    }
    if ("edge.fracture".equals(action)) {
      FractureSplit.perform(this, asLoop);
      return true;
    }
    if ("edge.smooth".equals(action)) {
      SmoothSplit.perform(this, asLoop);
      return true;
    }
    if ("edge.split.random".equals(action)) {
      EdgeSplit.perform(this, asLoop, true);
      return true;
    }
    if ("edge.collapse.1".equals(action)) {
      EdgeCollapseKeepEnds.perform(this, asLoop);
      return true;
    }
    if ("edge.collapse.2".equals(action)) {
      EdgeCollapseAll.perform(this, asLoop);
      return true;
    }
    if ("clean.edges".equals(action)) {
      CleanEdges.perform(this, asLoop);
      return true;
    }
    if ("delete.vertices".equals(action)) {
      DeleteVertices.perform(this, asLoop);
      return true;
    }
    if ("springize".equals(action)) {
      Springize.perform(this, asLoop);
      return true;
    }
    return false;
  }

  /**
   * apply the given index removal to the points
   *
   * @param removal
   *          what to remove
   */
  public void apply(final IndexRemoval removal) {
    removal.removeAll(points);
  }

  /**
   * apply the given point addition
   *
   * @param addition
   *          what to add
   */
  public void apply(final PointAddition addition) {
    addition.insert(points);
  }

  /**
   * get a point
   *
   * @param k
   *          the index of the point to get
   * @return a point at the given index
   */
  public SelectablePoint2 at(final int k) {
    return points.get(k);
  }

  /**
   * Based on what is selected, what actions are available
   *
   * @param actions
   *          the actions available
   * @param asLoop
   *          should the chain work as a loop
   */
  public void describePossibleActionsBasedOnSelectedVertices(final List<String> actions, final boolean asLoop) {
    boolean canSplit = false;
    final int n = points.size();
    final int m = asLoop ? n : n - 1;
    boolean canDeleteVertices = false;
    for (int k = 0; k < m && !canSplit; k++) {
      final SelectablePoint2 p1 = points.get(k);
      final SelectablePoint2 p2 = k + 1 < n ? points.get(k + 1) : points.get(0);
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

  /**
   * turn the chain into a list of lines that form the edges
   *
   * @param asLoop
   *          is the chain a polygon?
   * @return an array of all edges (x0,y0,x1,y1,x1,y1,x2,y2,...)
   */
  public double[] edges(final boolean asLoop) {
    final int n = points.size() + (asLoop ? 0 : -1);
    final double[] values = new double[n * 4];
    for (int k = 0; k < n; k++) {
      final SelectablePoint2 a = points.get(k);
      final SelectablePoint2 b = points.get((k + 1) % points.size());
      values[k * 4 + 0] = a.x;
      values[k * 4 + 1] = a.y;
      values[k * 4 + 2] = b.x;
      values[k * 4 + 3] = b.y;
    }
    return values;
  }

  /**
   * Helper: index the points to update the points' cachedIndex
   */
  private void index() {
    int k = 0;
    for (final SelectablePoint2 p : points) {
      p.cachedIndex = k;
      k++;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Iterator<SelectablePoint2> iterator() {
    return points.iterator();
  }

  /**
   * get an iterator over the points as line-point pairs
   *
   * @param asLoop
   *          should we treat the chain as a loop
   * @return an iterator over all the lines where a line is defined as a pair of points
   */
  public Iterable<SelectablePoint2[]> lines(final boolean asLoop) {
    index();
    return () -> {
      final ArrayList<SelectablePoint2[]> all = new ArrayList<SelectablePoint2[]>();
      final int n = points.size();
      final int sz = asLoop ? n : n - 1;
      for (int k = 0; k < sz; k++) {
        final SelectablePoint2 point = points.get(k % points.size());
        point.cachedIndex = k;
        final SelectablePoint2 next = points.get((k + 1) % points.size());
        all.add(new SelectablePoint2[] { point, next });
      }
      return all.iterator();
    };
  }

  /**
   * Helper: convert the given raw points serialize form into an array of points
   */
  private ArrayList<SelectablePoint2> parse(final String rawPoints) {
    final ArrayList<SelectablePoint2> points = new ArrayList<SelectablePoint2>();
    final String[] values = rawPoints.split(",");
    for (int k = 0; k + 1 < values.length; k += 2) {
      final double x = Double.parseDouble(values[k]);
      final double y = Double.parseDouble(values[k + 1]);
      points.add(new SelectablePoint2(x, y));
    }
    return points;
  }

  public Iterable<SelectablePoint2[]> selectedSegments(final boolean asLoop) {
    return selectedSegments(asLoop, false);
  }

  /**
   * Commplex: look at all the selected points and return them as a set of connected segment.
   *
   * @param asLoop
   *          should the chain be treated as a loop
   * @return an iterable over point arrays where each point array is a chain of connected and selected points
   */
  public Iterable<SelectablePoint2[]> selectedSegments(final boolean asLoop, final boolean keepEnds) {
    index();
    return () -> {
      final ArrayList<SelectablePoint2[]> all = new ArrayList<SelectablePoint2[]>();
      final int n = points.size();
      final int sz = asLoop ? n : n - 1;
      int offset = 0;
      if (asLoop) {
        for (int k1 = 0; k1 < n; k1++) {
          if (!points.get(k1).selected) {
            offset = k1;
            break;
          }
        }
      }
      for (int k2 = 0; k2 < sz; k2++) {
        final SelectablePoint2 point = points.get((k2 + offset) % points.size());
        final SelectablePoint2 next = points.get((k2 + offset + 1) % points.size());
        if (point.selected && next.selected) {
          final ArrayList<SelectablePoint2> segment = new ArrayList<SelectablePoint2>();
          if (keepEnds) {
            if (k2 + offset > 0 || asLoop) {
              segment.add(points.get((k2 + offset - 1 + points.size()) % points.size()));
            }
          }
          segment.add(point);
          while (k2 < sz) {
            final SelectablePoint2 middle = points.get((k2 + offset + 1) % points.size());
            if (middle.selected) {
              segment.add(middle);
            } else {
              break;
            }
            k2++;
          }
          if (keepEnds) {
            if (k2 < sz || asLoop) {
              segment.add(points.get((k2 + offset + 1) % points.size()));
            }
          }

          all.add(segment.toArray(new SelectablePoint2[segment.size()]));
        }
      }
      return all.iterator();
    };
  }

  /**
   * set the value of the chain via text
   *
   * @param txt
   *          the serialized form of the coordinates for the points
   */
  public void set(final String txt) {
    final ArrayList<SelectablePoint2> pnts = parse(txt);
    points.clear();
    points.addAll(pnts);
  }

  /**
   * @return how many points are in the chain
   */
  public int size() {
    return points.size();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    final ArrayList<Double> values = new ArrayList<Double>();
    for (final SelectablePoint2 p : points) {
      values.add(p.x);
      values.add(p.y);
    }
    return pack(values);
  }
}
