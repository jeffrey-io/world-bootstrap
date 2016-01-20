package io.jeffrey.world.things.base;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.parts.ColorPart;
import io.jeffrey.world.things.parts.DoodadRenderPart;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.MetadataPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;

public abstract class BasicThing extends AbstractThing {
  protected final ColorPart    fill;
  protected final LayerPart    layer;
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
  public BasicThing(final Document document, final ThingData node) {
    super(document, node);

    layer = new LayerPart(document, data);
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

    fill = new ColorPart("fill", data);
    register(fill);

    register(new DoodadRenderPart(this, transform));
  }

  @Override
  public Transform transform() {
    return transform;
  }
}
