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
	
	
	
	
	public double computeInverse(double x) {
		
		
		return 1;
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
