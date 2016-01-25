package io.jeffrey.world.things.interactions;

public enum Rule {
  AlreadySelectedFacetAndPointPreserves(100, GroupingRule.Set, true), AlreadySelectedItemAndPointPreserves(300, GroupingRule.Set, true), AlreadySelectedItemButNotInvolved(301, GroupingRule.Set, false), AlreadySelectedSubsetAndPointPreserves(201, GroupingRule.Set, true), AlreadySelectedSubsetButNotInvolved(200, GroupingRule.Set, false), // highest precedence
  Doodad(0, GroupingRule.Doodad, false), NotAlreadySelectedAndPointIsFacet(10, GroupingRule.Item, false), // we are not selected, but the point touches a sub selection
  NotAlreadySelectedAndPointIsInItem(12, GroupingRule.Item, false), // the point is inside and we are not selected
  NotAlreadySelectedAndPointIsInSubset(11, GroupingRule.Item, false), // the point is inside and we are not selected
  Nothing(Integer.MAX_VALUE, GroupingRule.Nothing, false);

  final GroupingRule group;
  public final int   precedence;
  final boolean      togglesSet;

  private Rule(final int precedence, final GroupingRule group, final boolean togglesSet) {
    this.precedence = precedence;
    this.group = group;
    this.togglesSet = togglesSet;
  }
}