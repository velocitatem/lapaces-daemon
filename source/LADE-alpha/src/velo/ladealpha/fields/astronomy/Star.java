package velo.ladealpha.fields.astronomy;

import java.awt.Color;

public class Star extends SpaceObject {
	
	
	public Star(double distance_ly, double apparent_magnitude, double absolute_magnitude, double liminosity,
			Color color, double radius, StellarSpectrum spectrum) {
		super(0); // TODO add param
		this.distance_ly = distance_ly;
		this.apparent_magnitude = apparent_magnitude;
		this.absolute_magnitude = absolute_magnitude;
		this.liminosity = liminosity * Math.pow(10, 24); 
		this.color = color;
		this.radius = radius;
		this.spectrum = spectrum;
	}
	private double distance_ly;
	private double apparent_magnitude;
	private double absolute_magnitude;
	private double liminosity; // J/s
	private Color color;
	private double radius;	
	private StellarSpectrum spectrum;
	/**
	 * @return the distance_ly
	 */
	public double getDistance_ly() {
		return distance_ly;
	}
	/**
	 * @param distance_ly the distance_ly to set
	 */
	public void setDistance_ly(double distance_ly) {
		this.distance_ly = distance_ly;
	}
	/**
	 * @return the apparent_magnitude
	 */
	public double getApparent_magnitude() {
		return apparent_magnitude;
	}
	/**
	 * @param apparent_magnitude the apparent_magnitude to set
	 */
	public void setApparent_magnitude(double apparent_magnitude) {
		this.apparent_magnitude = apparent_magnitude;
	}
	/**
	 * @return the absolute_magnitude
	 */
	public double getAbsolute_magnitude() {
		return absolute_magnitude;
	}
	/**
	 * @param absolute_magnitude the absolute_magnitude to set
	 */
	public void setAbsolute_magnitude(double absolute_magnitude) {
		this.absolute_magnitude = absolute_magnitude;
	}
	/**
	 * @return the liminosity
	 */
	public double getLiminosity() {
		return liminosity;
	}
	/**
	 * @param liminosity the liminosity to set
	 */
	public void setLiminosity(double liminosity) {
		this.liminosity = liminosity;
	}
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return the spectrum
	 */
	public StellarSpectrum getSpectrum() {
		return spectrum;
	}
	/**
	 * @param spectrum the spectrum to set
	 */
	public void setSpectrum(StellarSpectrum spectrum) {
		this.spectrum = spectrum;
	}
	
}
