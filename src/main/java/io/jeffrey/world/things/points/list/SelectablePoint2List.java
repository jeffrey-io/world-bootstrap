package io.jeffrey.world.things.points.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasSelectablePoints;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.points.SelectablePoint2;

public class SelectablePoint2List implements Part, HasSelectableEdges, HasSelectablePoints {
  public static enum Property {
    Finite, Looped
  }

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

  public final boolean                      finite;
  public final boolean                      looped;
  private final ArrayList<SelectablePoint2> points;

  /**
   * @param raw
   *          the serialized form of the points
   */
  public SelectablePoint2List(final String raw, final Property... properties) {
    points = parse(raw);
    boolean _looped = false;
    boolean _finite = false;
    for (final Property property : properties) {
      if (property == Property.Looped) {
        _looped = true;
      }
      if (property == Property.Finite) {
        _finite = true;
      }
    }
    looped = _looped;
    finite = _finite;
    index();
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

  @Override
  public int getNumberSelectablePoints() {
    return points.size();
  }

  /**
   * get an iterator over the points as line-point pairs
   *
   * @param asLoop
   *          should we treat the chain as a loop
   * @return an iterator over all the lines where a line is defined as a pair of points
   */
  @Override
  public Iterable<SelectablePoint2[]> getSelectableEdges() {
    return () -> {
      index();
      final ArrayList<SelectablePoint2[]> all = new ArrayList<SelectablePoint2[]>();
      final int n = points.size();
      final int sz = looped ? n : n - 1;
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
   * turn the chain into a list of lines that form the edges
   *
   * @param asLoop
   *          is the chain a polygon?
   * @return an array of all edges (x0,y0,x1,y1,x1,y1,x2,y2,...)
   */
  public double[] getThingSpaceEdges() {
    final int n = points.size() + (looped ? 0 : -1);
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
    return () -> {
      index();
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
