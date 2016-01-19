package io.jeffrey.world.things.behaviors;

import java.util.Collection;

import io.jeffrey.world.things.core.guides.GuideLineEnforcer;

/**
 * denotes whether or not the thing can utilize guide lines
 * 
 * @author jeffrey
 */
public interface HasGuideLineEnforcers {

  public Collection<GuideLineEnforcer> getGuideLineEnforcers();
}
