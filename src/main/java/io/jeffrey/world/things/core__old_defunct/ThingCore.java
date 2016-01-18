package io.jeffrey.world.things.core__old_defunct;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.document.history.HistoryEditTrap;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;
import io.jeffrey.zer.edits.EditString;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public abstract class ThingCore implements Editable, Comparable<Thing> {
  private static final double             DEGREES_TO_RADIANS = 0.0174532925;
  protected final EditBoolean             alock;
  protected final EditDouble              angle;
  protected final EditBoolean             aspect;
  protected final EditString              color;
  protected double                        cx                 = 1.0;
  protected double                        cy                 = 0.0;
  protected final EditBoolean             deleted;
  protected final Document                document;
  protected final EditString              id;
  protected final EditString              layer;
  protected final EditBoolean             layerlock;
  protected final EditBoolean             lockcolor;
  protected final EditBoolean             locked;
  protected final EditBoolean             locklock;
  protected final EditBoolean             lockmeta;
  protected final EditString              metaclass;
  protected final Map<String, EditString> metadata;
  protected final EditString              name;
  protected final EditBoolean             nometa;
  protected final EditDouble              order;
  protected final EditBoolean             selected;
  protected final EditBoolean             slock;

  protected final EditDouble              sx;
  protected final EditDouble              sy;
  protected final EditString              type;
  protected final EditDouble              x;
  protected final EditDouble              y;

  /**
   * @param document
   *          the owning document
   * @param node
   *          where the data for the node comes from
   */
  public ThingCore(final Document document, final ThingData node) {
    this.document = document;

    id = node.getString("id", UUID.randomUUID().toString());
    type = node.getString("_type", null);

    x = node.getDouble("x", 0.0);
    y = node.getDouble("y", 0.0);
    sx = node.getDouble("sx", 1.0);
    sy = node.getDouble("sy", 1.0);
    angle = node.getDouble("angle", 0.0);
    name = node.getString("name", "Unnamed");

    layer = node.getString("layer", "_");
    order = node.getDouble("order", Double.MAX_VALUE);

    locked = node.getBoolean("locked", false);
    deleted = node.getBoolean("deleted", false);
    selected = node.getBoolean("selected", false);
    color = node.getString("color", "blue");

    metaclass = node.getString("metaclass", "_");
    metadata = new HashMap<String, EditString>();

    slock = node.getBoolean("slock", false);
    alock = node.getBoolean("alock", false);
    aspect = node.getBoolean("aspect", true);

    locklock = node.getBoolean("locklock", false);
    lockmeta = node.getBoolean("lockmeta", false);
    nometa = node.getBoolean("nometa", false);
    lockcolor = node.getBoolean("lockcolor", false);
    layerlock = node.getBoolean("layerlock", false);

    for (final String key : node.fields.keySet()) {
      if (key.startsWith("metadata_")) {
        metadata.put(key.substring(9), node.getString(key, null));
      }
    }
  }

  /**
   * @return the current angle (in degrees)
   */
  public double angle() {
    return angle.value();
  }

  /**
   * @param angle
   *          the new angle value (in degrees)
   */
  public void angle(final double angle) {
    cx = Math.cos(DEGREES_TO_RADIANS * angle);
    cy = Math.sin(DEGREES_TO_RADIANS * angle);
    this.angle.value(angle);
  }

  /**
   * @return if the aspect is locked
   */
  public boolean aspectLocked() {
    return aspect.value();
  }

  /**
   * update the basis vectors given the current angle
   */
  protected void cacheAngle() {
    cx = Math.cos(DEGREES_TO_RADIANS * angle.value());
    cy = Math.sin(DEGREES_TO_RADIANS * angle.value());
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
    deleted.value(true);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Map<String, Edit> getLinks(final boolean withHistory) {
    final HashMap<String, Edit> links = new HashMap<>();
    links.put("id", id);
    links.put("_type", type);
    links.put("x", x);
    links.put("y", y);
    links.put("sx", sx);
    links.put("sy", sy);
    links.put("angle", angle);
    links.put("name", name);

    links.put("layer", layer);
    links.put("order", order);

    links.put("locked", locked);
    links.put("deleted", deleted);
    links.put("selected", selected);

    links.put("slock", slock);
    links.put("alock", alock);
    links.put("aspect", aspect);

    links.put("locklock", locklock);
    links.put("lockmeta", lockmeta);
    links.put("nometa", nometa);

    if (supportsColor()) {
      links.put("color", color);
      links.put("lockcolor", lockcolor);
    }
    links.put("layerlock", layerlock);
    links.put("metaclass", metaclass);
    for (final Entry<String, EditString> e : metadata.entrySet()) {
      links.put("metadata_" + e.getKey(), e.getValue());
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
    return metaclass.value();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String id() {
    return id.value();
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
    EditString ed = metadata.get(key);
    if (ed == null) {
      ed = new EditString("metadata_" + key, defaultValue) {
        @Override
        public boolean setByText(final String txt) {
          metadata.put(key, this);
          return super.setByText(txt);
        };
      };
    }
    return ed;
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
    selected.value(true);
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
    return sx.value();
  }

  /**
   * @param sx
   *          the new scale of the x axis
   */
  public void sx(final double sx) {
    this.sx.value(Math.min(10000.0, Math.max(0.1, sx)));
  }

  /**
   * @return the current scaling of the y axis
   */
  public double sy() {
    return sy.value();
  }

  /**
   * @param sy
   *          the new scale of the y axis
   */
  public void sy(final double sy) {
    this.sy.value(Math.min(10000.0, Math.max(0.1, sy)));
  }

  /**
   * helper to unselect the thing
   */
  public void unselect() {
    selected.value(false);
    clearSelection();
  }

  /**
   * @return the current x coordinate value
   */
  public double x() {
    return snapValue(x.value());
  }

  /**
   * @param x
   *          the new x coordinate value
   */
  public void x(final double x) {
    this.x.value(snapValue(x));
  }

  /**
   * @return the current y coordinate value
   */
  public double y() {
    return snapValue(y.value());
  }

  /**
   * @param y
   *          the new y coordinate value
   */
  public void y(final double y) {
    this.y.value(snapValue(y));
  }
}
