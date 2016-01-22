package io.jeffrey.world.things.core;

import org.junit.Test;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import javafx.scene.canvas.GraphicsContext;

public class TestAdaptThingSpaceDoodadsIntoWorldSpace extends WorldTestFramework {

  @Test
  public void verifyTransformApplied() {

    final Transform add1 = new Transform() {

      @Override
      public boolean allowed(final Type doodadType) {
        fail();
        return false;
      }

      @Override
      public void readyGraphicsContext(final GraphicsContext gc) {
        fail();
      }

      @Override
      public void writeToThingSpace(final VectorRegister3 reg) {
        fail();
      }

      @Override
      public void writeToWorldSpace(final VectorRegister3 reg) {
        reg.copy_from_0_to_1();
        reg.x_1++;
        reg.y_1++;
      }
    };
    final HasControlDoodadsInThingSpaceMock mock = new HasControlDoodadsInThingSpaceMock();
    final AdaptThingSpaceDoodadsIntoWorldSpace adapt = new AdaptThingSpaceDoodadsIntoWorldSpace(add1, mock);

    ControlDoodad[] transformed = adapt.getDoodadsInWorldSpace();
    assertEquals(0, transformed.length);

    mock.doodads = new ControlDoodad[] { new ControlDoodad(Type.PointSelected, 0, 1) };
    transformed = adapt.getDoodadsInWorldSpace();
    assertEquals(1, transformed.length);
    assertEquals(1, transformed[0].u);
    assertEquals(2, transformed[0].v);
  }

}
