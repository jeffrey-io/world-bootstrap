package io.jeffrey.world;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.HistoryMouseInteractionTrapper;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.core.Thing;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.Notifications;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SetMover;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.ZERStage;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.plugin.Model;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class WorldData extends SurfaceData {
    private final Camera   camera;
    private final Document document;

    private File           file;

    public WorldData() {
        camera = new Camera();
        document = new Document(camera, this);
        file = null;
    }

    /**
     * indicate that we should open
     *
     * @param file
     *            the file that we should open
     */
    @Override
    public void actionOpen(final File file) {
        if (file == null) {
            return;
        }
        setFile(file);
        try {
            document.load(file);
        } catch (final Exception failure) {
            document.notifications.println(failure, "unable to open file", file.toString());
        }
    }

    @Override
    public void add(final String type, final double at_x, final double at_y) {
        ThingData data = null;
        if ("Circle".equals(type)) {
            data = document.newData("circle");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
        }
        if ("Triangle".equals(type)) {
            data = document.newData("polygon");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            data.fields.put("points", polyCircle(0, 2 * Math.PI / 3, 3));
        }
        if ("Box".equals(type)) {
            data = document.newData("polygon");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            data.fields.put("points", polyCircle(Math.PI / 4, Math.PI / 2, 4));
        }
        if ("Hexagon".equals(type)) {
            data = document.newData("polygon");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            data.fields.put("points", polyCircle(Math.PI / 6, Math.PI / 3, 6));
        }
        if ("Path".equals(type)) {
            data = document.newData("path");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            data.fields.put("points", "0,0,1,0");
        }
        if ("Connector".equals(type)) {
            data = document.newData("connector");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            data.fields.put("points", "0,0,1,0");
        }
        if ("Image".equalsIgnoreCase(type)) {
            data = document.newData("image");
            data.fields.put("x", at_x);
            data.fields.put("y", at_y);
            final FileChooser chooser = new FileChooser();
            chooser.setTitle("Pick image");
            final File file = chooser.showOpenDialog(null);
            if (file != null) {
                try {
                    if (ImageIO.read(file) == null) {
                        document.notifications.println("unable to add image:", file.toString());
                        return;
                    }
                } catch (final IOException failure) {
                    document.notifications.println(failure, "unable to add image:", file.toString());
                    return;
                }
                data.fields.put("uri", document.normalize(file));
            }
        }

        if (data != null) {
            document.addThing(data.make(document));
        }
    }

    @Override
    public boolean available(final SurfaceAction action) {
        if (action == SurfaceAction.Copy || action == SurfaceAction.Cut || action == SurfaceAction.DeleteSelection) {
            return document.hasSelection();
        }
        if (action == SurfaceAction.Paste) {
            return Clipboard.getSystemClipboard().hasString();
        }
        if (action == SurfaceAction.Save) {
            return file != null;
        }
        if (action == SurfaceAction.Undo) {
            return document.history.canUndo();
        }
        if (action == SurfaceAction.Redo) {
            return document.history.canRedo();
        }
        return true;
    }

    @Override
    public void capture() {
        document.history.capture();
    }

    private void copy() throws Exception {
        final ClipboardContent content = new ClipboardContent();
        content.putString(document.snapshotSelection());
        Clipboard.getSystemClipboard().setContent(content);
    }

    @Override
    public void draw(final GraphicsContext gc, final Camera camera) {
        document.draw(gc, camera);
    }

    @Override
    public void execute(final SurfaceAction action, final double at_x, final double at_y) throws Exception {
        if (action == SurfaceAction.SelectAll) {
            for (final Thing thing : document.getThings()) {
                thing.select();
            }
        }
        if (action == SurfaceAction.InverseSelection) {
            for (final Thing thing : document.getThings()) {
                if (thing.selected()) {
                    thing.unselect();
                } else {
                    thing.select();
                }
            }
        }
        if (action == SurfaceAction.Copy) {
            copy();
        }
        if (action == SurfaceAction.Cut) {
            copy();
            document.deleteSelection();
        }
        if (action == SurfaceAction.DeleteSelection) {
            document.deleteSelection();
        }
        if (action == SurfaceAction.Paste) {
            paste(at_x, at_y);
        }
        if (action == SurfaceAction.Undo) {
            document.history.undo();
        }
        if (action == SurfaceAction.Redo) {
            document.history.redo();
        }
        if (action == SurfaceAction.Save) {
            try {
                document.save(file);
            } catch (final Exception failure) {
                document.notifications.println(failure, "unable to save file:", file.toString());
            }
        }
        if (action == SurfaceAction.NewFile) {
            final WorldData document = new WorldData();
            final Stage stage = new Stage();
            new ZERStage(document, stage);
        }
    }

    @Override
    public LayerProperties getActiveLayer() {
        for (final Thing thing : document.getThings()) {
            if (thing.selected()) {
                return thing.layer();
            }
        }
        return null;
    }

    @Override
    public List<String> getAddables() {
        final ArrayList<String> adds = new ArrayList<String>();
        adds.add("Circle");
        adds.add("Image");
        adds.add("Triangle");
        adds.add("Box");
        adds.add("Hexagon");
        adds.add("Path");
        adds.add("Connector");
        return adds;
    }

    @Override
    public Camera getCamera() {
        return camera;
    }

    @Override
    public Set<Editable> getEditables() {
        final HashSet<Editable> edits = new HashSet<Editable>();
        for (final Thing thing : document.getThings()) {
            if (thing.selected()) {
                document.history.register(thing);
                edits.add(thing);
            }
        }
        return edits;
    }

    @Override
    public Map<String, LayerProperties> getLayers() {
        return document.layers;
    }

    @Override
    public Map<String, MetaClass> getMetaClasses() {
        return document.classes;
    }

    @Override
    public Model getModel() {
        return document;
    }

    @Override
    public Notifications getNotifications() {
        return document.notifications;
    }

    @Override
    public File getPluginRoot() {
        final File start = new File(System.getProperty("user.home"));
        return new File(start, "world.js");
    }

    @Override
    public MouseInteraction getSelectionMovers(final AdjustedMouseEvent event) {
        document.history.capture();
        final HashSet<MouseInteraction> set = new HashSet<MouseInteraction>();
        for (final Thing thing : document.getThings()) {
            thing.addSelectionMovers(set, event);
        }
        if (set.size() == 0) {
            return null;
        }

        final MouseInteraction setmover = new SetMover(set);
        return new HistoryMouseInteractionTrapper(document.history, setmover);
    }

    @Override
    public String getTitle() {
        if (file == null) {
            return "Bootstrapping <New World>";
        }
        return file.getPath();
    }

    @Override
    public boolean isInSelectionSet(final AdjustedMouseEvent event) {
        for (final Thing thing : document.getThings()) {
            if (thing.isInCurrertSelection(event)) {
                return true;
            }
        }
        return false;
    }

    private void paste(final double x, final double y) throws Exception {
        final JsonNode arr = new ObjectMapper().readTree(Clipboard.getSystemClipboard().getString());
        for (int k = 0; k < arr.size(); k++) {
            final JsonNode thing = arr.get(k);
            final HashMap<String, String> data = new HashMap<String, String>();
            final Iterator<Entry<String, JsonNode>> fields = thing.getFields();
            while (fields.hasNext()) {
                final Entry<String, JsonNode> field = fields.next();
                data.put(field.getKey(), field.getValue().asText());
            }
            paste(data, x, y);
        }
    }

    private void paste(final HashMap<String, String> raw, final double x, final double y) {
        final ThingData data = document.newData(raw.get("_type"));
        final String newId = data.fields.get("id").toString();
        data.fields.putAll(raw);
        final double nx = data.getDouble("x", 0.0).value() + x;
        final double ny = data.getDouble("y", 0.0).value() + y;
        data.fields.put("x", Double.toString(nx));
        data.fields.put("y", Double.toString(ny));
        data.fields.put("id", newId);
        document.addThing(data.make(document));
    }

    /**
     * @return the root path
     */
    public URI path() {
        if (file != null) {
            return file.getParentFile().toURI();
        } else {
            return new File(".").toURI();
        }
    }

    private String polyCircle(final double start, final double dangle, final int count) {
        final ArrayList<Double> values = new ArrayList<Double>();
        double theta = start;
        for (int k = 0; k < count; k++) {
            values.add(Math.cos(theta));
            values.add(Math.sin(theta));
            theta += dangle;
        }
        return PointChain.pack(values);
    }

    @Override
    public void ready() {
        document.history.capture();
        for (final Thing thing : document.getThings()) {
            document.history.register(thing);
        }
    }

    @Override
    public boolean setFile(final File file) {
        this.file = file;
        return this.file != null;
    }

    @Override
    public MouseInteraction startSurfaceInteraction(final AdjustedMouseEvent event) {
        document.history.capture();
        for (int k = document.getThings().size() - 1; k >= 0; k--) {
            final Thing thing = document.getThings().get(k);
            thing.preInteract(event);
        }
        for (int k = document.getThings().size() - 1; k >= 0; k--) {
            final Thing thing = document.getThings().get(k);
            final MouseInteraction it = thing.startInteraction(event);
            if (it != null) {
                return new HistoryMouseInteractionTrapper(document.history, it);
            }
        }
        return null;
    }

    @Override
    public void updateSelectionWindow(final SelectionWindow window) {
        for (final Thing thing : document.getThings()) {
            thing.applySelection(window);
        }
    }

}
