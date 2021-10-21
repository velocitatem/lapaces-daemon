package velo.ladealpha.fields.physics;

public class SimpleVector {
	private double magnitude;
	private String direction;	
	public SimpleVector(double magnitude, String direction) {
		super();
		this.magnitude = magnitude;
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return  magnitude + " units " + direction + "]";
	}

	/**
	 * @return the magnitude
	 */
	public double getMagnitude() {
		return magnitude;
	}
	/**
	 * @param magnitude the magnitude to set
	 */
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
