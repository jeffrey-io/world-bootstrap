package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.Thing;
import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.enforcer.OriginEnforcer;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.edits.Edit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * A thing that is a circle
 *
 * @author jeffrey
 */
public class TCircle extends Thing {
    private static final Circle   CIRCLE = new Circle(1);
    private final ControlDoodad[] doodads;

    /**
     * @param document
     *            the owning document
     * @param node
     *            where the data is
     */
    public TCircle(final Document document, final ThingData node) {
        super(document, node);
        this.sx(node.getDouble("sx", 64).value());
        this.sy(node.getDouble("sy", 64).value());

        final ArrayList<ControlDoodad> doodads = new ArrayList<>();
        doodads.add(new ControlDoodad(Type.Rotate, -1, 0));
        doodads.add(new ControlDoodad(Type.Rotate, 1, 0));
        doodads.add(new ControlDoodad(Type.Rotate, 0, -1));
        doodads.add(new ControlDoodad(Type.Rotate, 0, 1));
        doodads.add(new ControlDoodad(Type.Scale, 0.7, 0.7));
        doodads.add(new ControlDoodad(Type.Scale, 0.7, -0.7));
        doodads.add(new ControlDoodad(Type.Scale, -0.7, 0.7));
        doodads.add(new ControlDoodad(Type.Scale, -0.7, -0.7));
        this.doodads = doodads.toArray(new ControlDoodad[doodads.size()]);
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
        final double d = x * x + y * y;
        return Math.sqrt(d) <= 1.0;
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
        gc.setFill(Color.valueOf(color.getAsText()));
        gc.fillArc(-1, -1, 2, 2, 0, 360, ArcType.ROUND);
        if (selected()) {
            gc.setStroke(Color.RED);
            gc.setLineWidth(4 / (sx() + sy()));
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
    protected ControlDoodad[] getDoodadsInThingSpace() {
        return doodads;
    }

    @Override
    protected GuideLineEnforcer getGuideLineEnforcer() {
        return new OriginEnforcer(this);
    }

    @Override
    public void invalidate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
        interactions.add(new ThingMover(event));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void populateLinks(final HashMap<String, Edit> links) {
    }

    @Override
    public Color queryTargetColor(final double x, final double y) {
        if (doesContainTargetPoint(x, y)) {
            return Color.valueOf(color.getAsText());
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean selectionIntersect(final Polygon p, final Mode mode) {
        return Shape.intersect(CIRCLE, p).getBoundsInLocal().getWidth() > 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
        if (doesPointApplyToSelection(event)) {
            return new ThingMover(event);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean supportsColor() {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
    }
}
