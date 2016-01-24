package io.jeffrey.world.things.parts;

import java.util.HashSet;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestLifetimePart extends WorldTestFramework {
  @Test
  public void verifyInvocation() {
    final LifetimePart lifetime = new LifetimePart(data());
    final HashSet<String> actions = new HashSet<>();

    lifetime.listActions(actions);
    assertTrue(actions.contains("delete"));
    assertFalse(actions.contains("undelete"));
    assertTrue(actions.contains("templatize"));
    actions.clear();

    lifetime.invokeAction("delete", null);
    lifetime.listActions(actions);
    assertTrue(lifetime.deleted.value());
    assertFalse(actions.contains("delete"));
    assertTrue(actions.contains("undelete"));
    assertTrue(actions.contains("templatize"));
    actions.clear();

    lifetime.locklock.value(true);
    lifetime.invokeAction("undelete", null);
    lifetime.listActions(actions);
    assertFalse(lifetime.deleted.value());
    assertTrue(actions.contains("delete"));
    assertFalse(actions.contains("undelete"));
    assertFalse(actions.contains("templatize"));
    actions.clear();

    lifetime.delete();
    lifetime.listActions(actions);
    assertTrue(lifetime.deleted.value());
    assertFalse(actions.contains("delete"));
    assertTrue(actions.contains("undelete"));
    assertFalse(actions.contains("templatize"));
    actions.clear();

    lifetime.undelete();
    lifetime.listActions(actions);
    assertFalse(lifetime.deleted.value());
    assertTrue(actions.contains("delete"));
    assertFalse(actions.contains("undelete"));
    assertFalse(actions.contains("templatize"));
    actions.clear();
  }
}
