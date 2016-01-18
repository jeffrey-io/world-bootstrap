package io.jeffrey.world.things.base;

import java.util.Set;

public interface Part {

  public void act(String action, SharedActionSpace space);

  public void list(Set<String> actionsAvailable);

  public boolean unique();

  public void update();
}
