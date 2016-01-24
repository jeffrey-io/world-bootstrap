package io.jeffrey.world.things.parts;

import java.util.ArrayList;

import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.AdjustedMouseEvent;

public class CirclePart implements Part, HasControlDoodadsInThingSpace, IsSelectable {
  private static final ControlDoodad[] DOODADS;

  static {
    final ArrayList<ControlDoodad> doodads = new ArrayList<>();
    doodads.add(new ControlDoodad(Type.Rotate, -1.05, 0));
    doodads.add(new ControlDoodad(Type.Rotate, 1.05, 0));
    doodads.add(new ControlDoodad(Type.Rotate, 0, -1.05));
    doodads.add(new ControlDoodad(Type.Rotate, 0, 1.05));
    doodads.add(new ControlDoodad(Type.Scale, 0.7, 0.7));
    doodads.add(new ControlDoodad(Type.Scale, 0.7, -0.7));
    doodads.add(new ControlDoodad(Type.Scale, -0.7, 0.7));
    doodads.add(new ControlDoodad(Type.Scale, -0.7, -0.7));
    DOODADS = doodads.toArray(new ControlDoodad[doodads.size()]);
  }

  public CirclePart() {
  }

  @Override
  public boolean contains(final double x, final double y) {
    final double d = x * x + y * y;
    return Math.sqrt(d) <= 1.0;
  }

  @Override
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event) {
    return contains(event.position.x_1, event.position.y_1);
  }

  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return DOODADS;
  }

  @Override
  public boolean selectionIntersect(final SelectionModel model) {
    return model.isOriginCircleSelected(1);
  }
}
