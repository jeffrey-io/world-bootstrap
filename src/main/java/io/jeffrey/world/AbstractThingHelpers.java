package io.jeffrey.world;

import java.util.ArrayList;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.behaviors.HasColorsToEmit;
import io.jeffrey.world.things.behaviors.HasMouseInteractions;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.interactions.MultiThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteractionToMouseIteractionAdapter;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import javafx.scene.paint.Color;

public class AbstractThingHelpers {

  public static boolean contains(final AbstractThing thing, final double x, final double y) {
    final VectorRegister3 scratch = new VectorRegister3();
    scratch.set_0(x, y);
    thing.transform().writeToThingSpace(scratch);
    for (final IsSelectable selectable : thing.collect(IsSelectable.class)) {
      if (selectable.contains(scratch.x_1, scratch.y_1)) {
        return true;
      }
    }
    return false;
  }

  /**
   * is the given point in the selection?
   *
   * @param document
   * @param event
   * @return
   */
  public static boolean isInCurrertSelection(final AbstractThing thing, final AdjustedMouseEvent event) {
    if (!thing.editing.selected.value()) {
      return false;
    }
    thing.transform().writeToThingSpace(event.position);
    for (final IsSelectable selectable : thing.collect(IsSelectable.class)) {
      if (selectable.doesMouseEventPreserveExistingSelection(event)) {
        return true;
      }
    }
    return false;
  }

  public static Color query(final AbstractThing thing, final double x, final double y) {
    final VectorRegister6 W = new VectorRegister6();
    W.set_0(x, y);
    thing.transform().writeToThingSpace(W);
    for (final HasColorsToEmit emitsColor : thing.collect(HasColorsToEmit.class)) {
      final Color result = emitsColor.queryTargetColor(W.x_1, W.y_1);
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  /**
   * start a new interaction
   *
   * @param event
   *          the world space event
   * @return a mouse interaction to manipulate things (or null if nothing to do)
   */
  public static MouseInteraction startInteraction(final AbstractThing thing, final AdjustedMouseEvent event) {
    if (thing.lifetime.isDeleted()) {
      return null;
    }
    if (thing.editing.locked.value()) {
      return null;
    }

    thing.transform().writeToThingSpace(event.position);

    final ArrayList<ThingInteraction> interactions = new ArrayList<>(1);
    for (final HasMouseInteractions mouse : thing.collect(HasMouseInteractions.class)) {
      final ThingInteraction interaction = mouse.startInteraction(event);
      if (interaction != null) {
        interactions.add(interaction);
      }
    }
    if (interactions.size() == 0) {
      return null;
    }

    final ThingInteraction interaction = interactions.size() == 1 ? interactions.get(0) : new MultiThingInteraction(interactions);
    thing.document.history.register(thing);
    return new ThingInteractionToMouseIteractionAdapter(thing.document.history, interaction, thing.transform());
  }
}
