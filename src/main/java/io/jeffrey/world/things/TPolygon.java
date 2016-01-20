package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.LazyPolygonPart;
import io.jeffrey.world.things.parts.RenderPolygonPart;
import io.jeffrey.world.things.polygon.AbstractPointChain;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * A thing that is a polygon
 *
 * @author jeffrey
 */
public class TPolygon extends AbstractPointChain {
  private final LazyPolygonPart lazyPolygonPart;
  private Polygon               polygon;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPolygon(final Document document, final ThingData node) {
    super(document, node);
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position), new EdgeEnforcer(list, position, rotation));
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
  protected void renderPolygon(final Document document, final GraphicsContext gc) {
    if (cache == null) {
      return;
    }
    gc.setFill(Color.valueOf(fill.color.getAsText()));
    gc.fillPolygon(cache.x, cache.y, cache.y.length);
    if (editing.selected.value() && cache.boundingRadiusForControls > 0) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(2.0 / (scale.sx() + scale.sy()));
      gc.moveTo(-cache.boundingRadiusForControls, 0);
      gc.strokeArc(-cache.boundingRadiusForControls, -cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 0, 3601, ArcType.ROUND);
      gc.strokePolygon(cache.x, cache.y, cache.y.length);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
  }

}
