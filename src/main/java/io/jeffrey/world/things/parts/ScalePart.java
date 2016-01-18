package io.jeffrey.world.things.parts;

import java.util.Set;

import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditDouble;

public class ScalePart implements Part {
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
  public void act(String action, SharedActionSpace space) {
    if ("normalize.scale".equals(action)) {
      final double s = (sx() + sy()) / 2.0;
      sx(s);
      sy(s);
    }
  }

  @Override
  public boolean unique() {
    return true;
  }

  @Override
  public void update() {
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

  @Override
  public void list(Set<String> actionsAvailable) {
    actionsAvailable.add("normalize.scale");
  }

}
