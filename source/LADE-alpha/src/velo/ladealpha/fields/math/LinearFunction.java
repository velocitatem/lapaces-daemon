package velo.ladealpha.fields.math;

public class LinearFunction {
	private double m, b;

	public LinearFunction() {}
	public LinearFunction(double m, double b) {
		super();
		this.m = m;
		this.b = b;
	}
	public void buildFromTwoPoints(double x1, double y1, double x2, double y2) {
		double MeanRateOfChange = (y2 - y1) / (x2 - x1);
		m = MeanRateOfChange;
		double intercept = y1 + (m * (-x1));
		b = intercept;
	}

	@Override
	public String toString() {
		return "y = " + m + "x + (" + b + ")";
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
