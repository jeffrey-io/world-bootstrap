package io.jeffrey.world.things.behaviors;

import java.util.Collection;

import io.jeffrey.world.things.core.guides.GuideLineEnforcer;

public interface HasGuideLineEnforcers {

  public Collection<GuideLineEnforcer> getGuideLineEnforcers();
}
