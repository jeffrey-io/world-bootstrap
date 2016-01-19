package io.jeffrey.world.things.core__old_defunct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.AdaptThingSpaceDoodadsIntoWorldSpace;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.interactions.DefaultMouseInteraction;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteractionToMouseIteractionAdapter;
import io.jeffrey.world.things.interactions.ThingSnapper;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.GuideLine;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public abstract class Thing extends ThingCore implements HasControlDoodadsInThingSpace {
  public AdaptThingSpaceDoodadsIntoWorldSpace doodadCache;
  private final DefaultMouseInteraction defaultMouseInteraction;
  
  /**
   * does the thing the given (x,y) point in world space
   *
   * @param x
   *          the x-coordinate
   * @param y
   *          the y-coordinate
   * @return whether or not point is in the thing
   */
  VectorRegister3                             threadUnsafeContainmentScratch = new VectorRegister8();

  /**
   * @param document
   *          owner of the thing
   * @param node
   *          where the data for the thing comes from
   */
  protected Thing(final Document document, final ThingData node) {
    super(document, node);

    this.defaultMouseInteraction = new DefaultMouseInteraction(this, transform) {
      @Override
      protected ThingInteraction startTargetAdjustedInteraction(AdjustedMouseEvent event) {
        return Thing.this.startTargetAdjustedInteraction(event);
      }
      
      @Override
      protected void iterateMovers(Set<ThingInteraction> interactions, AdjustedMouseEvent event) {
        Thing.this.iterateMovers(interactions, event);
      }
    };
    

    
    doodadCache = new AdaptThingSpaceDoodadsIntoWorldSpace(transform, this);
  }

  /**
   * iterate all the selection movers
   *
   * @param interactions
   *          the interactions to be built
   * @param event
   *          the event in world space
   */
  public void addSelectionMovers(final Set<MouseInteraction> interactions, final AdjustedMouseEvent event) {
    defaultMouseInteraction.addSelectionMovers(interactions, event, this);
  }

  /**
   * take the given event, and bind it to this object
   *
   * @param event
   */
  public void adjustAndBindEvent(final AdjustedMouseEvent event) {
    writeToTarget(event.position);
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

  protected abstract void cacheSelection();

  public boolean contains(final double x, final double y) {
    threadUnsafeContainmentScratch.set_0(x, y);
    writeToTarget(threadUnsafeContainmentScratch);
    return doesContainTargetPoint(threadUnsafeContainmentScratch.x_1, threadUnsafeContainmentScratch.y_1);
  }

  public boolean deleted() {
    return lifetime.isDeleted();
  }

  /**
   * What are the possible no-argument actions that are available
   *
   * @param actions
   *          where to accumulate actions
   */
  protected abstract void describePossibleActions(List<String> actions);

  /**
   * is the given point inside the object
   *
   * @param x
   *          the x-coordinate to check
   * @param y
   *          the y-coordinate to check
   * @return true if the point is in the thing
   */
  protected abstract boolean doesContainTargetPoint(double x, double y);

  /**
   * The user clicked while we have a selection, did that point land in our existing selection
   *
   * @param event
   *          the event in thing space
   * @return true if the point is in the selection
   */
  protected abstract boolean doesPointApplyToSelection(AdjustedMouseEvent event);

  /**
   * draw the thing in thing space
   *
   * @param gc
   *          the graphics context
   */
  protected abstract void draw(GraphicsContext gc);

  /**
   * execute an action
   *
   * @param action
   *          the action to execute
   */
  protected abstract Object executeAction(String action);

  /**
   * {@inheritDoc}
   */
  @Override
  public List<String> getActions() {
    final ArrayList<String> actions = new ArrayList<>();
    actions.addAll(getActionsAvailable());
    describePossibleActions(actions);
    return actions;
  }


  @Override
  public Object invoke(final String action) {

    if ("?".equals(action)) {
      return getActions();
    }

    invokeAction(action);

    if ("unselect".equals(action)) {
      unselect();
      return true;
    }
    if ("templatize".equals(action)) {
      final HashMap<String, String> template = new HashMap<String, String>();
      for (final Entry<String, Edit> link : getLinks(false).entrySet()) {
        template.put(link.getKey(), link.getValue().getAsText());
      }
      document.templates.put(identity.name.getAsText(), template);
      return true;
    }
    return executeAction(action);
  }

  /**
   * is the given point in the selection?
   *
   * @param document
   * @param event
   * @return
   */
  public boolean isInCurrertSelection(final AdjustedMouseEvent event) {
    if (!selected()) {
      return false;
    }
    adjustAndBindEvent(event);
    return doesPointApplyToSelection(event);
  }

  /**
   * we intend to move things in bulk
   *
   * @param interactions
   *          where to accumulate all the ways to interact with objects
   * @param event
   *          the event in targete space
   */
  protected abstract void iterateMovers(Set<ThingInteraction> interactions, AdjustedMouseEvent event);

  /**
   * we are about to start a new interaction, what should we do?
   *
   * @param event
   *          the event in world space
   */
  public void preInteract(final AdjustedMouseEvent event) {
    if (!event.altdown) {
      unselect();
    }
  }

  public void preSelectionWindow() {
    defaultMouseInteraction.aboutToBeginSelectionBasedOnWindow();
    cacheSelection();
  }

  public Color query(final double x, final double y) {
    final VectorRegister6 W = new VectorRegister6();
    W.set_0(x, y);
    writeToTarget(W);
    return queryTargetColor(W.x_1, W.y_1);
  }

  public abstract Color queryTargetColor(double x, double y);

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
    if (!editing.locked.value() && selected()) {
      for (final ControlDoodad doodad : doodadCache.getDoodadsInWorldSpace()) {

        if (doodad.type == Type.Scale) {
          gc.drawImage(document.SCALE_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
        } else if (doodad.type == Type.Rotate) {
          gc.drawImage(document.ROTATE_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
        } else if (doodad.type == Type.PointSelected) {
          gc.drawImage(document.VERTEX_ICON_SELECTED, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
        } else if (doodad.type == Type.PointUnselected) {
          gc.drawImage(document.VERTEX_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
        }
      }
    }

    gc.save();
    gc.translate(camera.tX, camera.tY);
    gc.scale(camera.scale, camera.scale);
    transform.readyGraphicsContext(gc);
    draw(gc);
    gc.restore();
  }

  /**
   * @return is the thing selected?
   */
  public boolean selected() {
    return editing.selected.value();
  }

  /**
   * @param p
   * @return does the given polygon intersect this thing
   */
  protected abstract boolean selectionIntersect(Polygon p, Mode mode);

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
    final MouseInteraction mi = startInteractionReal(event);
    if (editing.locked.value()) {
      return null;
    }
    return mi;
  }

  private MouseInteraction startInteractionReal(final AdjustedMouseEvent event) {
    adjustAndBindEvent(event);
    
    ThingInteraction interaction = defaultMouseInteraction.start(event);
    if (interaction == null) {
      return null;
    }
    document.history.register(this);

    return new ThingInteractionToMouseIteractionAdapter(document.history, interaction, transform);
  }

  protected abstract ThingInteraction startTargetAdjustedInteraction(AdjustedMouseEvent event);

  /**
   * update any state before we render
   */
  @Override
  public abstract void update();

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
