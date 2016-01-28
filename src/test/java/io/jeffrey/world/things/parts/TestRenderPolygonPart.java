package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFrameworkWithJavaFx;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import javafx.scene.canvas.Canvas;

public class TestRenderPolygonPart extends WorldTestFrameworkWithJavaFx {

  @Test
  public void coverageDefault() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final SelectablePoint2List points = new SelectablePoint2List(data().getString("v", "1,2,3,4"));
    final PointSetPart pointset = new PointSetPart(data(), container, thing.transform, thing.position, thing.scale, thing.rotation, points, thing.editing);
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    final RenderPolygonPart render = new RenderPolygonPart(thing.transform, container, thing.editing, thing.scale, fill, edge, pointset);
    final Canvas canvas = new Canvas();
    render.render(canvas.getGraphicsContext2D());
  }

  @Test
  public void coverageDisabled() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final SelectablePoint2List points = new SelectablePoint2List(data().getString("v", "1,2,3,4"));
    final PointSetPart pointset = new PointSetPart(data(), container, thing.transform, thing.position, thing.scale, thing.rotation, points, thing.editing);
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    fill.enabled.value(false);
    edge.enabled.value(false);
    final RenderPolygonPart render = new RenderPolygonPart(thing.transform, container, thing.editing, thing.scale, fill, edge, pointset);
    final Canvas canvas = new Canvas();
    render.render(canvas.getGraphicsContext2D());
  }

  @Test
  public void coverageSelected() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final SelectablePoint2List points = new SelectablePoint2List(data().getString("v", "1,2,3,4"));
    final PointSetPart pointset = new PointSetPart(data(), container, thing.transform, thing.position, thing.scale, thing.rotation, points, thing.editing);
    final ColorPart fill = new ColorPart("fill", "ccc", data());
    final ColorPart edge = new ColorPart("edge", "ccc", data());
    thing.editing.selected.value(true);
    final RenderPolygonPart render = new RenderPolygonPart(thing.transform, container, thing.editing, thing.scale, fill, edge, pointset);
    final Canvas canvas = new Canvas();
    render.render(canvas.getGraphicsContext2D());
  }
}
