package io.jeffrey.world.things.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasEdgesInWorldSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectanglePart implements Part, HasEdgesInWorldSpace, HasControlDoodadsInThingSpace, IsSelectable {

  public static enum DoodadControls {
    All(8, true, true), None(0, false, false), Rotation(4, false, true), Scale(4, true, false);

    public final boolean rotation;
    public final boolean scale;
    public final int     size;

    private DoodadControls(final int size, final boolean scale, final boolean rotation) {
      this.size = size;
      this.scale = scale;
      this.rotation = rotation;
    }
  }

  private final DoodadControls  controls;
  private final ControlDoodad[] doodads;
  private Rectangle             rect;

  private final Transform       transform;

  public RectanglePart(final Transform transform, final DoodadControls controls) {
    this.transform = transform;
    this.controls = controls;
    rect = new Rectangle(-1, -1, 2, 2);
    doodads = new ControlDoodad[controls.size];
    set(-1, -1, 2, 2);
  }

  @Override
  public boolean contains(final double x, final double y) {
    return rect.contains(x, y);
  }

  @Override
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event) {
    return rect.contains(event.position.x_1, event.position.y_1);
  }

  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return doodads;
  }

  @Override
  public double[] getWorldSpaceEdges() {
    final double[] edges = new double[16];
    final VectorRegister3 W = new VectorRegister8();
    W.set_0(-rect.getWidth() / 2, -rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 0);
    W.set_0(rect.getWidth() / 2, -rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 2);
    edges[4] = edges[2];
    edges[5] = edges[3];
    W.set_0(rect.getWidth() / 2, rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 6);
    edges[8] = edges[6];
    edges[9] = edges[7];
    W.set_0(-rect.getWidth() / 2, rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 10);
    edges[12] = edges[10];
    edges[13] = edges[11];
    edges[14] = edges[0];
    edges[15] = edges[1];
    return edges;
  }

  @Override
  public boolean selectionIntersect(final Polygon polygon, final Mode mode) {
    return Shape.intersect(rect, polygon).getBoundsInLocal().getWidth() > 0;
  }

  public void set(final double x, final double y, final double width, final double height) {
    rect = new Rectangle(x, y, width, height);
    int at = 0;
    if (controls.rotation) {
      doodads[at] = new ControlDoodad(Type.Rotate, 0, rect.getHeight() / 2);
      at++;
      doodads[at] = new ControlDoodad(Type.Rotate, 0, -rect.getHeight() / 2);
      at++;
      doodads[at] = new ControlDoodad(Type.Rotate, -rect.getWidth() / 2, 0);
      at++;
      doodads[at] = new ControlDoodad(Type.Rotate, rect.getWidth() / 2, 0);
      at++;
    }
    if (controls.scale) {
      doodads[at] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, -rect.getHeight() / 2);
      at++;
      doodads[at] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, rect.getHeight() / 2);
      at++;
      doodads[at] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, -rect.getHeight() / 2);
      at++;
      doodads[at] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, rect.getHeight() / 2);
      at++;
    }
  }

}
