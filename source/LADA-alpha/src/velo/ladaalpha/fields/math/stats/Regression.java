package velo.ladaalpha.fields.math.stats;

import velo.ladaalpha.fields.math.LinearFunction;

public class Regression {
	public static LinearFunction LSRL(double[] x, double[] y) {
		return new LSRL(x, y).compute();
	}
}
