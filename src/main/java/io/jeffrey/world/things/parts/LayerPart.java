package io.jeffrey.world.things.parts;

import java.util.function.BiConsumer;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.meta.LayerProperties;

public class LayerPart implements Part {
  private final Document document;
  public final EditString   layer;
  public final EditBoolean  layerlock;
  public final EditDouble   order;
  
  private LayerProperties cachedLayerProperties;
  
  public LayerPart(final Document document, final LinkedDataMap data) {
    this.document = document;
    layer = data.getString("layer", "_");
    layer.subscribe(new BiConsumer<String, String>() {
      @Override
      public void accept(String t, String u) {
        update();
      }
    });
    order = data.getDouble("order", Double.MAX_VALUE);
    layerlock = data.getBoolean("layerlock", false);
    update();
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
    cachedLayerProperties = document.layers.get(layer.getAsText());
  }
  
  public LayerProperties getLayerProperties() {
    return cachedLayerProperties;
  }
  
  public int z() {
    if (cachedLayerProperties != null) {
      return cachedLayerProperties.zorder.value();
    }
    return 0;
  }
}
