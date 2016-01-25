package io.jeffrey.world.things.interactions;

import java.util.function.Supplier;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.document.history.History;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;

public class TestInteractionSelectionSolver extends WorldTestFramework {
  private final Supplier<ThingInteraction> loser  = () -> {
                                                    fail();
                                                    return null;
                                                  };
  private final Supplier<ThingInteraction> winner = () -> new NoOpThingInteraction();

  InteractionSelectionSolver makeSolver() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    final InteractionSelectionSolver solver = new InteractionSelectionSolver(new History());
    final SimulatedMouse mouse = new SimulatedMouse();
    solver.focus(thing, mouse.get());
    return solver;
  }

  @Test
  public void verifyAllGroupItemsCome() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, winner);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, winner);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, winner);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, winner);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyDoodadTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.Doodad, winner);
    solver.propose(Rule.NotAlreadySelectedAndPointIsFacet, loser);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, loser);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, loser);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, loser);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, loser);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyFacetTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsFacet, winner);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, loser);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, loser);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, loser);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, loser);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyItemTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, winner);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, loser);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, loser);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyNoGroupingWithoutPreservation() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, loser);
    solver.propose(Rule.AlreadySelectedItemButNotInvolved, loser);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifySubsetTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, winner);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, loser);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, loser);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, loser);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, loser);
    solver.propose(Rule.Nothing, loser);
    solver.unfocus();
    solver.solve();
  }
}
