package io.jeffrey.world;

import io.jeffrey.zer.Editable;
import io.jeffrey.zer.IconResolver;
import io.jeffrey.zer.SurfaceContext;
import io.jeffrey.zer.SurfaceData.SurfaceAction;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Iconify implements IconResolver {
	private final Map<String, Image> icons;
	private final Canvas canvas;
	private final WorldData coreData;

	public Iconify(WorldData coreData) {
		this.icons = new HashMap<String, Image>();

		canvas = new Canvas();
		canvas.setWidth(96);
		canvas.setHeight(96);

		this.coreData = coreData;
		
		icons.put("Image", new Image(
				ClassLoader.getSystemResourceAsStream("add_image.png")));
	}

	@Override
	public Image get(IconType type, String addable) {
		if (icons.containsKey(addable)) {
			return icons.get(addable);
		}
		try {
			register(addable);
		} catch (Exception err) {

		}
		return icons.get(addable);
	}

	public void register(String addable) throws Exception {
		WorldData temp = new WorldData();
		SurfaceContext context = new SurfaceContext(temp.document.camera);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setFill(Color.TRANSPARENT);
		ctx.clearRect(0, 0, 96, 96);
		context.width = 96;
		context.height = 96;
		temp.document.templates.putAll(coreData.document.templates);

		temp.add(addable, context);
		temp.execute(SurfaceAction.ZoomAll, context);
		for (Editable ed : temp.getEditables()) {
			ed.invoke("unselect");
			ed.invoke("lock");
		}
		temp.draw(ctx, context);

		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		WritableImage wi = new WritableImage(96, 96);
		File file = File.createTempFile("bootstrap-icons-", ".png");

		System.out.println(file.toString());

		ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(sp, wi), null),
				"png", file);

		icons.put(addable, new Image(file.toURI().toASCIIString()));
	}
}
