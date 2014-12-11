package io.jeffrey.world.things.core;

import io.jeffrey.world.document.GuideLine;

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
     *            the line to snap to
     */
    public void attemptSnapTo(GuideLine line);
}
