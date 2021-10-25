package velo.ladealpha.fields.life;

import java.util.ArrayList;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;
import velo.ladealpha.fields.math.LinearFunction;
import velo.ladealpha.fields.math.calculus.Limits;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;
import velo.ladealpha.fields.math.operations.SystemOfLinearFunctions;

public class Event {
	private double day_freq, sigma, omega;
	private Equation eq;
	private ArrayList<Double> r = new ArrayList<Double>();
	
	public Event(double day_freq, double sigma, double omega) {
		super();
		this.day_freq = day_freq;
		this.sigma = sigma;
		this.omega = omega;
		class event extends Equation {
			@Override
			public double compute(double x) {
				return 1 + Math.cos( ( (1/day_freq) * x ) - ((day_freq - sigma) * Math.PI) ) + Math.pow(10, -omega);
			}
		}
		eq = new event();
	}

	public double forward(double x) {
		return this.eq.compute(x);
	}
	
	public ArrayList<Double> intersections(double l, double u) {
		LinearFunction life = new LinearFunction(0, 2);		
		double m = l, it = 0;
		int i = 0;
		while(m < u && i < 200) {
			LinearFunction tangentLine = NumericalDifferentiation.tangentLine(eq, m);
			SystemOfLinearFunctions solf = new SystemOfLinearFunctions(life, tangentLine);
			double intercept = LMath.round(solf.solution()[0], 4);
			System.out.println(i + ":\t"+ intercept + " - ");
			m = intercept;
			if (it == m || LMath.round(eq.compute(intercept), 3) == 2.0) {
				m+=0.5;
				if(!r.contains(intercept)) {
					r.add(intercept);
					return intersections(intercept, u);
				}				
				
			}
			else {
				it = m;
			}
			
			
			i+=1;
		}
		return r;
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

	/**
	 * @return the omega
	 */
	public double getOmega() {
		return omega;
	}

	/**
	 * @param omega the omega to set
	 */
	public void setOmega(double omega) {
		this.omega = omega;
	}
	
}
