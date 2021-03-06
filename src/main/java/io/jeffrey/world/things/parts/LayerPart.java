package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.data.EditBoolean;
import io.jeffrey.world.data.EditDouble;
import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;
import io.jeffrey.world.things.core.Snap;
import io.jeffrey.zer.meta.LayerProperties;

public class LayerPart implements Part, Snap, Comparable<LayerPart>, HasActions, HasUpdate {
  private LayerProperties  cachedLayerProperties;
  private final Container  container;
  public final EditBoolean ignoreSnap;
  public final EditString  layer;
  public final EditBoolean layerlock;
  public final EditDouble  order;

  public LayerPart(final Container container, final LinkedDataMap data) {
    this.container = container;
    layer = data.getString("layer", "_");
    layer.subscribe((t, u) -> update());
    order = data.getDouble("order", Double.MAX_VALUE);
    layerlock = data.getBoolean("layerlock", false);
    ignoreSnap = data.getBoolean("ignoresnap", false);
    update();
  }

  @Override
  public int compareTo(final LayerPart o) {
    return getEstimatedSortingKey().compareTo(o.getEstimatedSortingKey());
  }

  private Double getEstimatedSortingKey() {
    return z() * (1 + container.size()) + order.value();
  }

  public LayerProperties getLayerProperties() {
    return cachedLayerProperties;
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("order_push_down".equals(action)) {
      order.value(order.value() - 1.5);
      return;
    }
    if ("order_push_up".equals(action)) {
      order.value(order.value() + 1.5);
      return;
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    actionsAvailable.add("order_push_up");
    actionsAvailable.add("order_push_down");
  }

  /**
   * @return the order
   */
  public double order() {
    return order.value();
  }

  /**
   * @param value
   *          the new order
   */
  public void order(final double value) {
    order.value(value);
  }

  private double snapValue(final double v) {
    if (ignoreSnap.value()) {
      return v;
    }
    if (cachedLayerProperties != null) {
      return cachedLayerProperties.snap(v);
    }
    return v;
  }

  @Override
  public void update() {
    cachedLayerProperties = container.layers.get(layer.value());
  }

  @Override
  public double x(final double x) {
    return snapValue(x);
  }

  @Override
  public double y(final double y) {
    return snapValue(y);
  }

  public int z() {
    if (cachedLayerProperties != null) {
      return cachedLayerProperties.zorder.value();
    }
    return 0;
  }
}
