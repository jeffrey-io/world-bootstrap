package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.behaviors.HasColorsToEmit;
import io.jeffrey.world.things.behaviors.IsSelectable;
import javafx.scene.paint.Color;

public class SingleColorEmitterPart implements Part, HasColorsToEmit {

  protected ColorPart    color;
  protected IsSelectable selectable;

  public SingleColorEmitterPart(final ColorPart color, final IsSelectable selectable) {
    this.color = color;
    this.selectable = selectable;
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (selectable.contains(x, y)) {
      return Color.valueOf(color.color.getAsText());
    }
    return null;
  }
}
