package velo.ladaalpha.fields.math;

// TODO: Auto-generated Javadoc

/**
 * The Class CombinationFormula.
 */
public class CombinationFormula {

    /**
     * Ncr.
     *
     * @param n the n
     * @param r the r
     * @return the double
     */
    public static double ncr(double n, double r) {
        return LMath.factorial(n) / (LMath.factorial(r) * LMath.factorial(n - r));
    }
}
