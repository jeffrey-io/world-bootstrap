package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.CanRenderInThingSpace;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CircleRenderPart extends CanRenderInThingSpace implements Part{

  protected final ColorPart    fill;
  protected final ColorPart    edge;
  protected final ScalePart scale;
  protected final EditingPart editing;

  public CircleRenderPart(Transform transform, Document document, ColorPart fill, ColorPart edge, ScalePart scale, EditingPart editing) {
    super(transform, document);
    this.fill = fill;
    this.edge = edge;
    this.scale = scale;
    this.editing = editing;
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
  public void draw(GraphicsContext gc) {
    gc.setFill(Color.valueOf(fill.color.getAsText()));
    gc.fillArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    gc.setStroke(Color.valueOf(edge.color.getAsText()));
    gc.setLineWidth(4 / (scale.sx() + scale.sy()));
    gc.strokeArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    if (editing.selected.value()) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(2 / (scale.sx() + scale.sy()));
      gc.strokeArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    }
  }
}
