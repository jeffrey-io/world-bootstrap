package io.jeffrey.world.things.polygon;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.BasicThing;
import io.jeffrey.world.things.parts.EdgeMover;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.parts.PointSetPart;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.SelectablePoint2List;
import javafx.scene.canvas.GraphicsContext;

/**
 * Defines common operations on things that behave like polygons/lines/graph connects. That is, things that have a bunch of vertices connected on some kind of chain/loop
 *
 * @author jeffrey
 *
 */
public abstract class AbstractPointChain extends BasicThing {

  protected SharedMutableCache         cache;
  /**
   * {@inheritDoc}
   */
  boolean                              isSelected = false; // doesPolygonIntersect(p);
  /**
   * Defines how to render and interpret the points. This is lazily updated
   *
   * @author jeffrey
   */
  protected final SelectablePoint2List list;

  protected final PointSetPart         points;

  /**
   * @param document
   *          the document
   * @param node
   *          where the thing's data iss
   */
  protected AbstractPointChain(final Document document, final ThingData node) {
    super(document, node);
    list = new SelectablePoint2List(node.getString("points", "0,-1,1,1,-1,1").value(), false);

    points = new PointSetPart(data, document, transform, position, scale, rotation) {

      @Override
      public SelectablePoint2 at(final int k) {
        return list.at(k);
      }

      @Override
      public int getNumberOfPoints() {
        return list.size();
      }

      @Override
      public Iterable<SelectablePoint2> getSelectablePoints() {
        return list;
      }
    };
    points.subscribe(c -> {
      AbstractPointChain.this.cache = c;
    });

    register(points);
    register(new MousePart(this, transform));

    editing.selected.subscribe((t, u) -> {
      if (u.equals("false")) {
        for (final SelectablePoint2 point : list) {
          point.selected = false;
        }
        points.update();
      }
    });
    register(new EdgeMover(document, transform, list, points.lock, points));
  }

  /*
   * protected Object executeAction(final String action) { if ("self.center".equals(action)) { cache.center(); return true; } if ("apply.scale".equals(action)) { cache.apply_scale(); return true; } if (chain.act(action, isPolygonLooped(), document, this)) { cache.update(); return true; } return false; }
   */

  /*
   * protected void populateLinks(final HashMap<String, Edit> links) { pointsEditList.edits.clear(); cache.update(); int index = 0; for (final SelectablePoint2 p : chain) { pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), true)); pointsEditList.edits.add(new EditVertex(index, new Vertex(p, this), false)); index++; } links.put("points", pointsEditList); populatePolygonalEditLinks(links); }
   */

  /**
   * {@inheritDoc}
   */
  /*
   * @Override protected void describePossibleActions(final List<String> actions) { if (areTheNumberOfPointsFixed()) { return; } actions.add("apply.scale"); actions.add("self.center"); chain.describePossibleActionsBasedOnSelectedVertices(actions, isPolygonLooped()); }
   */

  protected void draw(final GraphicsContext gc) {
    points.requireUpToDate();
    renderPolygon(document, gc);
  }

  /**
   * draw the specifics of the polygon
   *
   * @param document
   *          the document that contains all
   * @param gc
   *          the graphics context where images are placed
   */
  protected abstract void renderPolygon(final Document document, final GraphicsContext gc);

}
