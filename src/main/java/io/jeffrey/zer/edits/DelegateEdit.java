package io.jeffrey.zer.edits;

public abstract class DelegateEdit extends Edit {
  
  private final Edit delegate;
  
  public DelegateEdit(Edit delegate) {
    this.delegate = delegate;
  }

  @Override
  public String getAsText() {
    return delegate.getAsText();
  }

  @Override
  public String name() {
    return delegate.name();
  }

  @Override
  protected boolean setByText(String txt) {
    if (acceptSetByText(txt)) {
      return delegate.setByText(txt);
    }
    return false;
  }

  public abstract boolean acceptSetByText(String value);
}
