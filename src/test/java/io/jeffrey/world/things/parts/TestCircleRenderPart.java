package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFrameworkWithJavaFx;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import javafx.scene.canvas.Canvas;

public class TestCircleRenderPart extends WorldTestFrameworkWithJavaFx {
  @Test
  public void coverageWithAll() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    final CircleRenderPart circleRenderPart = new CircleRenderPart(thing.transform, container, fill, edge, thing.scale, thing.editing);
    final Canvas canvas = new Canvas();
    circleRenderPart.render(canvas.getGraphicsContext2D());
  }

  @Test
  public void coverageWithEdgeDisabled() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    edge.enabled.value(false);
    final CircleRenderPart circleRenderPart = new CircleRenderPart(thing.transform, container, fill, edge, thing.scale, thing.editing);
    final Canvas canvas = new Canvas();
    circleRenderPart.render(canvas.getGraphicsContext2D());
  }

  @Test
  public void coverageWithFillDisabled() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    fill.enabled.value(false);
    final CircleRenderPart circleRenderPart = new CircleRenderPart(thing.transform, container, fill, edge, thing.scale, thing.editing);
    final Canvas canvas = new Canvas();
    circleRenderPart.render(canvas.getGraphicsContext2D());
  }

  @Test
  public void coverageWithSelected() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    thing.editing.selected.value(true);
    final CircleRenderPart circleRenderPart = new CircleRenderPart(thing.transform, container, fill, edge, thing.scale, thing.editing);
    final Canvas canvas = new Canvas();
    circleRenderPart.render(canvas.getGraphicsContext2D());
  }
}
