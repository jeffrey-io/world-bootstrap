package io.jeffrey.world;

import io.jeffrey.zer.ZERStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Bootstrap extends Application {

    public static void main(final String[] args) {
        System.setProperty("sun.java2d.opengl", "True");
        System.setProperty("sun.java2d.d3d", "True");
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        new ZERStage(new WorldData(), stage);
    }

}
