package io.jeffrey.world.things.points;

import io.jeffrey.world.things.behaviors.HasUpdate;

/**
 * a bi-direction link to a point inside of a polygon
 *
 * @author jeffrey
 *
 */
public class EventedPoint2 {
  public final SelectablePoint2 data;
  public final double           initialX;
  public final double           initialY;
  private final HasUpdate       update;

  public EventedPoint2(final SelectablePoint2 data, final HasUpdate update) {
    initialX = data.x;
    initialY = data.y;
    this.data = data;
    this.update = update;
  }

  public void reset() {
    setChange(0, 0);
  }

  public void setChange(final double dx, final double dy) {
    data.selected = true;
    data.x = initialX + dx;
    data.y = initialY + dy;
    update.update();
  }
}