package io.jeffrey.world.things.parts;

import java.util.Set;
import java.util.function.Consumer;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Subscribers;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasInternalSelection;
import io.jeffrey.world.things.behaviors.HasInternalStateThatMayNeedManualUpdating;
import io.jeffrey.world.things.behaviors.HasMover;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.EventedPoint2Mover;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;
import javafx.scene.shape.Polygon;

public abstract class PointSetPart implements Part, HasControlDoodadsInThingSpace, HasInternalSelection, IsSelectable, HasMover, HasActions, HasInternalStateThatMayNeedManualUpdating {

  public class SharedMutableCache {
    public double       boundingRadiusForControls;
    public double[]     inlineXYPairs;
    public PointSetPart owner;
    public double[]     x;
    public double[]     y;

    public SharedMutableCache() {
      boundingRadiusForControls = 0;
      inlineXYPairs = new double[0];
      x = new double[0];
      y = new double[0];
    }
  }

  private final SharedMutableCache              cache;
  private final Document                        document;

  private ControlDoodad[]                       doodads   = new ControlDoodad[0];
  public final EditBoolean                      lock;

  private final Subscribers<SharedMutableCache> notification;
  public boolean                                outOfDate = false;

  private final PositionPart                    position;
  private final RotationPart                    rotation;
  private final ScalePart                       scale;
  private final Transform                       transform;

  public final EditString                       vertices;

  public PointSetPart(final LinkedDataMap data, final Document document, final Transform transform, final PositionPart position, final ScalePart scale, final RotationPart rotation) {
    lock = data.getBoolean("vlock", false);
    this.document = document;
    this.scale = scale;
    this.rotation = rotation;
    this.transform = transform;
    cache = new SharedMutableCache();

    lock.subscribe((t, u) -> PointSetPart.this.dirty());
    outOfDate = true;
    notification = new Subscribers<>();
    this.position = position;

    vertices = data.getString("points", "0,-1,1,1,-1,1");
    updateInternalState();
  }

  @Override
  public void act(final String action, final SharedActionSpace space) {
    if ("apply_scale_to_points_reset_scale".equals(action)) {
      apply_scale_to_points_reset_scale();
    }
    if ("center_points_internally".equals(action)) {
      center_points_internally();
    }
  }

  private void apply_scale_to_points_reset_scale() {
    updateInternalState();
    final double mx = scale.sx();
    final double my = scale.sy();
    scale.sx(1.0);
    scale.sy(1.0);
    if (cache.inlineXYPairs.length == 0) {
      return;
    }
    for (final SelectablePoint2 p : getSelectablePoints()) {
      p.x *= mx;
      p.y *= my;
    }
    updateInternalState();
    dirty();
  }

  @Deprecated
  public abstract SelectablePoint2 at(int k);

  @Override
  public void cacheInternalSelection() {
    for (final SelectablePoint2 p : getSelectablePoints()) {
      p.alreadySelected = p.selected;
    }
  }

  private void center_points_internally() {
    updateInternalState();
    if (cache.inlineXYPairs.length == 0) {
      return;
    }
    double cx = 0;
    double cy = 0;
    int n = 0;
    for (final SelectablePoint2 p : getSelectablePoints()) {
      cx += p.x;
      cy += p.y;
      n++;
    }
    if (n == 0) {
      return; // should be impossible
    }
    cx /= n;
    cy /= n;
    for (final SelectablePoint2 p : getSelectablePoints()) {
      p.x -= cx;
      p.y -= cy;
    }
    // TODO: figure out how to translate the parent by a meaningful amount
    dirty();
  }

  @Override
  public boolean contains(final double x, final double y) {
    return false;
  }

  public void dirty() {
    outOfDate = true;
  }

  @Override
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event) {
    final VectorRegister3 W = new VectorRegister3();
    if (document != null) {
      for (final SelectablePoint2 point : getSelectablePoints()) {
        if (point.selected) {
          W.set_0(point.x, point.y);
          transform.writeToWorldSpace(W);
          if (event.doodadDistance(W.x_1, W.y_1) <= document.controlPointSize) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private void ensureCapacityIsCorrect(final int n, final int ds) {
    if (cache.x.length != n) {
      cache.inlineXYPairs = new double[n * 2];
      cache.x = new double[n];
      cache.y = new double[n];
    }
    if (doodads.length != ds) {
      doodads = new ControlDoodad[ds];
      for (int k = 0; k < doodads.length; k++) {
        doodads[k] = new ControlDoodad(Type.PointUnselected, 0, 0);
      }
    }
  }

  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return doodads;
  }

  @Deprecated
  public abstract int getNumberOfPoints();

  public abstract Iterable<SelectablePoint2> getSelectablePoints();

  public void invalidateNow() {
    dirty();
    updateInternalState();
  }

  @Override
  public void iterateMovers(final Set<ThingInteraction> interactions, final AdjustedMouseEvent event) {
    boolean all = true;
    boolean any = false;

    for (final SelectablePoint2 point : getSelectablePoints()) {
      if (!point.selected) {
        all = false;
      } else {
        any = true;
      }
    }
    if (all || !any) {
      // this will be faster
      interactions.add(new ThingMover(event, position, rotation));
      return;
    }

    final Syncable sync = () -> dirty();

    for (final SelectablePoint2 point : getSelectablePoints()) {
      if (point.selected) {
        interactions.add(new EventedPoint2Mover(new EventedPoint2(point, sync), event));
      }
    }
  }

  @Override
  public void list(final Set<String> actionsAvailable) {
    actionsAvailable.add("apply_scale_to_points_reset_scale");
    actionsAvailable.add("center_points_internally");
  }

  @Override
  public boolean selectionIntersect(final Polygon polygon, final Mode mode) {
    boolean doUpdate = false;
    boolean isSelected = false;
    boolean anySelected = false;
    final int n = getNumberOfPoints();
    for (int k = 0; k < n; k++) {
      final SelectablePoint2 point = at(k);
      final boolean old = point.selected;
      if (polygon.contains(point.x, point.y)) {
        point.selected = true;
        isSelected = true;
      } else {
        point.selected = false;
      }
      point.selected = mode.selected(point.alreadySelected, point.selected);
      if (old != point.selected) {
        doUpdate = true;
      }
      if (point.selected) {
        anySelected = true;
      }
    }
    if (doUpdate) {
      invalidateNow();
    }
    if (mode == Mode.Subtract && anySelected) {
      return false;
    }
    return isSelected;
  }

  public void subscribe(final Consumer<SharedMutableCache> subscriber) {
    subscriber.accept(cache);
    notification.subscribe(subscriber);
  }

  @Override
  public void updateInternalState() {
    if (!outOfDate) {
      return;
    }
    final int n = getNumberOfPoints();
    final boolean canScale = scale != null && !scale.lock.value();
    final boolean canRotate = rotation != null && !rotation.lock.value();
    final int doff = lock.value() ? 0 : n;
    final int ds = doff + (canScale ? 4 : 0) + (canRotate ? 4 : 0);
    ensureCapacityIsCorrect(n, ds);
    if (n == 0) {
      return;
    }
    int k;

    // walk the points
    cache.boundingRadiusForControls = 0;
    for (k = 0; k < n; k++) {
      final SelectablePoint2 p = at(k);
      cache.inlineXYPairs[2 * k] = p.x;
      cache.inlineXYPairs[2 * k + 1] = p.y;
      cache.x[k] = p.x;
      cache.y[k] = p.y;
      cache.boundingRadiusForControls = Math.max(cache.boundingRadiusForControls, p.x * p.x + p.y * p.y);
      if (!lock.value()) {
        doodads[k].u = p.x;
        doodads[k].v = p.y;
        doodads[k].type = p.selected ? Type.PointSelected : Type.PointUnselected;
      }
    }

    final double PI = 3.1415926535897932384626433832795;
    final double[] ANGLES = new double[] { PI / 4, 3 * PI / 4, -PI / 4, -3 * PI / 4, 0, PI / 2, PI, -PI / 2 };

    if (canScale || canRotate) {
      final double scale_norm = scale.sx() + scale.sy();
      final double aug = 32 / scale_norm;
      cache.boundingRadiusForControls = Math.sqrt(cache.boundingRadiusForControls) + aug;
      int j;
      if (canScale) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Scale;
          doodads[k].u = Math.cos(ANGLES[j]) * cache.boundingRadiusForControls;
          doodads[k].v = Math.sin(ANGLES[j]) * cache.boundingRadiusForControls;
          k++;
        }
      }
      if (canRotate) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Rotate;
          doodads[k].u = Math.cos(ANGLES[j + 4]) * cache.boundingRadiusForControls;
          doodads[k].v = Math.sin(ANGLES[j + 4]) * cache.boundingRadiusForControls;
          k++;
        }
      }
    }

    cache.owner = this;
    notification.publish(cache);
  }
}
