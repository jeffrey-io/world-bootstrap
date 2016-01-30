package io.jeffrey.world.things.descriptive;

import java.util.List;

import org.junit.Test;

import io.jeffrey.world.WorldTestFramework;

public class TestTurtleCompiler extends WorldTestFramework {

  @Test
  public void coverage() {
    new TurtleCompiler();
  }

  @Test
  public void verify() {
    StringBuilder sample = new StringBuilder();
    sample.append("# turtle comment\n");
    sample.append("draw false;; forward          1      ; ");
    sample.append("draw true; forward 2; left 45; back 2;");
    sample.append(" right 90; forwards 3; color fff; push; ");
    sample.append("forward 4; pop; rotate 45; forward 4");

    List<TurtleLine> lines = TurtleCompiler.compile(sample.toString());
    assertEquals(4, lines.size());
    TurtleLine line;

    for (int k = 0; k < 4; k++) {
      System.out.println("line = lines.get(" + k + ");");
      line = lines.get(k);
      System.out.println("assertEquals(" + line.x0 + ",line.x0);");
      System.out.println("assertEquals(" + line.y0 + ",line.y0);");
      System.out.println("assertEquals(" + line.x1 + ",line.x1);");
      System.out.println("assertEquals(" + line.y1 + ",line.y1);");
      System.out.println("assertEquals(\"" + line.color.toString() + "\",line.color.toString());");
    }

    line = lines.get(0);
    assertEquals(1.0,line.x0);
    assertEquals(0.0,line.y0);
    assertEquals(3.0,line.x1);
    assertEquals(0.0,line.y1);
    assertEquals("0x000000ff",line.color.toString());
    line = lines.get(1);
    assertEquals(3.0,line.x0);
    assertEquals(0.0,line.y0);
    assertEquals(1.5857860404731683,line.x1);
    assertEquals(1.414213165219247,line.y1);
    assertEquals("0x000000ff",line.color.toString());
    line = lines.get(2);
    assertEquals(1.5857860404731683,line.x0);
    assertEquals(1.414213165219247,line.y0);
    assertEquals(4.4142139595268315,line.x1);
    assertEquals(4.242639495657741,line.y1);
    assertEquals("0xffffffff",line.color.toString());
    line = lines.get(3);
    assertEquals(1.5857860404731683,line.x0);
    assertEquals(1.414213165219247,line.y0);
    assertEquals(4.4142139595268315,line.x1);
    assertEquals(4.242639495657741,line.y1);
    assertEquals("0xffffffff",line.color.toString());


  }
}
