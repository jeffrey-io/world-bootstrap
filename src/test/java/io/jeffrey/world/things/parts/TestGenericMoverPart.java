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
    final PositionPart position = new PositionPart(data, new IdentitySnap());
    final RotationPart rotation = new RotationPart(data);
    EditingPart editing = new EditingPart(data);
    GenericMoverPart mover = new GenericMoverPart(position, rotation, editing);
    SimulatedMouse mouse = new SimulatedMouse();
    ArrayList<Rule> proposals = new ArrayList<>();
    BasicThing thing = new BasicThing(makeSimpleContainer(), data);
    mover.buildSelectionSolver(prepareSolver(mouse, thing, proposals, true));
    assertEquals(0, proposals.size());
    editing.selected.value(true);
    mover.buildSelectionSolver(prepareSolver(mouse, thing, proposals, true));
    assertEquals(1, proposals.size());
    assertEquals(Rule.AlreadySelectedItemButNotInvolved, proposals.get(0));
  }
}
