package io.jeffrey.world.things.parts;

import java.util.HashSet;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.zer.meta.LayerProperties;

public class TestLayerPart extends WorldTestFramework {

  @Test
  public void verify() {
    final Container container = makeSimpleContainer();
    final LayerPart layer1 = new LayerPart(container, data("order", "2"));
    final LayerPart layer2 = new LayerPart(container, data("order", "7"));
    layer1.layer.value("foo");
    assertTrue(layer1.compareTo(layer2) < 0);
    assertTrue(layer2.compareTo(layer1) > 0);
    assertTrue(layer1.compareTo(layer1) == 0);
    assertTrue(layer2.compareTo(layer2) == 0);
    assertNull(layer1.getLayerProperties());
    final LayerProperties lp = new LayerProperties("z", "k");
    lp.zorder.value(10);
    container.layers.put("foo", lp);
    assertNull(layer1.getLayerProperties());
    assertEquals(123.12, layer1.x(123.12));
    layer1.update();
    assertNotNull(layer1.getLayerProperties());
    assertTrue(layer1.compareTo(layer2) > 0);
    assertTrue(layer2.compareTo(layer1) < 0);
    layer2.order(1000000);
    assertEquals(1000000, layer2.order());
    assertTrue(layer1.compareTo(layer2) < 0);
    assertTrue(layer2.compareTo(layer1) > 0);
    layer1.getLayerProperties().gridMinor.value(10.0);
    assertEquals(120, layer1.x(123.12));
    assertEquals(120, layer1.y(123.12));
    layer1.ignoreSnap.value(true);
    assertEquals(123.12, layer1.x(123.12));
    assertEquals(123.12, layer1.y(123.12));
    final HashSet<String> actions = new HashSet<>();
    layer1.listActions(actions);
    assertTrue(actions.contains("order_push_down"));
    assertTrue(actions.contains("order_push_up"));
    layer2.invokeAction("order_push_up", null);
    assertEquals(1000001.5, layer2.order());
    layer1.invokeAction("order_push_down", null);
    assertEquals(0.5, layer1.order());
    layer1.invokeAction("wikikiki", null);
  }
}
