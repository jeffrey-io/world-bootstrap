package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class RenderPolygonPart extends HasThingSpaceRendering implements Part {
  private SharedMutableCache cache;
  protected final ColorPart  edge;
  protected EditingPart      editing;
  protected final ColorPart  fill;

  private final PointSetPart pointset;
  protected final ScalePart  scale;

  public RenderPolygonPart(final Transform transform, final Container container, final EditingPart editing, final ScalePart scale, final ColorPart fill, final ColorPart edge, final PointSetPart pointset, final SelectablePoint2List pointlist) {
    super(transform, container);
    this.editing = editing;
    this.scale = scale;
    this.edge = edge;
    this.fill = fill;
    cache = null;
    pointset.subscribe(cache -> RenderPolygonPart.this.cache = cache);
    this.pointset = pointset;
  }

  @Override
  public void draw(final GraphicsContext gc) {
    pointset.requireUpToDate();
    if (cache == null) {
      return;
    }

    if (fill.enabled.value()) {
      gc.setFill(Color.valueOf(fill.color.getAsText()));
      gc.fillPolygon(cache.x, cache.y, cache.y.length);
    }
    if (edge.enabled.value()) {
      gc.setStroke(Color.valueOf(edge.color.getAsText()));
      gc.strokePolygon(cache.x, cache.y, cache.y.length);
    }
    if (editing.selected.value() && cache.boundingRadius > 0) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(2.0 / (scale.sx() + scale.sy()));
      gc.moveTo(-cache.boundingRadius, 0);
      gc.strokeArc(-cache.boundingRadius, -cache.boundingRadius, 2 * cache.boundingRadius, 2 * cache.boundingRadius, 0, 3601, ArcType.ROUND);
      gc.strokePolygon(cache.x, cache.y, cache.y.length);
    }

  }
}
