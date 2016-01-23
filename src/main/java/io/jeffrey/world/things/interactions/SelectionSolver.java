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

  private static enum GroupingRule {
    Doodad, Item, Set, Nothing
  }

  public static enum Rule {
    Doodad(0, GroupingRule.Doodad, false), // highest precedence

    NotAlreadySelectedAndPointIsFacet(10, GroupingRule.Item, false), // the point is inside and we are not selected
    NotAlreadySelectedAndPointIsInSubset(11, GroupingRule.Item, false), // the point is inside and we are not selected
    NotAlreadySelectedAndPointIsInItem(12, GroupingRule.Item, false), // we are not selected, but the point touches a sub selection

    AlreadySelectedAndPointPreservesFacet(100, GroupingRule.Set, true), // we are selected and the point preserves us
    AlreadySelectedAndPointPreservesSubset(101, GroupingRule.Set, true), // we are selected and the point preserves us
    AlreadySelectedAndPointPreservesItem(102, GroupingRule.Set, true), // we are selected and the point preserves us

    AlreadySelectedSubsetButNotInvolved(1000, GroupingRule.Set, false), // we are selected but not selected, and should something be moved, we would like to be moved as well
    AlreadySelectedFacetButNotInvolved(1001, GroupingRule.Set, false), // we are selected but not selected, and should something be moved, we would like to be moved as well

    
    Nothing(Integer.MAX_VALUE, GroupingRule.Nothing, false);

    public final int           precedence;
    private final GroupingRule group;
    private final boolean togglesSet;

    private Rule(int precedence, GroupingRule group, boolean togglesSet) {
      this.precedence = precedence;
      this.group = group;
      this.togglesSet = togglesSet;
    }
  }

  private AbstractThing                          current;
  public final AdjustedMouseEvent                event;
  private final History                          history;

  private final HashMap<GroupingRule, Possibily> possibilites;

  public SelectionSolver(final History history, final AdjustedMouseEvent event) {
    this.history = history;
    this.event = event;
    possibilites = new HashMap<>();
    current = null;
  }

  private Rule                       proposedRule;
  private Supplier<ThingInteraction> proposedSupplier;
  private boolean setEnabled;

  public void propose(final Rule rule, final Supplier<ThingInteraction> supplier) {
    System.out.println(" {{ proposed: " + rule + "}}");
    if (rule.precedence < proposedRule.precedence) {
      this.proposedRule = rule;
      this.proposedSupplier = supplier;
    }
  }

  private Possibily get(GroupingRule group) {
    Possibily possibilty = possibilites.get(group);
    if (possibilty == null) {
      possibilty = new Possibily();
      possibilites.put(group, possibilty);
    }
    return possibilty;
  }

  private void accept() {
    System.out.println("Accepted:" + proposedRule + " \\in " + proposedRule.group);
    AdaptThingToMouse adapted = new AdaptThingToMouse(current, proposedSupplier);
    get(proposedRule.group).suppliers.add(adapted);
    if (proposedRule.togglesSet) {
      setEnabled = true;
    }
  }

  public void focus(final AbstractThing thing) {
    current = thing;
    this.proposedRule = Rule.Nothing;
    this.proposedSupplier = null;
  }

  public void unfocus() {
    accept();
  }

  public MouseInteraction solve() {
    MouseInteraction solution = solveWithoutHistory();
    if (solution != null) {
      return new HistoryMouseInteractionTrapper(history, solution);
    }
    return null;
  }

  private MouseInteraction solveWithoutHistory() {
    for (final GroupingRule rule : possibilites.keySet()) {
      System.out.println("rule:" + rule + " " + possibilites.get(rule));
    }

    final Possibily doodad = possibilites.get(GroupingRule.Doodad);
    if (doodad != null) {
      return doodad.last();
    }

    final Possibily item = possibilites.get(GroupingRule.Item);
    if (item != null) {
      return item.last();
    }

    final Possibily already = possibilites.get(GroupingRule.Set);
    if (already != null && setEnabled) {
      return possibilites.get(GroupingRule.Set).all();
    }
    return null;
  }
}
