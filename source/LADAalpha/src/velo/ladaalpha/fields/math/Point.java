package velo.ladaalpha.fields.math;

// TODO: Auto-generated Javadoc
/**
 * The Class Point.
 */
public class Point {
	
	/** The y. */
	private double x, y;

	
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y
	 */
	public void setY(double y) {
		this.y = y;
	}

}