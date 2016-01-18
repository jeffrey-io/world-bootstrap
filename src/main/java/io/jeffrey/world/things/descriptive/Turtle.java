package io.jeffrey.world.things.descriptive;

import java.util.ArrayList;

import io.jeffrey.vector.VectorRegister1;

public class Turtle {
  private double                           dx = 1.0;
  private double                           dy = 0.0;
  private final ArrayList<VectorRegister1> path;
  private double                           x  = 0.0;

  private double                           y  = 0;

  public Turtle() {
    path = new ArrayList<>();
    mark();
  }

  public void forward(final double amount) {
    x += dx * amount;
    y += dy * amount;
    mark();
  }

  private void mark() {
    final VectorRegister1 step = new VectorRegister1();
    step.x_0 = x;
    step.y_0 = y;
    path.add(step);
  }

  @Override
  public String toString() {
    final String[] components = new String[2 * path.size()];
    int at = 0;
    for (final VectorRegister1 step : path) {
      components[2 * at] = Double.toString(step.x_0);
      components[2 * at + 1] = Double.toString(step.y_0);
      at++;
    }
    return String.join(",", components);
  }

  public void turn(final double angle_degrees) {
    final double u = Math.cos(angle_degrees / 57.2958);
    final double v = Math.sin(angle_degrees / 57.2958);
    final double t = dx * u - dy * v;
    dy = dy * u + dx * v;
    dx = t;
  }
}
