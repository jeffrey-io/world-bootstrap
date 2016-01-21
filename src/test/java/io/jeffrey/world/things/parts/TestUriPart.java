package io.jeffrey.world.things.parts;

import org.junit.Test;

public class TestUriPart {
  @Test
  public void sanityCheck() {
    final PartHelper helper = new PartHelper();
    final UriPart uri = new UriPart("p_", helper.newLinkedDataMap());
    uri.uri.set("cake");
    helper.assertWritten("p_uri", "cake");
  }
}
