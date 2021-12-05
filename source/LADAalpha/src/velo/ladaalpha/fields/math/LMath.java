package velo.ladaalpha.fields.math;

// TODO: Auto-generated Javadoc

/**
 * The Class LMath.
 */
public class LMath {


    /**
     * Factorial.
     *
     * @param number the number
     * @return the double
     */
    public static double factorial(double number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    /**
     * Round.
     *
     * @param x the x
     * @param p the p
     * @return the double
     */
    public static double round(double x, double p) {
        int m = (int) Math.pow(10, p);
        return ((double) (int) (x * m)) / m;
    }
}
