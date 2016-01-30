package io.jeffrey.world.ui;

import java.io.File;

import io.jeffrey.world.ui.hierarchy.Hierarchy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Playground extends Application {
  public static void main(final String[] args) {
    System.setProperty("sun.java2d.opengl", "True");
    System.setProperty("sun.java2d.d3d", "True");
    launch(args);
  }
  
  @Override
  public void start(final Stage stage) throws Exception {
    
    String userHomeProperty = System.getProperty("user.home");
    System.out.println(userHomeProperty);
    File userHome = new File(userHomeProperty);
    if (!userHome.exists()) {
      System.err.println("user has no home");
      // optionally, ask for a prompt where to save data
      return;
    }
    
    File workspaceData = new File(userHome, "world-bootstrap");
    if (!workspaceData.exists()) {
      if (!workspaceData.mkdir()) {
        System.err.println("unable to create '" + workspaceData.toString() + "'");
        return;
      }
    }
    
    final VBox left = new VBox();
    final VBox right = new VBox();
    final BorderPane root = new BorderPane();
    final Scene scene = new Scene(root);
    final Text status = new Text("last log message here");

    Hierarchy hierarchy = new Hierarchy();

    left.getChildren().add(new Label("Project Hierarchy"));
    left.getChildren().add(hierarchy.getTree());
    
    root.setLeft(left);
    root.setRight(right);
    root.setTop(menuBar());
    root.setBottom(status);
    stage.setTitle("Title");
    stage.setMaximized(true);
    stage.setScene(scene);
    stage.show();
  }
  
  public VBox menuBar() {
    final VBox top = new VBox();
    final MenuBar menuBar = new MenuBar();
    final Menu top_file = new Menu("File");
    menuBar.getMenus().addAll(top_file);
    final MenuItem _open = new MenuItem("Open Project...");
    final MenuItem _close = new MenuItem("Close");
    top_file.getItems().addAll(_open, _close);
    top.getChildren().add(menuBar);
    return top;
  }
}
