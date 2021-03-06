package io.jeffrey.world.document.history;

import io.jeffrey.world.data.Edit;
import io.jeffrey.world.things.core.AbstractThing;

/**
 * When the edit changes, we capture changes
 *
 * @author jeffrey
 */
public class HistoryEditTrap implements Edit {

  private final Edit          delegate;
  private final History       history;
  private final AbstractThing target;

  /**
   * @param delegate
   *          the underlying edit
   * @param history
   *          the history buffer
   * @param target
   *          the thing we are focused on
   */
  public HistoryEditTrap(final Edit delegate, final History history, final AbstractThing target) {
    this.delegate = delegate;
    this.history = history;
    this.target = target;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAsText() {
    return delegate.getAsText();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String name() {
    return delegate.name();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean setByText(final String txt) {
    history.focus(name(), target);
    return delegate.setByText(txt);
  }

}
