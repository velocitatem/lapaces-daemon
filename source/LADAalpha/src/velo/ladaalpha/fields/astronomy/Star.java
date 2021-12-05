package velo.ladaalpha.fields.astronomy;

import java.awt.*;

// TODO: Auto-generated Javadoc

/**
 * The Class Star.
 */
public class Star extends SpaceObject {

    // TODO implment paralax angle in structure

    /**
     * Instantiates a new star.
     *
     * @param distance_ly        the distance ly
     * @param apparent_magnitude the apparent magnitude
     * @param absolute_magnitude the absolute magnitude
     * @param liminosity         the liminosity
     * @param color              the color
     * @param radius             the radius
     * @param spectrum           the spectrum
     */
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

    /**
     * The distance ly.
     */
    private double distance_ly;

    /**
     * The apparent magnitude.
     */
    private double apparent_magnitude;

    /**
     * The absolute magnitude.
     */
    private double absolute_magnitude;

    /**
     * The liminosity.
     */
    private double liminosity; // J/s

    /**
     * The color.
     */
    private Color color;

    /**
     * The radius.
     */
    private double radius;

    /**
     * The paralax angle.
     */
    private double paralax_angle;

    /**
     * The spectrum.
     */
    private StellarSpectrum spectrum;

    /**
     * Compute distance given theta.
     *
     * @param theta the theta
     * @return the double
     */
    public static double computeDistanceGivenTheta(double theta) {

        return 1 / Math.tan(theta / 3600); // au

    }

    /**
     * Gets the distance ly.
     *
     * @return the distance_ly
     */
    // TODO TEST
    public double getDistance_ly() {
        return AstronomicalUnitConversion.AUtoLY(computeDistanceGivenTheta(paralax_angle));
    }

    /**
     * Sets the distance ly.
     *
     * @param distance_ly the distance_ly to set
     */
    public void setDistance_ly(double distance_ly) {
        this.distance_ly = distance_ly;
    }

    /**
     * Gets the apparent magnitude.
     *
     * @return the apparent_magnitude
     */
    public double getApparent_magnitude() {
        return apparent_magnitude;
    }

    /**
     * Sets the apparent magnitude.
     *
     * @param apparent_magnitude the apparent_magnitude to set
     */
    public void setApparent_magnitude(double apparent_magnitude) {
        this.apparent_magnitude = apparent_magnitude;
    }

    /**
     * Gets the absolute magnitude.
     *
     * @return the absolute_magnitude
     */
    public double getAbsolute_magnitude() {
        return absolute_magnitude;
    }

    /**
     * Sets the absolute magnitude.
     *
     * @param absolute_magnitude the absolute_magnitude to set
     */
    public void setAbsolute_magnitude(double absolute_magnitude) {
        this.absolute_magnitude = absolute_magnitude;
    }

    /**
     * Gets the liminosity.
     *
     * @return the liminosity
     */
    public double getLiminosity() {
        return liminosity;
    }

    /**
     * Sets the liminosity.
     *
     * @param liminosity the liminosity to set
     */
    public void setLiminosity(double liminosity) {
        this.liminosity = liminosity;
    }

    /**
     * Gets the color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color.
     *
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets the radius.
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius.
     *
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Gets the spectrum.
     *
     * @return the spectrum
     */
    public StellarSpectrum getSpectrum() {
        return spectrum;
    }

    /**
     * Sets the spectrum.
     *
     * @param spectrum the spectrum to set
     */
    public void setSpectrum(StellarSpectrum spectrum) {
        this.spectrum = spectrum;
    }

}
