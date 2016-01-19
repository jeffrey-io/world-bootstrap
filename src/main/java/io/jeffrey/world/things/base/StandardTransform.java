package io.jeffrey.world.things.base;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;
import javafx.scene.canvas.GraphicsContext;

/**
 * defines the canonical and most useful transfrom for things that have an (x,y) position, an angle, and is scalable.
 *
 * @author jeffrey
 */
public class StandardTransform implements Transform {
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

  /**
   * {@inheritDoc}
   */
  @Override
  public void writeToThingSpace(final VectorRegister3 reg) {
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
  public void writeToWorldSpace(final VectorRegister3 reg) {
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
