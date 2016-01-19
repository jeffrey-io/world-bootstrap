package io.jeffrey.world.things.parts;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import io.jeffrey.world.things.base.ControlDoodad;
import io.jeffrey.world.things.base.LinkedDataMap;
import io.jeffrey.world.things.base.Subscribers;
import io.jeffrey.world.things.base.Part;
import io.jeffrey.world.things.base.SharedActionSpace;
import io.jeffrey.world.things.base.ControlDoodad.Type;
import io.jeffrey.world.things.behaviors.CanCacheSelection;
import io.jeffrey.world.things.behaviors.HasControlDoodadsInThingSpace;
import io.jeffrey.world.things.polygon.SelectablePoint2;
import io.jeffrey.zer.edits.EditBoolean;
import io.jeffrey.zer.edits.EditString;
import javafx.scene.transform.Scale;

public abstract class PointSetPart implements Part, HasControlDoodadsInThingSpace, CanCacheSelection {

  public final EditBoolean lock;
  public final EditString vertices;
  
  private final ScalePart scale;
  private final RotationPart rotation;
  
  private ControlDoodad[] doodads = new ControlDoodad[0];
  private Subscribers<SharedMutableCache> notification;
  
  public class SharedMutableCache {
    public PointSetPart owner;
    public double   boundingRadiusForControls;
    public double[] inlineXYPairs;
    public double[] x;
    public double[] y;
    
    public SharedMutableCache() {
      this.boundingRadiusForControls = 0;
      this.inlineXYPairs = new double[0];
      this.x = new double[0];
      this.y = new double[0];
    }
  }

  private final SharedMutableCache cache;
  
  public boolean outOfDate = false;
  
  public PointSetPart(final LinkedDataMap data, final ScalePart scale, final RotationPart rotation) {
    this.lock = data.getBoolean("vlock", false);
    this.scale = scale;
    this.rotation = rotation;
    this.cache = new SharedMutableCache();
    
    lock.subscribe(new BiConsumer<String, String>() {
      @Override
      public void accept(String t, String u) {
        PointSetPart.this.dirty();
      }
    });
    outOfDate = true;
    this.notification = new Subscribers<>();
    
    vertices = data.getString("points", "0,-1,1,1,-1,1");
    update();
  }

  
  @Override
  public void act(String action, SharedActionSpace space) {
  }

  @Override
  public void list(Set<String> actionsAvailable) {
  }
  
  public void subscribe(Consumer<SharedMutableCache> subscriber) {
    subscriber.accept(cache);
    notification.subscribe(subscriber);
  }

  public abstract SelectablePoint2 at(int k);
  
  public abstract int getNumberOfPoints();
  
  public boolean hasStandardControls() {
    return true;
  }
  
  private void ensureCapacityIsCorrect(final int n, final int ds) {
    if (cache.x.length != n) {
      cache.inlineXYPairs = new double[n * 2];
      cache.x = new double[n];
      cache.y = new double[n];
    }
    if (doodads.length != ds) {
      doodads = new ControlDoodad[ds];
      for (int k = 0; k < doodads.length; k++) {
        doodads[k] = new ControlDoodad(Type.PointUnselected, 0, 0);
      }
    }
  }
  
  public void dirty() {
    outOfDate = true; 
  }
  
  public void invalidateNow() {
    dirty();
    update();
  }
  
  @Override
  public void update() {
    if (!outOfDate) {
      return;
    }
    final int n = getNumberOfPoints();
    final boolean canScale = scale.lock.value();
    final boolean canRotate = rotation.lock.value();
    final int doff = lock.value() ? 0 : n;
    final int ds = doff + (canScale ? 4 : 0) + (canRotate ? 4 : 0);
    ensureCapacityIsCorrect(n, ds);
    if (n == 0) {
      return;
    }
    int k;
    
    // walk the points
    cache.boundingRadiusForControls = 0;
    for (k = 0; k < n; k++) {
      final SelectablePoint2 p = at(k);
      cache.inlineXYPairs[2 * k] = p.x;
      cache.inlineXYPairs[2 * k + 1] = p.y;
      cache.x[k] = p.x;
      cache.y[k] = p.y;
      cache.boundingRadiusForControls = Math.max(cache.boundingRadiusForControls, p.x * p.x + p.y * p.y);
      if (!lock.value()) {
        doodads[k].u = p.x;
        doodads[k].v = p.y;
        doodads[k].type = p.selected ? Type.PointSelected : Type.PointUnselected;
      }
    }

    final double PI = 3.1415926535897932384626433832795;
    final double[] ANGLES = new double[] { PI / 4, 3 * PI / 4, -PI / 4, -3 * PI / 4, 0, PI / 2, PI, -PI / 2 };

    if (canScale || canRotate) {
      final double scale_norm = scale.sx() + scale.sy();
      final double aug = 32 / scale_norm;
      cache.boundingRadiusForControls = Math.sqrt(cache.boundingRadiusForControls) + aug;
      int j;
      if (canScale) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Scale;
          doodads[k].u = Math.cos(ANGLES[j]) * cache.boundingRadiusForControls;
          doodads[k].v = Math.sin(ANGLES[j]) * cache.boundingRadiusForControls;
          k++;
        }
      }
      if (canRotate) {
        for (j = 0; j < 4; j++) {
          doodads[k].type = Type.Scale;
          doodads[k].u = Math.cos(ANGLES[j + 4]) * cache.boundingRadiusForControls;
          doodads[k].v = Math.sin(ANGLES[j + 4]) * cache.boundingRadiusForControls;
          k++;
        }
      }      
    }
    
    cache.owner = this;
    notification.publish(cache);
  }


  @Override
  public ControlDoodad[] getDoodadsInThingSpace() {
    return doodads;
  }
  
  @Override
  public void cache() {
    for (int k = 0; k < getNumberOfPoints(); k++) {
      SelectablePoint2 p = at(k);
      p.alreadySelected = p.selected; 
    }
  }
}
