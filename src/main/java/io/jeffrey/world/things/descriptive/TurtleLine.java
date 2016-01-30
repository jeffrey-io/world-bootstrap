package io.jeffrey.world.things.descriptive;

import javafx.scene.paint.Color;

public class TurtleLine {
  public final Color  color;
  public final double x0;
  public final double y0;
  public final double x1;
  public final double y1;

  public TurtleLine(Color color, double x0, double y0, double x1, double y1) {
    this.color = color;
    this.x0 = x0;
    this.y0 = y0;
    this.x1 = x1;
    this.y1 = y1;
  }
}
