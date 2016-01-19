package io.jeffrey.world.things;

import java.util.List;
import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.behaviors.IsSelectable.ContainmentCheck;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.parts.CircleControlDoodadsPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends Thing {
  private final CircleControlDoodadsPart circle;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data is
   */
  public TCircle(final Document document, final ThingData node) {
    super(document, node);

    circle = new CircleControlDoodadsPart();
    register("shapes", circle);

    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register("enforcers", enforcers);
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
    return circle.contains(x, y, ContainmentCheck.ExactlyInside);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPointApplyToSelection(final AdjustedMouseEvent event) {
    return doesContainTargetPoint(event.position.x_1, event.position.y_1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void draw(final GraphicsContext gc) {
    gc.setFill(Color.valueOf(fill.color.getAsText()));
    gc.fillArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    if (selected()) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(4 / (scale.sx() + scale.sy()));
      gc.strokeArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected Object executeAction(final String action) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return circle.getDoodadsInThingSpace();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    interactions.add(new ThingMover(event, position, rotation));
  }

  @Override
  public Color queryTargetColor(final double x, final double y) {
    if (doesContainTargetPoint(x, y)) {
      return Color.valueOf(fill.color.getAsText());
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean selectionIntersect(final Polygon p, final Mode mode) {
    return circle.selectionIntersect(p, mode);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
    if (doesPointApplyToSelection(event)) {
      return new ThingMover(event, position, rotation);
    }
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
  }
}
