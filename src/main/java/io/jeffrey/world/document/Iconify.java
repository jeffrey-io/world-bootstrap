package io.jeffrey.world.document;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import io.jeffrey.world.WorldData;
import io.jeffrey.zer.Editable;
import io.jeffrey.zer.IconResolver;
import io.jeffrey.zer.SurfaceContext;
import io.jeffrey.zer.SurfaceData.SurfaceAction;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Iconify implements IconResolver {
  private final Canvas             canvas;
  private final WorldData          coreData;
  private final Map<String, Image> icons;

  public Iconify(final WorldData coreData) {
    icons = new HashMap<String, Image>();

    canvas = new Canvas();
    canvas.setWidth(96);
    canvas.setHeight(96);

    this.coreData = coreData;

    icons.put("Image", new Image(ClassLoader.getSystemResourceAsStream("add_image.png")));
  }

  @Override
  public Image get(final IconType type, final String addable) {
    if (icons.containsKey(addable)) {
      return icons.get(addable);
    }
    try {
      register(addable);
    } catch (final Exception err) {

    }
    return icons.get(addable);
  }

  public void register(final String addable) throws Exception {
    final WorldData temp = new WorldData();
    final SurfaceContext context = new SurfaceContext(temp.document.camera);
    final GraphicsContext ctx = canvas.getGraphicsContext2D();
    ctx.setFill(Color.TRANSPARENT);
    ctx.clearRect(0, 0, 96, 96);
    context.width = 96;
    context.height = 96;
    temp.document.templates.putAll(coreData.document.templates);

    temp.add(addable, context);
    temp.execute(SurfaceAction.ZoomAll, context);
    for (final Editable ed : temp.getEditables()) {
      ed.invoke("unselect");
      ed.invoke("lock");
    }
    temp.draw(ctx, context);

    final SnapshotParameters sp = new SnapshotParameters();
    sp.setFill(Color.TRANSPARENT);
    final WritableImage wi = new WritableImage(96, 96);
    final File file = File.createTempFile("bootstrap-icons-", ".png");

    System.out.println(file.toString());

    ImageIO.write(SwingFXUtils.fromFXImage(canvas.snapshot(sp, wi), null), "png", file);

    icons.put(addable, new Image(file.toURI().toASCIIString()));
  }
}
