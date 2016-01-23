package io.jeffrey.world.things.interactions;

import java.util.ArrayList;
import java.util.function.Supplier;

import io.jeffrey.zer.AdjustedMouseEvent;

public class SelectionSolver {

  private final ArrayList<Supplier<ThingInteraction>> acceptanceSuppliers;

  public final AdjustedMouseEvent event;

  public SelectionSolver(AdjustedMouseEvent event) {
    this.event = event;
    this.acceptanceSuppliers = new ArrayList<>();
  }
  
  public static enum Rule {
    AlreadySelectedButNotInvolved,
    AlreadySelectedAndPointPreserves,
    NotAlreadySelectedAndPointIsIn
  }

  public void accept(Rule rule, Supplier<ThingInteraction> supplier) {

  }

  public ThingInteraction solve() {
    return null;
  }
}
