package io.jeffrey.world;

import java.util.ArrayList;
import java.util.function.Consumer;

import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;

public class SimulatedMouse {
  private final boolean                                 altdown;

  public final Camera                                   camera;
  private final boolean                                 ctrldown;
  private final ArrayList<Consumer<AdjustedMouseEvent>> listeners;
  private double                                        x;
  private double                                        y;

  public SimulatedMouse() {
    camera = new Camera();
    listeners = new ArrayList<>();
    x = 0;
    y = 0;
    altdown = false;
    ctrldown = false;
  }

  public void add(final Consumer<AdjustedMouseEvent> listener) {
    listeners.add(listener);
  }

  public void add(final ThingInteraction it) {
    listeners.add(ev -> it.moved(ev));
  }

  public AdjustedMouseEvent get() {
    return new AdjustedMouseEvent(camera, x, y, altdown, ctrldown);
  }

  public void move(final double dx, final double dy) {
    x += dx;
    y += dy;
    final AdjustedMouseEvent event = get();
    event.position.set_1(x, y);
    for (final Consumer<AdjustedMouseEvent> listener : listeners) {
      listener.accept(event);
    }
  }
}
