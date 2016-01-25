package io.jeffrey.world;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.enforcer.GuideLineEnforcer;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.edits.ObjectDataMap;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.WorldFileSystem;
import javafx.scene.canvas.GraphicsContext;

public class WorldTestFramework {

  public class HasActionsMock implements Part, HasActions {

    private final ArrayList<String>  available   = new ArrayList<>();
    private final ArrayDeque<String> invocations = new ArrayDeque<>();

    public void allow(final String action) {
      available.add(action);
    }

    public void assertNextCallWas(final String expectedAction) {
      assertEquals(expectedAction, invocations.pop());
    }

    @Override
    public void invokeAction(final String action, final SharedActionSpace space) {
      invocations.add(action);
    }

    @Override
    public void listActions(final Set<String> actionsAvailable) {
      for (final String action : available) {
        actionsAvailable.add(action);
      }
    }
  }

  public class HasControlDoodadsInThingSpaceMock implements HasControlDoodadsInThingSpace {
    public ControlDoodad[] doodads = new ControlDoodad[0];

    @Override
    public ControlDoodad[] getDoodadsInThingSpace() {
      return doodads;
    }
  }

  public class HasUpdateMock implements Part, HasUpdate {

    private int updateCallsMade = 0;

    public void assertUpdateCallsMadeEquals(final int expected) {
      assertEquals(expected, updateCallsMade);
    }

    @Override
    public void update() {
      updateCallsMade++;
    }
  }

  public class IdentityTransform implements Transform {

    @Override
    public boolean allowed(final Type doodadType) {
      return true;
    }

    @Override
    public void readyGraphicsContext(final GraphicsContext gc) {
    }

    @Override
    public void writeToThingSpace(final VectorRegister3 reg) {
      reg.copy_from_0_to_1();
    }

    @Override
    public void writeToWorldSpace(final VectorRegister3 reg) {
      reg.copy_from_0_to_1();
    }

  }

  public class NoOpGuidelineEnforcer implements GuideLineEnforcer {

    public int attemptSnapToCallsMade = 0;

    @Override
    public void attemptSnapTo(final Camera camera, final GuideLine line) {
      attemptSnapToCallsMade++;
    }
  }

  public class NoOpThingInteraction implements ThingInteraction {

    public int cancelCalls = 0;
    public int commitCalls = 0;
    public int movedCalls  = 0;
    public int selectCalls = 0;

    @Override
    public void cancel() {
      cancelCalls++;
    }

    @Override
    public void commit() {
      commitCalls++;
    }

    @Override
    public void moved(final AdjustedMouseEvent event) {
      movedCalls++;
    }

    @Override
    public void select() {
      selectCalls++;
    }
  }

  public class SimpleAbstractThing extends AbstractThing {

    public SimpleAbstractThing() {
      super(makeSimpleContainer(), data());
    }

    public void externalRegister(final Part part) {
      register(part);
    }

    @Override
    public Transform transform() {
      return null;
    }
  }

  public void assertEquals(final double expected, final double actual) {
    final double diff = Math.abs(expected - actual);
    if (diff > 0.0001) {
      Assert.assertEquals(Double.toString(expected), Double.toString(actual));
    }
  }

  public void assertEquals(final int expected, final int actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertEquals(final Object expected, final Object actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertEquals(final String expected, final String actual) {
    Assert.assertEquals(expected, actual);
  }

  public void assertFalse(final boolean b) {
    Assert.assertFalse(b);
  }

  public void assertNull(final Object obj) {
    Assert.assertNull(obj);
  }

  public void assertTrue(final boolean b) {
    Assert.assertTrue(b);
  }

  public LinkedDataMap data(final String... keysAndValues) {
    final HashMap<String, String> map = new HashMap<>();
    for (int k = 0; k + 1 < keysAndValues.length; k += 2) {
      map.put(keysAndValues[k], keysAndValues[k + 1]);
    }
    return new LinkedDataMap(new ObjectDataMap(map));
  }

  public void fail() {
    Assert.fail();
  }

  public String joinStringsOrderly(final Set<String> set) {
    return String.join(",", new TreeSet<>(set));
  }

  public <T> List<T> listOf(final Iterable<T> iterable) {
    final ArrayList<T> list = new ArrayList<>();
    for (final T t : iterable) {
      list.add(t);
    }
    return list;
  }

  public Container makeSimpleContainer() {
    return new Container(new Camera(), new WorldFileSystem() {

      @Override
      public File find(final String path) {
        return new File(path);
      }

      @Override
      public String normalize(final File input) {
        return input.toString();
      }
    });
  }

  @Before
  public void witness() {

  }
}
