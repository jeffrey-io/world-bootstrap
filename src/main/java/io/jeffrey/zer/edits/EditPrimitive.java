package io.jeffrey.zer.edits;

import java.util.ArrayList;
import java.util.function.BiConsumer;

/**
 * Defines how to edit a single value
 *
 * @author jeffrey
 */
public abstract class EditPrimitive<T> implements Edit {
  private final String                  name;

  private T                             pValue;
  protected ArrayList<BiConsumer<T, T>> subscriptions;

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
   * set the value with the given text by parsing it
   *
   * @param txt
   *          the given text to parse
   * @return true if the value was accepted
   */
  @Override
  public final boolean setByText(final String txt) {
    return false;
  }

  protected abstract boolean setByTextWithPublishing(String txt);

  public void subscribe(final BiConsumer<T, T> change) {
    if (subscriptions == null) {
      subscriptions = new ArrayList<>();
    }
    subscriptions.add(change);
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
      final T before = pValue;
      this.pValue = v;
      for (final BiConsumer<T, T> event : subscriptions) {
        event.accept(before, v);
      }
    } else {
      this.pValue = v;
    }
  }
}
