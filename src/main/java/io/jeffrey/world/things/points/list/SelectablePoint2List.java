package io.jeffrey.world.things.points.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasSelectablePoints;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.points.SelectablePoint2;

public class SelectablePoint2List implements Part, HasSelectableEdges, HasSelectablePoints {
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

  private final EditString                  link;
  public final boolean                      looped;

  private final ArrayList<SelectablePoint2> points;
  private boolean                           upstreamChange;

  /**
   * @param raw
   *          the serialized form of the points
   */
  public SelectablePoint2List(final EditString link, final Property... properties) {
    this.link = link;
    points = parse(link.value());
    link.subscribe((t, u) -> {
      if (upstreamChange) {
        return;
      }
      points.clear();
      points.addAll(parse(u));
    });
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
    if (finite) {
      throw new IllegalArgumentException("list is finite in size");
    }
    removal.removeAll(points);
  }

  /**
   * apply the given point addition
   *
   * @param addition
   *          what to add
   */
  public void apply(final PointAddition addition) {
    if (finite) {
      throw new IllegalArgumentException("list is finite in size");
    }
    addition.insert(points);
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
   * Commplex: look at all the selected points and return them as a set of connected segment.
   *
   */
  public Iterable<SelectablePoint2[]> getSelectedSegments(final SegmentSelectMode mode) {
    final boolean keepEnds = mode == SegmentSelectMode.SelectedAndBoundary;
    return () -> {
      index();
      final ArrayList<SelectablePoint2[]> all = new ArrayList<SelectablePoint2[]>();
      final int n = points.size();
      final int sz = looped ? n : n - 1;
      int offset = 0;
      if (looped) {
        int k1 = 0;
        boolean found = false;
        for (final SelectablePoint2 p : points) {
          if (!p.selected) {
            offset = k1;
            found = true;
            break;
          }
          k1++;
        }
        if (!found) {
          // THIS API is TOTALLY BUSTED
          final SelectablePoint2[] entire = new SelectablePoint2[points.size() + 2];
          int at = 0;
          entire[at] = points.get(points.size() - 1);
          at++;
          for (final SelectablePoint2 p : points) {
            entire[at] = p;
            at++;
          }
          entire[at] = points.get(0);
          at++;
          all.add(entire);
          return all.iterator();
        }
      }
      int k2 = 0;
      while (k2 < sz) {
        final SelectablePoint2 point = points.get((k2 + offset) % points.size());
        final SelectablePoint2 next = points.get((k2 + offset + 1) % points.size());
        if (point.selected && next.selected) {
          final ArrayList<SelectablePoint2> segment = new ArrayList<SelectablePoint2>();
          if (keepEnds) {
            boolean includeStart = k2 + offset > 0;
            if (looped) {
              includeStart = true;
            }
            if (includeStart) {
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
            boolean includeEnd = k2 < sz;
            if (looped) {
              includeEnd = true;
            }
            if (includeEnd) {
              segment.add(points.get((k2 + offset + 1) % points.size()));
            }
          }

          all.add(segment.toArray(new SelectablePoint2[segment.size()]));
        }
        k2++;
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

  @Override
  public void informPointsChanged() {
    upstreamChange = true;
    link.value(toString());
    upstreamChange = false;
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
