package velo.ladaalpha.fields.math;

import java.util.ArrayList;

import velo.ladealpha.fields.services.Codify;
import velo.ladealpha.fields.services.MethodInvocationUtils;
import velo.ladealpha.fields.services.RuntimeCompiler;

// TODO: Auto-generated Javadoc
/**
 * The Class Equation.
 *
 * @author velo
 */
public class Equation{
	
	/** The string form. */
	private String stringForm;
	
	private Class<?> cl;
	
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
			if(cl!=null) {
				
				Object o = MethodInvocationUtils.invokeStaticMethod(cl, "compute", ""+input);            
				return (double)o;
			}	
			else {
							
				Codify c = new Codify();
				return c.computeStringEquation(stringForm, input);
			}
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
		String classNameA = "FunctionR";
		this.cl = new Codify().getCompiler(eq).getCompiledClass(classNameA);
		return this;
	}	
}
