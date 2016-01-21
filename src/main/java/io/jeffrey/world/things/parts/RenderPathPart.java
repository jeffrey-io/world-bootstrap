package io.jeffrey.world.things.parts;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import javafx.scene.canvas.GraphicsContext;

public class RenderPathPart extends HasThingSpaceRendering implements Part {

  private SharedMutableCache cache;
  private final PointSetPart pointset;

  public RenderPathPart(final Transform transform, final Document document, final PointSetPart pointset, final SelectablePoint2List pointlist) {
    super(transform, document);
    cache = null;
    pointset.subscribe(cache -> RenderPathPart.this.cache = cache);
    this.pointset = pointset;
  }

  @Override
  public void draw(final GraphicsContext gc) {
    pointset.requireUpToDate();
    if (cache == null) {
      return;
    }
    // gc.setStroke(Color.valueOf(fill.color.getAsText()));
    gc.beginPath();
    // final double s = 2.0 / (scale.sx() + scale.sy());
    // gc.setLineWidth(s);
    gc.moveTo(cache.x[0], cache.y[0]);
    for (int k = 1; k < cache.y.length; k++) {
      gc.lineTo(cache.x[k], cache.y[k]);
    }
    gc.stroke();
  }
}
