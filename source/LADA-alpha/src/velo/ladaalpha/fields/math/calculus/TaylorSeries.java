package velo.ladaalpha.fields.math.calculus;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.LMath;

public class TaylorSeries {
	public static Equation computeCenteredAt(Equation f, double s) {
		
		class res extends Equation {
			@Override
			public double compute(double x) {
				double sum = 0;
				for(int i = 1; i <= 4 ; i += 1) {
					sum += NumericalDifferentiation.differentiate(f, s, i) * ( Math.pow(x - s, i) / LMath.factorial(i) );
				}
				return f.compute(s) + sum;
			}
		}
		
		return new res();
	}
}
