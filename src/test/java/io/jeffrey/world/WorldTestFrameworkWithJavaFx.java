package io.jeffrey.world;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.sun.javafx.application.PlatformImpl;

public class WorldTestFrameworkWithJavaFx extends WorldTestFramework {
  private static boolean setup = false;

  public WorldTestFrameworkWithJavaFx() {
    if (setup) {
      return;
    }
    final CountDownLatch latch = new CountDownLatch(1);
    PlatformImpl.startup(() -> latch.countDown());
    try {
      latch.await(30000, TimeUnit.MILLISECONDS);
      setup = true;
    } catch (final InterruptedException e) {
    }
  }
}
