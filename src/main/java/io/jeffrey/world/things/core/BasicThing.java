package io.jeffrey.world.things.core;

import io.jeffrey.world.things.parts.DoodadRenderPart;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.MetadataPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;

public class BasicThing extends AbstractThing {
  protected final LayerPart    layer;
  protected final MetadataPart metadata;
  public final PositionPart    position;
  public final RotationPart    rotation;
  public final ScalePart       scale;
  public final Transform       transform;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data for the node comes from
   */
  public BasicThing(final Container container, final LinkedDataMap data) {
    super(container, data);

    layer = new LayerPart(container, data);
    register(layer);

    position = new PositionPart(data, layer);
    register(position);

    scale = new ScalePart(data);
    register(scale);

    rotation = new RotationPart(data);
    register(rotation);

    transform = new StandardTransform(position, scale, rotation);

    metadata = new MetadataPart("metadata_", data);
    register(metadata);

    register(new DoodadRenderPart(this, transform));
  }

  @Override
  public Transform transform() {
    return transform;
  }
}
