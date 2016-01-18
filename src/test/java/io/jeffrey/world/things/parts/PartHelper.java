package io.jeffrey.world.things.parts;

import java.util.TreeMap;

import org.junit.Assert;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.zer.edits.ObjectDataMap;

public class PartHelper {
  private final TreeMap<String, String> fields;
  private final ObjectDataMap objectDataMap;
  private final LinkedDataMap linkedDataMap;
  
  public PartHelper() {
    this.fields = new TreeMap<>();
    this.objectDataMap = new ObjectDataMap(fields);
    this.linkedDataMap = new LinkedDataMap(objectDataMap);
  }
  
  public LinkedDataMap getLinkedDataMap() {
    return linkedDataMap;
  }
  
  public PartHelper assertWritten(String key, String expected) {
    String actual = fields.get(key);
    Assert.assertEquals(expected, actual);
    return this;
  }
}
