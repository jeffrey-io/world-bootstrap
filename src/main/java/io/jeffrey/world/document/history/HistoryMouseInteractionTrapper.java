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

  /**
   * @param history
   *          the history of all changes
   * @param delegate
   *          the actual mouse interaction
   */
  public HistoryMouseInteractionTrapper(final History history, final MouseInteraction delegate) {
    this.history = history;
    this.delegate = delegate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    history.abort();
    delegate.cancel();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void commit() {
    history.capture();
    delegate.commit();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    delegate.moved(event);
  }
}
