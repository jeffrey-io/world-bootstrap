package io.jeffrey.world.things.core;

public class IdentitySnap implements Snap {

  @Override
  public double x(final double x) {
    return x;
  }

  @Override
  public double y(final double y) {
    return y;
  }

}