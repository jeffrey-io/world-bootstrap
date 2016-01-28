package io.jeffrey.world.things.parts;

import io.jeffrey.world.data.EditBoolean;
import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import javafx.scene.paint.Color;

public class ColorPart implements Part {
  private Color            cached;
  public final EditString  color;
  public final EditBoolean enabled;

  public final EditBoolean lock;

  public ColorPart(final String prefix, final String initial, final LinkedDataMap data) {
    color = data.getString(prefix + "_color", initial);
    lock = data.getBoolean(prefix + "_lock", false);
    enabled = data.getBoolean(prefix + "_enabled", true);

    color.subscribe((from, to) -> {
      refresh();
    });

    refresh();
  }

  public Color getCachedColor() {
    return cached;
  }

  private void refresh() {
    try {
      cached = Color.valueOf(color.value());
    } catch (final Exception err) {
    }
  }
}
