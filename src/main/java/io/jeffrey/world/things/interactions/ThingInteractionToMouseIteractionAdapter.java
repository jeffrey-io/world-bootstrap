package io.jeffrey.world.things.interactions;

import io.jeffrey.world.document.history.History;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;

/**
 * convert an interaction of a thing into an in world space mouse interaction
 *
 * @author jeffrey
 */
public class ThingInteractionToMouseIteractionAdapter implements MouseInteraction {
  private final ThingInteraction interaction;
  private final Transform        transform;

  /**
   * @param history
   *          the history buffer so we can capture we are about to do something
   * @param interaction
   *          the interaction of the thing
   * @param target
   *          the thing we are going to be interacting with
   */
  public ThingInteractionToMouseIteractionAdapter(final History history, final ThingInteraction interaction, final Transform transform) {
    this.interaction = interaction;
    this.transform = transform;
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
    interaction.commit();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    transform.writeToThingSpace(event.position);
    interaction.moved(event);
  }
}
