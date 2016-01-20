package io.jeffrey.world.things.polygon;

import java.util.HashMap;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.BasicThing;
import io.jeffrey.world.things.behaviors.HasEdgesInWorldSpace;
import io.jeffrey.zer.edits.Edit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Polygon;

/**
 * Making life simple, this class acts as an easy way to document the responsibilities AbstractPointChain.
 *
 * @author jeffrey
 *
 */
public abstract class AbstractPointChainContract extends BasicThing implements HasEdgesInWorldSpace {

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
   * @param poly
   *          the given polygon (i.e. a selection window)
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
   *          a map containing all the ways the metadata editor can peer inside
   */
  protected abstract void populatePolygonalEditLinks(HashMap<String, Edit> links);

  /**
   * draw the specifics of the polygon
   *
   * @param document
   *          the document that contains all
   * @param gc
   *          the graphics context where images are placed
   */
  protected abstract void renderPolygon(final Document document, final GraphicsContext gc);
}
