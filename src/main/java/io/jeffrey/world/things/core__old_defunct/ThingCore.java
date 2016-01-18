package io.jeffrey.world.things.core__old_defunct;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.document.history.HistoryEditTrap;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.Snap;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.parts.ColorPart;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.IdentityPart;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.LifetimePart;
import io.jeffrey.world.things.parts.MetadataPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;
import io.jeffrey.world.things.parts.StandardTransform;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public abstract class ThingCore extends AbstractThing implements Editable, Comparable<Thing> {
  protected final EditingPart  editing;
  protected final ColorPart    fill;
  protected final IdentityPart identity;
  protected final LayerPart    layerP;
  protected final LifetimePart lifetime;
  protected final MetadataPart metadata;
  protected final PositionPart position;
  protected final RotationPart rotation;
  protected final ScalePart    scale;
  protected final Transform    transform;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data for the node comes from
   */
  public ThingCore(final Document document, final ThingData node) {
    super(document, node);
    
    Snap snap = new Snap() {
      
      @Override
      public double y(double y) {
        return snapValue(y);
      }
      
      @Override
      public double x(double x) {
        return snapValue(x);
      }
    };

    position = new PositionPart(data, snap);
    register("position", position);

    scale = new ScalePart(data);
    register("scale", scale);

    rotation = new RotationPart(data);
    register("rotation", rotation);

    identity = new IdentityPart(data);
    register("identity", identity);

    transform = new StandardTransform(position, scale, rotation);

    metadata = new MetadataPart("metadata_", data);
    register("metadata", metadata);

    lifetime = new LifetimePart(data);
    register("lifetime", lifetime);

    editing = new EditingPart(data);
    register("editing", editing);

    layerP = new LayerPart(document, data);
    register("layer", layerP);

    fill = new ColorPart("fill", data);
    register("fill", fill);
  }

  /**
   * @return if the aspect is locked
   */
  public boolean aspectLocked() {
    return scale.aspect.value();
  }

  /**
   * reset the selection
   */
  protected abstract void clearSelection();

  /**
   * {@inheritDoc}
   */
  @Override
  public int compareTo(final Thing o) {
    final int dlayer = -Integer.compare(o.layerZ(), layerZ());
    if (dlayer == 0) {
      return -Double.compare(o.layerP.order.value(), layerP.order.value());
    }
    return dlayer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void createEditor(final SurfaceData data, final SurfaceItemEditorBuilder builder, final Syncable parent) {
    ThingEditor.buildUserInterface(document, data, this, builder, parent);
  }

  /**
   * delete the element
   */
  protected void delete() {
    document.history.register(this);
    unselect();
    lifetime.delete();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, Edit> getLinks(final boolean withHistory) {
    final HashMap<String, Edit> links = new HashMap<>();
    links.putAll(data.getLinks());
    if (withHistory) {
      final HashMap<String, Edit> actualLinks = new HashMap<>();
      for (final Entry<String, Edit> link : links.entrySet()) {
        actualLinks.put(link.getKey(), new HistoryEditTrap(link.getValue(), document.history, this));
      }
      return actualLinks;
    } else {
      return links;
    }
  }

  /**
   * @return the meta class of the thing
   */
  public String getMetaclass() {
    return identity.metaclass.value();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String id() {
    return identity.getID();
  }

  /**
   * indicate that the data has changed with force
   */
  public abstract void invalidate();

  /**
   * @return the thing's layer
   */
  public LayerProperties layer() {
    return layerP.getLayerProperties();
  }

  /**
   * @return the layer's order
   */
  public int layerZ() {
    return layerP.z();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Edit metadataOf(final String key, final String defaultValue) {
    return metadata.metadataOf(key, defaultValue);
  }

  /**
   * @return the order
   */
  public double order() {
    return layerP.order.value();
  }

  /**
   * @param value
   *          the new order
   */
  public void order(final double value) {
    layerP.order.value(value);
  }

  /**
   * save the data from things thing to the given map
   *
   * @param object
   *          the data container
   */
  public void saveTo(final Map<String, String> object) {
    final Map<String, Edit> myLinks = getLinks(false);
    for (final String key : myLinks.keySet()) {
      object.put(key, myLinks.get(key).getAsText());
    }
  }

  /**
   * helper to select the thing
   */
  public void select() {
    unselect();
    editing.selected.value(true);
  }

  /**
   * snap the given value to the current layer
   *
   * @param v
   *          the value to snap
   * @return the resulting snap'd value
   */
  private double snapValue(final double v) {
    final LayerProperties p = layerP.getLayerProperties();
    if (p != null) {
      return p.snap(v);
    }
    return v;
  }

  /**
   * @return whether or not thing supports a color property
   */
  protected abstract boolean supportsColor();



  /**
   * helper to unselect the thing
   */
  public void unselect() {
    editing.selected.value(false);
    clearSelection();
  }

  
  
}
