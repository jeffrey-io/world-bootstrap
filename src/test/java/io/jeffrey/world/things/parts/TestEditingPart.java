package io.jeffrey.world.things.parts;

import java.util.HashSet;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestEditingPart extends WorldTestFramework {

  @Test
  public void verifyInvocation() {
    final EditingPart editing = new EditingPart(data());
    assertFalse(editing.selected.value());
    assertFalse(editing.locked.value());

    final HashSet<String> actions = new HashSet<>();
    editing.listActions(actions);
    assertTrue(actions.contains("lock"));
    assertTrue(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertFalse(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("select", null);
    editing.listActions(actions);
    assertTrue(editing.selected.value());
    assertFalse(editing.locked.value());
    assertTrue(actions.contains("lock"));
    assertFalse(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertTrue(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("lock", null);
    editing.listActions(actions);
    assertTrue(editing.selected.value());
    assertTrue(editing.locked.value());
    assertFalse(actions.contains("lock"));
    assertFalse(actions.contains("select"));
    assertTrue(actions.contains("unlock"));
    assertTrue(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("unlock", null);
    editing.listActions(actions);
    assertTrue(editing.selected.value());
    assertFalse(editing.locked.value());
    assertTrue(actions.contains("lock"));
    assertFalse(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertTrue(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("unselect", null);
    editing.listActions(actions);
    assertFalse(editing.selected.value());
    assertFalse(editing.locked.value());
    assertTrue(actions.contains("lock"));
    assertTrue(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertFalse(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("inverse_selection", null);
    editing.listActions(actions);
    assertTrue(editing.selected.value());
    assertFalse(editing.locked.value());
    assertTrue(actions.contains("lock"));
    assertFalse(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertTrue(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

    editing.invokeAction("inverse_selection", null);
    editing.listActions(actions);
    assertFalse(editing.selected.value());
    assertFalse(editing.locked.value());
    assertTrue(actions.contains("lock"));
    assertTrue(actions.contains("select"));
    assertFalse(actions.contains("unlock"));
    assertFalse(actions.contains("unselect"));
    assertTrue(actions.contains("inverse_selection"));
    actions.clear();

  }
}
