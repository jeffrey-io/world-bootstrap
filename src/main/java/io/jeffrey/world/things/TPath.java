package io.jeffrey.world.things;

import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
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
  public TPath(final Container container, final LinkedDataMap data) {
    super(container, data);
    register(new RenderPathPart(transform, container, points, list));
  }

}
