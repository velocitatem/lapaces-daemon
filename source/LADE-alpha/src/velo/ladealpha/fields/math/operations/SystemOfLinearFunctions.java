package velo.ladealpha.fields.math.operations;

import velo.ladealpha.fields.math.LinearFunction;

public class SystemOfLinearFunctions {
	private LinearFunction a, b;
	public SystemOfLinearFunctions(LinearFunction a, LinearFunction b) {
		this.a = a ;
		this.b = b;		
	}
	public double[] solution() {
		double[] cords = new double[2];
		double compoundSlope = a.getM() + (-1*(b.getM())),
				compoundIntercept = b.getB() + (-1*(a.getB()));
		double x = compoundIntercept / compoundSlope;
		cords[0] = x;
		double sol0 = a.compute(x), sol1 = b.compute(x);
		if((int)(sol0-sol1 )== 0) {
			cords[1] = sol0;
		}
		return cords;
	}
}
