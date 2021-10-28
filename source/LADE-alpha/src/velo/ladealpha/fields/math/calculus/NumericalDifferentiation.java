package velo.ladealpha.fields.math.calculus;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LinearFunction;

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
				return ( f.compute(x + h) - f.compute(x) ) / (h);
			}
		}
		return Limits.limit(new df(), 0);			
		
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
		double b = f.compute(x) - ( m * x);
		LinearFunction lf = new LinearFunction(m, b);
		return lf;
	}
	
}
