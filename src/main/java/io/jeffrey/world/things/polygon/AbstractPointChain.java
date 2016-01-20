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
    list = new SelectablePoint2List(node.getString("points", "0,-1,1,1,-1,1").value(), false, false);

    points = new PointSetPart(data, document, transform, position, scale, rotation, list);
    
    points.subscribe(c -> {
      AbstractPointChain.this.cache = c;
    });

    register(points);
    register(list);
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
