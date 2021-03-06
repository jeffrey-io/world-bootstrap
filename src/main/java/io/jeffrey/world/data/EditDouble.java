package io.jeffrey.world.data;

/**
 * A link between text and double
 *
 * @author jeffrey
 *
 */
public class EditDouble extends EditPrimitive<Double> {
  /**
   * @param name
   *          the unique name of the field
   * @param v
   *          the value
   */

  public EditDouble(final String name, final Double v) {
    super(name, v);
  }

  /**
   * @param dv
   *          the quantity added to the value
   */
  public void add(final double dv) {
    value(value() + dv);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getAsText() {
    return Double.toString(value());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean setByTextWithPublishing(final String txt) {
    try {
      this.value(Double.parseDouble(txt));
      return true;
    } catch (final NumberFormatException nfe) {
      return false;
    }
  }

}
