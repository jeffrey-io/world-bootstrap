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

public class CircleRenderPart extends CanRenderInThingSpace implements Part {

  protected final ColorPart   edge;
  protected final EditingPart editing;
  protected final ColorPart   fill;
  protected final ScalePart   scale;

  public CircleRenderPart(final Transform transform, final Document document, final ColorPart fill, final ColorPart edge, final ScalePart scale, final EditingPart editing) {
    super(transform, document);
    this.fill = fill;
    this.edge = edge;
    this.scale = scale;
    this.editing = editing;
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public void draw(final GraphicsContext gc) {
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

  @Override
  public void list(final Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
  }
}
