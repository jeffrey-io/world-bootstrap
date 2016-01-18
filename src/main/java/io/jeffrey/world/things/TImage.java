package io.jeffrey.world.things;

import java.util.List;
import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.behaviors.IsSelectable.ContainmentCheck;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.parts.RectanglePart;
import io.jeffrey.world.things.parts.UriPart;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * A thing that is an image
 *
 * @author jeffrey
 *
 */
public class TImage extends Thing {
  private static int clamp(final int value, final int low, final int high) {
    return Math.min(high, Math.max(low, value));
  }

  private final ImageCache    cache;

  private Image               img = null;
  private final RectanglePart rectangle;
  private final UriPart       uri;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing is
   */
  public TImage(final Document document, final ThingData node) {
    super(document, node);
    cache = document.imageCache;
    rectangle = new RectanglePart(transform);

    uri = new UriPart("", data) {

      @Override
      public void update() {
        refresh();
      }
    };
    refresh();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void cacheSelection() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void clearSelection() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void describePossibleActions(final List<String> actions) {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesContainTargetPoint(final double x, final double y) {
    return rectangle.contains(x, y, ContainmentCheck.ExactlyInside);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPointApplyToSelection(final AdjustedMouseEvent event) {
    refresh();
    return rectangle.contains(event.position.x_1, event.position.y_1, ContainmentCheck.CloseEnoughToMaintainSelection);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void draw(final GraphicsContext gc) {
    refresh();
    gc.drawImage(img, -img.getWidth() / 2.0, -img.getHeight() / 2.0);
    if (selected()) {
      gc.save();
      gc.setStroke(Color.RED);
      gc.setLineWidth(10.0);
      gc.strokeRect(-img.getWidth() / 2.0, -img.getHeight() / 2.0, img.getWidth(), img.getHeight());
      gc.restore();
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Object executeAction(final String action) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    refresh();
    return rectangle.getDoodadsInThingSpace();
  }

  @Override
  protected GuideLineEnforcer getGuideLineEnforcer() {
    return new EdgeEnforcer(rectangle, position, rotation);
  }

  @Override
  public void invalidate() {
    refresh();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    refresh();
    interactions.add(new ThingMover(event, position, rotation));
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (doesContainTargetPoint(x, y)) {
      final int _x = clamp((int) Math.round(x + img.getWidth() / 2.0), 0, (int) (img.getWidth() - 1));
      final int _y = clamp((int) Math.round(y + img.getHeight() / 2.0), 0, (int) (img.getHeight() - 1));
      return img.getPixelReader().getColor(_x, _y);
    }
    return null;
  }

  /**
   * helper: update the image based on the cache
   */
  private void refresh() {
    img = cache.of(document.find(uri.uri.value()));
    if (img != null) {
      rectangle.set(-img.getWidth() / 2, -img.getHeight() / 2, img.getWidth(), img.getHeight());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean selectionIntersect(final Polygon p, final Mode mode) {
    refresh();
    return rectangle.selectionIntersect(p, mode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
    refresh();
    if (doesPointApplyToSelection(event)) {
      return new ThingMover(event, position, rotation);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean supportsColor() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
    refresh();
  }
}
