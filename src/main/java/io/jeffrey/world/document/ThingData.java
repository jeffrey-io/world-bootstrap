package io.jeffrey.world.document;

import java.util.HashMap;
import java.util.TreeMap;

import io.jeffrey.world.data.ObjectDataMap;
import io.jeffrey.world.things.TCircle;
import io.jeffrey.world.things.TConnector;
import io.jeffrey.world.things.TImage;
import io.jeffrey.world.things.TPath;
import io.jeffrey.world.things.TPolygon;
import io.jeffrey.world.things.TTurtle;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;

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
      return new TCircle(container, new LinkedDataMap(this));
    }
    if (fields.get("_type").equals("polygon")) {
      return new TPolygon(container, new LinkedDataMap(this));
    }
    if (fields.get("_type").equals("turtle")) {
      return new TTurtle(container, new LinkedDataMap(this));
    }
    if (fields.get("_type").equals("path")) {
      return new TPath(container, new LinkedDataMap(this));
    }
    if (fields.get("_type").equals("image")) {
      return new TImage(container, new LinkedDataMap(this));
    }
    if (fields.get("_type").equals("connector")) {
      return new TConnector(container, new LinkedDataMap(this));
    }
    return null;
  }
}
