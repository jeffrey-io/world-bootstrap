package io.jeffrey.world.things.parts;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasGuideLineEnforcers;
import io.jeffrey.world.things.behaviors.HasMouseInteractions;
import io.jeffrey.world.things.behaviors.HasMover;
import io.jeffrey.world.things.behaviors.HasSelectionByWindow;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.enforcer.SerialEnforcer;
import io.jeffrey.world.things.interactions.ThingInteraction;
import io.jeffrey.world.things.interactions.ThingInteractionToMouseIteractionAdapter;
import io.jeffrey.world.things.interactions.ThingMover;
import io.jeffrey.world.things.interactions.ThingRotater;
import io.jeffrey.world.things.interactions.ThingScaler;
import io.jeffrey.world.things.interactions.ThingSnapper;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.meta.GuideLine;
import javafx.scene.shape.Polygon;

public class MousePart implements Part, HasSelectionByWindow, HasMouseInteractions {

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

  // TODO: this should be moved out
  public void beginMoving(final Set<MouseInteraction> interactions, final AdjustedMouseEvent event) {
    if (editing != null) {
      if (editing.locked.value() || !editing.selected.value()) {
        return;
      }
    }
    if (lifetime != null && lifetime.isDeleted()) {
      return;
    }
    transform.writeToThingSpace(event.position);
    final HashSet<ThingInteraction> local = new HashSet<>();
    for (final HasMover mover : thing.collect(HasMover.class)) {
      mover.iterateMovers(local, event);
    }
    final Collection<GuideLine> lines = thing.document.getGuideLines(layer.layer.getAsText());

    GuideLineEnforcer enforcer = null;
    if (lines.size() > 0) {
      enforcer = getGuideLineEnforcer();
    }
    for (final ThingInteraction itRaw : local) {
      final ThingInteraction it;
      if (lines.size() > 0 && enforcer != null) {
        it = new ThingSnapper(thing.document.camera, lines, enforcer, itRaw);
      } else {
        it = itRaw;
      }
      thing.document.history.register(thing);
      interactions.add(new ThingInteractionToMouseIteractionAdapter(thing.document.history, it, transform));
    }
  }

  @Override
  public void beginSelectionWindow() {
    selectedPriorSelectionWindow = editing.selected.value();
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

  @Override
  public ThingInteraction startInteraction(final AdjustedMouseEvent event) {
    transform.writeToThingSpace(event.position);
    ThingInteraction interaction = null;
    final VectorRegister3 W = new VectorRegister3();

    for (final ControlDoodad doodad : thing.collectAndMergeOverArray(HasControlDoodadsInThingSpace.class, t -> t.getDoodadsInThingSpace())) {
      if (editing != null && editing.locked.value()) {
        break;
      }
      if (interaction != null) {
        break;
      }
      if (!transform.allowed(doodad.type)) {
        continue;
      }

      W.set_0(doodad.u, doodad.v);
      transform.writeToWorldSpace(W);
      final double d = event.doodadDistance(W.x_1, W.y_1);
      if (d <= thing.document.controlPointSize) {
        if (doodad.type == Type.PointSelected || doodad.type == Type.PointSelected) {
          break;
        }
        if (doodad.type == Type.Scale && scale != null) {
          interaction = new ThingScaler(event, transform, scale);
        }
        if (doodad.type == Type.Rotate && rotation != null) {
          interaction = new ThingRotater(event, transform, rotation);
        }
      }
    }
    if (interaction == null) {
      interaction = startTargetAdjustedInteraction(event);
    }
    if (interaction == null) {
      return null;
    }
    if (interaction instanceof ThingMover && layer != null) {
      final Collection<GuideLine> lines = thing.document.getGuideLines(layer.layer.getAsText());
      if (lines.size() > 0) {
        final GuideLineEnforcer enforcer = getGuideLineEnforcer();
        if (enforcer != null) {
          interaction = new ThingSnapper(thing.document.camera, lines, enforcer, interaction);
        }
      }
    }
    if (editing != null) {
      editing.selected.value(true);
    }
    return interaction;
  }

  private ThingInteraction startTargetAdjustedInteraction(final AdjustedMouseEvent event) {
    for (final IsSelectable isSelectable : thing.collect(IsSelectable.class)) {
      if (isSelectable.doesMouseEventPreserveExistingSelection(event)) {
        return new ThingMover(event, position, rotation);
      }
    }
    return null;
  }

  @Override
  public void updateSelectionWindow(final SelectionWindow window) {
    if (lifetime.isDeleted()) {
      return;
    }
    final double[] adjusted = window.rect();
    final VectorRegister3 scratch = new VectorRegister8();
    for (int k = 0; k < 8; k += 2) {
      scratch.set_0(adjusted[k], adjusted[k + 1]);
      transform.writeToThingSpace(scratch);
      adjusted[k] = scratch.x_1;
      adjusted[k + 1] = scratch.y_1;
    }
    final Polygon polygon = new Polygon(adjusted);
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
