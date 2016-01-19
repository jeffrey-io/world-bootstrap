package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Subscribers<T> {

  private final ArrayList<Consumer<T>> events;

  public Subscribers() {
    this.events = new ArrayList<>();
  }

  public void publish(final T value) {
    for (final Consumer<T> event : events) {
      event.accept(value);
    }
  }

  public void subscribe(final Consumer<T> event) {
    this.events.add(event);
  }
}
