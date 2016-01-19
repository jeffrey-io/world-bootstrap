package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.behaviors.IsSelectable;
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
  public void act(final String action, final SharedActionSpace space) {
  }

  @Override
  public boolean contains(final double x, final double y) {
    if (polygon == null) {
      return false;
    }
    return polygon.contains(x, y);
  }
  
  @Override
  public boolean doesMouseEventPreserveExistingSelection(AdjustedMouseEvent event) {
    return contains(event.position.x_1, event.position.y_1);
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
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

  @Override
  public void update() {
  }
}