package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.Snap;
import io.jeffrey.world.things.base.StandardTransform;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.parts.ColorPart;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.LifetimePart;
import io.jeffrey.world.things.parts.MetadataPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public abstract class ThingCore extends AbstractThing implements Editable, Comparable<Thing> {
  protected final ColorPart    fill;
  protected final LayerPart    layer;
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

    final Snap snap = new Snap() {

      @Override
      public double x(final double x) {
        return snapValue(x);
      }

      @Override
      public double y(final double y) {
        return snapValue(y);
      }
    };

    position = new PositionPart(data, snap);
    register("position", position);

    scale = new ScalePart(data);
    register("scale", scale);

    rotation = new RotationPart(data);
    register("rotation", rotation);

    transform = new StandardTransform(position, scale, rotation);

    metadata = new MetadataPart("metadata_", data);
    register("metadata", metadata);

    lifetime = new LifetimePart(data);
    register("lifetime", lifetime);

    layer = new LayerPart(document, data);
    register("layer", layer);

    fill = new ColorPart("fill", data);
    register("fill", fill);
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
      return -Double.compare(o.layer.order.value(), layer.order.value());
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
   * {@inheritDoc}
   */
  @Override
  public String id() {
    return identity.getID();
  }

  /**
   * @return the thing's layer
   */
  public LayerProperties layer() {
    return layer.getLayerProperties();
  }

  /**
   * @return the layer's order
   */
  @Deprecated
  public int layerZ() {
    return layer.z();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Deprecated
  public Edit metadataOf(final String key, final String defaultValue) {
    return metadata.metadataOf(key, defaultValue);
  }

  /**
   * @return the order
   */
  @Deprecated
  public double order() {
    return layer.order.value();
  }

  /**
   * @param value
   *          the new order
   */
  @Deprecated
  public void order(final double value) {
    layer.order.value(value);
  }

  /**
   * snap the given value to the current layer
   *
   * @param v
   *          the value to snap
   * @return the resulting snap'd value
   */
  @Deprecated
  private double snapValue(final double v) {
    final LayerProperties p = layer.getLayerProperties();
    if (p != null) {
      return p.snap(v);
    }
    return v;
  }

  /**
   * @return whether or not thing supports a color property
   */
  @Deprecated
  protected abstract boolean supportsColor();

  /**
   * helper to unselect the thing
   */
  @Deprecated
  public void unselect() {
    editing.selected.value(false);
    clearSelection();
  }

}
