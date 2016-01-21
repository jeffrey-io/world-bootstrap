package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.LazyPolygonPart;
import io.jeffrey.world.things.parts.PointListEdgesPart;
import io.jeffrey.world.things.parts.RenderPolygonPart;
import io.jeffrey.world.things.points.PointListThing;
import io.jeffrey.world.things.points.list.Property;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * A thing that is a polygon
 *
 * @author jeffrey
 */
public class TPolygon extends PointListThing {
  private final LazyPolygonPart lazyPolygonPart;
  private Polygon               polygon;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPolygon(final Document document, final ThingData node) {
    super(document, node, Property.Looped);

    final PointListEdgesPart edges = new PointListEdgesPart(list, transform);
    register(edges);

    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position), new EdgeEnforcer(edges, position, rotation));
    register(enforcers);

    lazyPolygonPart = new LazyPolygonPart();
    register(lazyPolygonPart);

    points.subscribe(c -> {
      TPolygon.this.polygon = new Polygon(c.inlineXYPairs);
      lazyPolygonPart.set(polygon);
    });

    register(new RenderPolygonPart(transform, document, points, list));
  }

  /**
   * {@inheritDoc}
   */
  protected boolean doesPolygonIntersectX(final Polygon p) {
    return Shape.intersect(p, polygon).getBoundsInLocal().getWidth() > 0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
  }

}
