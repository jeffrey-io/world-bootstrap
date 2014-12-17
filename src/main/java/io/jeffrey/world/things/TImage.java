package io.jeffrey.world.things;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.EdgedThing;
import io.jeffrey.world.things.core.GuideLineEnforcer;
import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditString;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 * A thing that is an image
 *
 * @author jeffrey
 *
 */
public class TImage extends EdgedThing {
    private final ImageCache      cache;
    private final ControlDoodad[] doodads;
    private Image                 img  = null;
    private Rectangle             rect = null;
    private final EditString      uri;

    /**
     * @param document
     *            the owner of the thing
     * @param node
     *            where the data for the thing iss
     */
    public TImage(final Document document, final ThingData node) {
        super(document, node);
        cache = document.imageCache;
        doodads = new ControlDoodad[8];
        this.sx(node.getDouble("sx", 0.1).value());
        this.sy(node.getDouble("sy", 0.1).value());
        uri = node.getString("uri", "");
        refresh();
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
        return rect.contains(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean doesPointApplyToSelection(final AdjustedMouseEvent event) {
        refresh();
        return rect.contains(event.position.x_1, event.position.y_1);
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

    @Override
    public double[] edges() {
        final double[] edges = new double[16];
        final VectorRegister3 W = new VectorRegister8();
        W.set_0(-rect.getWidth() / 2, -rect.getHeight() / 2);
        writeToWorld(W);
        W.extract_1(edges, 0);
        W.set_0(rect.getWidth() / 2, -rect.getHeight() / 2);
        writeToWorld(W);
        W.extract_1(edges, 2);
        edges[4] = edges[2];
        edges[5] = edges[3];
        W.set_0(rect.getWidth() / 2, rect.getHeight() / 2);
        writeToWorld(W);
        W.extract_1(edges, 6);
        edges[8] = edges[6];
        edges[9] = edges[7];
        W.set_0(-rect.getWidth() / 2, rect.getHeight() / 2);
        writeToWorld(W);
        W.extract_1(edges, 10);
        edges[12] = edges[10];
        edges[13] = edges[11];
        edges[14] = edges[0];
        edges[15] = edges[1];
        return edges;
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
    protected ControlDoodad[] getDoodadsInThingSpace() {
        refresh();
        return doodads;
    }

    @Override
    protected GuideLineEnforcer getGuideLineEnforcer() {
        return null;
        // return new EdgeEnforcer(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean intersect(final Polygon p) {
        refresh();
        return Shape.intersect(rect, p).getBoundsInLocal().getWidth() > 0;
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
        interactions.add(new ThingMover(event));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void populateLinks(final HashMap<String, Edit> links) {
        links.put("uri", uri);
    }

    /**
     * helper: update the image based on the cache
     */
    private void refresh() {
        img = cache.of(document.find(uri.value()));
        update(img);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
        refresh();
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
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update() {
    }

    /**
     * update the boundaries and the doodads
     *
     * @param img
     *            the image
     */
    private void update(final Image img) {
        if (img != null) {
            rect = new Rectangle(-img.getWidth() / 2, -img.getHeight() / 2, img.getWidth(), img.getHeight());
        } else {
            rect = new Rectangle(-100, -100, 200, 200);
        }
        doodads[0] = new ControlDoodad(Type.Rotate, 0, rect.getHeight() / 2);
        doodads[1] = new ControlDoodad(Type.Rotate, 0, -rect.getHeight() / 2);
        doodads[2] = new ControlDoodad(Type.Rotate, -rect.getWidth() / 2, 0);
        doodads[3] = new ControlDoodad(Type.Rotate, rect.getWidth() / 2, 0);
        doodads[4] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, -rect.getHeight() / 2);
        doodads[5] = new ControlDoodad(Type.Scale, -rect.getWidth() / 2, rect.getHeight() / 2);
        doodads[6] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, -rect.getHeight() / 2);
        doodads[7] = new ControlDoodad(Type.Scale, rect.getWidth() / 2, rect.getHeight() / 2);
    }
}
