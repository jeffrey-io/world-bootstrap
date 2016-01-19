package io.jeffrey.world.things.base;

import java.util.Set;

/**
 * Defines a part for a thing; a thing is ultimately made up of parts
 *
 * @author jeffrey
 */
public interface Part {

  /**
   * perform the given action in the given shared space
   *
   * @param action
   *          the action to perform
   * @param space
   *          the space to communicate with other actions in flight
   */
  public void act(String action, SharedActionSpace space);

  /**
   * list all available actions
   *
   * @param actionsAvailable
   *          where the actions will go
   */
  public void list(Set<String> actionsAvailable);

  /**
   * data has changed, refresh it
   */
  public void update();
}
