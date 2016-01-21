package io.jeffrey.world.things.points;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.ThingData;
import io.jeffrey.world.things.base.BasicThing;
import io.jeffrey.world.things.parts.EdgeMoverPart;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.parts.PointSetPart;
import io.jeffrey.world.things.parts.StandardPointListActions;
import io.jeffrey.world.things.points.list.SelectablePoint2List;
import io.jeffrey.world.things.points.list.SelectablePoint2List.Property;

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
  protected PointListThing(final Document document, final ThingData node, final Property... properties) {
    super(document, node);
    list = new SelectablePoint2List(node.getString("points", "0,-1,1,1,-1,1").value(), properties);
    points = new PointSetPart(data, document, transform, position, scale, rotation, list);
    register(points);
    register(list);
    register(new MousePart(this, transform));
    editing.selected.subscribe((t, u) -> {
      if (t.equals(u)) {
        return;
      }
      final boolean dest = Boolean.parseBoolean(u);
      if (!dest) {
        for (final SelectablePoint2 point : list) {
          point.selected = false;
        }
      }
      points.update();
    });
    register(new StandardPointListActions(list));
    register(new EdgeMoverPart(document, transform, list, points.lock, points));
  }

}
