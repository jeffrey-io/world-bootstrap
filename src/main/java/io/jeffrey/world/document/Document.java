package io.jeffrey.world.document;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.vector.VectorRegister2;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.WorldData;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.core__old_defunct.Thing;
import io.jeffrey.world.things.core__old_defunct.ThingCore;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.edits.ObjectDataMap;
import io.jeffrey.zer.meta.DocumentFileSystem;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Document extends ModeledDocument implements DocumentFileSystem {
  public final Camera     camera;
  public final int        controlPointSize = 8;
  public final int        edgeWidthSize    = 4;
  private boolean         hasSomeSelection = false;
  private int             id;
  public final ImageCache imageCache;

  private final WorldData owner;
  public final Image      ROTATE_ICON;
  public final Image      SCALE_ICON;
  public final Image      VERTEX_ICON;
  public final Image      VERTEX_ICON_SELECTED;

  public Document(final Camera camera, final WorldData owner) {
    this.camera = camera;
    this.owner = owner;
    imageCache = new ImageCache();
    id = 0;
    SCALE_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_scale.png"));
    ROTATE_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_rotate.png"));
    VERTEX_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_vertex.png"));
    VERTEX_ICON_SELECTED = new Image(ClassLoader.getSystemResourceAsStream("icon_vertex_selected.png"));
  }

  public void addThing(final Thing thing) {
    history.capture();
    things.add(thing);
    thing.invoke("delete");
    history.register(thing);
    thing.invoke("undelete");
    thing.select();
    history.capture();
  }

  private HashMap<String, Object> convert2(final JsonNode node) {
    final HashMap<String, Object> value = new HashMap<String, Object>();
    final Iterator<Entry<String, JsonNode>> fields = node.getFields();
    while (fields.hasNext()) {
      final Entry<String, JsonNode> field = fields.next();
      if (field.getValue().isDouble()) {
        value.put(field.getKey(), field.getValue().getDoubleValue());
      } else {
        value.put(field.getKey(), field.getValue().getTextValue());
      }
    }
    return value;
  }

  public void deleteSelection() {
    history.capture();
    for (final Thing thing : things) {
      if (thing.selected()) {
        thing.invoke("delete");
      }
    }
    history.capture();
  }

  public void draw(final GraphicsContext gc, final Camera camera, final double width, final double height, final String activeLayer) {
    update();
    sort();
    gc.save();
    gc.setLineWidth(2);
    gc.setStroke(Color.RED);

    gc.translate(camera.tX, camera.tY);
    gc.scale(camera.scale, camera.scale);
    final VectorRegister6 seg = new VectorRegister6();
    final Collection<GuideLine> lines = getGuideLines(activeLayer);
    for (final GuideLine line : lines) {
      line.writeSegment(camera, seg);
      gc.strokeLine(seg.x_0, seg.y_0, seg.x_1, seg.y_1);
    }
    gc.restore();
    for (final Thing thing : getThings()) {
      thing.render(gc, camera);
    }
    final double left = camera.projX(controlPointSize);
    final double top = camera.projY(controlPointSize);
    final double right = camera.projX(width - controlPointSize);
    final double bottom = camera.projY(height - controlPointSize);
    final double[] guideControls = new double[] { left, top, right, top, right, bottom, left, bottom, left, top };

    gc.save();
    for (int c = 0; c + 3 < guideControls.length; c += 2) {
      for (final GuideLine line : lines) {
        line.writeSegment(camera, seg);
        seg.set_2(guideControls[c], guideControls[c + 1]);
        seg.set_3(guideControls[c + 2], guideControls[c + 3]);
        if (Lines.doLinesIntersect_Destructively(seg, true, true)) {
          gc.drawImage(VERTEX_ICON, -controlPointSize + camera.x(seg.x_0), -controlPointSize + camera.y(seg.y_0), 2 * controlPointSize, 2 * controlPointSize);
        }
      }
    }
    gc.restore();
  }

  @Override
  public File find(final String path) {
    final File direct = new File(path);
    if (direct.exists()) {
      return direct;
    }
    return new File(owner.path().resolve(path));
  }

  public Collection<GuideLine> getGuideLines(final String layerId) {
    final LayerProperties lp = layers.get(layerId);
    if (lp != null) {
      return lp.guides;
    }
    return new HashSet<>();
  }

  public ArrayList<Thing> getThings() {
    return things;
  }

  public boolean hasSelection() {
    return hasSomeSelection;
  }

  public void load(final File file) throws Exception {
    final byte[] data = Files.readAllBytes(Paths.get(file.toURI()));
    final JsonNode tree = mapper.readTree(data);

    // load the view
    camera.sync(new ObjectDataMap(convert2(tree.get("view"))));

    loadMC(tree.get("metaclasses"));
    loadLP(tree.get("layers"));

    final JsonNode thingsToLoad = tree.get("things");
    final HashMap<String, ThingCore> lookup = new HashMap<String, ThingCore>();
    for (int k = 0; k < thingsToLoad.size(); k++) {
      final HashMap<String, Object> tdata = new HashMap<String, Object>();
      final JsonNode thing = thingsToLoad.get(k);
      final Iterator<String> fields = thing.getFieldNames();
      while (fields.hasNext()) {
        final String key = fields.next();
        final JsonNode value = thing.get(key);
        if (value.isBoolean()) {
          tdata.put(key, value.asBoolean());
        } else if (value.isDouble()) {
          tdata.put(key, value.asDouble());
        } else if (value.isInt()) {
          tdata.put(key, value.asInt());
        } else if (value.isTextual()) {
          tdata.put(key, value.asText());
        }
      }
      final Thing thingToAdd = new ThingData(tdata).make(this);
      things.add(thingToAdd);
      lookup.put(thingToAdd.id(), thingToAdd);
    }
    history.load(tree.get("history"), lookup);
  }

  private void loadLP(final JsonNode node) {
    final Iterator<Entry<String, JsonNode>> fields = node.getFields();
    while (fields.hasNext()) {
      final Entry<String, JsonNode> field = fields.next();
      final LayerProperties lp = new LayerProperties(field.getKey(), field.getValue().get("name").getTextValue());
      lp.unpack(new ObjectDataMap(convert2(field.getValue())));
      layers.put(lp.id(), lp);
    }
  }

  private void loadMC(final JsonNode node) {
    final Iterator<Entry<String, JsonNode>> fields = node.getFields();
    while (fields.hasNext()) {
      final Entry<String, JsonNode> field = fields.next();
      final MetaClass cls = new MetaClass(field.getKey(), field.getValue().get("name").getTextValue());
      cls.inject(new ObjectDataMap(convert2(field.getValue())));
      classes.put(field.getKey(), cls);
    }
  }

  public ThingData newData(final String type) {
    final ThingData data = new ThingData(type);
    data.fields.put("id", type.substring(0, 1).toUpperCase() + id);
    id++;
    return data;
  }

  @Override
  public String normalize(final File input) {
    final String result = owner.path().relativize(input.toURI()).getPath();
    return result;
  }

  public int populateBounds(final VectorRegister2 reg, final boolean onlySelected) {
    int n = 0;
    for (final Thing thing : things) {
      if (thing.deleted()) {
        continue;
      }
      if (!thing.selected() && onlySelected) {
        continue;
      }
      for (final ControlDoodad doodad : thing.getDoodadsInWorldSpace()) {
        if (n == 0) {
          reg.set_0(doodad.u, doodad.v);
          reg.set_1(doodad.u, doodad.v);
        }
        reg.x_0 = Math.min(reg.x_0, doodad.u);
        reg.x_1 = Math.max(reg.x_1, doodad.u);

        reg.y_0 = Math.min(reg.y_0, doodad.v);
        reg.y_1 = Math.max(reg.y_1, doodad.v);
        n++;
      }
    }
    return n;
  }

  public Color query(final double x, final double y, final Thing skip) {
    for (final Thing thing : things) {
      if (thing == skip) {
        continue;
      }
      final Color color = thing.query(x, y);
      if (color != null) {
        return color;
      }
    }
    return null;
  }

  public void save(final File file) throws Exception {
    final HashMap<String, Object> tree = new HashMap<String, Object>();
    tree.put("view", camera.pack());
    tree.put("history", history.pack());
    final HashMap<String, Object> layersPacked = new HashMap<>();
    final HashMap<String, Object> metaClassesPacked = new HashMap<>();
    for (final Entry<String, MetaClass> mc : classes.entrySet()) {
      metaClassesPacked.put(mc.getKey(), mc.getValue().pack());
    }
    for (final Entry<String, LayerProperties> mc : layers.entrySet()) {
      layersPacked.put(mc.getKey(), mc.getValue().pack());
    }

    tree.put("layers", layersPacked);
    tree.put("metaclasses", metaClassesPacked);

    final ArrayList<Object> store = new ArrayList<Object>();
    for (final Thing t : things) {
      final HashMap<String, String> tdata = new HashMap<String, String>();
      t.saveTo(tdata);
      store.add(tdata);
    }
    tree.put("things", store);
    Files.write(Paths.get(file.toURI()), mapper.writeValueAsBytes(tree));
  }

  public Thing selectFirstVisible(final double x, final double y) {
    for (final Thing thing : things) {
      if (thing.contains(x, y)) {
        return thing;
      }
    }
    return null;
  }

  public String snapshotSelection() throws Exception {
    final ArrayList<Object> store = new ArrayList<Object>();
    double x = 0;
    double y = 0;
    int c = 0;
    for (final Thing t : things) {
      if (t.selected()) {
        x += t.x();
        y += t.y();
        c++;
      }
    }
    if (c == 0) {
      return null;
    }
    x /= c;
    y /= c;
    for (final Thing t : things) {
      if (t.selected()) {
        final HashMap<String, String> tdata = new HashMap<String, String>();
        t.saveTo(tdata);
        tdata.put("x", Double.toString(t.x() - x));
        tdata.put("y", Double.toString(t.y() - y));
        store.add(tdata);
      }
    }
    final String snapshot = mapper.writeValueAsString(store);
    return snapshot;
  }

  public void sort() {
    if (things.size() == 0) {
      return;
    }
    things.sort((o1, o2) -> o1.compareTo(o2));
    int layerAt = things.get(0).layerZ();
    int newOrder = 0;
    for (final Thing thing : things) {
      if (thing.layerZ() != layerAt) {
        layerAt = thing.layerZ();
        newOrder = 0;
      }
      newOrder++;
      thing.order(newOrder);
    }
  }

  public void update() {
    hasSomeSelection = false;
    for (final Thing thing : things) {
      if (thing.selected()) {
        hasSomeSelection = true;
      }
      thing.update();
    }
  }

}
