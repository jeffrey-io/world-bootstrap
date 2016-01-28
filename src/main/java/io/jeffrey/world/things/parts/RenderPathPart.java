package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.parts.PointSetPart.SharedMutableCache;
import javafx.scene.canvas.GraphicsContext;

public class RenderPathPart extends HasThingSpaceRendering implements Part {

  private SharedMutableCache cache;
  private final PointSetPart pointset;

  public RenderPathPart(final Transform transform, final Container container, final PointSetPart pointset) {
    super(transform, container);
    cache = pointset.subscribe(cache -> RenderPathPart.this.cache = cache);
    this.pointset = pointset;
  }

  @Override
  public void draw(final GraphicsContext gc) {
    pointset.requireUpToDate();
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
