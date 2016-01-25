package io.jeffrey.world.things.core;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasSelectionByWindow;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;

public class ContainerQueryEngine {

  private final Container container;

  public ContainerQueryEngine(final Container container) {
    this.container = container;
  }

  public boolean contains(final AbstractThing thing, final double x, final double y) {
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
      boolean shouldRegister = false;
      for (final HasSelectionByPoint behavior : thing.collect(HasSelectionByPoint.class)) {
        if (behavior.buildSelectionSolver(selectionSolver)) {
          shouldRegister = true;
        }
      }
      if (shouldRegister) {
        container.history.register(thing);
      }
      selectionSolver.unfocus();

      thing.invokeAction("unselect", false);
    }

    final MouseInteraction it = selectionSolver.solve();
    if (it != null) {
      return new MouseInteraction() {

        @Override
        public void cancel() {
          it.cancel();
        }

        @Override
        public void commit() {
          it.commit();
          container.history.capture();
        }

        @Override
        public void moved(final AdjustedMouseEvent event) {
          it.moved(event);
        }
      };
    }
    return null;
  }

  public AbstractThing selectFirstVisible(final double x, final double y) {
    for (final AbstractThing thing : container) {
      if (contains(thing, x, y)) {
        return thing;
      }
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
