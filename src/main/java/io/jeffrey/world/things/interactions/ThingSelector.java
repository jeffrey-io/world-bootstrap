package io.jeffrey.world.things.interactions;

import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.zer.AdjustedMouseEvent;

public class ThingSelector implements ThingInteraction {

  private final EditingPart editing;

  public ThingSelector(final EditingPart editing) {
    this.editing = editing;
  }

  @Override
  public void cancel() {
  }

  @Override
  public void commit() {
  }

  @Override
  public void moved(final AdjustedMouseEvent event) {
  }

  @Override
  public void select() {
    editing.selected.value(true);
  }
}
