package io.jeffrey.world.ui.hierarchy;

public class Path extends AbstractItem {

  public final String path;
  public final String label;

  public Path(String path, String label) {
    this.path = path;
    this.label = label;
  }

  @Override
  public void open() {
  }

  @Override
  public String label() {
    return label;
  }

}
