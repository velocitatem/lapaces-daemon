package velo.ladaalpha.fields.math.calculus;

import velo.ladaalpha.fields.math.CombinationFormula;
import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.LinearFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class NumericalDifferentiation.
 *
 * @author velo
 */
public class NumericalDifferentiation {

	/**
	 * Differentiate.
	 *
	 * @param f the f
	 * @param x the x
	 * @return the double
	 */
	public static double differentiate(Equation f, double x) {
		class df extends Equation {
			@Override
			public double compute(double h) {
				return (f.compute(x + h) - f.compute(x)) / (h);
			}
		}
		return Limits.limit(new df(), 0);
	}

	public static Equation differentiate(Equation f) {

		class r extends Equation {
			private Equation eq = f;
			public double ps;

			@Override
			public double compute(double x) {
				return NumericalDifferentiation.differentiate(eq, x);
			}
		}
		return new r();

	}

	public static double differentiate(Equation f, double x, int order) {

		if (order == 1) {
			return NumericalDifferentiation.differentiate(f, x);
		} else if (order == 2) {
			class sndod extends Equation {
				@Override
				public double compute(double h) {
					double fox = f.compute(x);
					return (f.compute(x + h) - 2 * fox + f.compute(x - h)) / Math.pow(h, 2);
				}
			}
			return Limits.limit(new sndod(), 0);
		}

		else {
			class r extends Equation {
				@Override
				public double compute(double h) {
					double sum = 0;

					for (int i = 0; i <= order; i += 1) {
						sum += Math.pow(-1, order + i) * f.compute(x + (h * i)) * CombinationFormula.ncr(order, i);
					}

					return (1 / Math.pow(h, order)) * sum;
				}
			}
			return new r().compute(Math.pow(10, -3));
		}

	}

	/**
	 * Tangent line.
	 *
	 * @param f the f
	 * @param x the x
	 * @return the linear function
	 */
	public static LinearFunction tangentLine(Equation f, double x) {
		double m = differentiate(f, x);
		double b = f.compute(x) - (m * x);
		LinearFunction lf = new LinearFunction(m, b);
		return lf;
	}

}
