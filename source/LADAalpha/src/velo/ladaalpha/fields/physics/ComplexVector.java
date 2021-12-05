package velo.ladaalpha.fields.physics;

// TODO: Auto-generated Javadoc

/**
 * The Class ComplexVector.
 */
public class ComplexVector {

    /**
     * The A y.
     */
    private final double A_x;
    private final double A_y;

    /**
     * The mod.
     */
    private static final double mod = 180 / Math.PI;

    /**
     * Instantiates a new complex vector.
     *
     * @param a_x the a x
     * @param a_y the a y
     */
    public ComplexVector(double a_x, double a_y) {
        super();
        A_x = a_x;
        A_y = a_y;
    }

    /**
     * Gets the magnitude.
     *
     * @return the magnitude
     */
    public double getMagnitude() {
        return Math.sqrt(Math.pow(A_x, 2) + Math.pow(A_y, 2));
    }

    /**
     * Vector given theta and magnitude.
     *
     * @param theta_radians the theta radians
     * @param magnitude     the magnitude
     * @return the complex vector
     */
    public static ComplexVector vectorGivenThetaAndMagnitude(double theta_radians, double magnitude) {
        double x = magnitude * (Math.cos(theta_radians)), y = magnitude * Math.sin(theta_radians);
        ComplexVector cvr = new ComplexVector(x, y);
        return cvr;
    }

    /**
     * Theta radians.
     *
     * @return the double
     */
    public double ThetaRadians() {
        return Math.atan(A_y / A_x);
    }


    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return A_x + "i + " + A_y + "j";
    }

    /**
     * Theta degrees.
     *
     * @return the double
     */
    public double ThetaDegrees() {
        return ThetaRadians() * mod;
    }
}
