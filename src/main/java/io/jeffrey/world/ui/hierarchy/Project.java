package io.jeffrey.world.ui.hierarchy;

import java.io.File;

public class Project extends AbstractItem {

  public final File   directory;
  public final String name;

  public Project(File directory, String name) {
    this.directory = directory;
    this.name = name;
  }

  @Override
  public void open() {
    // nothing special
  }

  @Override
  public String label() {
    return name;
  }

}
