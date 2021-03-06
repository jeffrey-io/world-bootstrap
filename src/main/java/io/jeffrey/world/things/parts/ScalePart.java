package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.data.EditBoolean;
import io.jeffrey.world.data.EditDouble;
import io.jeffrey.world.things.behaviors.HasActions;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.SharedActionSpace;

public class ScalePart implements Part, HasActions {
  public final EditBoolean aspect;
  public final EditBoolean lock;
  public final EditDouble  x;
  public final EditDouble  y;

  public ScalePart(final LinkedDataMap data) {
    x = data.getDouble("sx", 1.0);
    y = data.getDouble("sy", 1.0);
    lock = data.getBoolean("slock", false);
    aspect = data.getBoolean("aspect", true);
  }

  @Override
  public void invokeAction(final String action, final SharedActionSpace space) {
    if ("normalize_scale".equals(action)) {
      final double s = (sx() + sy()) / 2.0;
      sx(s);
      sy(s);
    }
  }

  @Override
  public void listActions(final Set<String> actionsAvailable) {
    actionsAvailable.add("normalize_scale");
  }

  /**
   * @return the current scaling of the x axis
   */
  public double sx() {
    return x.value();
  }

  /**
   * @param sx
   *          the new scale of the x axis
   */
  public void sx(final double sx) {
    x.value(Math.min(10000.0, Math.max(0.1, sx)));
  }

  /**
   * @return the current scaling of the y axis
   */
  public double sy() {
    return y.value();
  }

  /**
   * @param sy
   *          the new scale of the y axis
   */
  public void sy(final double sy) {
    y.value(Math.min(10000.0, Math.max(0.1, sy)));
  }

}
