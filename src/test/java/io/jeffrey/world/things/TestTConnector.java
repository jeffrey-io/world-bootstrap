package io.jeffrey.world.things;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTConnector extends WorldTestFramework {
  @Test
  public void construct() {
    TConnector thing = new TConnector(makeSimpleContainer(), emptyData()); 
  }
}
