package io.jeffrey.world.things.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.HasGuideLineEnforcers;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;

public class EnforcersPart implements Part, HasGuideLineEnforcers {

  private final ArrayList<GuideLineEnforcer> enforcers;

  public EnforcersPart(final GuideLineEnforcer... enforcers) {
    this.enforcers = new ArrayList<>(enforcers.length);
    for (final GuideLineEnforcer enforcer : enforcers) {
      this.enforcers.add(enforcer);
    }
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public Collection<GuideLineEnforcer> getGuideLineEnforcers() {
    return enforcers;
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
  }
}
