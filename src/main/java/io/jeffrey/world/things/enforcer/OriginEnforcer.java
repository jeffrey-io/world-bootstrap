package io.jeffrey.world.things.enforcer;

import io.jeffrey.vector.VectorRegister5;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.document.GuideLine;
import io.jeffrey.world.things.core.GuideLineEnforcer;
import io.jeffrey.world.things.core.Thing;

public class OriginEnforcer implements GuideLineEnforcer {

    private final Thing target;

    public OriginEnforcer(Thing target) {
        this.target = target;
    }

    @Override
    public void attemptSnapTo(final GuideLine line) {
        VectorRegister5 reg = new VectorRegister5();

        reg.set_0(line.line.x_0, line.line.y_0);
        reg.set_1(line.line.x_1, line.line.y_1);
        reg.set_2(target.x(), target.y());
        double d = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(reg);
        if (d < 0)
            return;
        if (d < line.distance) {
            target.x(reg.x_0);
            target.y(reg.y_0);
        }
    }
}
