package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Snap;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasInternalStateThatMayNeedManualUpdating;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.meta.LayerProperties;

public class LayerPart implements Part, Snap, Comparable<LayerPart>, HasActions, HasInternalStateThatMayNeedManualUpdating {
  private LayerProperties  cachedLayerProperties;
  private final Document   document;
  public final EditBoolean ignoreSnap;
  public final EditString  layer;
  public final EditBoolean layerlock;
  public final EditDouble  order;

  public LayerPart(final Document document, final LinkedDataMap data) {
    this.document = document;
    layer = data.getString("layer", "_");
    layer.subscribe((t, u) -> updateInternalState());
    order = data.getDouble("order", Double.MAX_VALUE);
    layerlock = data.getBoolean("layerlock", false);
    ignoreSnap = data.getBoolean("ignoresnap", false);
    updateInternalState();
  }

  @Override
  public int compareTo(final LayerPart o) {
    return getEstimatedSortingKey().compareTo(o.getEstimatedSortingKey());
  }

  private Double getEstimatedSortingKey() {
    final int z = cachedLayerProperties.zorder.value();
    return z * document.getThings().size() + order.value();
  }

  public LayerProperties getLayerProperties() {
    return cachedLayerProperties;
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("push.down".equals(action)) {
      order.value(order.value() - 1.5);
      return;
    }
    if ("bring.up".equals(action)) {
      order.value(order.value() + 1.5);
      return;
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    actionsAvailable.add("bring.up");
    actionsAvailable.add("push.down");
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
  public void updateInternalState() {
    cachedLayerProperties = document.layers.get(layer.getAsText());
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
