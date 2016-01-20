package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.CanRenderInWorldSpace;
import io.jeffrey.world.things.behaviors.EmitsColor;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.interactions.MousePart;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteractionToMouseIteractionAdapter;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Thing extends ThingCore {
  private final MousePart defaultMouseInteraction;

  /**
   * does the thing the given (x,y) point in world space
   *
   * @param x
   *          the x-coordinate
   * @param y
   *          the y-coordinate
   * @return whether or not point is in the thing
   */
  VectorRegister3         threadUnsafeContainmentScratch = new VectorRegister8();

  /**
   * @param document
   *          owner of the thing
   * @param node
   *          where the data for the thing comes from
   */
  protected Thing(final Document document, final ThingData node) {
    super(document, node);
    defaultMouseInteraction = new MousePart(this, transform);
    register("mouse", defaultMouseInteraction);
  }

  /**
   * take the given selection window and test whether or not it intersects the thing
   *
   * @param window
   *          the selection window
   */
  public void applySelection(final SelectionWindow window) {
    defaultMouseInteraction.updateSelectionBasedOnWindow(window);
  }

  public boolean contains(final double x, final double y) {
    threadUnsafeContainmentScratch.set_0(x, y);
    writeToTarget(threadUnsafeContainmentScratch);
    for (final IsSelectable selectable : collect(IsSelectable.class)) {
      if (selectable.contains(threadUnsafeContainmentScratch.x_1, threadUnsafeContainmentScratch.y_1)) {
        return true;
      }
    }
    return false;
  }

  public Transform getTransform() {
    return transform;
  }

  /**
   * is the given point in the selection?
   *
   * @param document
   * @param event
   * @return
   */
  public boolean isInCurrertSelection(final AdjustedMouseEvent event) {
    if (!editing.selected.value()) {
      return false;
    }
    transform.writeToThingSpace(event.position);
    for (final IsSelectable selectable : collect(IsSelectable.class)) {
      if (selectable.doesMouseEventPreserveExistingSelection(event)) {
        return true;
      }
    }
    return false;
  }

  /**
   * we are about to start a new interaction, what should we do?
   *
   * @param event
   *          the event in world space
   */
  public void preInteract(final AdjustedMouseEvent event) {
    if (!event.altdown) {
      invokeAction("unselect", false);
    }
  }

  public Color query(final double x, final double y) {
    final VectorRegister6 W = new VectorRegister6();
    W.set_0(x, y);
    writeToTarget(W);
    for (final EmitsColor emitsColor : collect(EmitsColor.class)) {
      final Color result = emitsColor.queryTargetColor(W.x_1, W.y_1);
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  /**
   * render the thing according to the camera
   *
   * @param gc
   *          the graphics context
   * @param camera
   *          where the user is at
   */
  public void render(final GraphicsContext gc, final Camera camera) {
    if (lifetime.isDeleted()) {
      return;
    }

    for (final CanRenderInWorldSpace renderer : collect(CanRenderInWorldSpace.class)) {
      renderer.render(gc);
    }
  }

  /**
   * start a new interaction
   *
   * @param event
   *          the world space event
   * @return a mouse interaction to manipulate things (or null if nothing to do)
   */
  public MouseInteraction startInteraction(final AdjustedMouseEvent event) {
    if (lifetime.isDeleted()) {
      return null;
    }
    if (editing.locked.value()) {
      return null;
    }

    transform.writeToThingSpace(event.position);

    final ThingInteraction interaction = defaultMouseInteraction.start(event);
    if (interaction == null) {
      return null;
    }
    document.history.register(this);

    return new ThingInteractionToMouseIteractionAdapter(document.history, interaction, transform);
  }

  /**
   * convert the given (_x,_y) at vector 0 in world space into target space and write to vector 1 (vector 2 is used as scratch space)
   *
   * @param _x
   *          the x coordinate in thing/target space
   * @param _y
   *          the y coordinate in thing/target space
   * @return a vector representing the point in world space
   */
  public void writeToTarget(final VectorRegister3 reg) {
    transform.writeToThingSpace(reg);
  }

  /**
   * convert the given (_x,_y) at vector 0 in thing/target space into world space and write to vector 1 (vector 2 is used as scratch space)
   *
   * @param _x
   *          the x coordinate in thing/target space
   * @param _y
   *          the y coordinate in thing/target space
   * @return a vector representing the point in world space
   */
  public void writeToWorld(final VectorRegister3 reg) {
    transform.writeToWorldSpace(reg);
  }

  public double x() {
    return position.x();
  }

  public double y() {
    return position.y();
  }
}
