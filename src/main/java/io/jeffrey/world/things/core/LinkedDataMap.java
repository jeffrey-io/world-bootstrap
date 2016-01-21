package io.jeffrey.world.things.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditInteger;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.edits.ObjectDataMap;

/**
 * wraps an ObjectDataMap and keeps track of what data was created; this is then used to serialize the data and walk the data structure.
 *
 * @author jeffrey
 */
public class LinkedDataMap {
  private final ObjectDataMap         data;
  private final HashMap<String, Edit> links;

  public LinkedDataMap(final ObjectDataMap data) {
    this.data = data;
    links = new HashMap<>();
  }

  public Collection<String> fields() {
    return data.keys();
  }

  public EditBoolean getBoolean(final String name, final boolean def) {
    return link(name, data.getBoolean(name, def));
  }

  public EditDouble getDouble(final String name, final double def) {
    return link(name, data.getDouble(name, def));
  }

  public EditInteger getInteger(final String name, final int def) {
    return link(name, data.getInteger(name, def));
  }

  public Map<String, Edit> getLinks() {
    return Collections.unmodifiableMap(links);
  }

  public EditString getString(final String name, final String def) {
    return link(name, data.getString(name, def));
  }

  private <T extends Edit> T link(final String name, final T edit) {
    links.put(name, edit);
    return edit;
  }

}
