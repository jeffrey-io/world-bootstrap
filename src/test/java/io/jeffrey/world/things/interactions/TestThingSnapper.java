package io.jeffrey.world.things.interactions;

import java.util.ArrayList;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

public class TestThingSnapper extends WorldTestFramework {

  @Test
  public void verify() {
    final NoOpThingInteraction ti = new NoOpThingInteraction();
    final NoOpGuidelineEnforcer enforcer = new NoOpGuidelineEnforcer();
    final ArrayList<GuideLine> lines = new ArrayList<>();
    final ThingSnapper snapper = new ThingSnapper(new Camera(), lines, enforcer, ti);

    assertEquals(0, ti.cancelCalls);
    snapper.cancel();
    assertEquals(1, ti.cancelCalls);

    assertEquals(0, ti.commitCalls);
    snapper.commit();
    assertEquals(1, ti.commitCalls);

    assertEquals(0, ti.selectCalls);
    snapper.select();
    assertEquals(1, ti.selectCalls);

    assertEquals(0, ti.movedCalls);
    snapper.moved(null);
    assertEquals(1, ti.movedCalls);
    assertEquals(0, enforcer.attemptSnapToCallsMade);
    lines.add(new GuideLine());
    snapper.moved(null);
    assertEquals(2, ti.movedCalls);
    assertEquals(1, enforcer.attemptSnapToCallsMade);
  }
}
