package io.jeffrey.world.things.parts;

import java.util.ArrayList;
import java.util.Set;

import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class CircleControlDoodadsPart implements Part, HasControlDoodadsInThingSpace, IsSelectable {
  private static final Circle   CIRCLE = new Circle(1);
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
  
  public CircleControlDoodadsPart() {
  }
  
  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return DOODADS;
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
  }

  @Override
  public boolean contains(double x, double y, ContainmentCheck check) {
    final double d = x * x + y * y;
    return Math.sqrt(d) <= 1.0;
  }

  @Override
  public boolean selectionIntersect(Polygon polygon, Mode mode) {
    return Shape.intersect(CIRCLE, polygon).getBoundsInLocal().getWidth() > 0;
  }

}
