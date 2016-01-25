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
  private static final ControlDoodad[] DOODADS_ALL;
  private static final ControlDoodad[] DOODADS_NONE;
  private static final ControlDoodad[] DOODADS_ROTATE;
  private static final ControlDoodad[] DOODADS_SCALE;

  static {
    final ArrayList<ControlDoodad> doodads_all = new ArrayList<>();
    final ArrayList<ControlDoodad> doodads_scale = new ArrayList<>();
    final ArrayList<ControlDoodad> doodads_rotate = new ArrayList<>();
    doodads_all.add(new ControlDoodad(Type.Rotate, -1.05, 0));
    doodads_all.add(new ControlDoodad(Type.Rotate, 1.05, 0));
    doodads_all.add(new ControlDoodad(Type.Rotate, 0, -1.05));
    doodads_all.add(new ControlDoodad(Type.Rotate, 0, 1.05));
    doodads_rotate.add(new ControlDoodad(Type.Rotate, -1.05, 0));
    doodads_rotate.add(new ControlDoodad(Type.Rotate, 1.05, 0));
    doodads_rotate.add(new ControlDoodad(Type.Rotate, 0, -1.05));
    doodads_rotate.add(new ControlDoodad(Type.Rotate, 0, 1.05));
    doodads_all.add(new ControlDoodad(Type.Scale, 0.7, 0.7));
    doodads_all.add(new ControlDoodad(Type.Scale, 0.7, -0.7));
    doodads_all.add(new ControlDoodad(Type.Scale, -0.7, 0.7));
    doodads_all.add(new ControlDoodad(Type.Scale, -0.7, -0.7));
    doodads_scale.add(new ControlDoodad(Type.Scale, 0.7, 0.7));
    doodads_scale.add(new ControlDoodad(Type.Scale, 0.7, -0.7));
    doodads_scale.add(new ControlDoodad(Type.Scale, -0.7, 0.7));
    doodads_scale.add(new ControlDoodad(Type.Scale, -0.7, -0.7));
    DOODADS_ALL = doodads_all.toArray(new ControlDoodad[doodads_all.size()]);
    DOODADS_ROTATE = doodads_rotate.toArray(new ControlDoodad[doodads_rotate.size()]);
    DOODADS_SCALE = doodads_scale.toArray(new ControlDoodad[doodads_scale.size()]);
    DOODADS_NONE = new ControlDoodad[0];
  }

  private final ControlDoodad[] doodads;

  public CirclePart(final DoodadControls controls) {
    switch (controls) {
      case All:
        doodads = DOODADS_ALL;
        break;
      case Rotation:
        doodads = DOODADS_ROTATE;
        break;
      case Scale:
        doodads = DOODADS_SCALE;
        break;
      case None:
      default:
        doodads = DOODADS_NONE;
        break;
    }
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
    return doodads;
  }

  @Override
  public boolean selectionIntersect(final SelectionModel model) {
    return model.isOriginCircleSelected(1);
  }
}
