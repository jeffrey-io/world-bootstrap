package io.jeffrey.world.things.parts;

import java.util.Collection;
import java.util.function.Supplier;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasGuideLineEnforcers;
import io.jeffrey.world.things.behaviors.HasSelectionByPoint;
import io.jeffrey.world.things.behaviors.HasSelectionByWindow;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.enforcer.GuideLineEnforcer;
import io.jeffrey.world.things.enforcer.SerialEnforcer;
import io.jeffrey.world.things.interactions.SelectionSolver;
import io.jeffrey.world.things.interactions.SelectionSolver.Rule;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.interactions.ThingRotater;
import io.jeffrey.world.things.interactions.ThingScaler;
import io.jeffrey.world.things.interactions.ThingSnapper;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.meta.GuideLine;
import javafx.scene.shape.Polygon;

public class MousePart implements Part, HasSelectionByWindow, HasSelectionByPoint {

  public static Polygon transformSelectionWindow(final SelectionWindow window, final Transform transform) {
    final double[] adjusted = window.rect();
    final VectorRegister3 scratch = new VectorRegister8();
    for (int k = 0; k < 8; k += 2) {
      scratch.set_0(adjusted[k], adjusted[k + 1]);
      transform.writeToThingSpace(scratch);
      adjusted[k] = scratch.x_1;
      adjusted[k + 1] = scratch.y_1;
    }
    return new Polygon(adjusted);
  }

  private final EditingPart   editing;
  private final LayerPart     layer;
  private final LifetimePart  lifetime;
  private final PositionPart  position;
  private final RotationPart  rotation;
  private final ScalePart     scale;
  private boolean             selectedPriorSelectionWindow;

  private final AbstractThing thing;

  private final Transform     transform;

  public MousePart(final AbstractThing thing, final Transform transform) {
    this.thing = thing;
    this.transform = transform;
    editing = thing.first(EditingPart.class);
    scale = thing.first(ScalePart.class);
    position = thing.first(PositionPart.class);
    rotation = thing.first(RotationPart.class);
    layer = thing.first(LayerPart.class);
    lifetime = thing.first(LifetimePart.class);
  }

  @Override
  public void beginSelectionWindow() {
    selectedPriorSelectionWindow = editing.selected.value();
  }

  @Override
  public boolean buildSelectionSolver(final SelectionSolver solver) {
    if (produceDoodad(solver)) {
      return true;
    } else if (contains(solver.event)) {
      if (editing.selected.value()) {
        solver.propose(Rule.AlreadySelectedItemAndPointPreserves, snap(() -> new ThingMover(solver.event, position, rotation, editing)));
      } else {
        solver.propose(Rule.NotAlreadySelectedAndPointIsInItem, snap(() -> new ThingMover(solver.event, position, rotation, editing)));
      }
      return true;
    }
    return false;
  }

  private boolean contains(final AdjustedMouseEvent event) {
    for (final IsSelectable isSelectable : thing.collect(IsSelectable.class)) {
      if (isSelectable.doesMouseEventPreserveExistingSelection(event)) {
        return true;
      }
    }
    return false;
  }

  /**
   * @return how to snap this to lines
   */
  protected GuideLineEnforcer getGuideLineEnforcer() {
    final Collection<GuideLineEnforcer> enforcers = thing.collectAndMerge(HasGuideLineEnforcers.class, t -> t.getGuideLineEnforcers());

    if (enforcers.isEmpty()) {
      return null;
    } else {
      return new SerialEnforcer(enforcers);
    }
  }

  private boolean produceDoodad(final SelectionSolver solver) {
    if (!editing.selected.value()) {
      return false;
    }
    final VectorRegister3 W = new VectorRegister3();

    for (final ControlDoodad doodad : thing.collectAndMergeOverArray(HasControlDoodadsInThingSpace.class, t -> t.getDoodadsInThingSpace())) {
      if (!transform.allowed(doodad.type)) {
        continue;
      }

      W.set_0(doodad.u, doodad.v);
      transform.writeToWorldSpace(W);
      final double d = solver.event.doodadDistance(W.x_1, W.y_1);
      if (d <= thing.container.controlPointSize) {
        if (doodad.type == Type.PointSelected || doodad.type == Type.PointSelected) {
          return false;
        }
        if (doodad.type == Type.Scale && scale != null) {
          solver.propose(Rule.Doodad, () -> new ThingScaler(solver.event, transform, scale, editing));
          return true;
        }
        if (doodad.type == Type.Rotate && rotation != null) {
          solver.propose(Rule.Doodad, () -> new ThingRotater(solver.event, transform, rotation, editing));
          return true;
        }
      }
    }
    return false;
  }

  private Supplier<ThingInteraction> snap(final Supplier<ThingInteraction> delegate) {
    return () -> {
      ThingInteraction interaction = delegate.get();

      // TODO; to this as a higher level
      if (interaction != null && layer != null && interaction instanceof ThingMover) {
        final Collection<GuideLine> lines = thing.container.getGuideLines(layer.layer.getAsText());
        if (lines.size() > 0) {
          final GuideLineEnforcer enforcer = getGuideLineEnforcer();
          if (enforcer != null) {
            interaction = new ThingSnapper(thing.container.camera, lines, enforcer, interaction);
          }
        }
      }

      return interaction;
    };
  }

  @Override
  public void updateSelectionWindow(final SelectionWindow window) {
    if (lifetime.isDeleted()) {
      return;
    }
    final Polygon polygon = transformSelectionWindow(window, transform);
    boolean touches = false;
    for (final boolean mayTouch : thing.collect(IsSelectable.class, t -> t.selectionIntersect(polygon, window.mode))) {
      if (mayTouch) {
        touches = true;
      }
    }
    final boolean shouldSelect = window.mode.selected(selectedPriorSelectionWindow, touches);
    if (shouldSelect) {
      editing.selected.value(true);
    } else {
      editing.selected.value(false);
    }
  }

}
