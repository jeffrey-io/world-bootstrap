package io.jeffrey.world.things.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.base.ControlDoodad.Type;

public abstract class ControlDoodadPart implements Part {
  /**
   * cached allocation of the doodads
   */
  private ControlDoodad[] worldDoodads;
  private final Transform transform;
  
  public ControlDoodadPart(final Transform transform) {
    worldDoodads = new ControlDoodad[0];
    this.transform = transform;
  }
  
  /**
   * @return all the doodads in target space
   */
  protected abstract ControlDoodad[] getDoodadsInThingSpace();
  
  /**
   * @return all the control doodads in the world space for rendering
   */
  public ControlDoodad[] getDoodadsInWorldSpace() {
    final ControlDoodad[] original = getDoodadsInThingSpace();
    if (worldDoodads.length != original.length) {
      worldDoodads = new ControlDoodad[original.length];
      for (int k = 0; k < original.length; k++) {
        worldDoodads[k] = new ControlDoodad(Type.PointUnselected, 0.0, 0.0);
      }
    }
    final VectorRegister3 W = new VectorRegister3();
    for (int k = 0; k < original.length; k++) {
      final ControlDoodad doodad = original[k];
      W.set_0(doodad.u, doodad.v);
      transform.writeToWorld(W);
      final ControlDoodad world = worldDoodads[k];
      world.type = doodad.type;
      world.u = W.x_1;
      world.v = W.y_1;
    }
    return worldDoodads;
  }  

  @Override
  public boolean unique() {
    return false;
  }
}
