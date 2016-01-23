package io.jeffrey.world.things.interactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Supplier;

import io.jeffrey.world.document.history.History;
import io.jeffrey.world.document.history.HistoryMouseInteractionTrapper;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SetMover;

public class SelectionSolver {

  private class AdaptThingToMouse implements Supplier<MouseInteraction> {

    private final Supplier<ThingInteraction> delegate;
    private final AbstractThing              thing;

    public AdaptThingToMouse(final AbstractThing thing, final Supplier<ThingInteraction> delegate) {
      this.thing = thing;
      this.delegate = delegate;
    }

    @Override
    public MouseInteraction get() {
      final ThingInteraction it = delegate.get();
      it.select();
      return new ThingInteractionToMouseIteractionAdapter(history, it, thing.transform());
    }
  }

  private class Possibily {
    private final ArrayList<Supplier<MouseInteraction>> suppliers;

    private Possibily() {
      suppliers = new ArrayList<>();
    }

    public MouseInteraction all() {
      final HashSet<MouseInteraction> reduced = new HashSet<>();
      for (final Supplier<MouseInteraction> sup : suppliers) {
        reduced.add(sup.get());
      }
      return new SetMover(reduced);
    }

    public MouseInteraction last() {
      return suppliers.get(suppliers.size() - 1).get();
    }

    @Override
    public String toString() {
      return "sized=" + suppliers.size();
    }
  }

  public static enum Rule {
    AlreadySelectedAndPointPreserves, // a doodad is involved
    AlreadySelectedButNotInvolved, // confusing case
    Doodad, // move it along
    NotAlreadySelectedAndPointIsIn // move the thing
  }

  private AbstractThing                  current;
  public final AdjustedMouseEvent        event;
  private final History                  history;

  private final HashMap<Rule, Possibily> possibilites;

  public SelectionSolver(final History history, final AdjustedMouseEvent event) {
    this.history = history;
    this.event = event;
    possibilites = new HashMap<>();
    current = null;
  }

  public void accept(final Rule rule, final Supplier<ThingInteraction> supplier) {
    System.out.println("ACCEPT:" + rule);
    Possibily possibilty = possibilites.get(rule);
    if (possibilty == null) {
      possibilty = new Possibily();
      possibilites.put(rule, possibilty);
    }
    if (rule == Rule.AlreadySelectedAndPointPreserves) {
      accept(Rule.AlreadySelectedButNotInvolved, supplier);
    }
    possibilty.suppliers.add(new AdaptThingToMouse(current, supplier));
  }

  public void focus(final AbstractThing thing) {
    current = thing;
  }

  public MouseInteraction solve() {
    MouseInteraction solution = solveWithoutHistory();
    if (solution != null) {
      return new HistoryMouseInteractionTrapper(history, solution);
    }
    return null;
  }
  
  private MouseInteraction solveWithoutHistory() {
    for (final Rule rule : possibilites.keySet()) {
      System.out.println("rule:" + rule + " " + possibilites.get(rule));
    }

    final Possibily doodad = possibilites.get(Rule.Doodad);
    if (doodad != null) {
      return doodad.last();
    }

    final Possibily directSelection = possibilites.get(Rule.NotAlreadySelectedAndPointIsIn);
    if (directSelection != null) {
      return directSelection.last();
    }

    final Possibily already = possibilites.get(Rule.AlreadySelectedAndPointPreserves);
    if (already != null) {
      return possibilites.get(Rule.AlreadySelectedButNotInvolved).all();
    }
    return null;
  }
}
