package velo.ladaalpha.fields.math.stats;

// TODO: Auto-generated Javadoc

import velo.ladaalpha.fields.math.LinearFunction;

/**
 * The Class LSRL.
 */
public class LSRL {

    /**
     * The y.
     */
    private final double[] x;
    private final double[] y;

    /**
     * Instantiates a new lsrl.
     *
     * @param x the x
     * @param y the y
     */
    public LSRL(double[] x, double[] y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compute.
     *
     * @return the linear function
     */
    public LinearFunction compute() {
        double[] xy = new double[x.length], x2 = new double[x.length];
        int i = 0;
        for (Double xv : this.x) {
            Double yv = y[i];
            xy[i] = yv * xv;
            x2[i] = xv * xv;
            i += 1;
        }
        double xSum = sum(this.x), ySum = sum(this.y), xySum = sum(xy), x2Sum = sum(x2);
        int n = x.length;
        double m = (n * xySum - (xSum * ySum)) / (n * x2Sum - Math.pow(xSum, 2)),
                b = (ySum - (m * xSum)) / (n);
        LinearFunction lf = new LinearFunction(m, b);
        return lf;

    }

    /**
     * Sum.
     *
     * @param arr the arr
     * @return the double
     */
    private double sum(double[] arr) {
        double sum = 0;

        for (double v : arr) {
            sum += v;
        }

        return sum;
    }
}
