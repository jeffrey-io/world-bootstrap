package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import javafx.scene.shape.Polygon;

public class TestLazyPolygonPart extends WorldTestFramework {

  @Test
  public void verify() {
    SelectionModel model = new SelectionModel(new SelectionWindow(), new IdentityTransform(), Mode.Add) {
      @Override
      public boolean isOriginCircleSelected(double r) {
        return r > 0;
      }
    };
    LazyPolygonPart lazy = new LazyPolygonPart();
    assertFalse(lazy.selectionIntersect(model));
    assertNull(lazy.get());
    assertFalse(lazy.contains(0, 1));
    lazy.set(new Polygon(new double[] { 0, 0, 1, 1, 2, 0 }), 5);
    assertFalse(lazy.contains(0, 1));
    SimulatedMouse mouse = new SimulatedMouse();
    assertTrue(lazy.contains(1, 0));
    mouse.go(1, 0);
    assertTrue(lazy.doesMouseEventPreserveExistingSelection(mouse.get()));
    mouse.move(0, 5);
    assertFalse(lazy.doesMouseEventPreserveExistingSelection(mouse.get()));
    assertNotNull(lazy.get());
    assertFalse(lazy.selectionIntersect(model));
    lazy.set(new Polygon(new double[] { 0, 0, 1, 1, 2, 0 }), -1);
    assertFalse(lazy.selectionIntersect(model));
  }
}
