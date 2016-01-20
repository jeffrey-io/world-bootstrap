package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.BasicThing;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.CirclePart;
import io.jeffrey.world.things.parts.CircleRenderPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;
import io.jeffrey.world.things.parts.MousePart;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends BasicThing {
  private final CirclePart circle;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data is
   */
  public TCircle(final Document document, final ThingData node) {
    super(document, node);
    circle = new CirclePart();
    register(circle);
    register(new CircleRenderPart(transform, document, fill, fill, scale, editing));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register(enforcers);
    register(new GenericMoverPart(position, rotation));
    register(new MousePart(this, transform));
  }
}
