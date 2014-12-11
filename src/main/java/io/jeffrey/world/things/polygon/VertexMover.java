package io.jeffrey.world.things.polygon;

import io.jeffrey.world.things.core.ThingInteraction;
import io.jeffrey.zer.AdjustedMouseEvent;

/**
 * move a vertex
 *
 * @author jeffrey
 */
public class VertexMover implements ThingInteraction {

    private final double ix;
    private final double iy;
    private final Vertex vertex;

    /**
     * @param vertex
     *            the vertex to move
     * @param initial
     *            the initial event in thing space
     */
    public VertexMover(final Vertex vertex, final AdjustedMouseEvent initial) {
        this.vertex = vertex;
        ix = initial.position.x_1;
        iy = initial.position.y_1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        vertex.reset();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moved(final AdjustedMouseEvent event) {
        vertex.update(event.position.x_1 - ix, event.position.y_1 - iy);
    }

}
