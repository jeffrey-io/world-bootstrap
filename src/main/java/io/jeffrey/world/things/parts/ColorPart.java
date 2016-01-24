package io.jeffrey.world.things.parts;

import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;
import javafx.scene.paint.Color;

public class ColorPart implements Part {
  public final EditString  color;
  public final EditBoolean enabled;
  public final EditBoolean lock;

  private Color            cached;

  public ColorPart(final String prefix, final String initial, final LinkedDataMap data) {
    color = data.getString(prefix + "_color", initial);
    lock = data.getBoolean(prefix + "_lock", false);
    enabled = data.getBoolean(prefix + "_enabled", true);

    color.subscribe((from, to) -> {
      refresh();
    });

    refresh();
  }

  private void refresh() {
    try {
      cached = Color.valueOf(color.value());
    } catch (Exception err) {
    }
  }

  public Color getCachedColor() {
    return cached;
  }
}
