package io.jeffrey.world.things.enforcer;

import io.jeffrey.vector.VectorRegister5;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.world.things.behaviors.HasEdgesInWorldSpace;
import io.jeffrey.world.things.core.guides.GuideLineEnforcer;
import io.jeffrey.world.things.parts.PositionPart;
import io.jeffrey.world.things.parts.RotationPart;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.meta.GuideLine;

public class EdgeEnforcer implements GuideLineEnforcer {
  private static final double        RADIANS_TO_DEGREES = 57.295779578552298943021782279762;

  private final HasEdgesInWorldSpace thingWithEdges;
  private final PositionPart         position;
  private final RotationPart         rotation;

  public EdgeEnforcer(final HasEdgesInWorldSpace thingWithEdges, final PositionPart position, final RotationPart rotation) {
    this.thingWithEdges = thingWithEdges;
    this.position = position;
    this.rotation = rotation;
  }

  @Override
  public void attemptSnapTo(final Camera camera, final GuideLine line) {
    double A = -line.b.value();
    double B = line.a.value();
    final double AB = Math.sqrt(A * A + B * B);
    A /= AB;
    B /= AB;
    double angleToApply = 360;
    double[] edges = thingWithEdges.worldSpaceEdges();
    int at = -1;
    final VectorRegister5 temp = new VectorRegister5();
    for (int k = 0; k + 3 < edges.length; k += 4) {
      line.writeSegment(camera, temp);
      temp.set_2(edges[k], edges[k + 1]);
      double d = Lines.minimalDistanceV2toLineContainingV0V1_Destructive(temp);
      line.writeSegment(camera, temp);
      temp.set_2(edges[k + 2], edges[k + 3]);
      d += Lines.minimalDistanceV2toLineContainingV0V1_Destructive(temp);
      d /= 2;
      if (d < line.distance.value()) {
        final double dx = edges[k + 2] - edges[k];
        final double dy = edges[k + 3] - edges[k + 1];
        double top = -(dx * A + dy * B);
        double bottom = dx * B - dy * A;
        double mA = RADIANS_TO_DEGREES * Math.atan2(bottom, top);
        if (Math.abs(mA) < Math.abs(angleToApply)) {
          angleToApply = mA;
          at = k;
        }
        top = dx * A + dy * B;
        bottom = -(dx * B - dy * A);
        mA = RADIANS_TO_DEGREES * Math.atan2(bottom, top);
        if (Math.abs(mA) < Math.abs(angleToApply)) {
          angleToApply = mA;
          at = k;
        }
      }
    }
    if (Math.abs(angleToApply) < 30 && at >= 0) {
      double nextAngle = rotation.angle() + angleToApply;
      nextAngle = Math.round(nextAngle * 100) / 100.0;
      rotation.angle(nextAngle);
      edges = thingWithEdges.worldSpaceEdges();
      line.writeSegment(camera, temp);
      temp.set_2(edges[at], edges[at + 1]);
      Lines.minimalDistanceV2toLineContainingV0V1_Destructive(temp);
      position.x(position.x() - (edges[at] - temp.x_0));
      position.y(position.y() - (edges[at + 1] - temp.y_0));
    }
  }
}
