package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.polygon.AbstractPointChain;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * a point chain that is a path
 *
 * @author jeffrey
 *
 */
public class TPath extends AbstractPointChain {

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPath(final Document document, final ThingData node) {
    super(document, node);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void renderPolygon(final Document document, final GraphicsContext gc) {
    if (cache.x.length == 0) {
      return;
    }
    gc.setStroke(Color.valueOf(fill.color.getAsText()));
    gc.beginPath();
    final double s = 2.0 / (scale.sx() + scale.sy());
    gc.setLineWidth(s);
    gc.moveTo(cache.x[0], cache.y[0]);
    for (int k = 1; k < cache.y.length; k++) {
      gc.lineTo(cache.x[k], cache.y[k]);
    }
    gc.stroke();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
  }

}
