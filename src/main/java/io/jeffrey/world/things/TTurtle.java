package io.jeffrey.world.things;

import java.util.ArrayList;

import io.jeffrey.world.data.EditString;
import io.jeffrey.world.things.behaviors.HasSelectableEdges;
import io.jeffrey.world.things.behaviors.HasThingSpaceRendering;
import io.jeffrey.world.things.behaviors.IsSelectable;
import io.jeffrey.world.things.behaviors.structs.SelectionModel;
import io.jeffrey.world.things.core.BasicThing;
import io.jeffrey.world.things.core.Container;
import io.jeffrey.world.things.core.LinkedDataMap;
import io.jeffrey.world.things.core.Part;
import io.jeffrey.world.things.core.Transform;
import io.jeffrey.world.things.descriptive.TurtleCompiler;
import io.jeffrey.world.things.descriptive.TurtleLine;
import io.jeffrey.world.things.parts.MousePart;
import io.jeffrey.world.things.parts.MoveByEdgePart;
import io.jeffrey.world.things.points.SelectablePoint2;
import io.jeffrey.zer.AdjustedMouseEvent;
import javafx.scene.canvas.GraphicsContext;

public class TTurtle extends BasicThing {

  public TTurtle(final Container container, final LinkedDataMap data) {
    super(container, data);

    final EditString script = data.getString("script", "forward 50; right 45; forward 50;");

    TurtlePart turtle = new TurtlePart(transform, container, script);
    MoveByEdgePart mover = new MoveByEdgePart(container, transform, turtle, editing.locked, editing, position, rotation);
    register(turtle);
    register(mover);
    register(new MousePart(this, transform)); // TODO: this belongs as part of the framework since it's highly specific
  }

  public class TurtlePart extends HasThingSpaceRendering implements Part, HasSelectableEdges, IsSelectable {

    private final ArrayList<TurtleLine>   lines;
    private ArrayList<SelectablePoint2[]> edges;

    public TurtlePart(Transform transform, Container container, EditString script) {
      super(transform, container);
      this.lines = new ArrayList<>();
      this.edges = new ArrayList<>();
      script.subscribe((from, to) -> {
        update(to);
      });
      update(script.value());
    }

    private void update(String newScript) {
      lines.clear();
      lines.addAll(TurtleCompiler.compile(newScript));
      edges.clear();
      for (TurtleLine line : lines) {
        SelectablePoint2[] edge = new SelectablePoint2[] { new SelectablePoint2(line.x0, line.y0), new SelectablePoint2(line.x1, line.y1), };
        edges.add(edge);
      }
    }

    @Override
    public void draw(GraphicsContext gc) {
      for (TurtleLine line : lines) {
        gc.beginPath();
        gc.setStroke(line.color);
        gc.moveTo(line.x0, line.y0);
        gc.lineTo(line.x1, line.y1);
        gc.stroke();
      }
    }

    @Override
    public Iterable<SelectablePoint2[]> getSelectableEdges() {
      return edges;
    }

    @Override
    public boolean contains(double x, double y) {
      return false;
    }

    @Override
    public boolean doesMouseEventPreserveExistingSelection(AdjustedMouseEvent event) {
      return false;
    }

    @Override
    public boolean selectionIntersect(SelectionModel model) {
      for (SelectablePoint2[] edge : edges) {
        for (SelectablePoint2 p : edge) {
          if (model.contains(p.x, p.y)) {
            return true;
          }
        }
      }
      return false;
    }
  }
}
