package velo.ladealpha.fields.math;

import java.util.ArrayList;

import velo.ladealpha.fields.services.Codify;

/**
 * @author velo
 * 
 */
public class Equation{
	private String stringForm;
	public double compute(double input) {
		if(stringForm == null) {
			return -1;
		}
		else {
			Codify c = new Codify();
			return c.computeStringEquation(stringForm, input);
		}
	}	
	public Equation equationFromString(String eq) {
		stringForm = eq;
		return this;
	}	
}
