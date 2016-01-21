package io.jeffrey.world.things.core;

import java.util.HashMap;

/**
 * This is a shared object available for actions to coordinate
 *
 * @author jeffrey
 */
public class SharedActionSpace {
  private final HashMap<String, Object> pluginResults = null;

  public Object getPluginResults() {
    return pluginResults;
  }
}
