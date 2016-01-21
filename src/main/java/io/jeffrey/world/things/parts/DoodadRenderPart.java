package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInWorldSpace;
import io.jeffrey.world.things.behaviors.HasWorldSpaceRendering;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.AbstractThingSingleItemCache;
import io.jeffrey.world.things.core.AdaptThingSpaceDoodadsIntoWorldSpace;
import io.jeffrey.world.things.core.ControlDoodad;
import io.jeffrey.world.things.core.ControlDoodad.Type;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.zer.Camera;
import javafx.scene.canvas.GraphicsContext;

public class DoodadRenderPart implements Part, HasWorldSpaceRendering {

  private final AbstractThingSingleItemCache<Set<AdaptThingSpaceDoodadsIntoWorldSpace>> doodadCaches;
  private final EditingPart                                                             editing;
  private final LifetimePart                                                            lifetime;
  private final AbstractThing                                                           thing;

  public DoodadRenderPart(final AbstractThing thing, final Transform transform) {
    this.thing = thing;
    lifetime = thing.first(LifetimePart.class);
    editing = thing.first(EditingPart.class);

    doodadCaches = new AbstractThingSingleItemCache<Set<AdaptThingSpaceDoodadsIntoWorldSpace>>(thing) {
      @Override
      protected Set<AdaptThingSpaceDoodadsIntoWorldSpace> compute() {
        return thing.collect(HasControlDoodadsInThingSpace.class, child -> new AdaptThingSpaceDoodadsIntoWorldSpace(transform, child));
      }
    };
  }

  @Override
  public void render(final GraphicsContext gc) {
    final Document document = thing.document;
    final Camera camera = document.camera;

    if (lifetime.isDeleted()) {
      return;
    }
    if (!editing.locked.value() && editing.selected.value()) {
      for (final HasControlDoodadsInWorldSpace parent : doodadCaches.get()) {
        for (final ControlDoodad doodad : parent.getDoodadsInWorldSpace()) {
          if (doodad.type == Type.Scale) {
            gc.drawImage(document.SCALE_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
          } else if (doodad.type == Type.Rotate) {
            gc.drawImage(document.ROTATE_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
          } else if (doodad.type == Type.PointSelected) {
            gc.drawImage(document.VERTEX_ICON_SELECTED, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
          } else if (doodad.type == Type.PointUnselected) {
            gc.drawImage(document.VERTEX_ICON, -document.controlPointSize + camera.x(doodad.u), -document.controlPointSize + camera.y(doodad.v), 2 * document.controlPointSize, 2 * document.controlPointSize);
          }
        }
      }
    }
  }
}
