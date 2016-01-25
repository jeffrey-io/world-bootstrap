package io.jeffrey.world.things.interactions;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.document.history.History;
import io.jeffrey.world.things.core.Transform;

public class TestThingInteractionToMouseIteractionAdapter extends WorldTestFramework {

  @Test
  public void verify() {
    final Transform transform = new IdentityTransform();
    final NoOpThingInteraction interaction = new NoOpThingInteraction();
    final History history = new History();
    final SimulatedMouse mouse = new SimulatedMouse();
    final ThingInteractionToMouseIteractionAdapter adapter = new ThingInteractionToMouseIteractionAdapter(history, interaction, transform);
    adapter.cancel();
    assertEquals(1, interaction.cancelCalls);
    adapter.commit();
    assertEquals(1, interaction.commitCalls);
    adapter.moved(mouse.get());
    assertEquals(1, interaction.movedCalls);
  }
}
