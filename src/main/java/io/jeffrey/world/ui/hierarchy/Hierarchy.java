package io.jeffrey.world.ui.hierarchy;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

public class Hierarchy {

  private final TreeView<AbstractItem> tree;
  private final TreeItem<AbstractItem> root;

  public Hierarchy() {
    tree = new TreeView<AbstractItem>();
    root = new TreeItem<AbstractItem>();
    root.setValue(new Workspace());
    tree.setRoot(root);
    tree.showRootProperty().set(false);
    tree.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        if (event.getClickCount() == 2) {
          for (TreeItem<AbstractItem> selected : tree.getSelectionModel().getSelectedItems()) {
            selected.getValue().open();
          }
        }
      }
    });
  }

  public TreeView<AbstractItem> getTree() {
    return tree;
  }

  public void mountProject(File directory, String name) {
    TreeItem<AbstractItem> project = new TreeItem<>();
    project.setValue(new Project(directory, name));
    root.getChildren().add(project);
    TreeItem<AbstractItem> assets = new TreeItem<>();
    assets.setValue(new Path("assets", "Assets"));
    TreeItem<AbstractItem> worlds = new TreeItem<>();
    worlds.setValue(new Path("worlds", "Worlds"));
    project.getChildren().add(assets);
    project.getChildren().add(worlds);
  }
}
