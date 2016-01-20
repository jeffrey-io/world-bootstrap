package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Snap;
import io.jeffrey.zer.edits.EditDouble;

public class PositionPart implements Part {
  private final Snap      snap;
  public final EditDouble x;
  public final EditDouble y;

  public PositionPart(final LinkedDataMap data, final Snap snap) {
    x = data.getDouble("x", 0.0);
    y = data.getDouble("y", 0.0);
    this.snap = snap;
  }

  /**
   * @return the current x coordinate value
   */
  public double x() {
    return snap.x(x.value());
  }

  /**
   * @param x
   *          the new x coordinate value
   */
  public void x(final double x) {
    this.x.value(snap.x(x));
  }

  /**
   * @return the current y coordinate value
   */
  public double y() {
    return snap.y(y.value());
  }

  /**
   * @param y
   *          the new y coordinate value
   */
  public void y(final double y) {
    this.y.value(snap.y(y));
  }

}
