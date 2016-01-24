package io.jeffrey.world.things;

import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.ColorPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.LazyPolygonPart;
import io.jeffrey.world.things.parts.PointListEdgesPart;
import io.jeffrey.world.things.parts.RenderPolygonPart;
import io.jeffrey.world.things.points.PointListThing;
import io.jeffrey.world.things.points.list.Property;
import javafx.scene.shape.Polygon;

/**
 * A thing that is a polygon
 *
 * @author jeffrey
 */
public class TPolygon extends PointListThing {

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPolygon(final Container container, final LinkedDataMap data) {
    super(container, data, Property.Looped);

    final PointListEdgesPart edges = new PointListEdgesPart(list, transform);
    register(edges);

    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position), new EdgeEnforcer(edges, position, rotation));
    register(enforcers);

    final LazyPolygonPart lazyPolygonPart = new LazyPolygonPart();
    register(lazyPolygonPart);

    points.subscribe(c -> {
      lazyPolygonPart.set(new Polygon(c.inlineXYPairs));
    });

    final ColorPart fill = new ColorPart("fill", "ccc", data);
    register(fill);
    final ColorPart edge = new ColorPart("edge", "black", data);
    register(edge);
    register(new RenderPolygonPart(transform, container, editing, scale, fill, edge, points, list));
  }
}
