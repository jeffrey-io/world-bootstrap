package io.jeffrey.world.things.points;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import io.jeffrey.zer.edits.EditString;

public class TestSelectablePointsCommitment extends WorldTestFramework {

  @Test
  public void verify() {
    final EditString es = new EditString("points", "1,2,3,4,5,6");
    final SelectablePoint2List list = new SelectablePoint2List(es);
    list.iterator().next().x += 1;
    assertEquals("1,2,3,4,5,6", es.value());
    final SelectablePointsCommitment commitment = new SelectablePointsCommitment(list);
    commitment.commit();
    assertEquals("2.0,2.0,3.0,4.0,5.0,6.0", es.value());
  }
}
