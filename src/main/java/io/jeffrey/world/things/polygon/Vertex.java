package io.jeffrey.world.things.polygon;

import io.jeffrey.zer.Syncable;

/**
 * a bi-direction link to a point inside of a polygon
 *
 * @author jeffrey
 *
 */
public class Vertex {
    private final SelectablePoint2 point;
    private final Syncable         sync;
    public final double            x;
    public final double            y;

    Vertex(final SelectablePoint2 point, final Syncable sync) {
        x = point.x;
        y = point.y;
        this.point = point;
        this.sync = sync;
    }

    public void reset() {
        update(x, y);
    }

    public void update(final double dx, final double dy) {
        point.x = x + dx;
        point.y = y + dy;
        sync.sync();
    }
}