package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.EmitsColor;
import io.jeffrey.world.things.behaviors.IsSelectable;
import javafx.scene.paint.Color;

public class SingleColorEmitterPart implements Part, EmitsColor {

  protected ColorPart    color;
  protected IsSelectable selectable;

  public SingleColorEmitterPart(final ColorPart color, final IsSelectable selectable) {
    this.color = color;
    this.selectable = selectable;
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (selectable.contains(x, y)) {
      return Color.valueOf(color.color.getAsText());
    }
    return null;
  }

  @Override
  public void update() {
  }
}
