package io.jeffrey.world.things.core;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import io.jeffrey.world.document.Document;
import io.jeffrey.world.document.history.History;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.ImageCache;
import io.jeffrey.zer.meta.GuideLine;
import io.jeffrey.zer.meta.LayerProperties;
import javafx.scene.image.Image;

public class Container {
  public final Camera                       camera;
  public final int                          controlPointSize;

  private final Document                    document;
  public final int                          edgeWidthSize;
  public final History                      history;
  public final ImageCache                   imageCache;
  public final Map<String, LayerProperties> layers;
  public final Image                        ROTATE_ICON;
  public final Image                        SCALE_ICON;
  public final Image                        VERTEX_ICON;

  public final Image                        VERTEX_ICON_SELECTED;

  public Container(final Document document) {
    this.document = document;
    camera = document.camera;
    history = document.history;
    imageCache = document.imageCache;
    ROTATE_ICON = document.ROTATE_ICON;
    SCALE_ICON = document.SCALE_ICON;
    VERTEX_ICON = document.VERTEX_ICON;
    VERTEX_ICON_SELECTED = document.VERTEX_ICON_SELECTED;
    controlPointSize = document.controlPointSize;
    edgeWidthSize = document.edgeWidthSize;
    layers = document.layers;
  }

  public File find(final String path) {
    return document.find(path);
  }

  public Collection<GuideLine> getGuideLines(final String layerId) {
    return document.getGuideLines(layerId);
  }

  public int size() {
    return document.getThings().size();
  }
}
