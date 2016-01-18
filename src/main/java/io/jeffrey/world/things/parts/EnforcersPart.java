package io.jeffrey.world.things.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.HasGuideLineEnforcers;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;

public class EnforcersPart implements Part, HasGuideLineEnforcers {
  
  private ArrayList<GuideLineEnforcer> enforcers;
  
  public EnforcersPart(GuideLineEnforcer... enforcers) {
    this.enforcers = new ArrayList<>(enforcers.length);
    for (GuideLineEnforcer enforcer : enforcers) {
      this.enforcers.add(enforcer);
    }
  }

  @Override
  public Collection<GuideLineEnforcer> getGuideLineEnforcers() {
    return enforcers;
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void update() {
  }
}
