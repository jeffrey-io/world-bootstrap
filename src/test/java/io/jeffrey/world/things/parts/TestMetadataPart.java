package io.jeffrey.world.things.parts;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.core.LinkedDataMap;

public class TestMetadataPart extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data("zzzzz", "cool");
    final MetadataPart metadata = new MetadataPart("prefix", data);
    final EditString ed = metadata.metadataOf("x", "geee");
    assertEquals("geee", ed.value());
    final EditString dup = metadata.metadataOf("x", "ze");
    assertEquals("geee", dup.value());
    ed.value("cake");
    assertEquals("cake", dup.value());
  }

  @Test
  public void verifyPickup() {
    final LinkedDataMap data = data("prefixx", "foo");
    final MetadataPart metadata = new MetadataPart("prefix", data);
    final EditString ed = metadata.metadataOf("x", "geee");
    assertEquals("foo", ed.value());
    final EditString dup = metadata.metadataOf("x", "geee");
    assertEquals("foo", dup.value());
    ed.value("cake");
    assertEquals("cake", dup.value());
  }
}
