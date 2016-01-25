package io.jeffrey.world.things.parts;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasSelectablePoints;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasUpdate;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;
import io.jeffrey.world.things.core.Subscribers;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver;
import io.jeffrey.world.things.interactions.InteractionSelectionSolver.Rule;
import io.jeffrey.world.things.interactions.MultiThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.interactions.ThingSelector;
import io.jeffrey.world.things.points.EventedPoint2;
import io.jeffrey.world.things.points.EventedPoint2Mover;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.SelectablePointsCommitment;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.edits.EditBoolean;

public class PointSetPart implements Part, HasControlDoodadsInThingSpace, IsSelectable, HasActions, HasUpdate, HasSelectionByPoint {

  public class PointSetMoverModel implements Supplier<ThingInteraction> {
    private boolean                  all;
    private boolean                  any;
    private final AdjustedMouseEvent event;

    public PointSetMoverModel(final AdjustedMouseEvent event) {
      this.event = event;
      requireUpToDate();
      all = true;
      any = false;
      for (final SelectablePoint2 point : points) {
        point.alreadySelected = point.selected;
        if (point.selected) {
          any = true;
        } else {
          all = false;
        }
      }
    }

    @Override
    public ThingInteraction get() {
      if (all || !any && editing.selected.value()) {
        // this will be faster
        return new ThingMover(event, position, rotation, editing);
      }

      if (any) {
        final ArrayList<ThingInteraction> its = new ArrayList<>();
        its.add(new ThingSelector(editing));
        for (final SelectablePoint2 point : points) {
          if (point.selected || point.alreadySelected) {
            its.add(new EventedPoint2Mover(new EventedPoint2(point, PointSetPart.this), event));
          }
        }
        its.add(new SelectablePointsCommitment(points));
        return new MultiThingInteraction(its);
      } else {
        return null;
      }
    }

    public boolean should() {
      if (all || any) {
        return true;
      }
      return false;
    }
  }

  public class SharedMutableCache {
    public double       boundingRadius;
    public double[]     inlineXYPairs;
    public PointSetPart owner;
    public double[]     x;
    public double[]     y;

    public SharedMutableCache() {
      boundingRadius = 0;
      inlineXYPairs = new double[0];
      x = new double[0];
      y = new double[0];
    }
  }

  private final SharedMutableCache              cache;;

  private final Container                       container;
  private ControlDoodad[]                       doodads   = new ControlDoodad[0];

  public final EditingPart                      editing;
  public final EditBoolean                      lock;

  private final Subscribers<SharedMutableCache> notification;
  public boolean                                outOfDate = false;
  public final HasSelectablePoints              points;
  private final PositionPart                    position;

  private final RotationPart                    rotation;
  private final ScalePart                       scale;
  private final Transform                       transform;

  public PointSetPart(final LinkedDataMap data, final Container container, final Transform transform, final PositionPart position, final ScalePart scale, final RotationPart rotation, final HasSelectablePoints points, final EditingPart editing) {
    lock = data.getBoolean("vlock", false);
    this.points = points;
    this.container = container;
    this.scale = scale;
    this.rotation = rotation;
    this.transform = transform;
    this.position = position;
    this.editing = editing;
    cache = new SharedMutableCache();

    lock.subscribe((t, u) -> PointSetPart.this.update());
    outOfDate = true;
    notification = new Subscribers<>();

    update();
  }

  private void apply_scale_to_points_reset_scale() {
    requireUpToDate();
    final double mx = scale.sx();
    final double my = scale.sy();
    scale.sx(1.0);
    scale.sy(1.0);
    if (cache.inlineXYPairs.length == 0) {
      return;
    }
    for (final SelectablePoint2 p : points) {
      p.x *= mx;
      p.y *= my;
    }
    update();
  }

  @Override
  public boolean buildSelectionSolver(final InteractionSelectionSolver solver) {
    final boolean overPoint = doesMouseEventPreserveExistingSelection(solver.event, true);
    final PointSetMoverModel mover = new PointSetMoverModel(solver.event);
    if (mover.should()) { // any points selected
      Rule rule = Rule.AlreadySelectedSubsetButNotInvolved;
      if (overPoint) {
        rule = Rule.AlreadySelectedFacetAndPointPreserves;
      }
      solver.propose(rule, mover);
      return true;
    } else if (overPoint) {
      solver.propose(Rule.NotAlreadySelectedAndPointIsInSubset, () -> {
        // need to select it
        // well, this kind of sucks, we may want to move all the vertices selected
        return startInteractionWithClear(solver.event, !solver.event.selective_addititive_mode);
      });
    }
    return false;
  }

  private void center_points_internally() {
    requireUpToDate();
    if (cache.inlineXYPairs.length == 0) {
      return;
    }
    double cx = 0;
    double cy = 0;
    int n = 0;
    for (final SelectablePoint2 p : points) {
      cx += p.x;
      cy += p.y;
      n++;
    }
    if (n == 0) {
      return; // should be impossible
    }
    cx /= n;
    cy /= n;
    for (final SelectablePoint2 p : points) {
      p.x -= cx;
      p.y -= cy;
    }
    position.move(cx, cy);
    update();
  }

  @Override
  public boolean contains(final double x, final double y) {
    return false;
  }

  @Override
  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event) {
    return doesMouseEventPreserveExistingSelection(event, false);
  }

  public boolean doesMouseEventPreserveExistingSelection(final AdjustedMouseEvent event, final boolean shouldSelect) {
    requireUpToDate();
    final VectorRegister3 W = new VectorRegister3();
    if (container != null) {
      for (final SelectablePoint2 point : points) {
        if (shouldSelect || point.selected) {
          W.set_0(point.x, point.y);
          transform.writeToWorldSpace(W);
          if (event.doodadDistance(W.x_1, W.y_1) <= container.controlPointSize) {
            if (shouldSelect) {
              if (event.selective_subtractive_mode) {
                point.alreadySelected = false;
                point.selected = false;
              } else {
                if (!event.selective_addititive_mode) {
                  for (final SelectablePoint2 other : points) {
                    other.alreadySelected = false;
                    other.selected = false;
                  }
                }
                point.alreadySelected = true;
                point.selected = true;
                editing.selected.value(true);
              }
            }
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
    requireUpToDate();
    return doodads;
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("apply_scale_to_points_reset_scale".equals(action)) {
      apply_scale_to_points_reset_scale();
    }
    if ("center_points_internally".equals(action)) {
      center_points_internally();
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    actionsAvailable.add("apply_scale_to_points_reset_scale");
    actionsAvailable.add("center_points_internally");
  }

  public void requireUpToDate() {
    if (!outOfDate) {
      return;
    }
    outOfDate = false;
    final int n = points.getNumberSelectablePoints();
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
    cache.boundingRadius = 0;
    k = 0;
    for (final SelectablePoint2 p : points) {
      cache.inlineXYPairs[2 * k] = p.x;
      cache.inlineXYPairs[2 * k + 1] = p.y;
      cache.x[k] = p.x;
      cache.y[k] = p.y;
      cache.boundingRadius = Math.max(cache.boundingRadius, p.x * p.x + p.y * p.y);
      if (!lock.value()) {
        doodads[k].u = p.x;
        doodads[k].v = p.y;
        doodads[k].type = p.selected ? Type.PointSelected : Type.PointUnselected;
      }
      k++;
    }

    final double PI = 3.1415926535897932384626433832795;
    final double[] ANGLES = new double[] { PI / 4, 3 * PI / 4, -PI / 4, -3 * PI / 4, 0, PI / 2, PI, -PI / 2 };

    if (canScale || canRotate) {
      final double scale_norm = scale.sx() + scale.sy();
      final double aug = 32 / scale_norm;
      cache.boundingRadius = Math.sqrt(cache.boundingRadius) + aug;
      int j;
      if (canScale) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Scale;
          doodads[k].u = Math.cos(ANGLES[j]) * cache.boundingRadius;
          doodads[k].v = Math.sin(ANGLES[j]) * cache.boundingRadius;
          k++;
        }
      }
      if (canRotate) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Rotate;
          doodads[k].u = Math.cos(ANGLES[j + 4]) * cache.boundingRadius;
          doodads[k].v = Math.sin(ANGLES[j + 4]) * cache.boundingRadius;
          k++;
        }
      }
    }

    cache.owner = this;
    notification.publish(cache);
  }

  @Override
  public boolean selectionIntersect(final SelectionModel model) {
    requireUpToDate();
    final boolean attemptContainment = model.isOriginCircleSelected(cache.boundingRadius);
    boolean doUpdate = false;
    boolean isSelected = false;
    boolean anySelected = false;
    for (final SelectablePoint2 point : points) {
      final boolean old = point.selected;
      if (attemptContainment && model.contains(point.x, point.y)) {
        point.selected = true;
        isSelected = true;
      } else {
        point.selected = false;
      }
      point.selected = model.mode.selected(point.alreadySelected, point.selected);
      if (old != point.selected) {
        doUpdate = true;
      }
      if (point.selected) {
        anySelected = true;
      }
    }
    if (doUpdate) {
      update();
    }
    if (model.mode == Mode.Subtract && anySelected) {
      return false;
    }
    return isSelected;
  }

  public ThingInteraction startInteractionWithClear(final AdjustedMouseEvent event, final boolean withClear) {
    final VectorRegister3 W = new VectorRegister3();
    if (container != null) {
      for (final SelectablePoint2 point : points) {
        W.set_0(point.x, point.y);
        transform.writeToWorldSpace(W);
        if (event.doodadDistance(W.x_1, W.y_1) <= container.controlPointSize) {
          if (withClear) {
            for (final SelectablePoint2 other : points) {
              other.selected = false;
            }
          }
          point.selected = true;
          return new EventedPoint2Mover(new EventedPoint2(point, this), event);
        }
      }
    }
    return null;
  }

  public void subscribe(final Consumer<SharedMutableCache> subscriber) {
    requireUpToDate();
    subscriber.accept(cache);
    notification.subscribe(subscriber);
  }

  @Override
  public void update() {
    outOfDate = true;
  }

}
