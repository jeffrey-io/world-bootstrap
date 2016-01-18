package io.jeffrey.zer.edits;

import java.util.ArrayList;
import java.util.function.BiConsumer;

/**
 * The base type of something that is linkable
 *
 * @author jeffrey
 */
public abstract class Edit {

  protected ArrayList<BiConsumer<String, String>> subscriptions;

  public Edit() {
    subscriptions = null;
  }

  /**
   * @return a textual representation of the the item in question
   */
  public abstract String getAsText();

  /**
   * @return the pretty name of what is being edited
   */
  public abstract String name();

  /**
   * set the value with the given text by parsing it
   *
   * @param txt
   *          the given text to parse
   * @return true if the value was accepted
   */
  public boolean set(final String txt) {
    if (subscriptions != null) {
      final String before = getAsText();
      if (setByText(txt)) {
        for (final BiConsumer<String, String> event : subscriptions) {
          event.accept(before, txt);
        }
        return true;
      } else {
        return false;
      }
    } else {
      return setByText(txt);
    }
  }

  /**
   * set the value with the given text by parsing it
   *
   * @param txt
   *          the given text to parse
   * @return true if the value was accepted
   */
  protected abstract boolean setByText(String txt);

  public void subscribe(final BiConsumer<String, String> change) {
    if (subscriptions == null) {
      subscriptions = new ArrayList<>();
    }
    subscriptions.add(change);
  }
}
