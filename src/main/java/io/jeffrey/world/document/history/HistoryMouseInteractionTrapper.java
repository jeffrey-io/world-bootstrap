package io.jeffrey.world.document.history;

import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;

/**
 * Makes it easy to capture bulk events as they happen
 *
 * @author jeffrey
 */
public class HistoryMouseInteractionTrapper implements MouseInteraction {
    private final MouseInteraction delegate;
    private final History          history;

    public HistoryMouseInteractionTrapper(final History history, final MouseInteraction delegate) {
        this.history = history;
        this.delegate = delegate;
    }

    @Override
    public void cancel() {
        history.abort();
        delegate.cancel();
    }

    @Override
    public void commit() {
        history.capture();
        delegate.commit();
    }

    @Override
    public void moved(final AdjustedMouseEvent event) {
        delegate.moved(event);
    }
}
