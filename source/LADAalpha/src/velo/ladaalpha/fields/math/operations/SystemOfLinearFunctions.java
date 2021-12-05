package velo.ladaalpha.fields.math.operations;

import velo.ladaalpha.fields.math.LinearFunction;

// TODO: Auto-generated Javadoc

/**
 * The Class SystemOfLinearFunctions.
 */
public class SystemOfLinearFunctions {

    /**
     * The b.
     */
    private final LinearFunction a;
    private final LinearFunction b;

    /**
     * Instantiates a new system of linear functions.
     *
     * @param a the a
     * @param b the b
     */
    public SystemOfLinearFunctions(LinearFunction a, LinearFunction b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Solution.
     *
     * @return the double[]
     */
    public double[] solution() {
        double[] cords = new double[2];
        double compoundSlope = a.getM() + (-1 * (b.getM())),
                compoundIntercept = b.getB() + (-1 * (a.getB()));
        double x = compoundIntercept / compoundSlope;
        cords[0] = x;
        double sol0 = a.compute(x), sol1 = b.compute(x);
        if ((int) (sol0 - sol1) == 0) {
            cords[1] = sol0;
        }
        return cords;
    }
}
