package io.jeffrey.world.things;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.descriptive.TurtleCompiler;
import io.jeffrey.zer.edits.DelegateEdit;
import io.jeffrey.zer.edits.EditString;

public class TTurtle extends TPolygon {

  private final DelegateEdit script;

  public TTurtle(final Document document, final ThingData node) {
    super(document, node);
    final EditString scriptraw = data.getString("script", "forward 50;left 90; forward 50; left 90; forward 50; left 45; forward 100");

    // TODO: this is broken, need to put a filter/transformer in place
    script = new DelegateEdit(scriptraw) {
      @Override
      public boolean acceptSetByText(final String value) {
        try {
          points.vertices.set(TurtleCompiler.compile(value));
          return true;
        } catch (final IllegalStateException ise) {
          return false;
        }
      }
    };
  }
}
