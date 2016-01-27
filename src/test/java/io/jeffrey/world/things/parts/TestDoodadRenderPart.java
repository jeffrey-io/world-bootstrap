package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFrameworkWithJavaFx;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import javafx.scene.canvas.Canvas;

public class TestDoodadRenderPart extends WorldTestFrameworkWithJavaFx {

  @Test
  public void verify() {
    final BasicThing thing = new BasicThing(makeSimpleContainer(), data());
    final DoodadRenderPart render = new DoodadRenderPart(thing);

    final HasControlDoodadsInThingSpaceMock doodads = new HasControlDoodadsInThingSpaceMock();

    doodads.doodads = new ControlDoodad[] { new ControlDoodad(Type.PointSelected, 1, 1), new ControlDoodad(Type.PointUnselected, 1, 1), new ControlDoodad(Type.Rotate, 1, 1), new ControlDoodad(Type.Scale, 1, 1), new ControlDoodad(null, 1, 1), };
    thing.register(doodads);

    final Canvas canvas = new Canvas();
    render.render(canvas.getGraphicsContext2D());
    thing.lifetime.deleted.value(true);
    render.render(canvas.getGraphicsContext2D());
    thing.lifetime.deleted.value(false);
    thing.editing.selected.value(true);
    render.render(canvas.getGraphicsContext2D());
    thing.editing.locked.value(true);
    render.render(canvas.getGraphicsContext2D());
    thing.editing.locked.value(false);
    render.render(canvas.getGraphicsContext2D());
  }
}
