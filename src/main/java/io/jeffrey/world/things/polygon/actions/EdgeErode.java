package io.jeffrey.world.things.polygon.actions;

import java.util.Arrays;

import io.jeffrey.world.things.polygon.IndexRemoval;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

public class EdgeErode {

	private static double[] distancesOf(final SelectablePoint2[] sp) {
		double[] result = new double[sp.length - 1];
		for (int j = 0; j + 1 < sp.length; j++) {
			double dx = sp[j + 1].x - sp[j].x;
			double dy = sp[j + 1].y - sp[j].y;
			result[j] = Math.sqrt(dx * dx + dy * dy);
		}
		return result;

	}

	private static boolean[] collapsable(final SelectablePoint2[] sp) {
		if (sp.length <= 1)
			return new boolean[0];
		double[] distances = distancesOf(sp);
		Arrays.sort(distances);
		double cutoff = distances[(int) Math
				.floor((distances.length - 1) * 0.1)];
		boolean[] cut = new boolean[sp.length];
		for (int k = 0; k < sp.length; k++) {
			cut[k] = false;
		}
		int at = 0;
		for (int k = 1; k < sp.length; k++) {
			double dx = sp[k].x - sp[at].x;
			double dy = sp[k].y - sp[at].y;
			double d = Math.sqrt(dx * dx + dy * dy);
			if (d <= cutoff) {
				cut[k] = true;
			} else {
				at = k;
			}
		}
		return cut;
	}

	/**
	 * @param chain
	 *            what to act on
	 * @param asLoop
	 *            is it a loop
	 */
	public static void perform(final PointChain chain, final boolean asLoop) {
		final IndexRemoval remover = new IndexRemoval();
		for (final SelectablePoint2[] segments : chain.selectedSegments(asLoop)) {
			boolean[] cut = collapsable(segments);
			int collectAt = 0;
			int w = 1;
			for (int j = 1; j < segments.length; j++) {
				if (cut[j]) {
					segments[collectAt].x += segments[j].x;
					segments[collectAt].y += segments[j].y;
					w++;
					remover.denote(segments[j].cachedIndex);
				} else {
					if (w > 1) {
						segments[collectAt].x /= w;
						segments[collectAt].y /= w;
						w = 1;
					}
					collectAt = j;
				}
			}

			segments[collectAt].x /= w;
			segments[collectAt].y /= w;
		}
		chain.apply(remover);
	}
}
