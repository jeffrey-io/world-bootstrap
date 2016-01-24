package io.jeffrey.world.things;

import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.parts.CirclePart;
import io.jeffrey.world.things.parts.CircleRenderPart;
import io.jeffrey.world.things.parts.ColorPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;
import io.jeffrey.world.things.parts.MousePart;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends BasicThing {

  public TCircle(final Container container, final LinkedDataMap data) {
    super(container, data);
    register(new CirclePart());
    final ColorPart fill = new ColorPart("fill", "ccc", data);
    register(fill);
    final ColorPart edge = new ColorPart("edge", "black", data);
    register(edge);
    register(new CircleRenderPart(transform, container, fill, edge, scale, editing));
    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register(enforcers);
    register(new GenericMoverPart(position, rotation, editing));
    register(new MousePart(this, transform));
  }
}
