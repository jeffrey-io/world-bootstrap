package io.jeffrey.world.things.base;

import io.jeffrey.vector.VectorRegister3;
import javafx.scene.canvas.GraphicsContext;

/**
 * Controls how things are mapped from thing to space to world space
 *
 * @author jeffrey
 */
public interface Transform {

  /**
   * is the doodadType supported by this transformation
   *
   * @param doodadType
   *          the type of doodad
   * @return true if allowed, false otherwise
   */
  public boolean allowed(ControlDoodad.Type doodadType);

  /**
   * @param gc
   *          the graphics context to update
   */
  public void readyGraphicsContext(GraphicsContext gc);

  /**
   * convert the given (_x,_y) at vector 0 in world space into target space and write to vector 1 (vector 2 is used as scratch space)
   *
   * @param _x
   *          the x coordinate in thing/target space
   * @param _y
   *          the y coordinate in thing/target space
   * @return a vector representing the point in world space
   */
  public void writeToThingSpace(final VectorRegister3 reg);

  /**
   * convert the given (_x,_y) at vector 0 in thing/target space into world space and write to vector 1 (vector 2 is used as scratch space)
   *
   * @param _x
   *          the x coordinate in thing/target space
   * @param _y
   *          the y coordinate in thing/target space
   * @return a vector representing the point in world space
   */
  public void writeToWorldSpace(final VectorRegister3 reg);
}
