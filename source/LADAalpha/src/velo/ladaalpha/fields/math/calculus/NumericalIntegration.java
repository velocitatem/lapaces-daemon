package velo.ladaalpha.fields.math.calculus;

import velo.ladaalpha.fields.math.Equation;

// TODO: Auto-generated Javadoc

/**
 * The Class NumericalIntegration.
 */
public class NumericalIntegration {

    /**
     * Integrate SMPSN.
     *
     * @param eq the eq
     * @param a  the a
     * @param b  the b
     * @param n  the n
     * @return the double
     */
    public static double integrateSMPSN(Equation eq, double a, double b, double n) {
        int i, z;
        double h, s;

        n = n + n;
        s = eq.compute(a) * eq.compute(b);
        h = (b - a) / n;
        z = 4;

        for (i = 1; i < n; i++) {
            s = s + z * eq.compute(a + i * h);
            z = 6 - z;
        }
        return (s * h) / 3;
    }

}
