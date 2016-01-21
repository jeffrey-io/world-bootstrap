package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class LazyPolygonPart implements Part, IsSelectable {

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
  public boolean selectionIntersect(final Polygon incoming, final Mode mode) {
    if (polygon == null) {
      return false;
    }
    return Shape.intersect(incoming, polygon).getBoundsInLocal().getWidth() > 0;
  }

  public void set(final Polygon polygon) {
    this.polygon = polygon;
  }

}
