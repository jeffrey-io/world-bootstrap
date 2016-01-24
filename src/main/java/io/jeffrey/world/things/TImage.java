package io.jeffrey.world.things;

import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;
import io.jeffrey.world.things.parts.ImageRenderPart;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.parts.RectanglePart;
import io.jeffrey.world.things.parts.RectanglePart.DoodadControls;
import io.jeffrey.world.things.parts.UriPart;

/**
 * A thing that is an image
 *
 * @author jeffrey
 *
 */
public class TImage extends BasicThing {

  private final RectanglePart rectangle;
  private final UriPart       uri;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing is
   */
  public TImage(final Container container, final LinkedDataMap data) {
    super(container, data);
    rectangle = new RectanglePart(transform, DoodadControls.All);
    register(rectangle);
    uri = new UriPart("", data);
    register(uri);
    register(new ImageRenderPart(transform, container, uri, editing, rectangle));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position), new EdgeEnforcer(rectangle, position, rotation));
    register(enforcers);
    register(new GenericMoverPart(position, rotation, editing));
    register(new MousePart(this, transform));
  }
}
