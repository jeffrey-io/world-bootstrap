package io.jeffrey.world;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.edits.ObjectDataMap;
import io.jeffrey.zer.meta.WorldFileSystem;

public class WorldTestFramework {
  
  public class HasUpdateMock implements HasUpdate {

    private int updateCallsMade = 0;

    public void assertUpdateCallsMadeEquals(final int expected) {
      assertEquals(expected, updateCallsMade);
    }

    @Override
    public void update() {
      updateCallsMade++;
    }
  }

  public void assertEquals(final double a, final double b) {
    final double diff = Math.abs(a - b);
    if (diff > 0.0001) {
      Assert.fail("a:" + a + " != b:" + b);
    }
  }
  
  public void assertEquals(final String expected, final String actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertEquals(final int expected, final int actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertEquals(final Object expected, final Object actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertFalse(final boolean b) {
    Assert.assertFalse(b);
  }

  public void assertTrue(final boolean b) {
    Assert.assertTrue(b);
  }
  
  public void fail() {
    Assert.fail();
  }

  @Before
  public void witness() {

  }
  
  public <T> List<T> listOf(Iterable<T> iterable) {
    ArrayList<T> list = new ArrayList<>();
    for (T t : iterable) {
      list.add(t);
    }
    return list;
  }
  
  public Container makeSimpleContainer() {
    return new Container(new Camera(), new WorldFileSystem() {
      
      @Override
      public String normalize(File input) {
        return input.toString();
      }
      
      @Override
      public File find(String path) {
        return new File(path);
      }
    });
  }
  
  public LinkedDataMap emptyData() {
    return new LinkedDataMap(new ObjectDataMap(new HashMap<>()));
  }
}
