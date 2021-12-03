package velo.ladaalpha.fields.math;

// TODO: Auto-generated Javadoc
/**
 * The Class QuadraticFunction.
 */
public class QuadraticFunction {
	
	/** The c. */
	private double a, b, c;
	
	/**
	 * Compute.
	 *
	 * @param x the x
	 * @return the double
	 */
	public double compute(double x) {
		return (a*Math.pow(x, 2) + (b*x) + c);
	}
	
	/**
	 * Roots.
	 *
	 * @return the double[]
	 */
	public double[] roots() {
		double comp_p = (-b + (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2*a), comp_n = (-b - (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2*a);
		return new double[] {comp_p, comp_n};
	}
	
	/**
	 * Gets the a.
	 *
	 * @return the a
	 */
	public double getA() {
		return a;
	}
	
	/**
	 * Sets the a.
	 *
	 * @param a the a to set
	 */
	public void setA(double a) {
		this.a = a;
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
	
	/**
	 * Gets the c.
	 *
	 * @return the c
	 */
	public double getC() {
		return c;
	}
	
	/**
	 * Sets the c.
	 *
	 * @param c the c to set
	 */
	public void setC(double c) {
		this.c = c;
	}
	
	/**
	 * Instantiates a new quadratic function.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 */
	public QuadraticFunction(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}
