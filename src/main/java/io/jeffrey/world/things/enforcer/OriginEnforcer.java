package io.jeffrey.world.things.enforcer;

import io.jeffrey.vector.VectorRegister5;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.core.Thing;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

public class OriginEnforcer implements GuideLineEnforcer {

    private final Thing target;

    public OriginEnforcer(final Thing target) {
        this.target = target;
    }

    @Override
    public void attemptSnapTo(final Camera camera, final GuideLine line) {
        final VectorRegister5 reg = new VectorRegister5();

        line.writeSegment(camera, reg);
        reg.set_2(target.x(), target.y());
        final double d = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        if (d < 0) {
            return;
        }
        if (d < line.distance.value()) {
            target.x(reg.x_0);
            target.y(reg.y_0);
        }
    }
}
