package io.jeffrey.world;

import io.jeffrey.zer.SurfaceContext;

import java.io.File;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Iconify extends Application {

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage stage) throws Exception {
		System.out.println("Making an icon");

		Canvas canvas = new Canvas();
		canvas.setWidth(96);
		canvas.setHeight(96);

		WorldData data = new WorldData();
		SurfaceContext context = new SurfaceContext(data.document.camera);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		context.width = 96;
		context.height = 96;

		data.add("Circle", context);
		data.draw(ctx, context);

		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		WritableImage wi = new WritableImage(96, 96);
		File file = File.createTempFile("bootstrap-icons-", ".png");

		System.out.println(file.toString());

		ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(sp, wi), null),
				"png", file);
		System.out.println("X");
		stage.close();
		Runtime.getRuntime().exit(1);
	}
}
