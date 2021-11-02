package velo.ladealpha.fields.math;

import java.util.ArrayList;

import velo.ladealpha.fields.services.Codify;

// TODO: Auto-generated Javadoc
/**
 * The Class Equation.
 *
 * @author velo
 */
public class Equation{
	
	/** The string form. */
	private String stringForm;
	
	/**
	 * Compute.
	 *
	 * @param input the input
	 * @return the double
	 */
	public double compute(double input) {
		if(stringForm == null) {
			return -1;
		}
		else {
			Codify c = new Codify();
			return c.computeStringEquation(stringForm, input);
		}
	}	
	
	
	
	
	public double computeInverse(double input, double mid) {
		int range = 100000;
		ArrayList<Double> vec = new ArrayList<Double>();
		for(double i = mid-range; i < mid+range ; i += 0.01) {
			vec.add(i);
		}
		double smallestDiff = Double.POSITIVE_INFINITY, smallestPos = Double.POSITIVE_INFINITY;
		for(Double s : vec) {
			double diff = Math.abs(this.compute(s) - input);
			if(diff < smallestDiff) {
				smallestDiff = diff;
				smallestPos = s;
			}
		}
		if(mid > 1000) {
			return smallestPos;
		}
		else {
			return computeInverse(input, smallestPos);
		}
	}
	
	
	@Override
	public String toString() {
		return stringForm;
	}



	/**
	 * Equation from string.
	 *
	 * @param eq the eq
	 * @return the equation
	 */
	public Equation equationFromString(String eq) {
		stringForm = eq;
		return this;
	}	
}
