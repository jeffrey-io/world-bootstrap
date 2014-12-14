package io.jeffrey.world.document;

import io.jeffrey.vector.VectorRegister2;

/**
 * a guide line which objects can snap too
 *
 * @author jeffrey
 */
public class GuideLine {

    public double                distance;
    public final VectorRegister2 line;

    public GuideLine() {
        line = new VectorRegister2();
        line.set_0(0, 0);
        line.set_1(100, 100);
        distance = 10;
    }

    public void draw() {

    }

    /**
     * make the guide line "infinite"; TODO: Define how big the box can be
     *
     * @return a guide line
     */
    public GuideLine grow() {
        double dx = line.x_1 - line.x_0;
        double dy = line.y_1 - line.y_0;
        final double d = Math.sqrt(dx * dx + dy * dy);
        dx /= d;
        dy /= d;
        final double cx = (line.x_1 + line.x_1) / 2.0;
        final double cy = (line.y_1 + line.y_1) / 2.0;
        final GuideLine grown = new GuideLine();
        grown.line.set_0(cx - dx * 10000, cy - dy * 10000);
        grown.line.set_1(cx + dx * 10000, cy + dy * 10000);
        grown.distance = distance;
        return grown;
    }
}
