package io.jeffrey.world.things;

import java.util.HashMap;
import java.util.Map;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.polygon.AbstractPointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditString;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * A thing that connects to other things
 *
 * @author jeffrey
 */
public class TConnector extends AbstractPointChain {
  /**
   *
   * Represnets a vertex that is locked by name; this provides the snap-to effect when a node is editted
   *
   * @author jeffrey
   */
  private class LockedVertex {
    private Thing                  currentThing;
    private final EditString       link;
    private final String           name;
    private final SelectablePoint2 pnt;

    public LockedVertex(final SelectablePoint2 pnt, final ThingData node, final String name) {
      link = node.getString(name, "");
      this.pnt = pnt;
      currentThing = null;
      this.name = name;
    }

    private void addEditLink(final HashMap<String, Edit> links) {
      links.put(name, link);
    }

    private void saveOutChild(final Map<String, Object> object) {
      object.put(name, link.value());
    }

    private void update(final Document document) {
      final VectorRegister3 W = new VectorRegister3();
      W.set_0(pnt.x, pnt.y);
      writeToTarget(W);
      currentThing = document.selectFirstVisible(W.x_1, W.y_1);
      if (currentThing != null) {
        updateFast();
      } else {
        link.value("");
      }
    }

    private void updateFast() {
      if (currentThing != null) {
        final VectorRegister3 to = new VectorRegister8();
        to.set_0(currentThing.x(), currentThing.y());
        currentThing.writeToTarget(to);

        pnt.x = to.x_1;
        pnt.y = to.y_1;
        cache.update();
        dirty = false;
        link.value(currentThing.getID());
      }
    }
  }

  private boolean            dirty;
  private final LockedVertex from;
  private final LockedVertex to;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TConnector(final Document document, final ThingData node) {
    super(document, node);
    from = new LockedVertex(chain.at(0), node, "from");
    to = new LockedVertex(chain.at(1), node, "to");
    cache.update();
    dirty = true;
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
    return true;
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

  /**
   * {@inheritDoc}
   */
  @Override
  protected boolean hasStandardControls() {
    return false;
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
    dirty = true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  protected void populatePolygonalEditLinks(final HashMap<String, Edit> links) {
    from.addEditLink(links);
    to.addEditLink(links);
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
    from.saveOutChild(object);
    to.saveOutChild(object);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void update() {
    if (dirty) {
      from.update(document);
      to.update(document);
    } else {
      from.updateFast();
      to.updateFast();
    }
    dirty = false;
  }
}
