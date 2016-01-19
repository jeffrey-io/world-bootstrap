package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.AbstractThingSingleItemCache;
import io.jeffrey.world.things.base.AdaptThingSpaceDoodadsIntoWorldSpace;
import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.Transform;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.behaviors.CanRenderInWorldSpace;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInWorldSpace;
import io.jeffrey.zer.Camera;
import javafx.scene.canvas.GraphicsContext;

public class DoodadRenderPart implements Part, CanRenderInWorldSpace {

  private final AbstractThing                                                           thing;
  private final LifetimePart                                                            lifetime;
  private final EditingPart                                                             editing;
  private final AbstractThingSingleItemCache<Set<AdaptThingSpaceDoodadsIntoWorldSpace>> doodadCaches;

  public DoodadRenderPart(AbstractThing thing, Transform transform) {
    this.thing = thing;
    this.lifetime = thing.first(LifetimePart.class);
    this.editing = thing.first(EditingPart.class);

    doodadCaches = new AbstractThingSingleItemCache<Set<AdaptThingSpaceDoodadsIntoWorldSpace>>(thing) {
      @Override
      protected Set<AdaptThingSpaceDoodadsIntoWorldSpace> compute() {
        return thing.collect(HasControlDoodadsInThingSpace.class, child -> new AdaptThingSpaceDoodadsIntoWorldSpace(transform, child));
      }
    };
  }

  @Override
  public void render(GraphicsContext gc) {
    final Document document = thing.document;
    final Camera camera = document.camera;

    if (lifetime.isDeleted()) {
      return;
    }
    if (!editing.locked.value() && editing.selected.value()) {
      for (HasControlDoodadsInWorldSpace parent : doodadCaches.get()) {
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

  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }

  @Override
  public void update() {
  }

}
