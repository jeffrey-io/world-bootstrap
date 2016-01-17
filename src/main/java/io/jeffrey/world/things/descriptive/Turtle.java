package io.jeffrey.world.things.descriptive;

import java.util.ArrayList;
import io.jeffrey.vector.VectorRegister1;

public class Turtle {
  private double dx = 1.0;
  private double dy = 0.0;
  private double x = 0.0;
  private double y = 0;
  
  private final ArrayList<VectorRegister1> path;
  
  public Turtle() {
    this.path = new ArrayList<>();
    mark();
  }
  
  private void mark() {
    VectorRegister1 step = new VectorRegister1();
    step.x_0 = x;
    step.y_0 = y;
    path.add(step);
  }
  
  public void forward(double amount) {
    x += dx * amount;
    y += dy * amount;
    mark();
  }
  
  public void turn(double angle_degrees) {
    double u = Math.cos(angle_degrees / 57.2958);
    double v = Math.sin(angle_degrees / 57.2958);
    double t = dx * u - dy * v;
    dy = dy * u + dx * v;
    dx = t;
  }
  
  @Override
  public String toString() {
    String[] components = new String[2 * path.size()];
    int at = 0;
    for (VectorRegister1 step : path) {
      components[2 * at] = Double.toString(step.x_0);
      components[2 * at + 1] = Double.toString(step.y_0);
      at ++;
    }
    return String.join(",", components);
  }
}
