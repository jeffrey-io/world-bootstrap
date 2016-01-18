package io.jeffrey.world.things;

import java.util.HashMap;
import java.util.Map;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.enforcer.EdgeEnforcer;
import io.jeffrey.world.things.polygon.AbstractPointChain;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.Edit;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * A thing that is a polygon
 *
 * @author jeffrey
 */
public class TPolygon extends AbstractPointChain {

  private Polygon polygon;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TPolygon(final Document document, final ThingData node) {
    super(document, node);
    cache.update();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean allowEdgeSelect() {
    return true;
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
    return polygon.contains(x, y);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPointApplyMaintainSelection(final Document document, final AdjustedMouseEvent event) {
    return doesContainTargetPoint(event.position.x_1, event.position.y_1);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean doesPolygonIntersect(final Polygon p) {
    return Shape.intersect(p, polygon).getBoundsInLocal().getWidth() > 0;
  }

  @Override
  protected GuideLineEnforcer getGuideLineEnforcer() {
    return new EdgeEnforcer(this, position, rotation);
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
    return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void onCacheUpdated() {
    polygon = new Polygon(cache.inlineXYPairs);
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
    gc.setFill(Color.valueOf(fill.color.getAsText()));
    gc.fillPolygon(cache.x, cache.y, cache.y.length);
    if (selected()) {
      gc.setStroke(Color.RED);
      gc.setLineWidth(2.0 / (scale.sx() + scale.sy()));
      gc.moveTo(-cache.boundingRadiusForControls, 0);
      gc.strokeArc(-cache.boundingRadiusForControls, -cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 2 * cache.boundingRadiusForControls, 0, 3601, ArcType.ROUND);
      gc.strokePolygon(cache.x, cache.y, cache.y.length);
    }
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
