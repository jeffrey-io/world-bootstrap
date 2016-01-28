package io.jeffrey.world.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import io.jeffrey.world.data.Edit;
import io.jeffrey.world.things.core.AbstractThing;
import io.jeffrey.world.things.core__old_defunct.ThingEditor;
import io.jeffrey.world.things.parts.MetadataPart;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;

public class EditableThing implements Editable {

  private final Document      document;
  private final AbstractThing thing;

  public EditableThing(final Document document, final AbstractThing thing) {
    this.document = document;
    this.thing = thing;
  }

  @Override
  public void createEditor(final SurfaceData data, final SurfaceItemEditorBuilder builder, final Syncable parent) {
    ThingEditor.buildUserInterface(document, data, this, builder, parent);
  }

  @Override
  public List<String> getActions() {
    final ArrayList<String> actions = new ArrayList<>();
    actions.addAll(thing.getActionsAvailable());
    return actions;
  }

  @Override
  public Map<String, Edit> getLinks(final boolean withHistory) {
    return thing.getLinks(withHistory);
  }

  @Override
  public String id() {
    return thing.getID();
  }

  @Override
  public Object invoke(final String action) {
    if ("?".equals(action)) {
      return getActions();
    }
    if ("templatize".equals(action)) {
      final HashMap<String, String> template = new HashMap<String, String>();
      for (final Entry<String, Edit> link : getLinks(false).entrySet()) {
        template.put(link.getKey(), link.getValue().getAsText());
      }
      document.templates.put(thing.getName(), template);
      return true;
    }
    return thing.invokeAction(action, true).getPluginResults();
  }

  @Override
  public Edit metadataOf(final String key, final String defaultValue) {
    final MetadataPart metadata = thing.first(MetadataPart.class);
    if (metadata != null) {
      metadata.metadataOf(key, defaultValue);
    }
    return null; // Maybe, we need a NoOp metadata?
  }

}
