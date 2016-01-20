package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;
import io.jeffrey.world.things.parts.ImageRenderPart;
import io.jeffrey.world.things.parts.RectanglePart;
import io.jeffrey.world.things.parts.UriPart;

/**
 * A thing that is an image
 *
 * @author jeffrey
 *
 */
public class TImage extends Thing {

  private final RectanglePart rectangle;
  private final UriPart       uri;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing is
   */
  public TImage(final Document document, final ThingData node) {
    super(document, node);
    rectangle = new RectanglePart(transform);
    register("shapes", rectangle);
    uri = new UriPart("", data);
    register("uri", uri);
    register("render", new ImageRenderPart(transform, document, uri, editing, rectangle));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position), new EdgeEnforcer(rectangle, position, rotation));
    register("enforcers", enforcers);
    register("control", new GenericMoverPart(position, rotation));
  }
}
