package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.zer.Camera;
import javafx.scene.canvas.GraphicsContext;

public abstract class Thing extends ThingCore {
  private final MousePart defaultMouseInteractionX;

  /**
   * does the thing the given (x,y) point in world space
   *
   * @param x
   *          the x-coordinate
   * @param y
   *          the y-coordinate
   * @return whether or not point is in the thing
   */

  /**
   * @param document
   *          owner of the thing
   * @param node
   *          where the data for the thing comes from
   */
  protected Thing(final Document document, final ThingData node) {
    super(document, node);
    defaultMouseInteractionX = new MousePart(this, transform);
    register("mouse", defaultMouseInteractionX);
  }

  /**
   * render the thing according to the camera
   *
   * @param gc
   *          the graphics context
   * @param camera
   *          where the user is at
   */
  public void render(final GraphicsContext gc, final Camera camera) {
    if (lifetime.isDeleted()) {
      return;
    }

  }

}
