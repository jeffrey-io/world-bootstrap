package io.jeffrey.world.document;

import java.util.HashMap;
import java.util.TreeMap;

import io.jeffrey.world.things.TCircle;
import io.jeffrey.world.things.TConnector;
import io.jeffrey.world.things.TImage;
import io.jeffrey.world.things.TPath;
import io.jeffrey.world.things.TPolygon;
import io.jeffrey.world.things.TTurtle;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.zer.edits.ObjectDataMap;

public class ThingData extends ObjectDataMap {

  public ThingData(final HashMap<String, String> data) {
    super(data);
  }

  public ThingData(final String type) {
    super(new TreeMap<>());
    fields.put("_type", type);
  }

  public Thing make(final Document document) {
    if (fields.get("_type").equals("circle")) {
      return new TCircle(document, this);
    }
    if (fields.get("_type").equals("polygon")) {
      return new TPolygon(document, this);
    }
    if (fields.get("_type").equals("turtle")) {
      return new TTurtle(document, this);
    }
    if (fields.get("_type").equals("path")) {
      return new TPath(document, this);
    }
    if (fields.get("_type").equals("image")) {
      return new TImage(document, this);
    }
    if (fields.get("_type").equals("connector")) {
      return new TConnector(document, this);
    }
    return null;
  }
}
