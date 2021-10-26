package velo.ladealpha.fields.life;

import java.util.ArrayList;
import java.util.Arrays;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;
import velo.ladealpha.fields.math.LinearFunction;
import velo.ladealpha.fields.math.calculus.Limits;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;
import velo.ladealpha.fields.math.operations.SystemOfLinearFunctions;

public class Event {
	private double day_freq, sigma;
	private String name;
	private Equation eq;
	private ArrayList<Double> r = new ArrayList<Double>();
	
	

	@Override
	public String toString() {
		return "cos( 1/"+day_freq+"x + "+sigma+" π) + 1";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the eq
	 */
	public Equation getEq() {
		return eq;
	}
	/**
	 * @param eq the eq to set
	 */
	public void setEq(Equation eq) {
		this.eq = eq;
	}
	public Event(String name, double frequencyInDays, double hourOfOccurance) {
		super();
		this.name = name;
		double day_freq = frequencyInDays, sigma;
		double hourRadians = (hourOfOccurance / 24) * (Math.PI * 2);
		sigma = - ( ((1)/(frequencyInDays)) * hourRadians  ) / (Math.PI);
		this.day_freq = day_freq;
		this.sigma = sigma;
		class event extends Equation {
			@Override
			public double compute(double x) {
				return 1 + Math.cos( ( (1/day_freq) * x ) + ((sigma) * Math.PI) ) ;
			}
		}
		eq = new event();
	}
	public double forward(double x) {
		return this.eq.compute(x);
	}
	
	
	public double closestOccurance(double x) {	
		double m = Double.POSITIVE_INFINITY;
		LinearFunction life = new LinearFunction(0, 2); // m, b
		while(LMath.round(m, 4)!= 0.0) {
			m = NumericalDifferentiation.differentiate(eq, x);
			LinearFunction tangent = NumericalDifferentiation.tangentLine(eq, x);
			double[] sol = new SystemOfLinearFunctions(life, tangent).solution();
			x = sol[0];
		}
		return x;
	}
	
	
	/**
	 * @return the day_freq
	 */
	public double getDay_freq() {
		return day_freq;
	}

	/**
	 * @param day_freq the day_freq to set
	 */
	public void setDay_freq(double day_freq) {
		this.day_freq = day_freq;
	}

	/**
	 * @return the sigma
	 */
	public double getSigma() {
		return sigma;
	}

	/**
	 * @param sigma the sigma to set
	 */
	public void setSigma(double sigma) {
		this.sigma = sigma;
	}

	
}
