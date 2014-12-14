package io.jeffrey.world.things.core;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.GuideLine;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.interactions.ThingRotater;
import io.jeffrey.world.things.interactions.ThingScaler;
import io.jeffrey.world.things.interactions.ThingSnapper;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

public abstract class Thing extends ThingCore {
    /**
     * does the thing the given (x,y) point in world space
     *
     * @param x
     *            the x-coordinate
     * @param y
     *            the y-coordinate
     * @return whether or not point is in the thing
     */
    VectorRegister3         threadUnsafeContainmentScratch = new VectorRegister8();

    /**
     * cached allocation of the doodads
     */
    private ControlDoodad[] worldDoodads;

    /**
     * @param document
     *            owner of the thing
     * @param node
     *            where the data for the thing comes from
     */
    protected Thing(final Document document, final ThingData node) {
        super(document, node);
        worldDoodads = new ControlDoodad[0];
    }

    /**
     * iterate all the selection movers
     *
     * @param interactions
     *            the interactions to be built
     * @param event
     *            the event in world space
     */
    public void addSelectionMovers(final Set<MouseInteraction> interactions, final AdjustedMouseEvent event) {
        if (locked.value() || deleted.value()) {
            return;
        }
        if (!selected()) {
            return;
        }
        adjustAndBindEvent(event);
        final HashSet<ThingInteraction> local = new HashSet<>();
        iterateMovers(local, event);
        final Set<GuideLine> lines = document.getGuideLines(layer.getAsText());

        GuideLineEnforcer enforcer = null;
        if (lines.size() > 0) {
            enforcer = getGuideLineEnforcer();
        }
        for (final ThingInteraction itRaw : local) {
            final ThingInteraction it;
            if (lines.size() > 0 && enforcer != null) {
                it = new ThingSnapper(lines, enforcer, itRaw);
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
     *            the selection window
     */
    public void applySelection(final SelectionWindow window) {
        if (deleted.value()) {
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
        final boolean touches = intersect(polygon);
        if (touches) {
            selected.value(true);
        } else {
            unselect();
        }
    }

    public boolean contains(final double x, final double y) {
        threadUnsafeContainmentScratch.set_0(x, y);
        writeToTarget(threadUnsafeContainmentScratch);
        return doesContainTargetPoint(threadUnsafeContainmentScratch.x_1, threadUnsafeContainmentScratch.y_1);
    }

    /**
     * What are the possible no-argument actions that are available
     *
     * @param actions
     *            where to accumulate actions
     */
    protected abstract void describePossibleActions(List<String> actions);

    /**
     * is the given point inside the object
     *
     * @param x
     *            the x-coordinate to check
     * @param y
     *            the y-coordinate to check
     * @return true if the point is in the thing
     */
    protected abstract boolean doesContainTargetPoint(double x, double y);

    /**
     * The user clicked while we have a selection, did that point land in our existing selection
     *
     * @param event
     *            the event in thing space
     * @return true if the point is in the selection
     */
    protected abstract boolean doesPointApplyToSelection(AdjustedMouseEvent event);

    /**
     * draw the thing in thing space
     *
     * @param gc
     *            the graphics context
     */
    protected abstract void draw(GraphicsContext gc);

    /**
     * execute an action
     *
     * @param action
     *            the action to execute
     */
    protected abstract void executeAction(String action);

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
        if (deleted.value()) {
            actions.add("undelete");
        } else {
            actions.add("delete");
        }
        if (locked.value()) {
            actions.add("unlock");
        } else {
            actions.add("lock");
        }
        if (selected()) {
            actions.add("unselect");
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

    /**
     * @param p
     * @return does the given polygon intersect this thing
     */
    protected abstract boolean intersect(Polygon p);

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
     *            where to accumulate all the ways to interact with objects
     * @param event
     *            the event in targete space
     */
    protected abstract void iterateMovers(Set<ThingInteraction> interactions, AdjustedMouseEvent event);

    /**
     * {@inheritDoc}
     */
    @Override
    public void perform(final String action) {
        if ("reset.angle".equals(action)) {
            angle(0);
        }
        if ("normalize.scale".equals(action)) {
            final double s = (sx() + sy()) / 2.0;
            sx(s);
            sy(s);
        }
        if ("push.down".equals(action)) {
            order.value(order.value() - 1.5);
        }
        if ("bring.up".equals(action)) {
            order.value(order.value() + 1.5);
        }
        if ("delete".equals(action)) {
            deleted.value(true);
        }
        if ("undelete".equals(action)) {
            deleted.value(false);
        }
        if ("lock".equals(action)) {
            locked.value(true);
        }
        if ("unlock".equals(action)) {
            locked.value(false);
        }
        if ("unselect".equals(action)) {
            unselect();
        }
        executeAction(action);
    }

    /**
     * we are about to start a new interaction, what should we do?
     *
     * @param event
     *            the event in world space
     */
    public void preInteract(final AdjustedMouseEvent event) {
        if (!event.event.isAltDown()) {
            unselect();
        }
    }

    /**
     * render the thing according to the camera
     *
     * @param gc
     *            the graphics context
     * @param camera
     *            where the user is at
     */
    public void render(final GraphicsContext gc, final Camera camera) {
        if (deleted.value()) {
            return;
        }
        cacheAngle();
        if (!locked.value() && selected()) {
            for (final ControlDoodad doodad : getDoodadsInWorldSpace()) {

                if (doodad.type == Type.Scale && slock.value()) {
                    continue;
                }
                if (doodad.type == Type.Rotate && alock.value()) {
                    continue;
                }

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
        gc.translate(x.value(), y.value());
        gc.rotate(-angle.value());
        gc.scale(sx.value(), sy.value());
        draw(gc);
        gc.restore();
    }

    /**
     * @return is the thing selected?
     */
    public boolean selected() {
        return selected.value();
    }

    /**
     * start a new interaction
     *
     * @param event
     *            the world space event
     * @return a mouse interaction to manipulate things (or null if nothing to do)
     */
    public MouseInteraction startInteraction(final AdjustedMouseEvent event) {
        if (deleted.value()) {
            return null;
        }
        final MouseInteraction mi = startInteractionReal(event);
        if (locked.value()) {
            return null;
        }
        return mi;
    }

    private MouseInteraction startInteractionReal(final AdjustedMouseEvent event) {
        adjustAndBindEvent(event);
        ThingInteraction interaction = null;
        final VectorRegister3 W = new VectorRegister3();
        for (final ControlDoodad doodad : getDoodadsInThingSpace()) {
            if (locked.value()) {
                break;
            }
            if (interaction != null) {
                break;
            }
            if (doodad.type == Type.Scale && slock.value()) {
                break;
            }
            if (doodad.type == Type.Rotate && alock.value()) {
                break;
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
            final Set<GuideLine> lines = document.getGuideLines(layer.getAsText());
            if (lines.size() > 0) {
                final GuideLineEnforcer enforcer = getGuideLineEnforcer();
                if (enforcer != null) {
                    interaction = new ThingSnapper(lines, enforcer, interaction);
                }
            }
        }

        selected.value(true);
        // check document to see if the alignment
        return new ThingInteractionToMouseIteractionAdapter(document.history, interaction, this);
    }

    protected abstract ThingInteraction startTargetAdjustedInteraction(AdjustedMouseEvent event);

    /**
     * update any state before we render
     */
    public abstract void update();

    /**
     * convert the given (_x,_y) at vector 0 in world space into target space and write to vector 1 (vector 2 is used as scratch space)
     *
     * @param _x
     *            the x coordinate in thing/target space
     * @param _y
     *            the y coordinate in thing/target space
     * @return a vector representing the point in world space
     */
    public void writeToTarget(final VectorRegister3 reg) {
        reg.copy_from_0_to_1();
        reg.set_2(x.value(), y.value());
        reg.sub_2_from_1();
        reg.set_2(cx, cy);
        reg.complex_mult_2_1();
        // add sheer to vector register
        reg.x_1 /= sx.value();
        reg.y_1 /= sy.value();
    }

    /**
     * convert the given (_x,_y) at vector 0 in thing/target space into world space and write to vector 1 (vector 2 is used as scratch space)
     *
     * @param _x
     *            the x coordinate in thing/target space
     * @param _y
     *            the y coordinate in thing/target space
     * @return a vector representing the point in world space
     */
    public void writeToWorld(final VectorRegister3 reg) {
        reg.copy_from_0_to_1();
        // add sheer
        reg.x_1 *= sx.value();
        reg.y_1 *= sy.value();
        reg.set_2(cx, -cy);
        reg.complex_mult_2_1();
        reg.set_2(x.value(), y.value());
        reg.add_2_to_1();
    }
}
