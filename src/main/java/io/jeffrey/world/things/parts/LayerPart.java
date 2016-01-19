package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.meta.LayerProperties;

public class LayerPart implements Part {
  private LayerProperties  cachedLayerProperties;
  private final Document   document;
  public final EditString  layer;
  public final EditBoolean layerlock;

  public final EditDouble  order;

  public LayerPart(final Document document, final LinkedDataMap data) {
    this.document = document;
    layer = data.getString("layer", "_");
    layer.subscribe((t, u) -> update());
    order = data.getDouble("order", Double.MAX_VALUE);
    layerlock = data.getBoolean("layerlock", false);
    update();
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
    if ("push.down".equals(action)) {
      order.value(order.value() - 1.5);
      return;
    }
    if ("bring.up".equals(action)) {
      order.value(order.value() + 1.5);
      return;
    }
  }

  public LayerProperties getLayerProperties() {
    return cachedLayerProperties;
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
    actionsAvailable.add("bring.up");
    actionsAvailable.add("push.down");
  }

  @Override
  public void update() {
    cachedLayerProperties = document.layers.get(layer.getAsText());
  }

  public int z() {
    if (cachedLayerProperties != null) {
      return cachedLayerProperties.zorder.value();
    }
    return 0;
  }

}
