package velo.ladealpha.fields.astronomy;

// TODO: Auto-generated Javadoc
/**
 * The Class CelestialCordinates.
 */
public class CelestialCordinates {
	
	/** The right ascension. */
	private double declination, right_ascension;

	
	/**
	 * Instantiates a new celestial cordinates.
	 *
	 * @param declination the declination
	 * @param right_ascension the right ascension
	 */
	public CelestialCordinates(double declination, double right_ascension) {
		super();
		this.declination = declination;
		this.right_ascension = right_ascension;
	}
	
	/**
	 * Radians from right ascension.
	 *
	 * @param hours the hours
	 * @param minutes the minutes
	 * @param seconds the seconds
	 * @return the double
	 */
	public static double radiansFromRightAscension(double hours, double minutes, double seconds) {
		return ((hours + (minutes / 60) + (seconds / 3600)) * 15) / (180 / Math.PI);
	}

	/**
	 * Gets the declination.
	 *
	 * @return the declination
	 */
	public double getDeclination() {
		return declination;
	}

	/**
	 * Sets the declination.
	 *
	 * @param declination the declination to set
	 */
	public void setDeclination(double declination) {
		this.declination = declination;
	}

	/**
	 * Gets the right ascension.
	 *
	 * @return the right_ascension
	 */
	public double getRight_ascension() {
		return right_ascension;
	}

	/**
	 * Sets the right ascension.
	 *
	 * @param right_ascension the right_ascension to set
	 */
	public void setRight_ascension(double right_ascension) {
		this.right_ascension = right_ascension;
	}
	
}
