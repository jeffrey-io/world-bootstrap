package io.jeffrey.world.things.polygon;

import java.util.List;
import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister5;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.parts.PointSetPart;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.Syncable;
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

  protected SharedMutableCache cache;
  /**
   * Defines how to render and interpret the points. This is lazily updated
   *
   * @author jeffrey
   */
  /*
   * public class VertexCache { public double[] inlineXYPairs; private boolean myvlock = false; public double[] x; public double[] y;
   * 
   * public VertexCache() { inlineXYPairs = new double[0]; x = new double[0]; y = new double[0];
   * 
   * }
   * 
   * private void apply_scale() { final double mx = scale.sx(); final double my = scale.sy(); scale.sx(1.0); scale.sy(1.0); if (inlineXYPairs.length == 0) { return; } for (final SelectablePoint2 p : chain) { p.x *= mx; p.y *= my; } update(); }
   * 
   * private void center() { if (inlineXYPairs.length == 0) { return; } double cx = 0; double cy = 0; final int n = chain.size(); for (int k = 0; k < n; k++) { final SelectablePoint2 p = chain.at(k); cx += p.x; cy += p.y; } cx /= n; cy /= n; for (int k = 0; k < n; k++) { final SelectablePoint2 p = chain.at(k); p.x -= cx; p.y -= cy; } // TODO: figure out the math about how to translate the parent object update(); }
   * 
   * public void update() { onCacheUpdated(); } }
   */

  protected final PointChain   chain;
  protected final PointSetPart points;

  /**
   * @param document
   *          the document
   * @param node
   *          where the thing's data iss
   */
  protected AbstractPointChain(final Document document, final ThingData node) {
    super(document, node);
    chain = new PointChain(node.getString("points", "0,-1,1,1,-1,1").value());

    points = new PointSetPart(data, document, transform, position, scale, rotation) {
      @Override
      public SelectablePoint2 at(final int k) {
        return chain.at(k);
      }

      @Override
      public int getNumberOfPoints() {
        return chain.size();
      }
    };
    points.subscribe(c -> {
      AbstractPointChain.this.cache = c;
    });

    register("data", points);

    editing.selected.subscribe((t, u) -> {
      if (u.equals("false")) {
        clearSelectionOnPoints();
      }
    });
  }

  protected void clearSelectionOnPoints() {
    for (final SelectablePoint2 point : chain) {
      point.selected = false;
    }
    points.update();
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

  protected void draw(final GraphicsContext gc) {
    points.update();
    renderPolygon(document, gc);
  }

  /*
   * protected Object executeAction(final String action) { if ("self.center".equals(action)) { cache.center(); return true; } if ("apply.scale".equals(action)) { cache.apply_scale(); return true; } if (chain.act(action, isPolygonLooped(), document, this)) { cache.update(); return true; } return false; }
   */

  /**
   * {@inheritDoc}
   */
  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    points.update();
    return points.getDoodadsInThingSpace();
  }

  /*
   * protected void populateLinks(final HashMap<String, Edit> links) { pointsEditList.edits.clear(); cache.update(); int index = 0; for (final SelectablePoint2 p : chain) { pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), true)); pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), false)); index++; } links.put("points", pointsEditList); populatePolygonalEditLinks(links); }
   */


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
      points.dirty();
      points.update();
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
    if (allowEdgeSelect() && !points.lock.value()) {
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
    for (IsSelectable isSelectable : collect(IsSelectable.class)) {
      if (isSelectable.doesMouseEventPreserveExistingSelection(event)) {
        return new ThingMover(event, position, rotation);
      }
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void sync() {
    points.dirty();
    points.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public double[] worldSpaceEdges() {
    final VectorRegister5 W = new VectorRegister5();
    final double[] targetEdges = chain.edges(isPolygonLooped());
    for (int k = 0; k + 1 < targetEdges.length; k += 2) {
      W.inject_0(targetEdges, k);
      writeToWorld(W);
      W.extract_1(targetEdges, k);
    }
    return targetEdges;
  }

}
