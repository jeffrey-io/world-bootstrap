package io.jeffrey.world.ui.hierarchy;

public class OpenableItem extends AbstractItem {

  private final String label;

  public OpenableItem(String label) {
    this.label = label;
  }

  @Override
  public void open() {
    
  }

  @Override
  public String label() {
    return this.label;
  }
}
