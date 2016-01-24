package io.jeffrey.world.things.core;

import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasSelectionByWindow;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;

public class ContainerQueryEngine {

  private final Container container;

  public ContainerQueryEngine(final Container container) {
    this.container = container;
  }

  public MouseInteraction selectByPoint(final AdjustedMouseEvent event) {
    final InteractionSelectionSolver selectionSolver = new InteractionSelectionSolver(container.history);
    for (final AbstractThing thing : container) {
      // it's deleted, we do nothing
      if (thing.lifetime.isDeleted()) {
        continue;
      }

      // it's locked, we do nothing
      if (thing.editing.locked.value()) {
        // clear the selection
        if (thing.editing.selected.value()) {
          thing.editing.selected.value(false);
        }
        continue;
      }

      // indicate we may do a selection window (although, is this needed)
      thing.collect(HasSelectionByWindow.class, t -> {
        t.beginSelectionWindow();
        return null;
      });

      final AdjustedMouseEvent cevent = event.clone();
      thing.transform().writeToThingSpace(cevent.position);
      selectionSolver.focus(thing, cevent);
      for (final HasSelectionByPoint behavior : thing.collect(HasSelectionByPoint.class)) {
        behavior.buildSelectionSolver(selectionSolver);
      }
      selectionSolver.unfocus();

      thing.invokeAction("unselect", false);
    }

    final MouseInteraction it = selectionSolver.solve();
    if (it != null) {
      return it;
    }
    return null;
  }

  public void updateSelectionWindow(final SelectionWindow window) {
    for (final AbstractThing thing : container) {
      final HasSelectionByWindow mouse = thing.first(HasSelectionByWindow.class);
      if (mouse != null) {
        mouse.updateSelectionWindow(window);
      }
    }
  }
}
