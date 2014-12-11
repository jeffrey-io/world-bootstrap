package io.jeffrey.world.things.interactions;

import io.jeffrey.world.things.core.Thing;
import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * move the entire thing
 *
 * @author jeffrey
 */
public class ThingMover implements ThingInteraction {

    private final double             angle;

    private final Thing              target;
    private final double             ix;
    private final double             iy;
    private final double             x;
    private final double             y;

    /**
     * @param initial
     *            the initial event in the thing space
     */
    public ThingMover(final AdjustedMouseEvent initial) {
        this.target = (Thing) initial.userdata;
        x = target.x();
        y = target.y();
        ix = initial.position.x_0;
        iy = initial.position.y_0;
        angle = target.angle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        target.x(x);
        target.y(y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moved(final AdjustedMouseEvent event) {
        target.x(x + event.position.x_0 - ix);
        target.y(y + event.position.y_0 - iy);
        target.angle(angle);
    }

}
