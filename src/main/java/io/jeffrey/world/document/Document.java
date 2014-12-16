package io.jeffrey.world.document;

import io.jeffrey.vector.VectorRegister2;
import io.jeffrey.world.WorldData;
import io.jeffrey.world.things.core.Thing;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.edits.ObjectDataMap;
import io.jeffrey.zer.meta.DocumentFileSystem;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import org.codehaus.jackson.JsonNode;

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
        things.add(thing);
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
                thing.delete();
            }
        }
        history.capture();
    }

    public void draw(final GraphicsContext gc, final Camera camera) {
        update();
        sort();
        gc.save();
        gc.setLineWidth(2);
        gc.setStroke(Color.RED);

        gc.translate(camera.tX, camera.tY);
        gc.scale(camera.scale, camera.scale);
        final VectorRegister2 seg = new VectorRegister2();
        for (final GuideLine line : getGuideLines("_")) {
            line.writeSegment(camera, seg);
            gc.strokeLine(seg.x_0, seg.y_0, seg.x_1, seg.y_1);
        }
        gc.restore();
        for (final Thing thing : getThings()) {
            thing.render(gc, camera);
        }
    }

    @Override
    public File find(final String path) {
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
            things.add(new ThingData(tdata).make(this));
            // maybe pre-load?
        }
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
        return owner.path().relativize(input.toURI()).getPath();
    }

    public void save(final File file) throws Exception {
        final HashMap<String, Object> tree = new HashMap<String, Object>();
        tree.put("view", camera.pack());

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
        things.sort(new Comparator<Thing>() {
            @Override
            public int compare(final Thing o1, final Thing o2) {
                return o1.compareTo(o2);
            }
        });
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
