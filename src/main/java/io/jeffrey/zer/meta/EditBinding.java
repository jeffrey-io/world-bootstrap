package io.jeffrey.zer.meta;

import java.io.File;
import java.util.Map;

import io.jeffrey.world.data.Edit;
import io.jeffrey.zer.Notifications;
import io.jeffrey.zer.Syncable;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

/**
 * Handy Dandy Class to bind JavaFx classes to our Edit schema
 *
 * @author jeffrey
 */
public class EditBinding {
  private boolean            building;
  private String             focusOn    = null;
  public final Notifications notifications;
  final Pane                 root;
  private final Syncable     syncable;
  private Node               toSetFocus = null;

  /**
   * @param root
   *          the parent pane to utilize
   * @param syncable
   *          the thing that gets updated when a value changes
   * @param notify
   *          what to tell when things head south
   *
   */
  public EditBinding(final Pane root, final Syncable syncable, final Notifications notify) {
    this.root = root;
    this.syncable = syncable;
    building = false;
    notifications = notify;
  }

  /**
   * bind a checkbox
   *
   * @param checkbox
   *          the checkbox to bind
   * @param value
   *          the value to connect to
   */
  public void bindBoolean(final CheckBox checkbox, final Edit value) {
    try {
      building = true;
      checkbox.setIndeterminate(false);
      checkbox.setSelected(value.getAsText().equals("yes"));
      checkbox.selectedProperty().addListener((ChangeListener<Boolean>) (observed, before, after) -> {
        value.setByText(after ? "yes" : "no");
        syncable.sync();
      });
      bindFocus(value.name(), checkbox);
    } finally {
      building = false;
    }
  }

  /**
   * bind a color picker
   *
   * @param colorPicker
   *          the color picker in question
   * @param value
   *          the value to link to
   */
  public void bindColor(final ColorPicker colorPicker, final Edit value) {
    try {
      building = true;
      Color color = Color.BLACK;
      try {
        color = Color.valueOf(value.getAsText());
      } catch (final Exception failure) {
        notifications.println(failure, "unable to parse color:" + value.getAsText());
      }

      colorPicker.setValue(color);
      colorPicker.valueProperty().addListener((ChangeListener<Color>) (val, before, after) -> {
        value.setByText(after.toString());
        syncable.sync();
      });
      bindFocus(value.name(), colorPicker);
    } finally {
      building = false;
    }
  }

  /**
   * bind a combobox
   *
   * @param selector
   *          the combobox to bind
   * @param value
   *          the value to connect to
   * @param values
   *          all the current values
   * @param parent
   *          the owner that requires update once the value is changed
   * @param <T>
   *          the type of what we are selecting
   */
  public <T extends AbstractMapEditorItemRequirements> void bindComboBox(final ComboBox<T> selector, final Edit value, final Map<String, T> values, final Syncable parent) {
    try {
      building = true;
      final T cr = values.get(value.getAsText());
      if (cr != null) {
        selector.setValue(cr);
      }
      selector.valueProperty().addListener((ChangeListener<T>) (val, before, after) -> {
        if (value.setByText(after.id())) {
          syncable.sync();
          parent.sync();
        }
      });
      selector.getItems().addAll(values.values());
      bindFocus(value.name(), selector);
    } finally {
      building = false;
    }
  }

  /**
   * bind a button to pick a file
   *
   * @param title
   *          the title of the dialog to open
   * @param button
   *          the button to bind
   * @param ref
   *          the visual text field to update
   * @param value
   *          the value to connect to
   * @param normalize
   *          the method to normalize the file to a string
   */
  public void bindFile(final String title, final Button button, final TextField ref, final Edit value, final WorldFileSystem normalize) {
    try {
      building = true;
      button.setOnAction(arg0 -> {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        final File file = fileChooser.showOpenDialog(null);
        final String newUri = normalize.normalize(file);
        ref.setText(newUri);
        value.setByText(newUri);
        syncable.sync();
      });
      bindFocus(value.name(), button);
    } finally {
      building = false;
    }
  }

  /**
   * Helper function to ensure the focus is set appropriately
   *
   * @param name
   *          the name of the node
   * @param node
   *          the node to watch for focus
   */
  private void bindFocus(final String name, final Node node) {
    node.focusedProperty().addListener((ChangeListener<Boolean>) (dontCare, reallyDontCare, after) -> {
      if (after && !building) {
        focusOn = name;
      }
      if (!after) {

      }
    });
    if (name.equals(focusOn)) {
      toSetFocus = node;
    }
  }

  /**
   * bind a text field
   *
   * @param field
   *          the TextField to bind
   * @param value
   *          the value to connect to
   */
  public void bindTextField(final TextField field, final Edit value) {
    try {
      building = true;
      field.setText(value.getAsText());
      final EventHandler<ActionEvent> upload = dc -> {
        if (!value.setByText(field.getText())) {
        } else {
          syncable.sync();
        }
      };
      field.setOnAction(upload);
      field.setOnKeyReleased(arg0 -> upload.handle(null));
      bindFocus(value.name(), field);
    } finally {
      building = false;
    }
  }

  /**
   * attempt to grab the focus if we can
   */
  public void focus() {
    if (toSetFocus != null) {
      toSetFocus.requestFocus();
    } else {
      root.requestFocus();
      toSetFocus = null;
    }
  }

  /**
   * force a sync
   */
  public void forceSync() {
    syncable.sync();
  }

  /**
   * denote that the focus will not be acquired
   */
  public void resetFocus() {
    toSetFocus = null;
    focusOn = null;
  }
}
