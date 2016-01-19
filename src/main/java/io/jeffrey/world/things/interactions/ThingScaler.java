package io.jeffrey.world.things.interactions;

import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.world.things.parts.ScalePart;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * scale/resize the entire thing
 *
 * @author jeffrey
 */
public class ThingScaler implements ThingInteraction {
  private final Transform transform;
  private final ScalePart scale;
  private final double    ix;
  private final double    iy;
  private final double    sx;
  private final double    sy;

  /**
   * @param initial
   *          the initial event in the thing space
   */
  public ThingScaler(final AdjustedMouseEvent initial, final Transform transform, final ScalePart scale) {
    this.transform = transform;
    this.scale = scale;
    sx = scale.sx();
    sy = scale.sy();
    ix = initial.position.x_1;
    iy = initial.position.y_1;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void cancel() {
    scale.sx(sx);
    scale.sy(sy);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void moved(final AdjustedMouseEvent event) {
    scale.sx(sx);
    scale.sy(sy);
    transform.writeToThingSpace(event.position);
    final double mx = event.position.x_1 / ix;
    final double my = event.position.y_1 / iy;
    double nsx = sx * mx;
    double nsy = sy * my;
    if (event.altdown || scale.aspect.value()) {
      nsx = (nsx + nsy) / 2.0;
      nsy = nsx;
    }
    scale.sx(nsx);
    scale.sy(nsy);
  }
}
