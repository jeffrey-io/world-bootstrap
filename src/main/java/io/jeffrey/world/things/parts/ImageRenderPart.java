package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.CanRenderInThingSpace;
import io.jeffrey.world.things.behaviors.EmitsColor;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class ImageRenderPart extends CanRenderInThingSpace implements Part, EmitsColor {

  protected final UriPart uri;
  protected final EditingPart editing;
  private Image               img = null;
  protected final RectanglePart rectangle;
  
  
  public ImageRenderPart(Transform transform, Document document, UriPart uri, EditingPart editing, RectanglePart rectangle) {
    super(transform, document);
    this.uri = uri;
    this.editing = editing;
    this.rectangle = rectangle;
    update();
  }

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
    img = document.imageCache.of(document.find(uri.uri.value()));
    if (img != null) {
      rectangle.set(-img.getWidth() / 2, -img.getHeight() / 2, img.getWidth(), img.getHeight());
    }
  }

  @Override
  public void draw(GraphicsContext gc) {
    update();
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
  private static int clamp(final int value, final int low, final int high) {
    return Math.min(high, Math.max(low, value));
  }

}