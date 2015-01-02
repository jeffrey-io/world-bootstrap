package io.jeffrey.world.things.core.guides;

import io.jeffrey.zer.AdjustedMouseEvent;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.meta.GuideLine;

public class Updator implements MouseInteraction {

    private static final double LOCK_AT   = 7.5 * Math.PI * 2.0 / 360;
    private static final double PRECISION = 0.001;

    private final GuideLine     line;
    private final double        x;
    private final double        y;

    public Updator(final GuideLine line, final double x, final double y) {
        this.line = line;
        this.x = x;
        this.y = y;
    }

    @Override
    public void cancel() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void moved(final AdjustedMouseEvent event) {
        // (x - x0) * m = (y - y0)
        // (x - x0) * (y1 - y0) = (x1 - x0) * (y - y0)
        double dx = event.position.x_0 - x;
        double dy = event.position.y_0 - y;
        // x * dy - x0 * dy = y * dx - y0 * dx
        final double N = Math.sqrt(dx * dx + dy * dy);
        dx /= N;
        dy /= N;
        if (event.altdown) {
            double angle = Math.atan2(dy, dx);
            angle = Math.round(angle / LOCK_AT) * LOCK_AT;
            dx = Math.round(Math.cos(angle) / PRECISION) * PRECISION;
            dy = Math.round(Math.sin(angle) / PRECISION) * PRECISION;
            ;
        }
        line.a.value(dy);
        line.b.value(-dx);
        final double c = Math.round((x * dy - y * dx) / PRECISION) * PRECISION;
        line.c.value(c);
    }

}
