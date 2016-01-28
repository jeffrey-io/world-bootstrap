package io.jeffrey.world.data;

/**
 * The base type of something that is linkable
 *
 * @author jeffrey
 */
public interface Edit {

  /**
   * @return a textual representation of the the item in question
   */
  public String getAsText();

  /**
   * @return the pretty name of what is being edited
   */
  public String name();

  /**
   * set the value with the given text by parsing it
   *
   * @param txt
   *          the given text to parse
   * @return true if the value was accepted
   */
  public boolean setByText(String txt);

}
