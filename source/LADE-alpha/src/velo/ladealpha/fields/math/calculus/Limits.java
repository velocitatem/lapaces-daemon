package velo.ladealpha.fields.math.calculus;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;

// TODO: Auto-generated Javadoc
/**
 * The Class Limits.
 */
public class Limits {
	

	
	/** The prec diff. */
	public static double precDiff = 0.000001;
	
	/**
	 * Limit.
	 *
	 * @param eq the eq
	 * @param x the x
	 * @return the double
	 */
	public static double limit(Equation eq, double x) {
		
		int i = 1;		
		while(i <= 60) {
			double delta = Math.pow(10, -i);
			double ap = x + delta, an = x - delta;
			double rap = eq.compute(ap), ran = eq.compute(an);			
			
			if(Math.abs(rap - ran) <= precDiff) {
				return ((rap + ran) / 2);
			}			
			i+=1;
		}
		return Double.NaN; 
	}
}
