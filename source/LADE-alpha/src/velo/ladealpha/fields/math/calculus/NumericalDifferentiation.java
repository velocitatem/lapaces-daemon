package velo.ladealpha.fields.math.calculus;

import velo.ladealpha.fields.math.Equation;

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
}
