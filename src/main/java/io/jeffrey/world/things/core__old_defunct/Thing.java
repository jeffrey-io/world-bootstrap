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
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.interactions.ThingRotater;
import io.jeffrey.world.things.interactions.ThingScaler;
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

public abstract class Thing extends ThingCore {
  private boolean         alreadySelected                = false;

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
   * cached allocation of the doodads
   */
  private ControlDoodad[] worldDoodads;

  /**
   * @param document
   *          owner of the thing
   * @param node
   *          where the data for the thing comes from
   */
  protected Thing(final Document document, final ThingData node) {
    super(document, node);
    worldDoodads = new ControlDoodad[0];
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
    if (editing.locked.value() || lifetime.isDeleted()) {
      return;
    }
    if (!selected()) {
      return;
    }
    adjustAndBindEvent(event);
    final HashSet<ThingInteraction> local = new HashSet<>();
    iterateMovers(local, event);
    final Collection<GuideLine> lines = document.getGuideLines(layer.getAsText());

    GuideLineEnforcer enforcer = null;
    if (lines.size() > 0) {
      enforcer = getGuideLineEnforcer();
    }
    for (final ThingInteraction itRaw : local) {
      final ThingInteraction it;
      if (lines.size() > 0 && enforcer != null) {
        it = new ThingSnapper(document.camera, lines, enforcer, itRaw);
      } else {
        it = itRaw;
      }
      interactions.add(new ThingInteractionToMouseIteractionAdapter(document.history, it, this));
    }
  }

  /**
   * take the given event, and bind it to this object
   *
   * @param event
   */
  public void adjustAndBindEvent(final AdjustedMouseEvent event) {
    writeToTarget(event.position);
    event.userdata = this;
  }

  /**
   * take the given selection window and test whether or not it intersects the thing
   *
   * @param window
   *          the selection window
   */
  public void applySelection(final SelectionWindow window) {
    if (lifetime.isDeleted()) {
      return;
    }
    final double[] adjusted = window.rect();
    final VectorRegister3 scratch = new VectorRegister8();
    for (int k = 0; k < 8; k += 2) {
      scratch.set_0(adjusted[k], adjusted[k + 1]);
      writeToTarget(scratch);
      adjusted[k] = scratch.x_1;
      adjusted[k + 1] = scratch.y_1;
    }
    final Polygon polygon = new Polygon(adjusted);
    final boolean touches = selectionIntersect(polygon, window.mode);
    final boolean shouldSelect = window.mode.selected(alreadySelected, touches);
    if (shouldSelect) {
      editing.selected.value(true);
    } else {
      unselect();
    }
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
    actions.add("reset.angle");
    actions.add("normalize.scale");
    actions.add("bring.up");
    actions.add("push.down");
    if (lifetime.isDeleted()) {
      actions.add("undelete");
    } else {
      actions.add("delete");
    }
    if (editing.locked.value()) {
      actions.add("unlock");
    } else {
      actions.add("lock");
    }
    if (selected()) {
      actions.add("unselect");
    }
    if (!locklock.value()) {
      actions.add("templatize");
    }
    describePossibleActions(actions);
    return actions;
  }

  /**
   * @return all the doodads in target space
   */
  protected abstract ControlDoodad[] getDoodadsInThingSpace();

  /**
   * @return all the control doodads in the world space for rendering
   */
  public ControlDoodad[] getDoodadsInWorldSpace() {
    final ControlDoodad[] original = getDoodadsInThingSpace();
    if (worldDoodads.length != original.length) {
      worldDoodads = new ControlDoodad[original.length];
      for (int k = 0; k < original.length; k++) {
        worldDoodads[k] = new ControlDoodad(Type.PointUnselected, 0.0, 0.0);
      }
    }
    final VectorRegister3 W = new VectorRegister3();
    for (int k = 0; k < original.length; k++) {
      final ControlDoodad doodad = original[k];
      W.set_0(doodad.u, doodad.v);
      writeToWorld(W);
      final ControlDoodad world = worldDoodads[k];
      world.type = doodad.type;
      world.u = W.x_1;
      world.v = W.y_1;
    }
    return worldDoodads;
  }

  /**
   * @return a new link to align this in real time
   */
  protected abstract GuideLineEnforcer getGuideLineEnforcer();

  @Override
  public Object invoke(final String action) {

    if ("?".equals(action)) {
      return getActions();
    }

    if ("reset.angle".equals(action)) {
      angle(0);
      return true;
    }
    if ("normalize.scale".equals(action)) {
      final double s = (sx() + sy()) / 2.0;
      sx(s);
      sy(s);
      return true;
    }
    if ("push.down".equals(action)) {
      order.value(order.value() - 1.5);
      return true;
    }
    if ("bring.up".equals(action)) {
      order.value(order.value() + 1.5);
      return true;
    }
    if ("delete".equals(action)) {
      delete();
      return true;
    }
    if ("undelete".equals(action)) {
      lifetime.undelete();
      return true;
    }
    if ("lock".equals(action)) {
      editing.locked.value(true);
      return true;
    }
    if ("unlock".equals(action)) {
      editing.locked.value(false);
      return true;
    }
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
    alreadySelected = editing.selected.value();
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
      for (final ControlDoodad doodad : getDoodadsInWorldSpace()) {

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
    ThingInteraction interaction = null;
    final VectorRegister3 W = new VectorRegister3();
    for (final ControlDoodad doodad : getDoodadsInThingSpace()) {
      if (editing.locked.value()) {
        break;
      }
      if (interaction != null) {
        break;
      }
      if (!transform.allowed(doodad.type)) {
        continue;
      }

      W.set_0(doodad.u, doodad.v);
      writeToWorld(W);
      final double d = event.doodadDistance(W.x_1, W.y_1);
      if (d <= document.controlPointSize) {
        if (doodad.type == Type.PointSelected || doodad.type == Type.PointSelected) {
          break;
        }
        if (doodad.type == Type.Scale) {
          interaction = new ThingScaler(event);
        }
        if (doodad.type == Type.Rotate) {
          interaction = new ThingRotater(event);
        }
      }
    }
    if (interaction == null) {
      interaction = startTargetAdjustedInteraction(event);
    }
    if (interaction == null) {
      return null;
    }
    if (interaction instanceof ThingMover) {
      final Collection<GuideLine> lines = document.getGuideLines(layer.getAsText());
      if (lines.size() > 0) {
        final GuideLineEnforcer enforcer = getGuideLineEnforcer();
        if (enforcer != null) {
          interaction = new ThingSnapper(document.camera, lines, enforcer, interaction);
        }
      }
    }

    editing.selected.value(true);
    // check document to see if the alignment
    return new ThingInteractionToMouseIteractionAdapter(document.history, interaction, this);
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
    transform.writeToTarget(reg);
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
    transform.writeToWorld(reg);
  }
}
