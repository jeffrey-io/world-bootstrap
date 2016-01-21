package io.jeffrey.world.things;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister8;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.AbstractThing;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RenderPathPart;
import io.jeffrey.world.things.points.PointListThing;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.world.things.points.list.SelectablePoint2List.Property;
import io.jeffrey.zer.edits.EditString;

/**
 * A thing that connects to other things
 *
 * @author jeffrey
 */
public class TConnector extends PointListThing {
  /**
   *
   * Represnets a vertex that is locked by name; this provides the snap-to effect when a node is editted
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

    private void update(final Document document) {
      final VectorRegister3 W = new VectorRegister3();
      W.set_0(pnt.x, pnt.y);
      transform.writeToWorldSpace(W);
      currentThing = document.selectFirstVisible(W.x_1, W.y_1);
      if (currentThing != null) {
        updateFast();
      } else {
        link.value("");
      }
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
  public TConnector(final Document document, final ThingData node) {
    super(document, node, Property.Finite);
    from = new LockedVertex(list.at(0), data, "from");
    to = new LockedVertex(list.at(1), data, "to");
    points.update();
    points.requireUpToDate();
    dirty = true;
    register(new RenderPathPart(transform, document, points, list));
  }

  public void refresh() {
    if (dirty) {
      from.update(document);
      to.update(document);
    } else {
      from.updateFast();
      to.updateFast();
    }
    dirty = false;
  }
}
