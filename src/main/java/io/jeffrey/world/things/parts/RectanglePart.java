package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasEdgesInWorldSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RectanglePart implements Part, HasEdgesInWorldSpace, HasControlDoodadsInThingSpace, IsSelectable {

  private final ControlDoodad[] doodads;
  private Rectangle             rect;
  private final Transform       transform;

  public RectanglePart(final Transform transform) {
    rect = new Rectangle(-1, -1, 2, 2);
    doodads = new ControlDoodad[8];
    this.transform = transform;
    set(-1, -1, 2, 2);
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public boolean contains(final double x, final double y, final ContainmentCheck check) {
    return rect.contains(x, y);
  }

  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return doodads;
  }

  @Override
  public void list(final Set<String> actionsAvailable) {

  }

  @Override
  public boolean selectionIntersect(final Polygon polygon, final Mode mode) {
    return Shape.intersect(rect, polygon).getBoundsInLocal().getWidth() > 0;
  }

  public void set(final double x, final double y, final double width, final double height) {
    rect = new Rectangle(x, y, width, height);
    doodads[0] = new ControlDoodad(Type.Rotate, 0, rect.getHeight() / 2);
    doodads[1] = new ControlDoodad(Type.Rotate, 0, -rect.getHeight() / 2);
    doodads[2] = new ControlDoodad(Type.Rotate, -rect.getWidth() / 2, 0);
    doodads[3] = new ControlDoodad(Type.Rotate, rect.getWidth() / 2, 0);
    doodads[4] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, -rect.getHeight() / 2);
    doodads[5] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, rect.getHeight() / 2);
    doodads[6] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, -rect.getHeight() / 2);
    doodads[7] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, rect.getHeight() / 2);
  }

  @Override
  public boolean unique() {
    return false;
  }

  @Override
  public void update() {
  }

  @Override
  public double[] worldSpaceEdges() {
    final double[] edges = new double[16];
    final VectorRegister3 W = new VectorRegister8();

    W.set_0(-rect.getWidth() / 2, -rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 0);
    W.set_0(rect.getWidth() / 2, -rect.getHeight() / 2);
    transform.writeToWorldSpace(W);
    W.extract_1(edges, 2);

    /*
     * W.set_0(rect.getWidth() / 2, -rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 4); W.set_0(rect.getWidth() / 2, rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 6);
     *
     * W.set_0(rect.getWidth() / 2, rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 8); W.set_0(-rect.getWidth() / 2, rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 10);
     *
     * W.set_0(-rect.getWidth() / 2, rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 12); W.set_0(-rect.getWidth() / 2, -rect.getHeight() / 2); writeToWorld(W); W.extract_1(edges, 14);
     */

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

}
