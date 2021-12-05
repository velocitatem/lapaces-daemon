package velo.ladaalpha.fields.math.stats;

import velo.ladaalpha.fields.math.LinearFunction;

// TODO: Auto-generated Javadoc

/**
 * The Class Regression.
 */
public class Regression {

    /**
     * Lsrl.
     *
     * @param x the x
     * @param y the y
     * @return the linear function
     */
    public static LinearFunction LSRL(double[] x, double[] y) {
        return new LSRL(x, y).compute();
    }
}
