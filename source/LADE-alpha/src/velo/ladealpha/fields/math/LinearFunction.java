package velo.ladealpha.fields.math;

// TODO: Auto-generated Javadoc
/**
 * The Class LinearFunction.
 */
public class LinearFunction {
	
	/** The b. */
	private double m, b;

	/**
	 * Instantiates a new linear function.
	 */
	public LinearFunction() {}
	
	/**
	 * Instantiates a new linear function.
	 *
	 * @param m the m
	 * @param b the b
	 */
	public LinearFunction(double m, double b) {
		super();
		this.m = m;
		this.b = b;
	}
	
	/**
	 * Builds the from two points.
	 *
	 * @param x1 the x 1
	 * @param y1 the y 1
	 * @param x2 the x 2
	 * @param y2 the y 2
	 */
	public void buildFromTwoPoints(double x1, double y1, double x2, double y2) {
		double MeanRateOfChange = (y2 - y1) / (x2 - x1);
		m = MeanRateOfChange;
		double intercept = y1 + (m * (-x1));
		b = intercept;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "y = " + m + "x + (" + b + ")";
	}
	
	/**
	 * Compute.
	 *
	 * @param x the x
	 * @return the double
	 */
	public double compute(double x) {
		return (m*x) +b;
	}
	
	/**
	 * Gets the m.
	 *
	 * @return the m
	 */
	public double getM() {
		return m;
	}

	/**
	 * Sets the m.
	 *
	 * @param m the m to set
	 */
	public void setM(double m) {
		this.m = m;
	}

	/**
	 * Gets the b.
	 *
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * Sets the b.
	 *
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}
}
