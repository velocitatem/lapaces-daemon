package velo.ladaalpha.fields.math.calculus;

import velo.ladaalpha.fields.math.Equation;

// TODO: Auto-generated Javadoc

/**
 * The Class Limits.
 */
public class Limits {


    /**
     * The prec diff.
     */
    public static double precDiff = 0.000001;

    /**
     * Limit.
     *
     * @param eq the eq
     * @param x  the x
     * @return the double
     */
    public static double limit(Equation eq, double x) {
        double eval = eq.compute(x);
        int i = 1;
        while (i <= 100) {
            double delta = Math.pow(10, -(i));
            double rap = eq.compute(x + delta), ran = eq.compute(x - delta);
            if (Math.abs(rap - ran) <= precDiff) {
                return ((rap + ran) / 2);
            }
            i += 1;
        }
        return Double.NaN;
    }
}
