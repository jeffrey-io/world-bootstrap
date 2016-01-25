package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;

public class TestCirclePart extends WorldTestFramework {
  private void sanityCheck(final CirclePart circle, final int count, final ControlDoodad.Type type) {
    assertEquals(count, circle.getDoodadsInThingSpace().length);
    for (final ControlDoodad doodad : circle.getDoodadsInThingSpace()) {
      assertEquals(type, doodad.type);
    }

  }

  @Test
  public void verify() {
    data();
    final CirclePart circle = new CirclePart(DoodadControls.All);
    assertTrue(circle.contains(0, 0));
    assertFalse(circle.contains(1, 1));
    assertEquals(8, circle.getDoodadsInThingSpace().length);

    final SimulatedMouse mouse = new SimulatedMouse();
    assertTrue(circle.doesMouseEventPreserveExistingSelection(mouse.get()));
    mouse.move(2, 1);
    assertFalse(circle.doesMouseEventPreserveExistingSelection(mouse.get()));
    mouse.go(-1, -1);
    SelectionWindow window = mouse.dragTo(-0.9, -0.9);
    assertFalse(circle.selectionIntersect(new SelectionModel(window, new IdentityTransform(), Mode.Add)));
    window = mouse.dragTo(1, 1);
    assertTrue(circle.selectionIntersect(new SelectionModel(window, new IdentityTransform(), Mode.Add)));
  }

  @Test
  public void verifyModes() {
    sanityCheck(new CirclePart(DoodadControls.None), 0, null);
    sanityCheck(new CirclePart(DoodadControls.Scale), 4, ControlDoodad.Type.Scale);
    sanityCheck(new CirclePart(DoodadControls.Rotation), 4, ControlDoodad.Type.Rotate);
  }
}
