package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestThingCommitmentHook extends WorldTestFramework {

  @Test
  public void verify() {
    final ThingCommitmentHook hook = new ThingCommitmentHook() {
      @Override
      public void commit() {
      }
    };
    hook.moved(null);
    hook.commit();
    hook.cancel();
    hook.select();
  }
}
