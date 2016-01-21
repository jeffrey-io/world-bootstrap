package io.jeffrey.world.things.enforcer;

import java.util.Collection;

import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

public class SerialEnforcer implements GuideLineEnforcer {

  private final Collection<GuideLineEnforcer> enforcers;

  public SerialEnforcer(final Collection<GuideLineEnforcer> enforcers) {
    this.enforcers = enforcers;
  }

  @Override
  public void attemptSnapTo(final Camera camera, final GuideLine line) {
    for (final GuideLineEnforcer enforcer : enforcers) {
      enforcer.attemptSnapTo(camera, line);
    }
  }

}
