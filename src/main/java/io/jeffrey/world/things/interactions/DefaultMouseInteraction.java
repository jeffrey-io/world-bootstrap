package io.jeffrey.world.things.interactions;

import java.util.Collection;
import java.util.function.Function;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasGuideLineEnforcers;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.core__old_defunct.ThingInteraction;
import io.jeffrey.world.things.enforcer.SerialEnforcer;
import io.jeffrey.world.things.parts.EditingPart;
import io.jeffrey.world.things.parts.LayerPart;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.world.things.parts.ScalePart;
import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.meta.GuideLine;

public abstract class DefaultMouseInteraction {

  private final AbstractThing thing;
  private final HasControlDoodadsInThingSpace hasControlDoodadsInThingSpace;
  private final Document document;
  private final Transform transform;
  private final EditingPart editing;
  private final PositionPart position;
  private final ScalePart scale;
  private final RotationPart rotation;
  private final LayerPart layer;
  
  public DefaultMouseInteraction(  final AbstractThing thing, 
  final HasControlDoodadsInThingSpace hasControlDoodadsInThingSpace,
  final Document document,
  final Transform transform,
  final EditingPart editing,
  final PositionPart position,
  final ScalePart scale,
  final RotationPart rotation,
  final LayerPart layer) {
    this.thing = thing;
    this.hasControlDoodadsInThingSpace = hasControlDoodadsInThingSpace;
    this.document = document;
    this.transform = transform;
    this.editing = editing;
    this.position = position;
    this.scale = scale;
    this.rotation = rotation;
    this.layer = layer;
    
  }
  

  public ThingInteraction start(final AdjustedMouseEvent event) {
    transform.writeToTarget(event.position);
    ThingInteraction interaction = null;
    final VectorRegister3 W = new VectorRegister3();
  
    for (final ControlDoodad doodad : hasControlDoodadsInThingSpace.getDoodadsInThingSpace()) {
      if (editing.locked.value()) {
        break;
      }  
      if (interaction != null) {
        break;
      }
      if (!transform.allowed(doodad.type)) {
        continue;
      }

      W.set_0(doodad.u, doodad.v);
      transform.writeToWorld(W);
      final double d = event.doodadDistance(W.x_1, W.y_1);
      if (d <= document.controlPointSize) {
        if (doodad.type == Type.PointSelected || doodad.type == Type.PointSelected) {
          break;
        }
        if (doodad.type == Type.Scale) {
          interaction = new ThingScaler(event, transform, scale);
        }
        if (doodad.type == Type.Rotate) {
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
    if (interaction instanceof ThingMover) {
      final Collection<GuideLine> lines = document.getGuideLines(layer.layer.getAsText());
      if (lines.size() > 0) {
        final GuideLineEnforcer enforcer = getGuideLineEnforcer();
        if (enforcer != null) {
          interaction = new ThingSnapper(document.camera, lines, enforcer, interaction);
        }
      }
    }

    editing.selected.value(true);
    return interaction;
  }
  protected abstract ThingInteraction startTargetAdjustedInteraction(AdjustedMouseEvent event);
  /**
   * @return how to snap this to lines
   */
  protected GuideLineEnforcer getGuideLineEnforcer() {
    Collection<GuideLineEnforcer> enforcers = thing.collect(
        HasGuideLineEnforcers.class,
        new Function<HasGuideLineEnforcers,
        Collection<GuideLineEnforcer>>() {
      @Override
      public Collection<GuideLineEnforcer> apply(HasGuideLineEnforcers t) {
        return t.getGuideLineEnforcers();
      }
    });
    
    if (enforcers.isEmpty()) {
      return null;
    } else {
      return new SerialEnforcer(enforcers);
    }
  }

  
}
