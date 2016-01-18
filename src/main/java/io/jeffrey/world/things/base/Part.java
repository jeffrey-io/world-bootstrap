package io.jeffrey.world.things.base;

import java.util.Set;

public interface Part {

  public boolean unique();

  public void update();

  public void list(Set<String> actionsAvailable);

  public void act(String action, SharedActionSpace space);
}
