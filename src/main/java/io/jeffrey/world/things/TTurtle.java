package io.jeffrey.world.things;

import java.util.function.BiConsumer;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.descriptive.TurtleCompiler;
import io.jeffrey.zer.edits.DelegateEdit;
import io.jeffrey.zer.edits.EditString;

public class TTurtle extends TPolygon {

  private final EditString script;

  public TTurtle(final Document document, final ThingData node) {
    super(document, node);
    
    script = data.getString("script", "forward 50;left 90; forward 50; left 90; forward 50; left 45; forward 100");
    script.subscribe(new BiConsumer<String, String>() {
      
      @Override
      public void accept(String t, String value) {
        // perhaps, this is broken
        points.vertices.set(TurtleCompiler.compile(value));        
      }
    });
  }
}
