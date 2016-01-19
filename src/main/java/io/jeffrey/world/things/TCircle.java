package io.jeffrey.world.things;

import java.util.List;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.parts.CirclePart;
import io.jeffrey.world.things.parts.CircleRenderPart;
import io.jeffrey.world.things.parts.EnforcersPart;
import io.jeffrey.world.things.parts.GenericMoverPart;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends Thing {
  private final CirclePart circle;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data is
   */
  public TCircle(final Document document, final ThingData node) {
    super(document, node);

    circle = new CirclePart();
    register("shapes", circle);
    
    register("render", new CircleRenderPart(transform, document, fill, fill, scale, editing));

    final EnforcersPart enforcers = new EnforcersPart(new OriginEnforcer(position));
    register("enforcers", enforcers);
    register("control", new GenericMoverPart(position, rotation));
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
  public ControlDoodad[] getDoodadsInThingSpace() {
    return circle.getDoodadsInThingSpace();
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
    for (IsSelectable isSelectable : collect(IsSelectable.class)) {
      if (isSelectable.doesMouseEventPreserveExistingSelection(event)) {
        return new ThingMover(event, position, rotation);
      }
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
