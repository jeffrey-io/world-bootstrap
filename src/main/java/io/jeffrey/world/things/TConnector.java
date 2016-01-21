package io.jeffrey.world.things;

import java.util.Iterator;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RenderPathPart;
import io.jeffrey.world.things.points.PointListThing;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.Property;
import io.jeffrey.zer.edits.EditString;

/**
 * A thing that connects to other things
 *
 * @author jeffrey
 */
public class TConnector extends PointListThing {
  /**
   *
   * Represents a vertex that is locked by name; this provides the snap-to effect when a node is editted
   *
   * @author jeffrey
   */
  private class LockedVertex {
    private AbstractThing          currentThing;
    private final EditString       link;
    private final SelectablePoint2 pnt;

    public LockedVertex(final SelectablePoint2 pnt, final LinkedDataMap node, final String name) {
      link = node.getString(name, "");
      this.pnt = pnt;
      currentThing = null;
    }

    private void update(final Container container) {
      /*
       * final VectorRegister3 W = new VectorRegister3(); W.set_0(pnt.x, pnt.y); transform.writeToWorldSpace(W); currentThing = container.selectFirstVisible(W.x_1, W.y_1); if (currentThing != null) { updateFast(); } else { link.value(""); }
       */
    }

    private void updateFast() {
      if (currentThing != null) {
        final VectorRegister3 to = new VectorRegister8();
        final PositionPart position = currentThing.first(PositionPart.class);
        if (position == null) {
          currentThing = null;
          dirty = true;
          return;
        }
        to.set_0(position.x(), position.y());
        currentThing.transform().writeToThingSpace(to);
        pnt.x = to.x_1;
        pnt.y = to.y_1;
        points.update();
        dirty = false;
        link.value(currentThing.getID());
      }
    }
  }

  private boolean            dirty;
  private final LockedVertex from;
  private final LockedVertex to;

  /**
   * @param document
   *          the owner of the thing
   * @param node
   *          where the data for the thing iss
   */
  public TConnector(final Container container, final LinkedDataMap data) {
    super(container, data, Property.Finite);
    final Iterator<SelectablePoint2> it = list.iterator();
    from = new LockedVertex(it.next(), data, "from");
    to = new LockedVertex(it.next(), data, "to");
    points.update();
    points.requireUpToDate();
    dirty = true;
    register(new RenderPathPart(transform, container, points, list));
  }

  public void refresh() {
    if (dirty) {
      from.update(container);
      to.update(container);
    } else {
      from.updateFast();
      to.updateFast();
    }
    dirty = false;
  }
}
