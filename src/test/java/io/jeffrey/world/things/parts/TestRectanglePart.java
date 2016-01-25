package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.zer.SelectionWindow.Mode;

public class TestRectanglePart extends WorldTestFramework {

  @Test
  public void verify() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.All);
    rectangle.set(0, 1, 3, 4);
    assertFalse(rectangle.contains(-1, -1));
    assertTrue(rectangle.contains(2, 2));
    assertEquals(8, rectangle.getDoodadsInThingSpace().length);
    double[] edges = rectangle.getWorldSpaceEdges();
    assertEquals(16, edges.length);
    assertEquals(-1.5, edges[0]);
    assertEquals(-2.0, edges[1]);
    assertEquals(1.5, edges[2]);
    assertEquals(-2.0, edges[3]);
    assertEquals(1.5, edges[4]);
    assertEquals(-2.0, edges[5]);
    assertEquals(1.5, edges[6]);
    assertEquals(2.0, edges[7]);
    assertEquals(1.5, edges[8]);
    assertEquals(2.0, edges[9]);
    assertEquals(-1.5, edges[10]);
    assertEquals(2.0, edges[11]);
    assertEquals(-1.5, edges[12]);
    assertEquals(2.0, edges[13]);
    assertEquals(-1.5, edges[14]);
    assertEquals(-2.0, edges[15]);
  }

  @Test
  public void verifyNoDoodads() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.None);
    assertEquals(0, rectangle.getDoodadsInThingSpace().length);

  }

  @Test
  public void verifyOnlyRotationDoodads() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.Rotation);
    assertEquals(4, rectangle.getDoodadsInThingSpace().length);
    for (ControlDoodad d : rectangle.getDoodadsInThingSpace()) {
      assertEquals(Type.Rotate, d.type);
    }
  }

  @Test
  public void verifyOnlyScaleDoodads() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.Scale);
    assertEquals(4, rectangle.getDoodadsInThingSpace().length);
    for (ControlDoodad d : rectangle.getDoodadsInThingSpace()) {
      assertEquals(Type.Scale, d.type);
    }
  }

  @Test
  public void verifyMouseContains() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.All);
    rectangle.set(0, 1, 3, 4);
    SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(-1, -1);
    assertFalse(rectangle.doesMouseEventPreserveExistingSelection(mouse.get()));
    mouse.go(1.5, 2.5);
    assertTrue(rectangle.doesMouseEventPreserveExistingSelection(mouse.get()));
  }

  @Test
  public void verifySelectionWindowTrue() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.All);
    rectangle.set(0, 1, 3, 4);
    SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(-1.5, -1.5);
    SelectionModel model = new SelectionModel(mouse.dragTo(1.5, 2.5), new IdentityTransform(), Mode.Set);
    assertTrue(rectangle.selectionIntersect(model));
  }

  @Test
  public void verifySelectionWindowFalse() {
    final RectanglePart rectangle = new RectanglePart(new IdentityTransform(), DoodadControls.All);
    rectangle.set(0, 1, 3, 4);
    SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(-1.5, -1.5);
    SelectionModel model = new SelectionModel(mouse.dragTo(-1.5, -2.5), new IdentityTransform(), Mode.Set);
    assertFalse(rectangle.selectionIntersect(model));
  }
}
