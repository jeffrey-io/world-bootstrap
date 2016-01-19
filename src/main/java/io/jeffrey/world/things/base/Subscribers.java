package io.jeffrey.world.things.base;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Subscribers<T> {

  private ArrayList<Consumer<T>> events;
  
  public Subscribers() {
    this.events = new ArrayList<>();
  }
  
  public void subscribe(Consumer<T> event) {
    this.events.add(event);
  }
  
  public void publish(T value) {
    for (Consumer<T> event : events) {
      event.accept(value);
    }
  }
}
