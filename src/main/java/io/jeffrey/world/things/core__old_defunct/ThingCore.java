package io.jeffrey.world.things.core__old_defunct;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.document.history.HistoryEditTrap;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.base.parts.IdentityPart;
import io.jeffrey.world.things.base.parts.LifetimePart;
import io.jeffrey.world.things.base.parts.MetadataPart;
import io.jeffrey.world.things.base.parts.PositionPart;
import io.jeffrey.world.things.base.parts.RotationPart;
import io.jeffrey.world.things.base.parts.ScalePart;
import io.jeffrey.world.things.base.parts.StandardTransform;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public abstract class ThingCore extends AbstractThing implements Editable, Comparable<Thing> {
  protected final IdentityPart identity;
  protected final LifetimePart lifetime;

  
  protected final EditString   color;
  protected final EditString   layer;
  protected final EditBoolean  layerlock;
  protected final EditBoolean  lockcolor;
  protected final EditBoolean  locklock;

  
  protected final EditDouble   order;
  protected final MetadataPart metadata;
  protected final PositionPart position;
  protected final RotationPart rotation;
  protected final ScalePart    scale;
  protected final Transform    transform;
  protected final EditingPart editing;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data for the node comes from
   */
  public ThingCore(final Document document, final ThingData node) {
    super(document, node);

    position = new PositionPart(data);
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

    layer = node.getString("layer", "_");
    order = node.getDouble("order", Double.MAX_VALUE);


    color = node.getString("color", "blue");


    locklock = node.getBoolean("locklock", false);

    lockcolor = node.getBoolean("lockcolor", false);
    layerlock = node.getBoolean("layerlock", false);

  }

  /**
   * @return the current angle (in degrees)
   */
  public double angle() {
    return rotation.angle.value();
  }

  /**
   * @param angle
   *          the new angle value (in degrees)
   */
  public void angle(final double angle) {

    rotation.angle.value(angle);
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
      return -Double.compare(o.order.value(), order.value());
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
    links.put("layer", layer);
    links.put("order", order);
    links.put("layerlock", layerlock);

    links.put("locklock", locklock);

    if (supportsColor()) {
      links.put("color", color);
      links.put("lockcolor", lockcolor);
    }

    populateLinks(links);
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
    return document.layers.get(layer.getAsText());
  }

  /**
   * @return the layer's order
   */
  public int layerZ() {
    final LayerProperties p = document.layers.get(layer.getAsText());
    if (p != null) {
      return p.zorder.value();
    }
    return 0;
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
    return order.value();
  }

  /**
   * @param value
   *          the new order
   */
  public void order(final double value) {
    order.value(value);
  }

  /**
   * walk the subclassing links
   *
   * @param links
   *          the links to all the fields
   */
  protected abstract void populateLinks(HashMap<String, Edit> links);

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
    final LayerProperties p = document.layers.get(layer.getAsText());
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
   * @return the current scaling of the x axis
   */
  public double sx() {
    return scale.x.value();
  }

  /**
   * @param sx
   *          the new scale of the x axis
   */
  public void sx(final double sx) {
    scale.x.value(Math.min(10000.0, Math.max(0.1, sx)));
  }

  /**
   * @return the current scaling of the y axis
   */
  public double sy() {
    return scale.y.value();
  }

  /**
   * @param sy
   *          the new scale of the y axis
   */
  public void sy(final double sy) {
    scale.y.value(Math.min(10000.0, Math.max(0.1, sy)));
  }

  /**
   * helper to unselect the thing
   */
  public void unselect() {
    editing.selected.value(false);
    clearSelection();
  }

  /**
   * @return the current x coordinate value
   */
  public double x() {
    return snapValue(position.x.value());
  }

  /**
   * @param x
   *          the new x coordinate value
   */
  public void x(final double x) {
    position.x.value(snapValue(x));
  }

  /**
   * @return the current y coordinate value
   */
  public double y() {
    return snapValue(position.y.value());
  }

  /**
   * @param y
   *          the new y coordinate value
   */
  public void y(final double y) {
    position.y.value(snapValue(y));
  }
}