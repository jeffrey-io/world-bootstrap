package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.core.Transform;
import javafx.scene.canvas.GraphicsContext;

public abstract class HasThingSpaceRendering implements HasWorldSpaceRendering {

  protected final Document  document;
  protected final Transform transform;

  public HasThingSpaceRendering(final Transform transform, final Document document) {
    this.transform = transform;
    this.document = document;
  }

  public abstract void draw(GraphicsContext gc);

  @Override
  public void render(final GraphicsContext gc) {
    gc.save();
    gc.translate(document.camera.tX, document.camera.tY);
    gc.scale(document.camera.scale, document.camera.scale);
    transform.readyGraphicsContext(gc);
    draw(gc);
    gc.restore();
  }
}
