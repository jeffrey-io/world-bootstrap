package io.jeffrey.world.things;

import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.descriptive.TurtleCompiler;
import io.jeffrey.zer.edits.EditString;

public class TTurtle extends TPolygon {

  private final EditString script;

  public TTurtle(final Container container, final ThingData node) {
    super(container, node);

    script = data.getString("script", "forward 50;left 90; forward 50; left 90; forward 50; left 45; forward 100");
    script.subscribe((t, value) -> points.vertices.set(TurtleCompiler.compile(value)));
  }
}
