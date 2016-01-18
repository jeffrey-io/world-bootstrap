package io.jeffrey.world.things.base.parts;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Transform;
import javafx.scene.canvas.GraphicsContext;

public class StandardTransform implements Part, Transform {
  private final PositionPart position;
  private final RotationPart rotation;
  private final ScalePart    scale;

  public StandardTransform(final PositionPart position, final ScalePart scale, final RotationPart rotation) {
    this.position = position;
    this.scale = scale;
    this.rotation = rotation;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean allowed(final ControlDoodad.Type doodadType) {
    if (doodadType == Type.Scale && scale.lock.value()) {
      return false;
    }
    if (doodadType == Type.Rotate && rotation.lock.value()) {
      return false;
    }
    return true;
  }

  @Override
  public void readyGraphicsContext(final GraphicsContext gc) {
    gc.translate(position.x.value(), position.y.value());
    gc.rotate(-rotation.angle.value());
    gc.scale(scale.x.value(), scale.y.value());
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeToTarget(final VectorRegister3 reg) {
    reg.copy_from_0_to_1();
    reg.set_2(position.x.value(), position.y.value());
    reg.sub_2_from_1();
    reg.set_2(rotation.cachedComplexX(), rotation.cachedComplexY());
    reg.complex_mult_2_1();
    // add sheer to vector register
    reg.x_1 /= scale.x.value();
    reg.y_1 /= scale.y.value();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeToWorld(final VectorRegister3 reg) {
    reg.copy_from_0_to_1();
    // add sheer
    reg.x_1 *= scale.x.value();
    reg.y_1 *= scale.y.value();
    reg.set_2(rotation.cachedComplexX(), -rotation.cachedComplexY());
    reg.complex_mult_2_1();
    reg.set_2(position.x.value(), position.y.value());
    reg.add_2_to_1();
  }
}
