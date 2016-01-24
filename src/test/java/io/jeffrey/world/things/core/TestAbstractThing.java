package io.jeffrey.world.things.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.zer.edits.Edit;

public class TestAbstractThing extends WorldTestFramework {

  public static class DumbPart implements Part {

    public Collection<String> Coordinates() {
      final ArrayList<String> coord = new ArrayList<>();
      coord.add("X");
      coord.add("Y");
      coord.add("Z");
      return coord;
    }

    public String[] HereComeTheABCs() {
      return new String[] { "A", "B", "C" };
    }

    public String x() {
      return "X";
    }
  }

  @Test
  public void listActions() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    final HasActionsMock actions1 = new HasActionsMock();
    actions1.allow("a");
    final HasActionsMock actions2 = new HasActionsMock();
    actions2.allow("b");
    thing.register(actions1);
    thing.register(actions2);
    assertEquals("a,b,delete,inverse_selection,lock,select,templatize", joinStringsOrderly(thing.getActionsAvailable()));
  }

  @Test
  public void verifyActingWithHistory() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    assertFalse(thing.lifetime.isDeleted());
    thing.invokeAction("delete", true);
    assertTrue(thing.lifetime.isDeleted());
    assertTrue(thing.container.history.canUndo());
    thing.container.history.undo();
    assertFalse(thing.container.history.canUndo());
    assertFalse(thing.lifetime.isDeleted());
  }

  @Test
  public void verifyActingWithoutHistory() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    assertFalse(thing.lifetime.isDeleted());
    thing.invokeAction("delete", false);
    assertTrue(thing.lifetime.isDeleted());
    assertFalse(thing.container.history.canUndo());
  }

  @Test
  public void verifyCacheGrowth() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    assertEquals(0, thing.getSequencer());
    assertEquals(0, thing.collect(DumbPart.class).size());
    thing.externalRegister(new DumbPart());
    assertEquals(1, thing.getSequencer());
    assertEquals(1, thing.collect(DumbPart.class).size());
    assertEquals(1, thing.collect(DumbPart.class).size());
    thing.externalRegister(new DumbPart());
    assertEquals(2, thing.collect(DumbPart.class).size());
    assertEquals(2, thing.collect(DumbPart.class).size());
    assertEquals(2, thing.getSequencer());
    thing.externalRegister(new DumbPart());
    assertEquals(3, thing.collect(DumbPart.class).size());
    assertEquals(3, thing.getSequencer());
    assertEquals(3, thing.collect(DumbPart.class).size());
    assertEquals(3, thing.getSequencer());
  }

  @Test
  public void verifyCollectingFunction() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    thing.externalRegister(new DumbPart());
    thing.externalRegister(new DumbPart());
    final Set<String> abcs = thing.collect(DumbPart.class, dp -> dp.x());
    assertEquals(1, abcs.size());
    assertEquals("X", joinStringsOrderly(abcs));
  }

  @Test
  public void verifyInsertionOrder() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    final DumbPart dp = new DumbPart();
    thing.externalRegister(dp);
    thing.externalRegister(new DumbPart());
    thing.externalRegister(new DumbPart());
    assertTrue(dp == thing.first(DumbPart.class));
  }

  @Test
  public void verifyLinksWithHistory() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    final Edit deleted = thing.getLinks(true).get("deleted");
    assertEquals("no", deleted.getAsText());
    assertFalse(thing.lifetime.isDeleted());
    deleted.setByText("yes");
    assertTrue(thing.lifetime.isDeleted());
    // links require manual capture, otherwise we will spam the history
    thing.container.history.capture();
    assertTrue(thing.container.history.canUndo());
    thing.container.history.undo();
    assertFalse(thing.container.history.canUndo());
    assertFalse(thing.lifetime.isDeleted());
    assertEquals("no", deleted.getAsText());
  }

  @Test
  public void verifyLinksWithoutHistory() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    final Edit deleted = thing.getLinks(false).get("deleted");
    assertEquals("no", deleted.getAsText());
    assertFalse(thing.lifetime.isDeleted());
    deleted.setByText("yes");
    assertTrue(thing.lifetime.isDeleted());
    assertFalse(thing.container.history.canUndo());
  }

  @Test
  public void verifyMergingOverArrays() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    thing.externalRegister(new DumbPart());
    thing.externalRegister(new DumbPart());
    final Set<String> abcs = thing.collectAndMergeOverArray(DumbPart.class, dp -> dp.HereComeTheABCs());
    assertEquals(3, abcs.size());
    assertEquals("A,B,C", joinStringsOrderly(abcs));
  }

  @Test
  public void verifyMergingOverCollections() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    thing.externalRegister(new DumbPart());
    thing.externalRegister(new DumbPart());
    final Set<String> xyz = thing.collectAndMerge(DumbPart.class, dp -> dp.Coordinates());
    assertEquals(3, xyz.size());
    assertEquals("X,Y,Z", joinStringsOrderly(xyz));
  }

  @Test
  public void verifyProperties() {
    final SimpleAbstractThing thing = new SimpleAbstractThing();
    assertTrue(thing.getID().length() > 4);
    assertEquals("Unnamed", thing.getName());
    assertEquals("_", thing.getMetaclass());
    final TreeMap<String, String> data = new TreeMap<>();
    thing.saveTo(data);
    assertEquals(8, data.size());
    thing.update();
    final HasUpdateMock update = new HasUpdateMock();
    thing.externalRegister(update);
    thing.update();
    update.assertUpdateCallsMadeEquals(1);
    thing.update();
    update.assertUpdateCallsMadeEquals(2);
  }
}
