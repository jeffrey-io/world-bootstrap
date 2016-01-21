package io.jeffrey.zer.edits;

public abstract class DelegateEdit implements Edit {

  private final Edit delegate;

  public DelegateEdit(final Edit delegate) {
    this.delegate = delegate;
  }

  public abstract boolean acceptSetByText(String value);

  @Override
  public String getAsText() {
    return delegate.getAsText();
  }

  @Override
  public String name() {
    return delegate.name();
  }

  @Override
  public boolean setByText(final String txt) {
    if (acceptSetByText(txt)) {
      return delegate.setByText(txt);
    }
    return false;
  }
}
