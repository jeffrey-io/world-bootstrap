package io.jeffrey.world.things.core;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.TestAbstractThing.DumbPart;

public class TestAbstractThingSingleItemCache extends WorldTestFramework {

  @Test
  public void verifyAbstractThingSingleItemCache() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    final AtomicInteger called = new AtomicInteger(0);
    final AbstractThingSingleItemCache<String> cache = new AbstractThingSingleItemCache<String>(thing) {

      @Override
      protected String compute() {
        called.incrementAndGet();
        return Long.toHexString(thing.getSequencer() * 7);
      }
    };
    assertEquals(0, called.get());
    assertEquals("0", cache.get());
    assertEquals(1, called.get());
    for (int k = 0; k < 100; k++) {
      assertEquals("0", cache.get());
      assertEquals(1, called.get());
    }
    thing.externalRegister(new DumbPart());
    assertEquals(1, called.get());
    assertEquals("7", cache.get());
    assertEquals(2, called.get());
    for (int k = 0; k < 100; k++) {
      assertEquals("7", cache.get());
      assertEquals(2, called.get());
    }
  }
}
