package io.jeffrey.world.things.core__old_defunct;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import io.jeffrey.world.document.Document;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.SurfaceData;
import io.jeffrey.zer.Syncable;
import io.jeffrey.zer.edits.AbstractEditList;
import io.jeffrey.zer.edits.Edit;
import io.jeffrey.zer.meta.LayerPropertiesEditor;
import io.jeffrey.zer.meta.MetaClass;
import io.jeffrey.zer.meta.MetaClassEditor;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder;
import io.jeffrey.zer.meta.SurfaceItemEditorBuilder.SurfaceFourColumnGrid;

/**
 * Defines how the editor for things is built
 *
 * @author jeffrey
 *
 */
public class ThingEditor {
  private static final String[] booleans = new String[] { "vlock", "slock", "alock", "aspect", "locked", "deleted", "selected", "urilock", "lockmeta", "nometa", "lockcolor", "layerlock" };

  /**
   * build the user interface to the side editor
   */
  public static void buildUserInterface(final Document document, final SurfaceData data, final Editable editable, final SurfaceItemEditorBuilder builder, final Syncable parent) {
    final Map<String, Edit> fields = editable.getLinks(true);

    if (containAll(fields, "name")) {
      builder.startBorder("Identification");
      final SurfaceFourColumnGrid pg = builder.startFourColumnGrid();
      pg.add("ID", editable.id());
      pg.add("Name", fields.get("name"));
      builder.endBorder();
    }

    if (containAll(fields, "script")) {
      builder.startBorder("Script");
      final SurfaceFourColumnGrid pg = builder.startFourColumnGrid();
      pg.add("script", fields.get("script"));
      builder.endBorder();
    }

    if (containAll(fields, "x", "y", "sx", "sy", "angle")) {
      builder.startBorder("Geometry");
      final SurfaceFourColumnGrid pg = builder.startFourColumnGrid();
      if (fields.containsKey("x") && fields.containsKey("y")) {
        pg.add("X", fields.get("x"), "Y", fields.get("y"));
      }
      if (isNotLocked(fields, "slock") && fields.containsKey("sx") && fields.containsKey("sy")) {
        pg.add("Scale X", fields.get("sx"), "Scale Y", fields.get("sy"));
      }
      if (isNotLocked(fields, "alock") && fields.containsKey("angle")) {
        pg.add("Angle", fields.get("angle"));
      }
      builder.endBorder();
    }

    if (containAll(fields, "layer", "order")) {
      builder.startBorder("Layer");
      if (isNotLocked(fields, "layerlock")) {
        builder.addCombo(true, "Layer", fields.get("layer"), data.getLayers(), LayerPropertiesEditor.class, parent);
      }
      final SurfaceFourColumnGrid al = builder.startFourColumnGrid();
      al.add("Order", fields.get("order"));
      builder.endBorder();
    }

    if (containAll(fields, "fill_color") && isNotLocked(fields, "fill_lock")) {
      builder.startBorder("Color");
      builder.addColor("Color", fields.get("fill_color"));
      builder.endBorder();
    }

    if (isNotLocked(fields, "urilock")) {
      if (containAll(fields, "uri")) {
        builder.startBorder("Image Properties");
        builder.addFile("Choose Image", "URI", fields.get("uri"), document);
        builder.endBorder();
      }
    }

    if (isNotLocked(fields, "locklock")) {
      builder.startBorder("Properties");
      for (final String boolName : booleans) {
        final Edit boolEdit = fields.get(boolName);
        if (boolEdit != null) {
          builder.addBoolean(boolEdit.name(), new Edit() {

            @Override
            public String getAsText() {
              return boolEdit.getAsText();
            }

            @Override
            public String name() {
              return boolEdit.name();
            }

            @Override
            protected boolean setByText(final String txt) {
              final String old = boolEdit.getAsText();
              final boolean result = boolEdit.set(txt);
              if (!old.equals(txt)) {
                parent.sync();
              }
              return result;
            }
          });
        }
      }
      builder.endBorder();
    }

    if (fields.containsKey("from") && fields.containsKey("to")) {
      builder.startBorder("Connectivity");
      final SurfaceFourColumnGrid pg = builder.startFourColumnGrid();
      pg.add("From", fields.get("from"), "To", fields.get("to"));
      builder.endBorder();
    }

    if (isNotLocked(fields, "vlock")) {
      if (fields.containsKey("points")) {
        builder.startBorder("Vertices");
        final Edit ed = fields.get("points");
        final SurfaceFourColumnGrid al = builder.startFourColumnGrid();
        if (ed instanceof AbstractEditList) {
          // BUG: https://github.com/jeffrey-io/world-bootstrap/issues/1
          final ArrayList<Edit> coords = ((AbstractEditList) ed).edits;
          for (int k = 0; k + 1 < coords.size(); k += 2) {
            final Edit _X = coords.get(k);
            final Edit _Y = coords.get(k + 1);
            al.add("X" + _X.name(), _X, "Y" + _Y.name(), _Y);
          }
        }
        builder.endBorder();
      }
    }

    if (isNotLocked(fields, "nometa")) {
      if (fields.containsKey("metaclass")) {
        builder.startBorder("Meta Data");
        if (isNotLocked(fields, "lockmeta")) {
          builder.addCombo(true, "Meta Class", fields.get("metaclass"), data.getMetaClasses(), MetaClassEditor.class, parent);
        }
        final MetaClass cls = data.getMetaClasses().get(fields.get("metaclass").getAsText());
        if (cls != null) {
          final SurfaceFourColumnGrid al = builder.startFourColumnGrid();
          for (final Entry<String, String> field : cls.fields.entrySet()) {
            Edit edit = editable.metadataOf(field.getKey(), field.getValue());
            if (edit != null) {
              al.add(field.getKey(), edit);
            }
          }
        }
        builder.endBorder();
      }
    }
  }

  /**
   * Do the given fields contain all the fields that we need to exist
   */
  private static boolean containAll(final Map<String, Edit> fields, final String... fieldsThatMustExist) {
    for (final String field : fieldsThatMustExist) {
      if (!fields.containsKey(field)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isNotLocked(final Map<String, Edit> fields, final String name) {
    final Edit f = fields.get(name);
    if (f == null) {
      return true;
    }
    final String v = f.getAsText();
    if ("yes".equals(v)) {
      return false;
    }
    return true;
  }
}
