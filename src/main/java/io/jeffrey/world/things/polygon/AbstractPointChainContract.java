package io.jeffrey.world.things.polygon;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.EdgedThing;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.Edit;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

/**
 * Making life simple, this class acts as an easy way to document the responsibilities AbstractPointChain.
 *
 * @author jeffrey
 *
 */
public abstract class AbstractPointChainContract extends EdgedThing {

    protected AbstractPointChainContract(final Document document, final ThingData node) {
        super(document, node);
    }

    /**
     * @return whether or not edge selection is allowed
     */
    protected abstract boolean allowEdgeSelect();

    /**
     * @return are the number of points allowed to grow/decrease
     */
    protected abstract boolean areTheNumberOfPointsFixed();

    /**
     *
     * @param document
     *            the document that contains all
     * @param event
     *            the mouse event in the target space
     * @return does the given click maintain the selection of this polygon
     */
    protected abstract boolean doesPointApplyMaintainSelection(Document document, AdjustedMouseEvent event);

    /**
     * @param poly
     *            the given polygon (i.e. a selection window)
     * @return does the given polygon intersect with the subclassing figure
     */
    protected abstract boolean doesPolygonIntersect(Polygon poly);

    /**
     * @return whether or not the subclassing polygon support scaling and rotation
     */
    protected abstract boolean hasStandardControls();

    /**
     * @return is the polygon a connected loop
     */
    protected abstract boolean isPolygonLooped();

    /**
     * event to notify the subclass that the cache has been updated
     */
    protected abstract void onCacheUpdated();

    /**
     * link the things that can be edited up stream
     *
     * @param links
     *            a map containing all the ways the metadata editor can peer inside
     */
    protected abstract void populatePolygonalEditLinks(HashMap<String, Edit> links);

    /**
     * draw the specifics of the polygon
     *
     * @param document
     *            the document that contains all
     * @param gc
     *            the graphics context where images are placed
     */
    protected abstract void renderPolygon(final Document document, final GraphicsContext gc);

    /**
     * write the specific polygonal properties out to disk
     *
     * @param object
     *            the map containing all the objects to be put to disk/network
     */
    protected abstract void saveOutPolygonalProperties(Map<String, Object> object);
}
