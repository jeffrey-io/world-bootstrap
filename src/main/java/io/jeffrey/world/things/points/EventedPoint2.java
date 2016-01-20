package io.jeffrey.world.things.points;

import io.jeffrey.zer.Syncable;

/**
 * a bi-direction link to a point inside of a polygon
 *
 * @author jeffrey
 *
 */
public class EventedPoint2 {
  private final SelectablePoint2 point;
  private final Syncable         sync;
  public final double            x;
  public final double            y;

  public EventedPoint2(final SelectablePoint2 point, final Syncable sync) {
    x = point.x;
    y = point.y;
    this.point = point;
    this.sync = sync;
  }

  public void reset() {
    setChange(0, 0);
  }

  public void setChange(final double dx, final double dy) {
    point.x = x + dx;
    point.y = y + dy;
    sync.sync();
  }
}