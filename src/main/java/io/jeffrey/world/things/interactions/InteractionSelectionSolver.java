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

public class InteractionSelectionSolver {

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
  }

  private AbstractThing                          currentThing;
  public AdjustedMouseEvent                      event;
  private final History                          history;

  private final HashMap<GroupingRule, Possibily> possibilites;

  private Rule                                   proposedRule;

  private Supplier<ThingInteraction>             proposedSupplier;
  private boolean                                setEnabled;

  public InteractionSelectionSolver(final History history) {
    this.history = history;
    event = null;
    possibilites = new HashMap<>();
    currentThing = null;
    setEnabled = false;
  }

  private void accept() {
    final AdaptThingToMouse adapted = new AdaptThingToMouse(currentThing, proposedSupplier);
    get(proposedRule.group).suppliers.add(adapted);
  }

  public void focus(final AbstractThing thing, final AdjustedMouseEvent event) {
    this.event = event;
    currentThing = thing;
    proposedRule = Rule.Nothing;
    proposedSupplier = null;
  }

  private Possibily get(final GroupingRule group) {
    Possibily possibilty = possibilites.get(group);
    if (possibilty == null) {
      possibilty = new Possibily();
      possibilites.put(group, possibilty);
    }
    return possibilty;
  }

  public void propose(final Rule rule, final Supplier<ThingInteraction> supplier) {
    if (rule.precedence < proposedRule.precedence) {
      proposedRule = rule;
      proposedSupplier = supplier;
    }
    if (rule.togglesSet) {
      setEnabled = true;
    }
  }

  public MouseInteraction solve() {
    MouseInteraction solution = solveWithoutHistory();
    if (solution != null) {
      solution = new HistoryMouseInteractionTrapper(history, solution);
    }
    return solution;
  }

  private MouseInteraction solveWithoutHistory() {
    final Possibily doodad = possibilites.get(GroupingRule.Doodad);
    if (doodad != null) {
      return doodad.last();
    }
    final Possibily item = possibilites.get(GroupingRule.Item);
    if (item != null) {
      return item.last();
    }
    if (setEnabled) {
      return possibilites.get(GroupingRule.Set).all();
    }
    return null;
  }

  public void unfocus() {
    accept();
  }
}
