package io.jeffrey.world.things.interactions;

import java.util.ArrayList;

import org.junit.Test;

import io.jeffrey.world.SimulatedMouse;
import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.RoundingSnap;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;

public class TestMultiThingInteraction extends WorldTestFramework {

  @Test
  public void verify() {
    final LinkedDataMap data = data();
    final SimulatedMouse mouse = new SimulatedMouse();
    final PositionPart position = new PositionPart(data, new RoundingSnap());
    final RotationPart rotation = new RotationPart(data);
    final EditingPart editing = new EditingPart(data());
    position.x(1);
    position.y(2);
    mouse.go(2.5, 3.5);
    final EditingPart editing2 = new EditingPart(data());
    final MultiThingInteraction multi = wrap(new ThingMover(mouse.get(), position, rotation, editing), new ThingSelector(editing2));
    mouse.add(multi);
    assertEquals(1, position.x());
    assertEquals(2, position.y());
    mouse.move(3.2, 3.9);
    assertEquals(4, position.x());
    assertEquals(6, position.y());
    assertFalse(editing.selected.value());
    assertFalse(editing2.selected.value());
    multi.select();
    assertTrue(editing.selected.value());
    assertTrue(editing2.selected.value());
    multi.cancel();
    multi.commit();
    assertEquals(1, position.x());
    assertEquals(2, position.y());
  }

  private MultiThingInteraction wrap(final ThingInteraction... its) {
    final ArrayList<ThingInteraction> list = new ArrayList<>();
    for (final ThingInteraction it : its) {
      list.add(it);
    }
    return new MultiThingInteraction(list);
  }
}
