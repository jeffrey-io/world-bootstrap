package io.jeffrey.world.things.parts;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class RenderPolygonPart extends HasThingSpaceRendering implements Part {

  private SharedMutableCache cache;
  private final PointSetPart pointset;

  public RenderPolygonPart(final Transform transform, final Document document, final PointSetPart pointset, final SelectablePoint2List pointlist) {
    super(transform, document);
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

    // gc.setFill(Color.valueOf(fill.color.getAsText()));
    gc.setFill(Color.RED);
    gc.fillPolygon(cache.x, cache.y, cache.y.length);
    /*
     * if (editing.selected.value() && cache.boundingRadiusForControls > 0) { gc.setStroke(Color.RED); gc.setLineWidth(2.0 / (scale.sx() + scale.sy())); gc.moveTo(-cache.boundingRadiusForControls, 0); gc.strokeArc(-cache.boundingRadiusForControls, -cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 0, 3601, ArcType.ROUND); gc.strokePolygon(cache.x, cache.y, cache.y.length); }
     */
  }
}
