package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.parts.RenderPathPart;
import io.jeffrey.world.things.points.PointListThing;
import io.jeffrey.world.things.points.list.SelectablePoint2List.Property;

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
  public TPath(final Document document, final ThingData node) {
    super(document, node);
    register(new RenderPathPart(transform, document, points, list));
  }

}
