package io.jeffrey.world.things.polygon.actions;

import java.util.Random;

import io.jeffrey.vector.VectorRegister3;
import io.jeffrey.vector.VectorRegister6;
import io.jeffrey.world.document.Document;
import io.jeffrey.world.things.core.Thing;
import io.jeffrey.world.things.polygon.PointChain;
import io.jeffrey.world.things.polygon.SelectablePoint2;

public class NormalGrowth {

	private static class ColorSeeker implements Augmenter {

		private final Thing thing;
		private final Document document;
		private final VectorRegister3 W;

		public ColorSeeker(Thing thing, Document document) {
			this.thing = thing;
			this.document = document;
			this.W = new VectorRegister3();
		}

		@Override
		public void augment(double[] buffer, int j, VectorRegister6 reg) {

			double[] S = new double[2];

			boolean found = false;
			for (double seekM = 0; seekM < 2; seekM += 0.01) {
				if (found)
					break;
				S[0] = -seekM;
				S[1] = seekM;
				for (double seek : S) {
					if (found)
						break;
					reg.copy_from_3_to_1();
					reg.mult_1_by(seek);
					reg.add_0_to_1();

					W.set_0(reg.x_1, reg.y_1);
					thing.writeToWorld(W);
					if (document.query(W.x_1, W.y_1, thing) != null) {
						found = true;
						buffer[j * 2] = reg.x_1;
						buffer[j * 2 + 1] = reg.y_1;
					}
				}
			}
		}

	}

	private static void augment(final PointChain chain, final boolean asLoop,
			Augmenter seeker) {
		VectorRegister6 reg = new VectorRegister6();
		reg.set_2(0, -1);
		for (final SelectablePoint2[] segments : chain.selectedSegments(asLoop,
				true)) {
			double[] buffer = new double[segments.length * 2];
			for (int j = 1; j < segments.length - 1; j++) {
				reg.set_0(segments[j].x, segments[j].y);
				reg.set_1(segments[j + 1].x, segments[j + 1].y);
				reg.sub_0_from_1();
				reg.normalize_1();
				reg.complex_mult_2_1();
				reg.copy_from_1_to_3();
				reg.set_0(segments[j - 1].x, segments[j - 1].y);
				reg.set_1(segments[j].x, segments[j].y);
				reg.sub_0_from_1();
				reg.normalize_1();
				reg.complex_mult_2_1();
				reg.add_1_to_3();
				reg.div_3_by(2.0);

				reg.set_0(segments[j].x, segments[j].y);
				buffer[j * 2] = reg.x_0;
				buffer[j * 2 + 1] = reg.y_0;
				seeker.augment(buffer, j, reg);

			}
			for (int j = 1; j < segments.length - 1; j++) {
				segments[j].x = buffer[j * 2];
				segments[j].y = buffer[j * 2 + 1];
			}
		}

	}

	public interface Augmenter {
		public void augment(double[] buffer, int j, VectorRegister6 reg);
	}

	/**
	 * @param chain
	 *            what to act on
	 * @param asLoop
	 *            is it a loop
	 */
	public static void seekColor(final Thing thing, final Document document,
			final PointChain chain, final boolean asLoop) {
		augment(chain, asLoop, new ColorSeeker(thing, document));
	}

	public static void expand(final PointChain chain, final boolean asLoop) {
		augment(chain, asLoop, new Augmenter() {

			@Override
			public void augment(double[] buffer, int j, VectorRegister6 reg) {
				reg.copy_from_3_to_1();
				reg.mult_1_by(0.1);
				reg.add_0_to_1();
				buffer[j * 2] = reg.x_1;
				buffer[j * 2 + 1] = reg.y_1;
			}
		});
	}

	public static void contract(final PointChain chain, final boolean asLoop) {
		augment(chain, asLoop, new Augmenter() {

			@Override
			public void augment(double[] buffer, int j, VectorRegister6 reg) {
				reg.copy_from_3_to_1();
				reg.mult_1_by(-0.1);
				reg.add_0_to_1();
				buffer[j * 2] = reg.x_1;
				buffer[j * 2 + 1] = reg.y_1;
			}
		});
	}

	public static void expandRandomly(final PointChain chain,
			final boolean asLoop) {
		final Random rng = new Random();

		augment(chain, asLoop, new Augmenter() {

			@Override
			public void augment(double[] buffer, int j, VectorRegister6 reg) {
				reg.copy_from_3_to_1();
				reg.mult_1_by(0.1 * rng.nextDouble());
				reg.add_0_to_1();
				buffer[j * 2] = reg.x_1;
				buffer[j * 2 + 1] = reg.y_1;
			}
		});
	}

	public static void contractRandomly(final PointChain chain,
			final boolean asLoop) {
		final Random rng = new Random();

		augment(chain, asLoop, new Augmenter() {

			@Override
			public void augment(double[] buffer, int j, VectorRegister6 reg) {
				reg.copy_from_3_to_1();
				reg.mult_1_by(-0.1 * rng.nextDouble());
				reg.add_0_to_1();
				buffer[j * 2] = reg.x_1;
				buffer[j * 2 + 1] = reg.y_1;
			}
		});
	}
}