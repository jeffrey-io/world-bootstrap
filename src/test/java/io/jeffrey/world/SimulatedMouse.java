package io.jeffrey.world;

import java.util.ArrayList;
import java.util.function.Consumer;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;

public class SimulatedMouse {
  public final Camera camera;

  private final ArrayList<Consumer<AdjustedMouseEvent>> listeners;
  private double x;
  private double y;
  private boolean altdown;
  private boolean ctrldown;

  public SimulatedMouse() {
    this.camera = new Camera();
    this.listeners = new ArrayList<>();
    this.x = 0;
    this.y = 0;
    this.altdown = false;
    this.ctrldown = false;
  }
  
  public void add(Consumer<AdjustedMouseEvent> listener) {
    listeners.add(listener);
  }
  
  public void add(ThingInteraction it) {
    listeners.add(ev -> it.moved(ev) );
  }

  public AdjustedMouseEvent get() {
    return new AdjustedMouseEvent(camera, x, y, altdown, ctrldown);
  }
  
  public void move(double dx, double dy) {
    x += dx;
    y += dy;
    AdjustedMouseEvent event = get();
    event.position.set_1(x, y);
    for (Consumer<AdjustedMouseEvent> listener : listeners) {
      listener.accept(event);
    }
  }
}
