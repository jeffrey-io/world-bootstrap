package io.jeffrey.world.things;

import java.util.HashMap;
import java.util.Map;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.descriptive.TurtleCompiler;
import io.jeffrey.zer.edits.DelegateEdit;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditString;

public class TTurtle extends TPolygon {

  private final DelegateEdit script;

  public TTurtle(final Document document, final ThingData node) {
    super(document, node);
    final EditString data = node.getString("script", "forward 50;left 90; forward 50; left 90; forward 50; left 45; forward 100");
    script = new DelegateEdit(data) {
      @Override
      public boolean acceptSetByText(final String value) {
        try {
          getPointsLinks().set(TurtleCompiler.compile(value));
          return true;
        } catch (final IllegalStateException ise) {
          return false;
        }
      }
    };
  }

  @Override
  protected void populatePolygonalEditLinks(final HashMap<String, Edit> links) {
    super.populatePolygonalEditLinks(links);
    links.put("script", script);
  }

  @Override
  protected void saveOutPolygonalProperties(final Map<String, Object> object) {
    throw new IllegalStateException("Is this even called?");
  }
}
