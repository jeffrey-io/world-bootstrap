package io.jeffrey.world.things.parts;

import java.util.ArrayList;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.IdentitySnap;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.interactions.Rule;

public class TestGenericMoverPart extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final BasicThing thing = new BasicThing(makeSimpleContainer(), data);
    final GenericMoverPart mover = new GenericMoverPart(thing.position, thing.rotation, thing.editing);
    final SimulatedMouse mouse = new SimulatedMouse();
    final ArrayList<Rule> proposals = new ArrayList<>();
    mover.buildSelectionSolver(prepareSolver(mouse, thing, proposals, true));
    assertEquals(0, proposals.size());
    thing.editing.selected.value(true);
    mover.buildSelectionSolver(prepareSolver(mouse, thing, proposals, true));
    assertEquals(1, proposals.size());
    assertEquals(Rule.AlreadySelectedItemButNotInvolved, proposals.get(0));
  }
}
