package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.Transform;
import javafx.scene.canvas.GraphicsContext;

public abstract class CanRenderInThingSpace implements CanRenderInWorldSpace {
  
  protected final Transform transform;
  protected final Document document;
  
  public CanRenderInThingSpace(Transform transform, Document document) {
    this.transform = transform;
    this.document = document;
  }

  @Override
  public void render(GraphicsContext gc) {
    gc.save();
    gc.translate(document.camera.tX, document.camera.tY);
    gc.scale(document.camera.scale, document.camera.scale);
    transform.readyGraphicsContext(gc);
    draw(gc);
    gc.restore();
  }

  public abstract void draw(GraphicsContext gc);
}
