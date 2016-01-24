package io.jeffrey.world.things.behaviors.structs;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public class SelectionModel {

  private Polygon               cachedPolygon;

  public final Mode             mode;
  private final Transform       transform;
  private final SelectionWindow window;

  public SelectionModel(final SelectionWindow window, final Transform transform, final Mode mode) {
    this.window = window;
    this.transform = transform;
    this.mode = mode;
    cachedPolygon = null;
  }

  private Polygon computePolygon() {
    final double[] adjusted = window.rect();
    final VectorRegister3 scratch = new VectorRegister8();
    for (int k = 0; k < 8; k += 2) {
      scratch.set_0(adjusted[k], adjusted[k + 1]);
      transform.writeToThingSpace(scratch);
      adjusted[k] = scratch.x_1;
      adjusted[k + 1] = scratch.y_1;
    }
    return new Polygon(adjusted);
  }

  public Polygon getPolygon() {
    if (cachedPolygon == null) {
      cachedPolygon = computePolygon();
    }
    return cachedPolygon;
  }
}
