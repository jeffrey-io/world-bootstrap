package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public class TestCirclePart extends WorldTestFramework {
  @Test
  public void verify() {
    data();
    final CirclePart circle = new CirclePart();
    assertTrue(circle.contains(0, 0));
    assertFalse(circle.contains(1, 1));
    assertEquals(8, circle.getDoodadsInThingSpace().length);

    final SimulatedMouse mouse = new SimulatedMouse();
    assertTrue(circle.doesMouseEventPreserveExistingSelection(mouse.get()));
    mouse.move(2, 1);
    assertFalse(circle.doesMouseEventPreserveExistingSelection(mouse.get()));

    mouse.go(-1, -1);
    SelectionWindow window = mouse.dragTo(-0.9, -0.9);
    final Polygon notTouching = MousePart.transformSelectionWindow(window, new IdentityTransform());
    assertFalse(circle.selectionIntersect(new SelectionModel(notTouching, Mode.Add)));

    window = mouse.dragTo(1, 1);
    final Polygon touching = MousePart.transformSelectionWindow(window, new IdentityTransform());
    assertTrue(circle.selectionIntersect(new SelectionModel(touching, Mode.Add)));

  }
}
