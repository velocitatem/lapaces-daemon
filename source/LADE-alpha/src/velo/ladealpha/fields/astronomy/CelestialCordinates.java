package velo.ladealpha.fields.astronomy;

public class CelestialCordinates {
	private double declination, right_ascension;

	
	public CelestialCordinates(double declination, double right_ascension) {
		super();
		this.declination = declination;
		this.right_ascension = right_ascension;
	}
	
	public static double radiansFromRightAscension(double hours, double minutes, double seconds) {
		return ((hours + (minutes / 60) + (seconds / 3600)) * 15) / (180 / Math.PI);
	}

	/**
	 * @return the declination
	 */
	public double getDeclination() {
		return declination;
	}

	/**
	 * @param declination the declination to set
	 */
	public void setDeclination(double declination) {
		this.declination = declination;
	}

	/**
	 * @return the right_ascension
	 */
	public double getRight_ascension() {
		return right_ascension;
	}

	/**
	 * @param right_ascension the right_ascension to set
	 */
	public void setRight_ascension(double right_ascension) {
		this.right_ascension = right_ascension;
	}
	
}
