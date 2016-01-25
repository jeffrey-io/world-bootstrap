package io.jeffrey.world.things.interactions;

import java.util.function.Supplier;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;

public class TestInteractionSelectionSolver extends WorldTestFramework {
  private final Supplier<ThingInteraction> LOSER  = () -> {
                                                    fail();
                                                    return null;
                                                  };
  private final Supplier<ThingInteraction> WINNER = () -> new NoOpThingInteraction();

  InteractionSelectionSolver makeSolver() {
    final Container container = makeSimpleContainer();
    final BasicThing thing = new BasicThing(container, data());
    return prepareSolver(new SimulatedMouse(), thing);
  }

  @Test
  public void verifyAllGroupItemsCome() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, WINNER);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, WINNER);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, WINNER);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, WINNER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyDoodadTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.Doodad, WINNER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsFacet, LOSER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, LOSER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, LOSER);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, LOSER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyFacetTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsFacet, WINNER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, LOSER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, LOSER);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, LOSER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyItemTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, WINNER);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, LOSER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifyNoGroupingWithoutPreservation() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, LOSER);
    solver.propose(Rule.AlreadySelectedItemButNotInvolved, LOSER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }

  @Test
  public void verifySubsetTrumping() {
    final InteractionSelectionSolver solver = makeSolver();
    solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, WINNER);
    solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, LOSER);
    solver.propose(Rule.AlreadySelectedFacetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetButNotInvolved, LOSER);
    solver.propose(Rule.AlreadySelectedSubsetAndPointPreserves, LOSER);
    solver.propose(Rule.AlreadySelectedItemAndPointPreserves, LOSER);
    solver.propose(Rule.Nothing, LOSER);
    solver.unfocus();
    solver.solve();
  }
}
