package io.jeffrey.world.things.parts;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasColorsToEmit;
import io.jeffrey.world.things.behaviors.HasInternalStateThatMayNeedManualUpdating;
import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ImageRenderPart extends HasThingSpaceRendering implements Part, HasColorsToEmit, HasInternalStateThatMayNeedManualUpdating {

  private static int clamp(final int value, final int low, final int high) {
    return Math.min(high, Math.max(low, value));
  }

  protected final EditingPart   editing;
  private Image                 img = null;
  protected final RectanglePart rectangle;

  protected final UriPart       uri;

  public ImageRenderPart(final Transform transform, final Document document, final UriPart uri, final EditingPart editing, final RectanglePart rectangle) {
    super(transform, document);
    this.uri = uri;
    this.editing = editing;
    this.rectangle = rectangle;
    updateInternalState();
  }

  @Override
  public void draw(final GraphicsContext gc) {
    updateInternalState();
    gc.drawImage(img, -img.getWidth() / 2.0, -img.getHeight() / 2.0);
    if (editing.selected.value()) {
      gc.save();
      gc.setStroke(Color.RED);
      gc.setLineWidth(10.0);
      gc.strokeRect(-img.getWidth() / 2.0, -img.getHeight() / 2.0, img.getWidth(), img.getHeight());
      gc.restore();
    }
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (rectangle.contains(x, y)) {
      final int _x = clamp((int) Math.round(x + img.getWidth() / 2.0), 0, (int) (img.getWidth() - 1));
      final int _y = clamp((int) Math.round(y + img.getHeight() / 2.0), 0, (int) (img.getHeight() - 1));
      return img.getPixelReader().getColor(_x, _y);
    }
    return null;
  }

  @Override
  public void updateInternalState() {
    img = document.imageCache.of(document.find(uri.uri.value()));
    if (img != null) {
      rectangle.set(-img.getWidth() / 2, -img.getHeight() / 2, img.getWidth(), img.getHeight());
    }
  }

}
