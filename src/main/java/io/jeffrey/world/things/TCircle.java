package io.jeffrey.world.things;

import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
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
  public TCircle(final Container document, final LinkedDataMap data) {
    super(document, data);
    circle = new CirclePart();
    register(circle);
    register(new CircleRenderPart(transform, document, fill, fill, scale, editing));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register(enforcers);
    register(new GenericMoverPart(position, rotation, editing));
    register(new MousePart(this, transform));
  }
}
