package io.jeffrey.world.things.core.guides;

import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

/**
 * Enforce the guidelines and interpret how to snap to
 *
 * @author jeffrey
 */
public interface GuideLineEnforcer {
  /**
   * try to snap the thing to the guide line
   *
   * @param line
   *          the line to snap to
   */
  public void attemptSnapTo(Camera camera, GuideLine line);
}
