package io.jeffrey.world.things.core;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInWorldSpace;
import io.jeffrey.world.things.core.ControlDoodad.Type;

public class AdaptThingSpaceDoodadsIntoWorldSpace implements HasControlDoodadsInWorldSpace {
  private final HasControlDoodadsInThingSpace doodads;
  private final Transform                     transform;

  /**
   * cached allocation of the doodads
   */
  private ControlDoodad[]                     worldDoodadCache;

  public AdaptThingSpaceDoodadsIntoWorldSpace(final Transform transform, final HasControlDoodadsInThingSpace doodads) {
    this.transform = transform;
    this.doodads = doodads;
    worldDoodadCache = new ControlDoodad[0];
  }

  /**
   * @return all the control doodads in the world space for rendering
   */
  @Override
  public ControlDoodad[] getDoodadsInWorldSpace() {
    final ControlDoodad[] original = doodads.getDoodadsInThingSpace();
    if (worldDoodadCache.length != original.length) {
      worldDoodadCache = new ControlDoodad[original.length];
      for (int k = 0; k < original.length; k++) {
        worldDoodadCache[k] = new ControlDoodad(Type.PointUnselected, 0.0, 0.0);
      }
    }
    final VectorRegister3 W = new VectorRegister3();
    for (int k = 0; k < original.length; k++) {
      final ControlDoodad doodad = original[k];
      W.set_0(doodad.u, doodad.v);
      transform.writeToWorldSpace(W);
      final ControlDoodad world = worldDoodadCache[k];
      world.type = doodad.type;
      world.u = W.x_1;
      world.v = W.y_1;
    }
    return worldDoodadCache;
  }
}
