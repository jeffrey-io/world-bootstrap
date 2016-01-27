package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.AdjustedMouseEvent;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class LazyPolygonPart implements Part, IsSelectable {

  private double  boundingRadius;
  private Polygon polygon;

  public LazyPolygonPart() {
    polygon = null;
  }

  @Override
  public boolean contains(final double x, final double y) {
    if (polygon == null) {
      return false;
    }
    return polygon.contains(x, y);
  }

  @Override
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event) {
    return contains(event.position.x_1, event.position.y_1);
  }

  public final Polygon get() {
    return polygon;
  }

  @Override
  public boolean selectionIntersect(final SelectionModel model) {
    if (polygon == null) {
      return false;
    }
    if (model.isOriginCircleSelected(boundingRadius)) {
      return Shape.intersect(model.getPolygon(), polygon).getBoundsInLocal().getWidth() > 0;
    }
    return false;
  }

  public void set(final Polygon polygon, final double boundingRadius) {
    this.boundingRadius = boundingRadius;
    this.polygon = polygon;
  }

}
