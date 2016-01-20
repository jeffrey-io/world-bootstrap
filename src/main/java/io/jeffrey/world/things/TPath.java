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

}
