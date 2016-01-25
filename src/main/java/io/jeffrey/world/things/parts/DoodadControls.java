package io.jeffrey.world.things.parts;

public enum DoodadControls {
  All(8, true, true), None(0, false, false), Rotation(4, false, true), Scale(4, true, false);

  public final boolean rotation;
  public final boolean scale;
  public final int     size;

  private DoodadControls(final int size, final boolean scale, final boolean rotation) {
    this.size = size;
    this.scale = scale;
    this.rotation = rotation;
  }
}