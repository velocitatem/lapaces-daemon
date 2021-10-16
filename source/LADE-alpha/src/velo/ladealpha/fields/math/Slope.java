package velo.ladealpha.fields.math;

public class Slope {
	private double m, b;

	public Slope(double m, double b) {
		super();
		this.m = m;
		this.b = b;
	}
	public double compute(double x) {
		return (m*x) +b;
	}
	/**
	 * @return the m
	 */
	public double getM() {
		return m;
	}

	/**
	 * @param m the m to set
	 */
	public void setM(double m) {
		this.m = m;
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
}
