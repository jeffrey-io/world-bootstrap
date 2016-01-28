package io.jeffrey.world.benchmark;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import io.jeffrey.world.data.ObjectDataMap;
import io.jeffrey.world.things.TCircle;
import io.jeffrey.world.things.TPolygon;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.ContainerQueryEngine;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.zer.Camera;
import io.jeffrey.zer.SelectionWindow;
import io.jeffrey.zer.SelectionWindow.Mode;
import io.jeffrey.zer.meta.WorldFileSystem;

public class Benchmark {
  private static abstract class BenchmarkTask {

    protected Container createContainer() {
      return new Container(new Camera(), new WorldFileSystem() {
        @Override
        public File find(final String path) {
          throw new IllegalStateException();
        }

        @Override
        public String normalize(final File input) {
          throw new IllegalStateException();
        }
      });
    }

    public LinkedDataMap data(final String... keysAndValues) {
      final HashMap<String, String> map = new HashMap<>();
      for (int k = 0; k + 1 < keysAndValues.length; k += 2) {
        map.put(keysAndValues[k], keysAndValues[k + 1]);
      }
      return new LinkedDataMap(new ObjectDataMap(map));
    }

    public abstract Runnable setup();
  }

  public static void main(final String[] args) {
    final Benchmark benchmark = new Benchmark();
    benchmark.register("select-1000-sparse-circles-by-window", new BenchmarkTask() {

      @Override
      public Runnable setup() {
        final Container container = createContainer();
        for (int k = 0; k < 1000; k++) {
          container.add(new TCircle(container, data("x", Double.toString(k * 100))));
        }
        final ContainerQueryEngine engine = new ContainerQueryEngine(container);
        final SelectionWindow window = new SelectionWindow();
        window.start(-1, -1);
        window.update(1, 1, Mode.Set);
        return () -> {
          for (int k = 0; k < 1000; k++) {
            engine.updateSelectionWindow(window);
          }
        };
      }
    });

    benchmark.register("select-1000-sparse-triangles-by-window", new BenchmarkTask() {
      @Override
      public Runnable setup() {
        final Container container = createContainer();
        for (int k = 0; k < 1000; k++) {
          container.add(new TPolygon(container, data("x", Double.toString(k * 100))));
        }
        final ContainerQueryEngine engine = new ContainerQueryEngine(container);
        final SelectionWindow window = new SelectionWindow();
        window.start(-1, -1);
        window.update(1, 1, Mode.Set);
        return () -> {
          for (int k = 0; k < 1000; k++) {
            engine.updateSelectionWindow(window);
          }
        };
      }
    });
    benchmark.runAndReport();
  }

  private final TreeMap<String, BenchmarkTask> tasks;

  public Benchmark() {
    tasks = new TreeMap<>();
  }

  private void register(final String name, final BenchmarkTask task) {
    tasks.put(name, task);
  }

  public void runAndReport() {
    System.out.println("trial,benchmark,time_ms");
    for (int trial = 0; trial < 3; trial++) {
      for (final Entry<String, BenchmarkTask> entry : tasks.entrySet()) {
        final Runnable task = entry.getValue().setup();
        final long started = System.nanoTime();
        task.run();
        final long time = System.nanoTime() - started;
        final double ms = time / 1000000.0;
        System.out.println(trial + "," + entry.getKey() + "," + ms);
      }
    }
  }
}
