package io.jeffrey.world.things.parts;

import java.util.ArrayList;
import java.util.Set;

import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class CirclePart implements Part, HasControlDoodadsInThingSpace, IsSelectable {
  private static final Circle          CIRCLE = new Circle(1);
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
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public boolean contains(final double x, final double y, final ContainmentCheck check) {
    final double d = x * x + y * y;
    return Math.sqrt(d) <= 1.0;
  }

  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return DOODADS;
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
  }

  @Override
  public boolean selectionIntersect(final Polygon polygon, final Mode mode) {
    return Shape.intersect(CIRCLE, polygon).getBoundsInLocal().getWidth() > 0;
  }

  @Override
  public void update() {
  }

}
