package velo.ladealpha.fields.math.calculus;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LinearFunction;

public class NumericalDifferentiation {
	public static double differentiate(Equation f, double x) {				
		class df extends Equation {
			@Override
			public double compute(double h) {								
				return ( f.compute(x + h) - f.compute(x) ) / (h);
			}
		}
		return Limits.limit(new df(), 0);			
		
	}
	
	public static LinearFunction tangentLine(Equation f, double x) {
		double m = differentiate(f, x);
		double b = f.compute(x) - ( m * x);
		LinearFunction lf = new LinearFunction(m, b);
		return lf;
	}
	
}
