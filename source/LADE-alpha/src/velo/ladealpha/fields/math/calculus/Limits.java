package velo.ladealpha.fields.math.calculus;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;

public class Limits {
	public static int prec = 5;
	public static double precDiff = 0.001;
	public static double limit(Equation eq, double x) {
		double approaching = Double.NaN;
		double diff = Double.POSITIVE_INFINITY;
		int i = 1;
		boolean found = false;
		while(i <= 50) {
			double delta = Math.pow(10, -i);
			double ap = x + delta, an = x - delta;
			double rap = eq.compute(ap), ran = eq.compute(an);			
			diff = Math.abs(rap - ran);
			if(diff < precDiff) {
				return LMath.round(((rap + ran) / 2), 5);
			}			
			i+=1;
		}
		return approaching;
	}
}
