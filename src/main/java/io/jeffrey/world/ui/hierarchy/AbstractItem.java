package io.jeffrey.world.ui.hierarchy;

public abstract class AbstractItem {
  public abstract void open();
  
  public abstract String label();
  
  @Override
  public String toString() {
    return label();
  }
}
