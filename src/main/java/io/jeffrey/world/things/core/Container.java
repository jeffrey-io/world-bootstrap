package io.jeffrey.world.things.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import io.jeffrey.world.document.history.History;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.WorldFileSystem;

public class Container implements Iterable<AbstractThing> {
  public final Camera                       camera;
  public final int                          controlPointSize = 8;
  public final int                          edgeWidthSize    = 4;

  public final WorldFileSystem              fs;
  public final History                      history;
  public final ImageCache                   imageCache       = new ImageCache();

  public final Map<String, LayerProperties> layers;
  private final ArrayList<AbstractThing>    thingsByOrder;
  private final ArrayList<AbstractThing>    thingsByPersistence;

  public Container(final Camera camera, final WorldFileSystem fs) {
    this.camera = camera;
    this.fs = fs;
    thingsByOrder = new ArrayList<>();
    thingsByPersistence = new ArrayList<>();

    // history of all changes in the container
    history = new History();

    // layer data source
    layers = new TreeMap<>();
    layers.put("_", new LayerProperties("_", "Foreground"));
  }

  public Iterable<AbstractThing> getThingsByPersistenceOrder() {
    return thingsByPersistence;
  }

  public void add(final AbstractThing thing) {
    history.capture();
    thingsByOrder.add(thing);
    thingsByPersistence.add(thing);
    thing.invokeAction("delete", false);
    history.register(thing);
    thing.invokeAction("undelete", false);
    thing.invokeAction("select", false);
    history.capture();
  }

  private int compare(final AbstractThing a, final AbstractThing b) {
    final LayerPart layerA = a.first(LayerPart.class);
    final LayerPart layerB = b.first(LayerPart.class);
    if (layerA == null) {
      if (layerB == null) {
        return 0;
      } else {
        return 1;
      }
    } else {
      if (layerB == null) {
        return -1;
      } else {
        return layerA.compareTo(layerB);
      }
    }
  }

  public Collection<GuideLine> getGuideLines(final String layerId) {
    final LayerProperties lp = layers.get(layerId);
    if (lp != null) {
      return lp.guides;
    }
    return new HashSet<>();
  }

  @Override
  public Iterator<AbstractThing> iterator() {
    return thingsByOrder.iterator();
  }

  public int size() {
    return thingsByOrder.size();
  }

  public void sort() {
    if (thingsByOrder.size() == 0) {
      return;
    }
    thingsByOrder.sort((o1, o2) -> compare(o1, o2));
    int layerAt = -1;
    int newOrder = 0;
    for (final AbstractThing thing : thingsByOrder) {
      final LayerPart layer = thing.first(LayerPart.class);
      if (layer != null) {
        if (layer.z() != layerAt) {
          layerAt = layer.z();
          newOrder = 0;
        }
        newOrder++;
        layer.order(newOrder);
      }
    }
  }

}
