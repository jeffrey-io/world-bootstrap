package io.jeffrey.world.things.core__old_defunct;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.StandardTransform;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.parts.ColorPart;
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
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public abstract class ThingCore extends AbstractThing implements Editable {
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

    layer = new LayerPart(document, data);
    register("layer", layer);

    position = new PositionPart(data, layer);
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
   * {@inheritDoc}
   */
  @Override
  @Deprecated
  public Edit metadataOf(final String key, final String defaultValue) {
    return metadata.metadataOf(key, defaultValue);
  }

}
