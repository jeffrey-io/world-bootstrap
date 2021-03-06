package io.jeffrey.world.things.points;

import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.parts.IndividualEdgeMoverPart;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.parts.PointSetPart;
import io.jeffrey.world.things.parts.StandardPointListActions;
import io.jeffrey.world.things.points.list.Property;
import io.jeffrey.world.things.points.list.SelectablePoint2List;

/**
 * Defines common operations on things that behave like polygons/lines/graph connects. That is, things that have a bunch of vertices connected on some kind of chain/loop
 *
 * @author jeffrey
 *
 */
public class PointListThing extends BasicThing {

  /**
   * Defines how to render and interpret the points. This is lazily updated
   *
   * @author jeffrey
   */
  protected final SelectablePoint2List list;
  protected final PointSetPart         points;

  /**
   * @param document
   *          the document
   * @param node
   *          where the thing's data iss
   */
  protected PointListThing(final Container container, final LinkedDataMap data, final Property... properties) {
    super(container, data);
    list = new SelectablePoint2List(data.getString("points", "0,-1,1,1,-1,1"), properties);

    points = new PointSetPart(data, container, transform, position, scale, rotation, list, editing);
    register(points);
    register(list);
    register(new MousePart(this, transform));
    editing.selected.subscribe((t, u) -> {
      if (t.equals(u)) {
        return;
      }
      if (!u) {
        for (final SelectablePoint2 point : list) {
          point.selected = false;
        }
      }
      points.update();
    });
    register(new StandardPointListActions(list));
    register(new IndividualEdgeMoverPart(container, transform, list, points.lock, points, editing));
  }

}
