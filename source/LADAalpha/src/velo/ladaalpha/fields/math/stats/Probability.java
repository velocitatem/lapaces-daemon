package velo.ladaalpha.fields.math.stats;

// TODO: Auto-generated Javadoc

/**
 * The Class Probability.
 */
public class Probability {

    /**
     * Simulate.
     *
     * @param trials the trials
     * @param prob   the prob
     * @return the double
     */
    public static double simulate(int trials, Double prob) {
        double occurances = 0;
        for (int i = 0; i < trials; i += 1)
            if (Math.random() < prob)
                occurances += 1;
        return (occurances / trials);
    }
}
