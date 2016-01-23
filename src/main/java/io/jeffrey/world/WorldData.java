package io.jeffrey.world;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import io.jeffrey.vector.VectorRegister2;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.EditableThing;
import io.jeffrey.world.document.Iconify;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.behaviors.HasInternalSelection;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasSelectionByWindow;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.guides.Picker;
import io.jeffrey.world.things.interactions.SelectionSolver;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.IconResolver;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.Notifications;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SurfaceContext;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.ZERStage;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.plugin.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WorldData extends SurfaceData {
  private final Camera       camera;
  public final Document      document;
  private File               file;
  private final IconResolver resolver;

  public WorldData() {
    camera = new Camera();
    document = new Document(camera, this);
    file = null;
    resolver = new Iconify(this);
  }

  /**
   * indicate that we should open
   *
   * @param file
   *          the file that we should open
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
  public void add(final String type, final SurfaceContext context) {
    ThingData data = null;
    final double at_x = context.cursor_x;
    final double at_y = context.cursor_y;
    if ("Circle".equals(type)) {
      data = document.newData("circle");
      data.fields.put("sx", "50");
      data.fields.put("sy", "50");
    }
    if ("Triangle".equals(type)) {
      data = document.newData("polygon");
      data.fields.put("points", polyCircle(0, 2 * Math.PI / 3, 3));
    }
    if ("Turtle".equals(type)) {
      data = document.newData("turtle");
      data.fields.put("points", polyCircle(0, 2 * Math.PI / 3, 3));
    }
    if ("Box".equals(type)) {
      data = document.newData("polygon");
      data.fields.put("points", polyCircle(Math.PI / 4, Math.PI / 2, 4));
    }
    if ("Hexagon".equals(type)) {
      data = document.newData("polygon");
      data.fields.put("points", polyCircle(Math.PI / 6, Math.PI / 3, 6));
    }
    if ("Path".equals(type)) {
      data = document.newData("path");
      data.fields.put("points", "0,0,25,0");
    }
    if ("Connector".equals(type)) {
      data = document.newData("connector");
      data.fields.put("points", "0,0,25,0");
    }
    if ("Image".equalsIgnoreCase(type)) {
      data = document.newData("image");
      data.fields.put("sx", "0.50");
      data.fields.put("sy", "0.50");

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
        if (!file.isFile()) {
          return;
        }
        if (!file.exists()) {
          return;
        }
        data.fields.put("uri", document.container.fs.normalize(file));
      } else {
        return;
      }
    }

    if (data == null) {
      final Map<String, String> temp = document.templates.get(type);
      data = document.newData(temp.get("_type"));
      for (final Entry<String, String> en : temp.entrySet()) {
        data.fields.put(en.getKey(), en.getValue());
      }
      data.fields.put("locklock", "true");
    }
    if (data != null) {
      data.fields.put("x", Double.toString(at_x));
      data.fields.put("y", Double.toString(at_y));
      document.addThing(data.make(document.container));
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
      return document.container.history.canUndo();
    }
    if (action == SurfaceAction.Redo) {
      return document.container.history.canRedo();
    }
    return true;
  }

  @Override
  public void capture() {
    document.container.history.capture();
  }

  private void copy() throws Exception {
    final ClipboardContent content = new ClipboardContent();
    content.putString(document.snapshotSelection());
    Clipboard.getSystemClipboard().setContent(content);
  }

  @Override
  public void draw(final GraphicsContext gc, final SurfaceContext context) {
    String layerId = "";
    final LayerProperties lp = getActiveLayer();
    if (lp != null) {
      layerId = lp.id();
    }
    document.draw(gc, camera, context.width, context.height, layerId);
  }

  @Override
  public void execute(final SurfaceAction action, final SurfaceContext context) throws Exception {

    final double at_x = context.cursor_x;
    final double at_y = context.cursor_y;
    if (action == SurfaceAction.SelectAll) {
      for (final AbstractThing thing : document.container) {
        thing.invokeAction("select", false);
      }
    }
    if (action == SurfaceAction.InverseSelection) {
      for (final AbstractThing thing : document.container) {
        thing.invokeAction("inverse-selection", false);
      }
    }
    final boolean onlySelected = action == SurfaceAction.ZoomSelection;
    if (action == SurfaceAction.ZoomAll || onlySelected) {
      final VectorRegister2 bounds = new VectorRegister2();
      if (document.populateBounds(bounds, onlySelected) > 0) {
        camera.zoom(bounds, context);
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
      document.container.history.undo();
    }
    if (action == SurfaceAction.Redo) {
      document.container.history.redo();
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
    for (final AbstractThing thing : document.container) {
      if (thing.editing.selected.value()) {
        final LayerPart layer = thing.first(LayerPart.class);
        if (layer != null) {
          return layer.getLayerProperties();
        }
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
    adds.add("Turtle");
    for (final String template : document.templates.keySet()) {
      adds.add(template);
    }
    return adds;
  }

  @Override
  public Camera getCamera() {
    return camera;
  }

  @Override
  public Set<Editable> getEditables() {
    final HashSet<Editable> edits = new HashSet<Editable>();
    for (final AbstractThing thing : document.container) {
      if (thing.editing.selected.value()) {
        document.container.history.register(thing);
        edits.add(new EditableThing(document, thing));
      }
    }
    return edits;
  }

  // DONE
  private MouseInteraction getGuidelineEditor(final AdjustedMouseEvent event, final SurfaceContext context) {
    final double left = camera.projX(document.container.controlPointSize);
    final double top = camera.projY(document.container.controlPointSize);
    final double right = camera.projX(context.width - document.container.controlPointSize);
    final double bottom = camera.projY(context.height - document.container.controlPointSize);
    String layerId = "";
    final LayerProperties lp = getActiveLayer();
    if (lp != null) {
      layerId = lp.id();
    }
    final Collection<GuideLine> lines = document.container.getGuideLines(layerId);
    final Picker picker = new Picker(left, right, top, bottom);

    MouseInteraction lineIt = null;
    for (final GuideLine line : lines) {
      if (lineIt != null) {
        break;
      }
      lineIt = picker.select(line, camera, event.position.x_0, event.position.y_0, document.container.controlPointSize);
    }
    return lineIt;
  }

  @Override
  public IconResolver getIconResolver() {
    return resolver;
  }

  @Override
  public Map<String, LayerProperties> getLayers() {
    return document.container.layers;
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
  public String getTitle() {
    if (file == null) {
      return "Bootstrapping <New World>";
    }
    return file.getPath();
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
    document.addThing(data.make(document.container));
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
      values.add(50 * Math.cos(theta));
      values.add(50 * Math.sin(theta));
      theta += dangle;
    }
    return SelectablePoint2List.pack(values);
  }

  @Override
  public void ready() {
    document.container.history.capture();
    for (final AbstractThing thing : document.container) {
      document.container.history.register(thing);
    }
  }

  @Override
  public MouseInteraction selectByPoint(final AdjustedMouseEvent event, final SurfaceContext context) {
    final SelectionSolver selectionSolver = new SelectionSolver(document.container.history, event);
    System.out.println("----------------------");
    System.out.println("Starting selectByPoint");
    for (final AbstractThing thing : document.container) {
      System.out.println("@thing.id=" + thing.getID());
      // it's deleted, we do nothing
      if (thing.lifetime.isDeleted()) {
        continue;
      }

      // it's locked, we do nothing
      if (thing.editing.locked.value()) {
        // clear the selection
        if (thing.editing.selected.value()) {
          thing.editing.selected.value(false);
        }
        continue;
      }

      // indicate we may do a selection window (although, is this needed)
      thing.collect(HasSelectionByWindow.class, t -> {
        t.beginSelectionWindow();
        return null;
      });

      thing.collect(HasInternalSelection.class, t -> {
        t.cacheInternalSelection();
        return null;
      });

      thing.transform().writeToThingSpace(event.position);

      selectionSolver.focus(thing);
      for (final HasSelectionByPoint behavior : thing.collect(HasSelectionByPoint.class)) {
        if (behavior.buildSelectionSolver(selectionSolver)) {
          System.out.println(" ^^ from:" + behavior.getClass().getSimpleName());
        }
      }
      selectionSolver.unfocus();
      thing.invokeAction("unselect", false);
    }

    final MouseInteraction it = selectionSolver.solve();
    if (it != null) {
      return it;
    }

    return getGuidelineEditor(event, context);
  }

  /*
   * public MouseInteraction startSurfaceInteraction(final AdjustedMouseEvent event, final SurfaceContext context) { document.container.history.capture(); for (int k = document.container.size() - 1; k >= 0; k--) { final AbstractThing thing = document.container.get(k); if (!event.altdown) { thing.invokeAction("unselect", false); } } for (int k = document.container.size() - 1; k >= 0; k--) { final AbstractThing thing = document.container.get(k); final MouseInteraction it = null; // AbstractThingHelpers.startInteraction(thing, event); if (it != null) { return new HistoryMouseInteractionTrapper(document.container.history, it); } } }
   */

  @Override
  public boolean setFile(final File file) {
    this.file = file;
    return this.file != null;
  }

  /**
   * start a new interaction
   *
   * @param event
   *          the world space event
   * @return a mouse interaction to manipulate things (or null if nothing to do)
   */
  /*
   * public static MouseInteraction startInteractionXYZx(final AbstractThing thing, final AdjustedMouseEvent event) {
   * 
   * thing.transform().writeToThingSpace(event.position);
   * 
   * final ArrayList<ThingInteraction> interactions = new ArrayList<>(1);
   * 
   * for (final HasMouseInteractionsDEFUNCT mouse : thing.collect(HasMouseInteractionsDEFUNCT.class)) { final ThingInteraction interaction = mouse.startInteraction(event); if (interaction != null) { interactions.add(interaction); } }
   * 
   * if (interactions.size() == 0) { return null; }
   * 
   * final ThingInteraction interaction = interactions.size() == 1 ? interactions.get(0) : new MultiThingInteraction(interactions); thing.container.history.register(thing); return new ThingInteractionToMouseIteractionAdapter(thing.container.history, interaction, thing.transform()); }
   */

  /*
   * public MouseInteraction getSelectionMovers(final AdjustedMouseEvent event) { document.container.history.capture(); final HashSet<MouseInteraction> set = new HashSet<MouseInteraction>(); for (final AbstractThing thing : document.container) { final MousePart mouse = thing.first(MousePart.class); if (mouse != null) { // mouse.beginMoving(set, event); } } if (set.size() == 0) { return null; }
   * 
   * final MouseInteraction setmover = new SetMover(set); return new HistoryMouseInteractionTrapper(document.container.history, setmover); }
   */

  /*
   * public boolean isInSelectionSet(final AdjustedMouseEvent event) { for (final AbstractThing thing : document.container) { if (AbstractThingHelpers.isInCurrertSelection(thing, event)) { return true; } } return false; }
   */

  @Override
  public void updateSelectionWindow(final SelectionWindow window) {
    for (final AbstractThing thing : document.container) {
      final MousePart mouse = thing.first(MousePart.class);
      if (mouse != null) {
        mouse.updateSelectionWindow(window);
      }
    }
  }
}