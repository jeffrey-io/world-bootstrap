package io.jeffrey.world.things.core;

import io.jeffrey.world.document.history.History;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;

/**
 * convert an interaction of a thing into an in world space mouse interaction
 *
 * @author jeffrey
 */
public class ThingInteractionToMouseIteractionAdapter implements MouseInteraction {
  private final ThingInteraction interaction;
  private final Thing            target;

  /**
   * @param history
   *          the history buffer so we can capture we are about to do something
   * @param interaction
   *          the interaction of the thing
   * @param target
   *          the thing we are going to be interacting with
   */
  public ThingInteractionToMouseIteractionAdapter(final History history, final ThingInteraction interaction, final Thing target) {
    this.interaction = interaction;
    this.target = target;
    history.register(target);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    interaction.cancel();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void commit() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    target.adjustAndBindEvent(event);
    interaction.moved(event);
  }
}
