package io.jeffrey.world.things.behaviors.structs;

import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public class SelectionModel {

  private final double[]        adjusted;
  private Polygon               cachedPolygon;

  public final Mode             mode;
  private final VectorRegister8 scratch;
  private final double[]        wrap;

  public SelectionModel(final SelectionWindow window, final Transform transform, final Mode mode) {
    this.mode = mode;
    scratch = new VectorRegister8();
    adjusted = window.rect();
    wrap = new double[adjusted.length + 2];
    for (int k = 0; k < 8; k += 2) {
      scratch.set_0(adjusted[k], adjusted[k + 1]);
      transform.writeToThingSpace(scratch);
      adjusted[k] = scratch.x_1;
      adjusted[k + 1] = scratch.y_1;
      wrap[k] = scratch.x_1;
      wrap[k + 1] = scratch.y_1;
    }
    wrap[wrap.length - 2] = adjusted[0];
    wrap[wrap.length - 1] = adjusted[1];
    cachedPolygon = null;
  }

  private Polygon computePolygon() {
    return new Polygon(adjusted);
  }

  public Polygon getPolygon() {
    if (cachedPolygon == null) {
      cachedPolygon = computePolygon();
    }
    return cachedPolygon;
  }

  public boolean isCircleSelected(final double x, final double y, final double r) {
    for (int k = 0; k < adjusted.length; k += 2) {
      scratch.set_0(wrap[k], wrap[k + 1]);
      scratch.set_1(wrap[k + 2], wrap[k + 3]);
      scratch.set_2(0, 0);
      scratch.copy_from_1_to_3();
      scratch.sub_0_from_3();
      scratch.copy_from_2_to_4();
      scratch.sub_0_from_4();

      // check if point is on the outside
      if (scratch.planer_cross_at_zero_3_4() < 0) {
        // ok, it is; does it touch the line segment
        final double distance = Lines.minimalDistanceV2toLineSegmentV0V1_Destructive(scratch);
        if (distance >= r) {
          // it does not, so we are done
          return false;
        } else {
          return true;
        }
      }
    }

    // it was not on the outside, so it must be on the instance
    return true;
  }

  public boolean isOriginCircleSelected(final double r) {
    return isCircleSelected(0, 0, r);
  }
}
