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
  }

  private static enum GroupingRule {
    Doodad, Item, Set, Nothing
  }

  public static enum Rule {
    Doodad(0, GroupingRule.Doodad, false), // highest precedence

    NotAlreadySelectedAndPointIsFacet(10, GroupingRule.Item, false), // the point is inside and we are not selected
    NotAlreadySelectedAndPointIsInSubset(11, GroupingRule.Item, false), // the point is inside and we are not selected
    NotAlreadySelectedAndPointIsInItem(12, GroupingRule.Item, false), // we are not selected, but the point touches a sub selection

    AlreadySelectedFacetAndPointPreserves(100, GroupingRule.Set, true),

    AlreadySelectedSubsetButNotInvolved(200, GroupingRule.Set, false),
    AlreadySelectedSubsetAndPointPreserves(201, GroupingRule.Set, true),
    
    AlreadySelectedItemAndPointPreserves(300, GroupingRule.Set, true),
    AlreadySelectedItemButNotInvolved(301, GroupingRule.Set, false),
    
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

  private AbstractThing                          currentThing;
  public AdjustedMouseEvent                event;
  private final History                          history;

  private final HashMap<GroupingRule, Possibily> possibilites;

  public SelectionSolver(final History history) {
    this.history = history;
    this.event = null;
    possibilites = new HashMap<>();
    currentThing = null;
    this.setEnabled = false;
  }

  private Rule                       proposedRule;
  private Supplier<ThingInteraction> proposedSupplier;
  private boolean setEnabled;

  public void propose(final Rule rule, final Supplier<ThingInteraction> supplier) {
    if (rule.precedence < proposedRule.precedence) {
      this.proposedRule = rule;
      this.proposedSupplier = supplier;
    }
    if (rule.togglesSet) {
      setEnabled = true;
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
    AdaptThingToMouse adapted = new AdaptThingToMouse(currentThing, proposedSupplier);
    get(proposedRule.group).suppliers.add(adapted);
    
    System.out.println("accepted:" + proposedRule + " on " + currentThing.getClass());
  }

  public void focus(final AbstractThing thing, AdjustedMouseEvent event) {
    this.event = event;
    currentThing = thing;
    this.proposedRule = Rule.Nothing;
    this.proposedSupplier = null;
  }

  public void unfocus() {
    accept();
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
      System.out.println("using doodad's last");
      return doodad.last();
    }

    final Possibily item = possibilites.get(GroupingRule.Item);
    if (item != null) {
      System.out.println("using item's last");
      return item.last();
    }

    final Possibily already = possibilites.get(GroupingRule.Set);
    if (already != null && setEnabled) {
      System.out.println("using group");
      return possibilites.get(GroupingRule.Set).all();
    }
    return null;
  }
}
