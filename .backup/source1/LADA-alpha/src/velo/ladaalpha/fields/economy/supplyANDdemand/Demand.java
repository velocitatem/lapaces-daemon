package velo.ladaalpha.fields.economy.supplyANDdemand;

import velo.ladaalpha.fields.math.LinearFunction;

// TODO: Auto-generated Javadoc
/**
 * The Class Demand.
 */
public class Demand extends LinearFunction{
	
	/**
	 * Instantiates a new demand.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 */
	public Demand(double x1, double y1, double x2, double y2) {
		super();
		super.buildFromTwoPoints(x1, y1, x2, y2);
	}
}
