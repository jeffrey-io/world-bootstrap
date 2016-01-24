package io.jeffrey.world.things.behaviors.structs;

import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public class SelectionModel {

  private final Polygon cachedPolygon;
  public final Mode     mode;

  public SelectionModel(final Polygon polygon, final Mode mode) {
    cachedPolygon = polygon;
    this.mode = mode;
  }

  public Polygon getPolygon() {
    return cachedPolygon;
  }
}
