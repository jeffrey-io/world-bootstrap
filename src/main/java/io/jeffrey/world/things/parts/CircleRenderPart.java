package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class CircleRenderPart extends HasThingSpaceRendering implements Part {

  protected final ColorPart   edge;
  protected final EditingPart editing;
  protected final ColorPart   fill;
  protected final ScalePart   scale;

  public CircleRenderPart(final Transform transform, final Container container, final ColorPart fill, final ColorPart edge, final ScalePart scale, final EditingPart editing) {
    super(transform, container);
    this.fill = fill;
    this.edge = edge;
    this.scale = scale;
    this.editing = editing;
  }

  @Override
  public void draw(final GraphicsContext gc) {
    if (fill.enabled.value()) {
      gc.setFill(fill.getCachedColor());
      gc.fillArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    }
    if (edge.enabled.value()) {
      gc.setStroke(edge.getCachedColor());
      gc.setLineWidth(4 / (scale.sx() + scale.sy()));
      gc.strokeArc(-1, -1, 2, 2, 0, 360, ArcType.OPEN);
    }
    if (editing.selected.value()) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(8 / (scale.sx() + scale.sy()));
      gc.strokeArc(-1, -1, 2, 2, 0, 360, ArcType.OPEN);
    }
  }
}
