package io.jeffrey.world.things.enforcer;

import java.util.Collection;

import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

public class SerialEnforcer implements GuideLineEnforcer {

  private final Collection<GuideLineEnforcer> enforcers;
  
  public SerialEnforcer(Collection<GuideLineEnforcer> enforcers) {
    this.enforcers = enforcers;
  }
  
  @Override
  public void attemptSnapTo(Camera camera, GuideLine line) {
    for (GuideLineEnforcer enforcer : enforcers) {
      enforcer.attemptSnapTo(camera, line);
    }
  }

}
