package io.jeffrey.world.things.core;

public class RoundingSnap implements Snap {

  @Override
  public double x(final double x) {
    return Math.round(x);
  }

  @Override
  public double y(final double y) {
    return Math.round(y);
  }
}