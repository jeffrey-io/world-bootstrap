package io.jeffrey.world.things.interactions;

import io.jeffrey.world.document.GuideLine;
import io.jeffrey.world.things.core.GuideLineEnforcer;
import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

import java.util.Set;

/**
 * Wrap a thing mover and snap the object to the guideline
 *
 * @author jeffrey
 */
public class ThingSnapper implements ThingInteraction {
    private final ThingInteraction  delegate;
    private final Set<GuideLine>    lines;
    private final GuideLineEnforcer link;

    /**
     * @param lines
     *            the guide lines
     * @param link
     *            how to enforce the guide lines
     * @param delegate
     *            the delegate interaction that is updating the object (we will snap after to prevent locking)
     */
    public ThingSnapper(final Set<GuideLine> lines, final GuideLineEnforcer link, final ThingInteraction delegate) {
        this.lines = lines;
        this.link = link;
        this.delegate = delegate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        delegate.cancel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moved(final AdjustedMouseEvent event) {
        delegate.moved(event);
        for (final GuideLine line : lines) {
            link.attemptSnapTo(line);
        }
    }

}
