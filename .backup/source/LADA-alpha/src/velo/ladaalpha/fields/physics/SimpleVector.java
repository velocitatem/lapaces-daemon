package velo.ladaalpha.fields.physics;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleVector.
 */
public class SimpleVector {
	
	/** The magnitude. */
	private double magnitude;
	
	/** The direction. */
	private String direction;	
	
	/**
	 * Instantiates a new simple vector.
	 *
	 * @param magnitude the magnitude
	 * @param direction the direction
	 */
	public SimpleVector(double magnitude, String direction) {
		super();
		this.magnitude = magnitude;
		this.direction = direction;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return  magnitude + " units " + direction + "]";
	}

	/**
	 * Gets the magnitude.
	 *
	 * @return the magnitude
	 */
	public double getMagnitude() {
		return magnitude;
	}
	
	/**
	 * Sets the magnitude.
	 *
	 * @param magnitude the magnitude to set
	 */
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	
	/**
	 * Gets the direction.
	 *
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	
	/**
	 * Sets the direction.
	 *
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
