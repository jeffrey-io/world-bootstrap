package io.jeffrey.world.document;

import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;

public class DocumentInteractionCapture implements MouseInteraction {

  private final Document         document;
  private final MouseInteraction delegate;

  public DocumentInteractionCapture(Document document, MouseInteraction delegate) {
    this.document = document;
    this.delegate = delegate;
    document.setInteracting(true);
  }

  @Override
  public void cancel() {
    delegate.cancel();
    document.setInteracting(false);
  }

  @Override
  public void commit() {
    delegate.commit();
    document.setInteracting(false);
  }

  @Override
  public void moved(AdjustedMouseEvent event) {
    delegate.moved(event);
  }
}
