package io.jeffrey.world.things.behaviors;

import io.jeffrey.zer.SelectionWindow;

public interface CanBeSelectedByWindow {

  public void beginSelectionWindow();

  public void updateSelectionWindow(final SelectionWindow window);
}
