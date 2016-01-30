package io.jeffrey.world.things.descriptive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javafx.scene.paint.Color;

public class Turtle {
  private Color                       color = Color.BLACK;
  private double                      dx    = 1.0;
  private double                      dy    = 0.0;
  private final ArrayList<TurtleLine> lines = new ArrayList<>();
  private double                      x     = 0.0;
  private double                      y     = 0;
  private boolean                     draw  = true;
  private final Stack<Double>         stack = new Stack<>();

  public void push() {
    stack.push(x);
    stack.push(y);
  }

  public void pop() {
    y = stack.pop();
    x = stack.pop();
  }

  public void forward(final double amount) {
    if (draw) {
      lines.add(new TurtleLine(color, x, y, x + dx * amount, y + dy * amount));
    }
    x += dx * amount;
    y += dy * amount;
  }

  public void draw(boolean draw) {
    this.draw = draw;
  }

  public void color(String color) {
    this.color = Color.valueOf(color);
  }

  public void turn(final double angle_degrees) {
    final double u = Math.cos(angle_degrees / 57.2958);
    final double v = Math.sin(angle_degrees / 57.2958);
    final double t = dx * u - dy * v;
    dy = dy * u + dx * v;
    dx = t;
  }

  public List<TurtleLine> lines() {
    return Collections.unmodifiableList(lines);
  }
}
