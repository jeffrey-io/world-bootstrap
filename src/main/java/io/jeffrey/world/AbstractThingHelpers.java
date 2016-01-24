package io.jeffrey.world;

import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.world.things.behaviors.HasColorsToEmit;
import io.jeffrey.world.things.core.AbstractThing;
import javafx.scene.paint.Color;

public class AbstractThingHelpers {

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
