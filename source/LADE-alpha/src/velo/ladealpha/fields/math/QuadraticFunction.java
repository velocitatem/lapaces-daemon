package velo.ladealpha.fields.math;

public class QuadraticFunction {
	private double a, b, c;
	
	public double compute(double x) {
		return (a*Math.pow(x, 2) + (b*x) + c);
	}
	public double[] roots() {
		double comp_p = (-b + (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2*a), comp_n = (-b - (Math.sqrt(Math.pow(b, 2) - (4 * a * c)))) / (2*a);
		return new double[] {comp_p, comp_n};
	}
	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}
	/**
	 * @param a the a to set
	 */
	public void setA(double a) {
		this.a = a;
	}
	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}
	/**
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}
	/**
	 * @return the c
	 */
	public double getC() {
		return c;
	}
	/**
	 * @param c the c to set
	 */
	public void setC(double c) {
		this.c = c;
	}
	public QuadraticFunction(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}
