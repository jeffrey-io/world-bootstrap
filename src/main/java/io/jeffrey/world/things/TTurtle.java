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
  
  public TTurtle(Document document, ThingData node) {
    super(document, node);
    EditString data = node.getString("script", "forward 50;left 90; forward 50; left 90; forward 50; left 45; forward 100");
    this.script = new DelegateEdit(data) {
      @Override
      public boolean acceptSetByText(String value) {
        try {
          getPointsLinks().set(TurtleCompiler.compile(value));
          return true;
        } catch (IllegalStateException ise) {
          return false;
        }
      }
    };
  }
  
  @Override
  protected void populatePolygonalEditLinks(HashMap<String, Edit> links) {
    super.populatePolygonalEditLinks(links);
    links.put("script", script);
  }
  
  @Override
  protected void saveOutPolygonalProperties(Map<String, Object> object) {
    throw new IllegalStateException("Is this even called?");
  }
}
