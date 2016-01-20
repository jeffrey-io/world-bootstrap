package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.CirclePart;
import io.jeffrey.world.things.parts.CircleRenderPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends Thing {
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
    register("shapes", circle);
    register("render", new CircleRenderPart(transform, document, fill, fill, scale, editing));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register("enforcers", enforcers);
    register("control", new GenericMoverPart(position, rotation));
  }
}
