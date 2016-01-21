package io.jeffrey.zer;

import java.io.File;
import java.util.HashMap;

import javafx.scene.image.Image;

/**
 * An image cache to ensure we are able to use a ton of distinct images
 *
 * @author jeffrey
 */
public class ImageCache {
  /**
   * The actual cache
   */
  private final HashMap<String, Image> images;
  public final Image                   ROTATE_ICON;
  public final Image                   SCALE_ICON;
  public final Image                   VERTEX_ICON;

  public final Image                   VERTEX_ICON_SELECTED;

  /**
   * construct the image cache
   */
  public ImageCache() {
    images = new HashMap<>();
    SCALE_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_scale.png"));
    ROTATE_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_rotate.png"));
    VERTEX_ICON = new Image(ClassLoader.getSystemResourceAsStream("icon_vertex.png"));
    VERTEX_ICON_SELECTED = new Image(ClassLoader.getSystemResourceAsStream("icon_vertex_selected.png"));
  }

  /**
   * @return true if the image cache is fully loaded
   */
  public synchronized boolean done() {
    for (final Image img : images.values()) {
      if (img.isBackgroundLoading()) {
        return false;
      }
    }
    return true;
  }

  /**
   * get the image for the given uri
   *
   * @param uri
   *          the uri for the image
   * @return an image
   */
  public synchronized Image of(final File file) {
    final String uri = file.toURI().toString();
    Image img = images.get(uri);
    if (img == null) {
      img = new Image(uri);
      images.put(uri, img);
    }
    return img;
  }

  /**
   * indicate that the given uri should be preloaded
   *
   * @param uri
   *          the uri for the image to preload
   */
  public synchronized void preload(final String uri) {
    images.put(uri, new Image(uri, true));
  }

  /**
   * @return a percentage of how much of the cache is loaded
   */
  public synchronized double progress() {
    double n = 1;
    double d = 1;
    for (final Image img : images.values()) {
      d++;
      if (!img.isBackgroundLoading()) {
        n++;
      }
    }
    return n / d;
  }
}
