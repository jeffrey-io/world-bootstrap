package io.jeffrey.world.things.core;

import org.junit.Test;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;

public class TestStandardTransform extends WorldTestFramework {

  @Test
  public void validate() {
    final LinkedDataMap data = emptyData();
    final PositionPart position = new PositionPart(data, new IdentitySnap());
    final ScalePart scale = new ScalePart(data);
    final RotationPart rotation = new RotationPart(data);
    final StandardTransform transform = new StandardTransform(position, scale, rotation);
    assertTrue(transform.allowed(Type.Scale));
    assertTrue(transform.allowed(Type.Rotate));
    assertTrue(transform.allowed(Type.PointSelected));
    assertTrue(transform.allowed(Type.PointUnselected));

    scale.lock.value(true);
    assertFalse(transform.allowed(Type.Scale));
    assertTrue(transform.allowed(Type.Rotate));
    assertTrue(transform.allowed(Type.PointSelected));
    assertTrue(transform.allowed(Type.PointUnselected));

    rotation.lock.value(true);
    assertFalse(transform.allowed(Type.Scale));
    assertFalse(transform.allowed(Type.Rotate));
    assertTrue(transform.allowed(Type.PointSelected));
    assertTrue(transform.allowed(Type.PointUnselected));

    position.x.value(1.0);
    position.y.value(2.0);
    scale.sx(4.0);
    scale.sy(6.0);
    rotation.angle.value(3.14 / 4);
    final VectorRegister3 W = new VectorRegister3();
    W.set_0(1, 1);
    assertEquals(0, W.x_1);
    assertEquals(0, W.y_1);
    transform.writeToThingSpace(W);
    assertEquals(0.003425101494840175, W.x_1);
    assertEquals(-0.16665102417227048, W.y_1);
    W.set_0(0, 0);
    transform.writeToWorldSpace(W);
    assertEquals(1.0, W.x_1);
    assertEquals(2.0, W.y_1);
    W.set_0(2, 2);
    transform.writeToWorldSpace(W);
    assertEquals(9.163654032021313, W.x_1);
    assertEquals(13.88927049256859, W.y_1);
    W.copy_from_1_to_0();
    transform.writeToThingSpace(W);
    assertEquals(2.0, W.x_1);
    assertEquals(2.0, W.y_1);
  }
}
