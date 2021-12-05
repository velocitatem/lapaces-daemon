package velo.ladaalpha.fields.math.stats;

// TODO: Auto-generated Javadoc

/**
 * The Class Scores.
 */
public class Scores {

    /**
     * Z score.
     *
     * @param x     the x
     * @param mu    the mu
     * @param sigma the sigma
     * @return the double
     */
    public static double zScore(double x, double mu, double sigma) {
        return (x - mu) / sigma;
    }
}
