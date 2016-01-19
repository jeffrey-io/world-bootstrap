package io.jeffrey.world.things.base;

public abstract class AbstractThingSingleItemCache<T> {

  private AbstractThing thing;
  private long cachedAt;
  private T cached;
  
  public AbstractThingSingleItemCache(AbstractThing thing) {
    this.thing = thing;
    this.cachedAt = -1;
    this.cached = null;
  }
  
  protected abstract T compute();
  
  public T get() {
    long current = thing.getSequencer();
    if (current != cachedAt || cached == null) {
      cached = compute();
      cachedAt = current;
    }
    return cached;
  }
}
