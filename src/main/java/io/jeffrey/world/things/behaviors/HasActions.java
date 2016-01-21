package io.jeffrey.world.things.behaviors;

import java.util.Set;

import io.jeffrey.world.things.core.SharedActionSpace;

public interface HasActions {
  /**
   * perform the given action in the given shared space
   *
   * @param action
   *          the action to perform
   * @param space
   *          the space to communicate with other actions in flight
   */
  public void invokeAction(String action, SharedActionSpace space);

  /**
   * list all available actions
   *
   * @param actionsAvailable
   *          where the actions will go
   */
  public void listActions(Set<String> actionsAvailable);

}
