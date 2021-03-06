package io.jeffrey.world.things.core.guides;

import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.vector.math.Lines;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.MouseInteraction;
import io.jeffrey.zer.meta.GuideLine;

public class Picker {
  private final double[]    boundary;

  private final PickState[] guideSelectBuffer;
  final VectorRegister6     seg;

  public Picker(final double left, final double right, final double top, final double bottom) {
    boundary = new double[] { left, top, right, top, right, bottom, left, bottom, left, top };
    guideSelectBuffer = new PickState[5];
    seg = new VectorRegister6();
    for (int k = 0; k < guideSelectBuffer.length; k++) {
      guideSelectBuffer[k] = new PickState();
    }
  }

  public MouseInteraction select(final GuideLine line, final Camera camera, final double x, final double y, final double radius) {
    int writeAt = 0;
    boolean found = false;
    for (int c = 0; c + 3 < boundary.length; c += 2) {
      line.writeSegment(camera, seg);
      seg.set_2(boundary[c], boundary[c + 1]);
      seg.set_3(boundary[c + 2], boundary[c + 3]);
      if (Lines.doLinesIntersect_Destructively(seg, true, true)) {
        guideSelectBuffer[writeAt].x = seg.x_0;
        guideSelectBuffer[writeAt].y = seg.y_0;
        seg.set_1(x, y);
        seg.sub_0_from_1();
        guideSelectBuffer[writeAt].selected = seg.length_1() <= radius / camera.scale;
        found = found || guideSelectBuffer[writeAt].selected;
        writeAt++;
      }
    }

    if (found) {
      for (final PickState state : guideSelectBuffer) {
        if (!state.selected) {
          return new Updator(line, state.x, state.y);
        }
      }
    }

    return null;
  }
}
