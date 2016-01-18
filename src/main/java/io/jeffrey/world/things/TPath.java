package io.jeffrey.world.things;

import java.util.HashMap;
import java.util.Map;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.polygon.AbstractPointChain;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.Edit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * a point chain that is a path
 *
 * @author jeffrey
 *
 */
public class TPath extends AbstractPointChain {

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPath(final Document document, final ThingData node) {
    super(document, node);
    cache.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean allowEdgeSelect() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean areTheNumberOfPointsFixed() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesContainTargetPoint(final double x, final double y) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPointApplyMaintainSelection(final Document document, final AdjustedMouseEvent event) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPolygonIntersect(final Polygon p) {
    return false;
  }

  @Override
  protected GuideLineEnforcer getGuideLineEnforcer() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean hasStandardControls() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean isPolygonLooped() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void onCacheUpdated() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void populatePolygonalEditLinks(final HashMap<String, Edit> links) {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void renderPolygon(final Document document, final GraphicsContext gc) {
    if (cache.x.length == 0) {
      return;
    }
    gc.setStroke(Color.valueOf(fill.color.getAsText()));
    gc.beginPath();
    final double s = 2.0 / (scale.sx() + scale.sy());
    gc.setLineWidth(s);
    gc.moveTo(cache.x[0], cache.y[0]);
    for (int k = 1; k < cache.y.length; k++) {
      gc.lineTo(cache.x[k], cache.y[k]);
    }
    gc.stroke();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void saveOutPolygonalProperties(final Map<String, Object> object) {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
  }

}
