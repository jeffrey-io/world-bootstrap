package io.jeffrey.world.things.interactions;

import java.util.Collection;

import io.jeffrey.world.things.enforcer.GuideLineEnforcer;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

/**
 * Wrap a thing mover and snap the object to the guideline
 *
 * @author jeffrey
 */
public class ThingSnapper implements ThingInteraction {
  private final Camera                camera;
  private final ThingInteraction      delegate;
  private final Collection<GuideLine> lines;
  private final GuideLineEnforcer     link;

  /**
   * @param lines
   *          the guide lines
   * @param link
   *          how to enforce the guide lines
   * @param delegate
   *          the delegate interaction that is updating the object (we will snap after to prevent locking)
   */
  public ThingSnapper(final Camera camera, final Collection<GuideLine> lines, final GuideLineEnforcer link, final ThingInteraction delegate) {
    this.camera = camera;
    this.lines = lines;
    this.link = link;
    this.delegate = delegate;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    delegate.cancel();
  }

  @Override
  public void commit() {
    delegate.commit();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    delegate.moved(event);
    for (final GuideLine line : lines) {
      link.attemptSnapTo(camera, line);
    }
  }

  @Override
  public void select() {
    delegate.select();
  }
}
