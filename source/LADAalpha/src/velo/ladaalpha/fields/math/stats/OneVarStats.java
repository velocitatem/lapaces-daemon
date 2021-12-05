package velo.ladaalpha.fields.math.stats;

import velo.ladaalpha.misc.SortingAlgorithms;

import java.util.Arrays;

// TODO: Auto-generated Javadoc

/**
 * The Class OneVarStats.
 */
public class OneVarStats {

    /**
     * The iqr.
     */
    private Double xBar = 0.0, sumX = 0.0, sumX2 = 0.0, SD = 0.0, n = 0.0, minX = 0.0, q1 = 0.0, med = 0.0, q3 = 0.0,
            maxX = 0.0, iqr = 0.0;

    /**
     * The arrx.
     */
    private double[] arr, arrx;

    /**
     * Quartiles.
     *
     * @param val the val
     * @return the double[]
     */
    private double[] Quartiles(double[] val) {
        double[] ans = new double[3];

        for (int quartileType = 1; quartileType < 4; quartileType++) {
            float length = val.length + 1;
            double quartile;
            float newArraySize = (length * ((float) (quartileType) * 25 / 100)) - 1;
            if (newArraySize % 1 == 0) {
                quartile = val[(int) (newArraySize)];
            } else {
                int newArraySize1 = (int) (newArraySize);
                quartile = (val[newArraySize1] + val[newArraySize1 + 1]) / 2;
            }
            ans[quartileType - 1] = quartile;
        }
        return ans;
    }

    /**
     * Instantiates a new one var stats.
     *
     * @param arr the arr
     */
    public OneVarStats(double[] arr) {
        super();
        this.arr = arr;
        compute();
    }


    /**
     * Compute.
     */
    private void compute() {
        this.n = 1.0 * arr.length;
        for (Double d : arr) {
            this.sumX += d;
        }
        this.xBar = sumX / n;
        for (Double d : arr) {
            this.sumX2 += d * d;
        }
        double sumMeanDiffSQ = 0, sumMeanDiffSQP = 0;
        for (double d : arr) {
            sumMeanDiffSQ += Math.pow(d - this.xBar, 2);
        }
        SD = Math.sqrt(sumMeanDiffSQ / (n - 1));
        double[] sorted = SortingAlgorithms.insertionSort(arr);
        minX = sorted[0];
        maxX = sorted[sorted.length - 1];
        double[] qs = Quartiles(sorted);
        q1 = qs[0];
        med = qs[1];
        q3 = qs[2];
        iqr = q3 - q1;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "OneVarStats [xBar=" + xBar + ", sumX=" + sumX + ", sumX2=" + sumX2 + ", SD=" + SD + ", n=" + n
                + ", minX=" + minX + ", q1=" + q1 + ", med=" + med + ", q3=" + q3 + ", maxX=" + maxX + ", iqr=" + iqr
                + ", arr=" + Arrays.toString(arr) + "]";
    }

    /**
     * Gets the x bar.
     *
     * @return the x bar
     */
    public Double getxBar() {
        return xBar;
    }

    /**
     * Sets the x bar.
     *
     * @param xBar the new x bar
     */
    public void setxBar(Double xBar) {
        this.xBar = xBar;
    }

    /**
     * Gets the sum X.
     *
     * @return the sum X
     */
    public Double getSumX() {
        return sumX;
    }

    /**
     * Sets the sum X.
     *
     * @param sumX the new sum X
     */
    public void setSumX(Double sumX) {
        this.sumX = sumX;
    }

    /**
     * Gets the sum X 2.
     *
     * @return the sum X 2
     */
    public Double getSumX2() {
        return sumX2;
    }

    /**
     * Sets the sum X 2.
     *
     * @param sumX2 the new sum X 2
     */
    public void setSumX2(Double sumX2) {
        this.sumX2 = sumX2;
    }

    /**
     * Gets the sd.
     *
     * @return the sd
     */
    public Double getSD() {
        return SD;
    }

    /**
     * Sets the sd.
     *
     * @param sD the new sd
     */
    public void setSD(Double sD) {
        SD = sD;
    }

    /**
     * Gets the n.
     *
     * @return the n
     */
    public Double getN() {
        return n;
    }

    /**
     * Sets the n.
     *
     * @param n the new n
     */
    public void setN(Double n) {
        this.n = n;
    }

    /**
     * Gets the min X.
     *
     * @return the min X
     */
    public Double getMinX() {
        return minX;
    }

    /**
     * Sets the min X.
     *
     * @param minX the new min X
     */
    public void setMinX(Double minX) {
        this.minX = minX;
    }

    /**
     * Gets the q1.
     *
     * @return the q1
     */
    public Double getQ1() {
        return q1;
    }

    /**
     * Sets the q1.
     *
     * @param q1 the new q1
     */
    public void setQ1(Double q1) {
        this.q1 = q1;
    }

    /**
     * Gets the med.
     *
     * @return the med
     */
    public Double getMed() {
        return med;
    }

    /**
     * Sets the med.
     *
     * @param med the new med
     */
    public void setMed(Double med) {
        this.med = med;
    }

    /**
     * Gets the q3.
     *
     * @return the q3
     */
    public Double getQ3() {
        return q3;
    }

    /**
     * Sets the q3.
     *
     * @param q3 the new q3
     */
    public void setQ3(Double q3) {
        this.q3 = q3;
    }

    /**
     * Gets the max X.
     *
     * @return the max X
     */
    public Double getMaxX() {
        return maxX;
    }

    /**
     * Sets the max X.
     *
     * @param maxX the new max X
     */
    public void setMaxX(Double maxX) {
        this.maxX = maxX;
    }

    /**
     * Gets the iqr.
     *
     * @return the iqr
     */
    public Double getIqr() {
        return iqr;
    }

    /**
     * Sets the iqr.
     *
     * @param iqr the new iqr
     */
    public void setIqr(Double iqr) {
        this.iqr = iqr;
    }

    /**
     * Gets the arr.
     *
     * @return the arr
     */
    public double[] getArr() {
        return arr;
    }

    /**
     * Sets the arr.
     *
     * @param arr the new arr
     */
    public void setArr(double[] arr) {
        this.arr = arr;
    }

}
