package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFrameworkWithJavaFx;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import javafx.scene.canvas.Canvas;

public class TestRenderPathPart extends WorldTestFrameworkWithJavaFx {

  @Test
  public void verify() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final SelectablePoint2List points = new SelectablePoint2List(data().getString("v", "1,2,3,4"));
    final PointSetPart pointset = new PointSetPart(data(), container, thing.transform, thing.position, thing.scale, thing.rotation, points, thing.editing);
    final RenderPathPart render = new RenderPathPart(thing.transform, container, pointset);
    final Canvas canvas = new Canvas();
    render.render(canvas.getGraphicsContext2D());
  }
}
