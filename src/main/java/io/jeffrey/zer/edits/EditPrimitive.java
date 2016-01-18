package io.jeffrey.zer.edits;

import java.util.function.BiConsumer;

/**
 * Defines how to edit a single value
 *
 * @author jeffrey
 */
public abstract class EditPrimitive<T> extends Edit {

  private final String name;
  private T            pValue;

  /**
   * @param name
   *          the name of the value
   * @param v
   *          the initial value
   */
  public EditPrimitive(final String name, final T v) {
    this.name = name;
    pValue = v;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return the value
   */
  public T value() {
    return pValue;
  }

  /**
   * @param v
   *          the new value to set
   */
  public void value(final T v) {
    if (subscriptions != null) {
      String before = this.getAsText();
      this.pValue = v;
      String after = this.getAsText();
      for (BiConsumer<String, String> event : subscriptions) {
        event.accept(before, after);
      }
    } else {
      this.pValue = v;
    }
    
  }
}
