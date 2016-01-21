package io.jeffrey.world.document;

import java.util.HashMap;
import java.util.TreeMap;

import io.jeffrey.world.things.TCircle;
import io.jeffrey.world.things.TConnector;
import io.jeffrey.world.things.TImage;
import io.jeffrey.world.things.TPath;
import io.jeffrey.world.things.TPolygon;
import io.jeffrey.world.things.TTurtle;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.zer.edits.ObjectDataMap;

public class ThingData extends ObjectDataMap {

  public ThingData(final HashMap<String, String> data) {
    super(data);
  }

  public ThingData(final String type) {
    super(new TreeMap<>());
    fields.put("_type", type);
  }

  public BasicThing make(final Container container) {
    if (fields.get("_type").equals("circle")) {
      return new TCircle(container, this);
    }
    if (fields.get("_type").equals("polygon")) {
      return new TPolygon(container, this);
    }
    if (fields.get("_type").equals("turtle")) {
      return new TTurtle(container, this);
    }
    if (fields.get("_type").equals("path")) {
      return new TPath(container, this);
    }
    if (fields.get("_type").equals("image")) {
      return new TImage(container, this);
    }
    if (fields.get("_type").equals("connector")) {
      return new TConnector(container, this);
    }
    return null;
  }
}
