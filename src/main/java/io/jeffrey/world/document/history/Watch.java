package io.jeffrey.world.document.history;

import java.util.HashMap;

import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.core__old_defunct.ThingCore;

/**
 * Watch a thing by copying and it then build the transition
 *
 * @author jeffrey
 */
public class Watch {
  private final HashMap<String, String> before;
  private final AbstractThing               thing;

  public Watch(final AbstractThing thing) {
    this.thing = thing;
    before = new HashMap<String, String>();
    thing.saveTo(before);
  }

  /**
   * @return convert the watch into a Transition if it makes sense
   */
  public Transition commit() {
    final HashMap<String, String> after = new HashMap<String, String>();
    thing.saveTo(after);
    final Transition t = new Transition(thing, before, after);
    if (!t.keep) {
      return null;
    }
    return t;
  }
}