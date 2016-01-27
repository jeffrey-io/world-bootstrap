package io.jeffrey.world.things.parts;

import java.util.ArrayList;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.world.things.interactions.Rule;
import io.jeffrey.world.things.points.SelectablePoint2;

public class TestMoveByEdgePart extends WorldTestFramework {

  @Test
  public void verifyFoundAndNotSelected() {
    final ArrayList<Rule> proposed = new ArrayList<>();
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final HasSelectableEdgesMock edges = new HasSelectableEdgesMock();
    final SelectablePoint2[] points = new SelectablePoint2[] { new SelectablePoint2(0, 0), new SelectablePoint2(1, 0), };
    edges.edges.add(points);
    points[1].selected = true;
    final MoveByEdgePart edgeMover = new MoveByEdgePart(container, new IdentityTransform(), edges, thing.editing.locked, thing.editing, thing.position, thing.rotation);
    final SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(0.5, 0.0);
    final InteractionSelectionSolver solver = prepareSolver(mouse, thing, proposed, true);
    edgeMover.buildSelectionSolver(solver);
    solver.unfocus();
    assertNotNull(solver.solve());
    assertEquals(1, proposed.size());
    assertEquals(Rule.NotAlreadySelectedAndPointIsInItem, proposed.get(0));
  }

  @Test
  public void verifyFoundAndAlreadySelectedByObject() {
    final ArrayList<Rule> proposed = new ArrayList<>();
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final HasSelectableEdgesMock edges = new HasSelectableEdgesMock();
    final SelectablePoint2[] points = new SelectablePoint2[] { new SelectablePoint2(0, 0), new SelectablePoint2(1, 0), };
    edges.edges.add(points);
    thing.editing.selected.value(true);
    final MoveByEdgePart edgeMover = new MoveByEdgePart(container, new IdentityTransform(), edges, thing.editing.locked, thing.editing, thing.position, thing.rotation);
    final SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(0.5, 0.0);
    final InteractionSelectionSolver solver = prepareSolver(mouse, thing, proposed, true);
    edgeMover.buildSelectionSolver(solver);
    solver.unfocus();
    assertNotNull(solver.solve());
    assertEquals(1, proposed.size());
    assertEquals(Rule.AlreadySelectedItemAndPointPreserves, proposed.get(0));
  }

  @Test
  public void verifyNotFound() {
    final ArrayList<Rule> proposed = new ArrayList<>();
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final HasSelectableEdgesMock edges = new HasSelectableEdgesMock();
    final SelectablePoint2[] points = new SelectablePoint2[] { new SelectablePoint2(0, 0), new SelectablePoint2(1, 0), };
    edges.edges.add(points);
    points[0].selected = true;
    final MoveByEdgePart edgeMover = new MoveByEdgePart(container, new IdentityTransform(), edges, thing.editing.locked, thing.editing, thing.position, thing.rotation);
    final SimulatedMouse mouse = new SimulatedMouse();
    mouse.go(20, 2);
    final InteractionSelectionSolver solver = prepareSolver(mouse, thing, proposed, true);
    edgeMover.buildSelectionSolver(solver);
    solver.unfocus();
    assertNull(solver.solve());
    assertEquals(0, proposed.size());
  }
}