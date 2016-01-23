package io.jeffrey.world;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.world.things.behaviors.HasColorsToEmit;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.zer.AdjustedMouseEvent;
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

}
