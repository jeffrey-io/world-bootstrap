package io.jeffrey.world.things.polygon;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister5;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.AbstractEditList;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditBoolean;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Defines common operations on things that behave like polygons/lines/graph connects. That is, things that have a bunch of vertices connected on some kind of chain/loop
 *
 * @author jeffrey
 *
 */
public abstract class AbstractPointChain extends AbstractPointChainContract implements Syncable {

  /**
   * Defines how to render and interpret the points. This is lazily updated
   *
   * @author jeffrey
   */
  public class VertexCache {
    public double          boundingRadiusForControls;
    public ControlDoodad[] doodads;
    public double[]        inlineXYPairs;
    private boolean        myvlock = false;
    public double[]        x;
    public double[]        y;

    public VertexCache() {
      inlineXYPairs = new double[0];
      x = new double[0];
      y = new double[0];
      doodads = new ControlDoodad[0];
    }

    /**
     * normalize the scale
     */
    private void apply_scale() {
      final double mx = sx();
      final double my = sy();
      sx(1.0);
      sy(1.0);
      if (inlineXYPairs.length == 0) {
        return;
      }
      for (final SelectablePoint2 p : chain) {
        p.x *= mx;
        p.y *= my;
      }
      update();
    }

    /**
     * center all the points around the senter
     */
    private void center() {
      if (inlineXYPairs.length == 0) {
        return;
      }
      double cx = 0;
      double cy = 0;
      final int n = chain.size();
      for (int k = 0; k < n; k++) {
        final SelectablePoint2 p = chain.at(k);
        cx += p.x;
        cy += p.y;
      }
      cx /= n;
      cy /= n;
      for (int k = 0; k < n; k++) {
        final SelectablePoint2 p = chain.at(k);
        p.x -= cx;
        p.y -= cy;
      }
      // TODO: figure out the math about how to translate the parent object
      update();
    }

    /**
     * @return if the cache needs to be manually updated
     */
    private boolean needsUpdate() {
      return myvlock != vlock.value();
    }

    /**
     * update the cache by pulling data from the chain
     */
    public void update() {
      final int n = chain.size();
      final int doff = vlock.value() ? 0 : n;
      final int nOps = hasStandardControls() ? 8 : 0;
      final int ds = doff + nOps;
      myvlock = vlock.value();
      int k;
      if (x.length != n) {
        inlineXYPairs = new double[n * 2];
        x = new double[n];
        y = new double[n];
      }
      if (doodads.length != ds) {
        doodads = new ControlDoodad[ds];
        for (k = 0; k < doodads.length; k++) {
          doodads[k] = new ControlDoodad(Type.PointUnselected, 0, 0);
        }
      }
      if (n == 0) {
        return;
      }
      boundingRadiusForControls = 0;
      for (k = 0; k < n; k++) {
        final SelectablePoint2 p = chain.at(k);
        inlineXYPairs[2 * k] = p.x;
        inlineXYPairs[2 * k + 1] = p.y;
        x[k] = p.x;
        y[k] = p.y;
        boundingRadiusForControls = Math.max(boundingRadiusForControls, p.x * p.x + p.y * p.y);
        if (!myvlock) {
          doodads[k].u = p.x;
          doodads[k].v = p.y;
          doodads[k].type = p.selected ? Type.PointSelected : Type.PointUnselected;
        }
      }
      if (hasStandardControls()) {
        final double aug = 32 / (sx() + sy());

        boundingRadiusForControls = Math.sqrt(boundingRadiusForControls) + aug;

        for (k = 0; k < 4; k++) {
          doodads[doff + k].type = Type.Scale;
        }
        for (k = 4; k < 8; k++) {
          doodads[doff + k].type = Type.Rotate;
        }

        final double PI = 3.1415926535897932384626433832795;
        final double[] ANGLES = new double[] { PI / 4, 3 * PI / 4, -PI / 4, -3 * PI / 4, 0, PI / 2, PI, -PI / 2 };
        for (k = 0; k < 8; k++) {
          doodads[doff + k].u = Math.cos(ANGLES[k]) * boundingRadiusForControls;
          doodads[doff + k].v = Math.sin(ANGLES[k]) * boundingRadiusForControls;
        }
      }
      onCacheUpdated();
    }
  }

  protected final VertexCache    cache;
  protected final PointChain     chain;
  private final AbstractEditList pointsEditList;
  private final EditBoolean      vlock;

  /**
   * @param document
   *          the document
   * @param node
   *          where the thing's data iss
   */
  protected AbstractPointChain(final Document document, final ThingData node) {
    super(document, node);
    pointsEditList = new AbstractEditList("points") {

      @Override
      public String getAsText() {
        return chain.toString();
      }

      @Override
      protected boolean setByText(final String txt) {
        try {
          chain.set(txt);
          return true;
        } catch (final Exception failure) {
          document.notifications.println(failure, "unable to set the points list");
          return false;
        }
      }

    };
    cache = new VertexCache();
    vlock = node.getBoolean("vlock", false);
    chain = new PointChain(node.getString("points", "0,-1,1,1,-1,1").value());
    cache.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void cacheSelection() {
    for (final SelectablePoint2 point : chain) {
      point.alreadySelected = point.selected;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void clearSelection() {
    for (final SelectablePoint2 point : chain) {
      point.selected = false;
    }
    cache.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void describePossibleActions(final List<String> actions) {
    if (areTheNumberOfPointsFixed()) {
      return;
    }
    actions.add("apply.scale");
    actions.add("self.center");
    chain.describePossibleActionsBasedOnSelectedVertices(actions, isPolygonLooped());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPointApplyToSelection(final AdjustedMouseEvent event) {
    final VectorRegister3 W = new VectorRegister3();
    if (document != null) {
      for (final SelectablePoint2 point : chain) {
        if (point.selected) {
          W.set_0(point.x, point.y);
          writeToWorld(W);
          if (event.doodadDistance(W.x_1, W.y_1) <= document.controlPointSize) {
            return true;
          }
        }
      }
    }
    return doesPointApplyMaintainSelection(document, event);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void draw(final GraphicsContext gc) {
    if (cache.needsUpdate()) {
      cache.update();
    }
    renderPolygon(document, gc);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double[] edges() {
    final VectorRegister5 W = new VectorRegister5();
    final double[] targetEdges = chain.edges(isPolygonLooped());
    for (int k = 0; k + 1 < targetEdges.length; k += 2) {
      W.inject_0(targetEdges, k);
      writeToWorld(W);
      W.extract_1(targetEdges, k);
    }
    return targetEdges;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Object executeAction(final String action) {
    if ("self.center".equals(action)) {
      cache.center();
      return true;
    }
    if ("apply.scale".equals(action)) {
      cache.apply_scale();
      return true;
    }
    if (chain.act(action, isPolygonLooped(), document, this)) {
      cache.update();
      return true;
    }
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ControlDoodad[] getDoodadsInThingSpace() {
    if (cache.needsUpdate()) {
      cache.update();
    }
    return cache.doodads;
  }

  @Override
  public void invalidate() {
    cache.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    boolean all = true;
    boolean any = false;
    for (final SelectablePoint2 point : chain) {
      if (!point.selected) {
        all = false;
      } else {
        any = true;
      }
    }
    if (all || !any) {
      // this will be faster
      interactions.add(new ThingMover(event));
      return;
    }
    for (final SelectablePoint2 point : chain) {
      if (point.selected) {
        interactions.add(new VertexMover(new Vertex(point, this), event));
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void populateLinks(final HashMap<String, Edit> links) {
    pointsEditList.edits.clear();
    cache.update();
    int index = 0;
    for (final SelectablePoint2 p : chain) {
      pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), true));
      pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), false));
      index++;
    }
    links.put("points", pointsEditList);
    links.put("vlock", vlock);
    populatePolygonalEditLinks(links);
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (doesContainTargetPoint(x, y)) {
      return Color.valueOf(color.getAsText());
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean selectionIntersect(final Polygon p, final Mode mode) {
    boolean doUpdate = false;
    boolean isSelected = doesPolygonIntersect(p);
    boolean anySelected = false;
    for (final SelectablePoint2 point : chain) {
      final boolean old = point.selected;
      if (p.contains(point.x, point.y)) {
        point.selected = true;
        isSelected = true;
      } else {
        point.selected = false;
      }
      point.selected = mode.selected(point.alreadySelected, point.selected);
      if (old != point.selected) {
        doUpdate = true;
      }
      if (point.selected) {
        anySelected = true;
      }
    }
    if (doUpdate) {
      cache.update();
    }
    if (mode == Mode.Subtract && anySelected) {
      return false;
    }
    return isSelected;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
    final VectorRegister3 W = new VectorRegister3();

    for (final SelectablePoint2 point : chain) {
      W.set_0(point.x, point.y);
      writeToWorld(W);
      if (event.doodadDistance(W.x_1, W.y_1) <= document.controlPointSize) {
        point.selected = true;
        return new VertexMover(new Vertex(point, this), event);
      }
    }
    if (allowEdgeSelect() && !vlock.value()) {
      final VectorRegister3 reg = new VectorRegister3();
      for (final SelectablePoint2[] line : chain.lines(isPolygonLooped())) {

        // transform the starting point to a temporary place
        final SelectablePoint2 begin = line[0];
        W.set_0(begin.x, begin.y);
        writeToWorld(W);

        // transform the endpoint directly
        final SelectablePoint2 end = line[1];
        reg.set_0(end.x, end.y);
        writeToWorld(reg);

        // inject the starting point
        reg.set_0(W.x_1, W.y_1);

        // set where we are
        reg.set_2(event.position.x_0, event.position.y_0);
        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(reg);
        if (distance > 0) {
          if (event.doodadDistance(reg.x_0, reg.y_0) <= document.edgeWidthSize) {
            begin.selected = true;
            end.selected = true;
            return new EdgeMover(new Vertex(begin, this), new Vertex(end, this), event);
          }
        }
      }
    }
    if (doesPointApplyToSelection(event)) {
      return new ThingMover(event);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean supportsColor() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sync() {
    cache.update();
  }

}
