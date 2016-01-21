package io.jeffrey.world.things.behaviors;

import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Transform;
import javafx.scene.canvas.GraphicsContext;

public abstract class HasThingSpaceRendering implements HasWorldSpaceRendering {

  protected final Container container;
  protected final Transform transform;

  public HasThingSpaceRendering(final Transform transform, final Container container) {
    this.transform = transform;
    this.container = container;
  }

  public abstract void draw(GraphicsContext gc);

  @Override
  public void render(final GraphicsContext gc) {
    gc.save();
    gc.translate(container.camera.tX, container.camera.tY);
    gc.scale(container.camera.scale, container.camera.scale);
    transform.readyGraphicsContext(gc);
    draw(gc);
    gc.restore();
  }
}
