package io.jeffrey.world.things.core;

public abstract class AbstractThingSingleItemCache<T> {

  private T                   cached;
  private long                cachedAt;
  private final AbstractThing thing;

  public AbstractThingSingleItemCache(final AbstractThing thing) {
    this.thing = thing;
    this.cachedAt = -1;
    this.cached = null;
  }

  protected abstract T compute();

  public T get() {
    final long current = thing.getSequencer();
    if (current != cachedAt) {
      cached = compute();
      cachedAt = current;
    }
    return cached;
  }
}
