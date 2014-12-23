package io.jeffrey.world.things.polygon.actions;

import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

public class Springize {

	private static double dist(SelectablePoint2 a, SelectablePoint2 b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static void perform(PointChain chain, boolean asLoop) {
		double step = 0.1 * 0.1 / 2.0;
		for (final SelectablePoint2[] segments : chain.selectedSegments(asLoop,
				true)) {

			double[] buffer = new double[segments.length * 2];

			for (int round = 0; round < 10; round++) {
				double d = 0;
				int n = 0;
				for (int j = 0; j + 1 < segments.length; j++) {
					d += dist(segments[j], segments[j + 1]);
					n++;
				}
				d /= n;

				for (int j = 1; j + 1 < segments.length; j++) {
					double prior = dist(segments[j], segments[j - 1]) - d;
					double next = dist(segments[j], segments[j + 1]) - d;

					double ax = -prior * (segments[j].x - segments[j - 1].x)
							- next * (segments[j].x - segments[j + 1].x);
					double ay = -prior * (segments[j].y - segments[j - 1].y)
							- next * (segments[j].y - segments[j + 1].y);

					buffer[2 * j] = segments[j].x + ax * step;
					buffer[2 * j + 1] = segments[j].y + ay * step;
				}
				for (int j = 1; j + 1 < segments.length; j++) {
					segments[j].x = buffer[2 * j];
					segments[j].y = buffer[2 * j + 1];
				}
			}
		}
	}
}
