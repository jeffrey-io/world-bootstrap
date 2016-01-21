package io.jeffrey.world.things;

import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.parts.RenderPathPart;
import io.jeffrey.world.things.points.PointListThing;

/**
 * a point chain that is a path
 *
 * @author jeffrey
 *
 */
public class TPath extends PointListThing {

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPath(final Container container, final ThingData node) {
    super(container, node);
    register(new RenderPathPart(transform, container, points, list));
  }

}
