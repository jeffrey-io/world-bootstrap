package io.jeffrey.world.things.polygon;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.BasicThing;

/**
 * Making life simple, this class acts as an easy way to document the responsibilities AbstractPointChain.
 *
 * @author jeffrey
 *
 */
public abstract class AbstractPointChainContract extends BasicThing {

  protected AbstractPointChainContract(final Document document, final ThingData node) {
    super(document, node);
  }

}
