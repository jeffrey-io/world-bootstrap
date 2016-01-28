package io.jeffrey.world.document;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.codehaus.jackson.JsonNode;

import io.jeffrey.vector.VectorRegister2;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.AbstractThingHelpers;
import io.jeffrey.world.WorldData;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasWorldSpaceRendering;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.AdaptThingSpaceDoodadsIntoWorldSpace;
import io.jeffrey.world.things.core.ContainerQueryEngine;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.LifetimePart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.edits.ObjectDataMap;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Document extends ModeledDocument {
  private final Canvas              background;
  private WritableImage             backgroundImage      = null;

  public final Camera               camera;
  private boolean                   currentlyInteracting = false;
  public final ContainerQueryEngine engine;

  private int                       expectedHash         = 0;

  private final boolean             hasSomeSelection     = false;

  private int                       id;

  public Document(final Camera camera, final WorldData owner) {
    super(camera, owner);
    this.camera = camera;
    engine = new ContainerQueryEngine(container);
    id = 0;
    background = new Canvas();
  }

  public void addThing(final AbstractThing thing) {
    container.add(thing);
  }

  private HashMap<String, String> convert2(final JsonNode node) {
    final HashMap<String, String> value = new HashMap<String, String>();
    final Iterator<Entry<String, JsonNode>> fields = node.getFields();
    while (fields.hasNext()) {
      final Entry<String, JsonNode> field = fields.next();
      if (field.getValue().isDouble()) {
        value.put(field.getKey(), Double.toString(field.getValue().getDoubleValue()));
      } else {
        value.put(field.getKey(), field.getValue().getTextValue());
      }
    }
    return value;
  }

  private boolean createBackground(final double width, final double height, final int cameraHash) {
    final int hash = Double.hashCode(width) * 31 + Double.hashCode(height) * 17 + cameraHash;
    if (hash == expectedHash) {
      return false;
    } else {
      expectedHash = hash;
      background.setWidth(width);
      background.setHeight(height);
      return true;
    }
  }

  public void deleteSelection() {
    container.history.capture();
    for (final AbstractThing thing : container) {
      if (thing.editing.selected.value()) {
        thing.invokeAction("delete", false);
      }
    }
    container.history.capture();
  }

  public void draw(final GraphicsContext gc, final Camera camera, final double width, final double height, final String activeLayer) {
    update();
    if (currentlyInteracting) {
      if (createBackground(width, height, camera.hashCode())) {
        final GraphicsContext bgc = background.getGraphicsContext2D();
        bgc.setFill(Color.TRANSPARENT);
        bgc.clearRect(0, 0, width, height);
        drawBackground(bgc, camera, width, height, activeLayer, true);
        final SnapshotParameters sp = new SnapshotParameters();
        sp.setFill(Color.TRANSPARENT);
        final WritableImage wi = new WritableImage((int) width, (int) height);
        backgroundImage = wi;
        background.snapshot(sp, wi);
      }
      gc.drawImage(backgroundImage, 0, 0);
      drawSelection(gc, camera, width, height, activeLayer);
    } else {
      container.sort();
      drawBackground(gc, camera, width, height, activeLayer, false);
    }
  }

  public void drawBackground(final GraphicsContext gc, final Camera camera, final double width, final double height, final String activeLayer, final boolean dontShowSelected) {
    gc.save();
    gc.setLineWidth(2);
    gc.setStroke(Color.RED);
    gc.translate(camera.tX, camera.tY);
    gc.scale(camera.scale, camera.scale);

    final VectorRegister6 seg = new VectorRegister6();
    final Collection<GuideLine> lines = container.getGuideLines(activeLayer);
    for (final GuideLine line : lines) {
      line.writeSegment(camera, seg);
      gc.strokeLine(seg.x_0, seg.y_0, seg.x_1, seg.y_1);
    }
    gc.restore();
    for (final AbstractThing thing : container) {
      final LifetimePart lifetime = thing.lifetime;
      final EditingPart editing = thing.editing;
      boolean show = !lifetime.isDeleted();
      if (dontShowSelected && editing.selected.value()) {
        show = false;
      }
      if (show) {
        for (final HasWorldSpaceRendering renderer : thing.collect(HasWorldSpaceRendering.class)) {
          renderer.render(gc);
        }
      }
    }
    final double left = camera.projX(container.controlPointSize);
    final double top = camera.projY(container.controlPointSize);
    final double right = camera.projX(width - container.controlPointSize);
    final double bottom = camera.projY(height - container.controlPointSize);
    final double[] guideControls = new double[] { left, top, right, top, right, bottom, left, bottom, left, top };

    gc.save();
    for (int c = 0; c + 3 < guideControls.length; c += 2) {
      for (final GuideLine line : lines) {
        line.writeSegment(camera, seg);
        seg.set_2(guideControls[c], guideControls[c + 1]);
        seg.set_3(guideControls[c + 2], guideControls[c + 3]);
        if (Lines.doLinesIntersect_Destructively(seg, true, true)) {
          gc.drawImage(container.imageCache.VERTEX_ICON, -container.controlPointSize + camera.x(seg.x_0), -container.controlPointSize + camera.y(seg.y_0), 2 * container.controlPointSize, 2 * container.controlPointSize);
        }
      }
    }
    gc.restore();
  }

  public void drawSelection(final GraphicsContext gc, final Camera camera, final double width, final double height, final String activeLayer) {
    for (final AbstractThing thing : container) {
      final LifetimePart lifetime = thing.lifetime;
      final EditingPart editing = thing.editing;
      final boolean show = !lifetime.isDeleted() && editing.selected.value();
      if (show) {
        for (final HasWorldSpaceRendering renderer : thing.collect(HasWorldSpaceRendering.class)) {
          renderer.render(gc);
        }
      }
    }
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
    final HashMap<String, AbstractThing> lookup = new HashMap<>();
    for (int k = 0; k < thingsToLoad.size(); k++) {
      final HashMap<String, String> tdata = new HashMap<String, String>();
      final JsonNode thing = thingsToLoad.get(k);
      final Iterator<String> fields = thing.getFieldNames();
      while (fields.hasNext()) {
        final String key = fields.next();
        final JsonNode value = thing.get(key);
        if (value.isBoolean()) {
          tdata.put(key, Boolean.toString(value.asBoolean()));
        } else if (value.isDouble()) {
          tdata.put(key, Double.toString(value.asDouble()));
        } else if (value.isInt()) {
          tdata.put(key, Integer.toString(value.asInt()));
        } else if (value.isTextual()) {
          tdata.put(key, value.asText());
        }
      }
      final AbstractThing thingToAdd = new ThingData(tdata).make(container);
      container.add(thingToAdd);
      lookup.put(thingToAdd.getID(), thingToAdd);
    }
    container.history.load(tree.get("history"), lookup);
  }

  private void loadLP(final JsonNode node) {
    final Iterator<Entry<String, JsonNode>> fields = node.getFields();
    while (fields.hasNext()) {
      final Entry<String, JsonNode> field = fields.next();
      final LayerProperties lp = new LayerProperties(field.getKey(), field.getValue().get("name").getTextValue());
      lp.unpack(new ObjectDataMap(convert2(field.getValue())));
      container.layers.put(lp.id(), lp);
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

  public int populateBounds(final VectorRegister2 reg, final boolean onlySelected) {
    int n = 0;
    for (final AbstractThing thing : container) {
      final EditingPart editing = thing.first(EditingPart.class);
      final LifetimePart lifetime = thing.first(LifetimePart.class);

      boolean selected = false;
      if (editing != null) {
        selected = editing.selected.value();
      }
      if (lifetime != null && lifetime.isDeleted()) {
        continue;
      }
      if (!selected && onlySelected) {
        continue;
      }
      for (final HasControlDoodadsInThingSpace space1 : thing.collect(HasControlDoodadsInThingSpace.class)) {
        final AdaptThingSpaceDoodadsIntoWorldSpace space2 = new AdaptThingSpaceDoodadsIntoWorldSpace(thing.transform(), space1);
        for (final ControlDoodad doodad : space2.getDoodadsInWorldSpace()) {
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
    }
    return n;
  }

  public Color query(final double x, final double y, final AbstractThing skip) {
    for (final AbstractThing thing : container) {
      if (thing == skip) {
        continue;
      }
      final Color color = AbstractThingHelpers.query(thing, x, y);
      if (color != null) {
        return color;
      }
    }
    return null;
  }

  public void save(final File file) throws Exception {
    final HashMap<String, Object> tree = new HashMap<String, Object>();
    tree.put("view", camera.pack());
    tree.put("history", container.history.pack());
    final HashMap<String, Object> layersPacked = new HashMap<>();
    final HashMap<String, Object> metaClassesPacked = new HashMap<>();
    for (final Entry<String, MetaClass> mc : classes.entrySet()) {
      metaClassesPacked.put(mc.getKey(), mc.getValue().pack());
    }
    for (final Entry<String, LayerProperties> mc : container.layers.entrySet()) {
      layersPacked.put(mc.getKey(), mc.getValue().pack());
    }

    tree.put("layers", layersPacked);
    tree.put("metaclasses", metaClassesPacked);

    final ArrayList<Object> store = new ArrayList<Object>();
    for (final AbstractThing t : container.getThingsByPersistenceOrder()) {
      final HashMap<String, String> tdata = new HashMap<String, String>();
      t.saveTo(tdata);
      store.add(tdata);
    }
    tree.put("things", store);
    Files.write(Paths.get(file.toURI()), mapper.writeValueAsBytes(tree));
  }

  public AbstractThing selectFirstVisible(final double x, final double y) {
    return engine.selectFirstVisible(x, y);
  }

  public void setInteracting(final boolean it) {
    currentlyInteracting = it;
    if (!it) {
      expectedHash = 0;
    }
  }

  public String snapshotSelection() throws Exception {
    final ArrayList<Object> store = new ArrayList<Object>();
    double x = 0;
    double y = 0;
    int c = 0;
    for (final AbstractThing t : container) {
      final PositionPart position = t.first(PositionPart.class);
      if (t.editing.selected.value() && position != null) {
        x += position.x();
        y += position.y();
        c++;
      }
    }
    if (c == 0) {
      return null;
    }
    x /= c;
    y /= c;
    for (final AbstractThing t : container) {
      final PositionPart position = t.first(PositionPart.class);
      if (t.editing.selected.value() && position != null) {
        final HashMap<String, String> tdata = new HashMap<String, String>();
        t.saveTo(tdata);
        tdata.put("x", Double.toString(position.x() - x));
        tdata.put("y", Double.toString(position.y() - y));
        store.add(tdata);
      }
    }
    final String snapshot = mapper.writeValueAsString(store);
    return snapshot;
  }

  public void update() {
    for (final AbstractThing thing : container) {
      thing.update();
    }
  }

}
