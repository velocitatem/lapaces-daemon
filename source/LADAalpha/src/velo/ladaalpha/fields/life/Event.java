package velo.ladaalpha.fields.life;

import java.util.ArrayList;
import java.util.Arrays;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.LMath;
import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.calculus.Limits;
import velo.ladaalpha.fields.math.calculus.NumericalDifferentiation;
import velo.ladaalpha.fields.math.operations.SystemOfLinearFunctions;

// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
public class Event {

	/** The shift. */
	private double day_freq, sigma, shift = 0;

	/** The name. */
	private String name;

	/** The eq. */
	private Equation eq;

	/** The r. */
	private ArrayList<Double> r = new ArrayList<Double>();

	/**
	 * Checks if is exclusion.
	 *
	 * @return true, if is exclusion
	 */
	public boolean isExclusion() {
		return name.contains("exclusion");
	}

	/**
	 * Gets the shift.
	 *
	 * @return the shift
	 */
	public double getShift() {
		return shift;
	}

	/**
	 * Sets the shift.
	 *
	 * @param shift the shift to set
	 */
	public void setShift(double shift) {
		this.shift = shift;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "cos( 1/" + day_freq + "x + " + sigma + " ??) + 1 + " + shift;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the eq.
	 *
	 * @return the eq
	 */
	public Equation getEq() {
		return eq;
	}

	/**
	 * Sets the eq.
	 *
	 * @param eq the eq to set
	 */
	public void setEq(Equation eq) {
		this.eq = eq;
	}

	/**
	 * Instantiates a new event.
	 *
	 * @param name            the name
	 * @param frequencyInDays the frequency in days
	 * @param hourOfOccurance the hour of occurance
	 */
	public Event(String name, double frequencyInDays, double hourOfOccurance) {
		super();
		this.name = name;
		double day_freq = frequencyInDays, sigma;
		double hourRadians = (hourOfOccurance / 24) * (Math.PI * 2);
		sigma = -(((1) / (frequencyInDays)) * hourRadians) / (Math.PI);
		this.day_freq = day_freq;
		this.sigma = sigma;
		class event extends Equation {
			@Override
			public double compute(double x) {
				return 1 + Math.cos(((1 / day_freq) * x) + ((sigma) * Math.PI));
			}
		}
		eq = new event();
	}

	/**
	 * Forward.
	 *
	 * @param x the x
	 * @return the double
	 */
	public double forward(double x) {
		return this.eq.compute(x);
	}

	/**
	 * Closest occurance.
	 *
	 * @param x the x
	 * @return the double
	 */
	public double closestOccurance(double x) {
		double m = Double.POSITIVE_INFINITY;
		LinearFunction life = new LinearFunction(0, 2); // m, b
		while (LMath.round(m, 4) != 0.0) {
			m = NumericalDifferentiation.differentiate(eq, x);
			LinearFunction tangent = NumericalDifferentiation.tangentLine(eq, x);
			double[] sol = new SystemOfLinearFunctions(life, tangent).solution();
			x = sol[0];
		}
		return x;
	}

	/**
	 * Gets the day freq.
	 *
	 * @return the day_freq
	 */
	public double getDay_freq() {
		return day_freq;
	}

	/**
	 * Sets the day freq.
	 *
	 * @param day_freq the day_freq to set
	 */
	public void setDay_freq(double day_freq) {
		this.day_freq = day_freq;
	}

	/**
	 * Gets the sigma.
	 *
	 * @return the sigma
	 */
	public double getSigma() {
		return sigma;
	}

	/**
	 * Sets the sigma.
	 *
	 * @param sigma the sigma to set
	 */
	public void setSigma(double sigma) {
		this.sigma = sigma;
	}

}
