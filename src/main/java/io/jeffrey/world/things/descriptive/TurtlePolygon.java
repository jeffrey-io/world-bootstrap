package io.jeffrey.world.things.descriptive;

import java.util.ArrayList;
import java.util.List;

public class TurtlePolygon {

  public static void compile(final String script) {
    final double dx = 1.0;
    final double dy = 0.0;
    for (final String[] statement : tokenizeLines(script)) {
      final String command = statement[0];
      switch (command) {
        case "walk":
          if (statement.length != 2) {
            throw new IllegalStateException("NO!");
          }
          final double amount = Double.parseDouble(statement[1]);
        case "left":
        case "right":
      }
    }
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
    final String[] lines = script.split("\n");
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
