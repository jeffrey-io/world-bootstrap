package io.jeffrey.world.things.polygon;

import io.jeffrey.world.things.polygon.actions.FractureSplit;
import io.jeffrey.world.things.polygon.actions.ColinearReduction;
import io.jeffrey.world.things.polygon.actions.EdgeCollapseAll;
import io.jeffrey.world.things.polygon.actions.EdgeCollapseKeepEnds;
import io.jeffrey.world.things.polygon.actions.EdgeSplit;
import io.jeffrey.world.things.polygon.actions.SmoothSplit;
import io.jeffrey.world.things.polygon.actions.UniformEdgeSplit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PointChain implements Iterable<SelectablePoint2> {
    /**
     * convert the list of doubles into a string
     *
     * @param values
     *            the doubles to convert
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
     *            the serialized form of the points
     */
    public PointChain(final String raw) {
        points = parse(raw);
    }

    /**
     * apply the given index removal to the points
     * 
     * @param removal
     *            what to remove
     */
    public void apply(IndexRemoval removal) {
        removal.removeAll(points);
    }

    /**
     * apply the given point addition
     * 
     * @param addition
     *            what to add
     */
    public void apply(PointAddition addition) {
        addition.insert(points);
    }

    /**
     * Perform the given action on the point chain
     *
     * @param action
     *            the action to execute
     * @param asLoop
     *            should the chain be treated as a loop
     * @return true if the cache needs to be updated becauses the points where updated
     */
    public boolean act(final String action, final boolean asLoop) {
        if ("edge.colinear".equals(action)) {
            ColinearReduction.perform(this, asLoop);
            return true;
        }
        if ("edge.uniform".equals(action)) {
            UniformEdgeSplit.perform(this, asLoop);
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
        return false;
    }

    /**
     * get a point
     *
     * @param k
     *            the index of the point to get
     * @return a point at the given index
     */
    public SelectablePoint2 at(final int k) {
        return points.get(k);
    }

    /**
     * Based on what is selected, what actions are available
     *
     * @param actions
     *            the actions available
     * @param asLoop
     *            should the chain work as a loop
     */
    public void describePossibleActionsBasedOnSelectedVertices(final List<String> actions, final boolean asLoop) {
        boolean canSplit = false;
        final int n = points.size();
        final int m = asLoop ? n : n - 1;
        for (int k = 0; k < m && !canSplit; k++) {
            final SelectablePoint2 p1 = points.get(k);
            final SelectablePoint2 p2 = k + 1 < n ? points.get(k + 1) : points.get(0);
            if (p1.selected && p2.selected) {
                canSplit = true;
            }
        }
        if (canSplit) {
            actions.add("edge.split");
            actions.add("edge.split.random");
            actions.add("edge.collapse.1");
            actions.add("edge.collapse.2");
            actions.add("edge.fracture");
            actions.add("edge.smooth");
            actions.add("edge.uniform");
            actions.add("edge.colinear");
        }
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
     *            should we treat the chain as a loop
     * @return an iterator over all the lines where a line is defined as a pair of points
     */
    public Iterable<SelectablePoint2[]> lines(final boolean asLoop) {
        index();
        return new Iterable<SelectablePoint2[]>() {
            @Override
            public Iterator<SelectablePoint2[]> iterator() {
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
            }
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

    /**
     * Commplex: look at all the selected points and return them as a set of connected segment.
     *
     * @param asLoop
     *            should the chain be treated as a loop
     * @return an iterable over point arrays where each point array is a chain of connected and selected points
     */
    public Iterable<SelectablePoint2[]> selectedSegments(final boolean asLoop) {
        index();
        return new Iterable<SelectablePoint2[]>() {
            @Override
            public Iterator<SelectablePoint2[]> iterator() {
                final ArrayList<SelectablePoint2[]> all = new ArrayList<SelectablePoint2[]>();
                final int n = points.size();
                final int sz = asLoop ? n : n - 1;
                int offset = 0;
                if (asLoop) {
                    for (int k = 0; k < n; k++) {
                        if (!points.get(k).selected) {
                            offset = k;
                            break;
                        }
                    }
                }
                for (int k = 0; k < sz; k++) {
                    final SelectablePoint2 point = points.get((k + offset) % points.size());
                    final SelectablePoint2 next = points.get((k + offset + 1) % points.size());
                    if (point.selected && next.selected) {
                        final ArrayList<SelectablePoint2> segment = new ArrayList<SelectablePoint2>();
                        segment.add(point);
                        while (k < sz) {
                            final SelectablePoint2 middle = points.get((k + offset + 1) % points.size());
                            if (middle.selected) {
                                segment.add(middle);
                            } else {
                                break;
                            }
                            k++;
                        }
                        all.add(segment.toArray(new SelectablePoint2[segment.size()]));
                    }
                }
                return all.iterator();
            }
        };
    }

    /**
     * set the value of the chain via text
     *
     * @param txt
     *            the serialized form of the coordinates for the points
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
