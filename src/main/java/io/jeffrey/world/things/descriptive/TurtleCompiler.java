package io.jeffrey.world.things.descriptive;

import java.util.ArrayList;
import java.util.List;

public class TurtleCompiler {

  public static String compile(final String script) {
    final Turtle turtle = new Turtle();
    for (final String[] statement : tokenizeLines(script)) {
      final String command = statement[0];
      if (statement.length != 2) {
        throw new IllegalStateException("NO!");
      }
      switch (command) {
        case "forward":
          turtle.forward(Double.parseDouble(statement[1]));
          break;
        case "back":
          turtle.forward(-Double.parseDouble(statement[1]));
          break;
        case "left":
          turtle.turn(-Double.parseDouble(statement[1]));
          break;
        case "right":
          turtle.turn(Double.parseDouble(statement[1]));
          break;
      }
    }
    return turtle.toString();
  }

  private static String[] tokenizeLine(final String line) {
    final ArrayList<String> parts = new ArrayList<>();
    for (String part : line.trim().split(" ")) {
      part = part.trim();
      if (part.length() > 0) {
        parts.add(part);
      }
    }
    return parts.toArray(new String[parts.size()]);
  }

  private static List<String[]> tokenizeLines(final String script) {
    final ArrayList<String[]> commands = new ArrayList<>();
    final String[] lines = script.replaceAll(";", "\n").split("\n");
    for (String line : lines) {
      line = line.trim().toLowerCase();
      if (line.length() == 0) {
        continue;
      }
      if (line.charAt(0) == '#') {
        continue; // comment
      }
      final String[] parts = tokenizeLine(line);
      if (parts.length > 0) {
        commands.add(parts);
      }
    }
    return commands;
  }
}
