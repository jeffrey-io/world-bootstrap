package io.jeffrey.world.things.parts;

import java.util.TreeMap;

import org.junit.Assert;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.zer.edits.ObjectDataMap;

public class PartHelper {
  private final TreeMap<String, String> fields;
  private final LinkedDataMap           linkedDataMap;
  private final ObjectDataMap           objectDataMap;

  public PartHelper() {
    fields = new TreeMap<>();
    objectDataMap = new ObjectDataMap(fields);
    linkedDataMap = new LinkedDataMap(objectDataMap);
  }

  public PartHelper assertWritten(final String key, final String expected) {
    final String actual = fields.get(key);
    Assert.assertEquals(expected, actual);
    return this;
  }

  public LinkedDataMap getLinkedDataMap() {
    return linkedDataMap;
  }
}
