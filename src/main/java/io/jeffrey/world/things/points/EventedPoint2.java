package io.jeffrey.world.things.points;

import io.jeffrey.world.things.behaviors.HasUpdate;

/**
 * a bi-direction link to a point inside of a polygon
 *
 * @author jeffrey
 *
 */
public class EventedPoint2 {
  private final SelectablePoint2 point;
  private final HasUpdate        update;
  public final double            x;
  public final double            y;

  public EventedPoint2(final SelectablePoint2 point, final HasUpdate update) {
    x = point.x;
    y = point.y;
    this.point = point;
    this.update = update;
  }

  public void reset() {
    setChange(0, 0);
  }

  public void setChange(final double dx, final double dy) {
    point.selected = true;
    point.x = x + dx;
    point.y = y + dy;
    update.update();
  }
}