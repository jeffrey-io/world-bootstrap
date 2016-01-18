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

  public LayerProperties getLayerProperties() {
    return cachedLayerProperties;
  }

  @Override
  public boolean unique() {
    return true;
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

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {

  }

}
