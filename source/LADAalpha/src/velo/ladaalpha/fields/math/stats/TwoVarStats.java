package velo.ladaalpha.fields.math.stats;

import java.util.Arrays;

// TODO: Auto-generated Javadoc

/**
 * The Class TwoVarStats.
 */
public class TwoVarStats {

    /**
     * The r 2.
     */
    private double xBar, sumX, sumX2, sX, n, yBar, sumY, sumY2, sY, sumXY, minX, maxX, minY, maxY, r, r2;

    /**
     * The y.
     */
    private double[] x, y;

    /**
     * Instantiates a new two var stats.
     *
     * @param x the x
     * @param y the y
     */
    public TwoVarStats(double[] x, double[] y) {
        this.x = x;
        this.y = y;
        OneVarStats ovsX = new OneVarStats(x), ovsY = new OneVarStats(y);
        n = x.length - y.length == 0 ? x.length : -1;
        if (n == -1) return;
        xBar = ovsX.getxBar();
        sumX = ovsX.getSumX();
        sumX2 = ovsX.getSumX2();
        sX = ovsX.getSD();
        yBar = ovsY.getxBar();
        sumY = ovsY.getSumX();
        sumY2 = ovsY.getSumX2();
        sY = ovsY.getSD();
        double sum1 = 0, sum2 = 0, sum3 = 0;
        int i = 0;
        for (double xx : x) {
            double yy = y[i];
            sum1 += (xx - xBar) * (yy - yBar);
            i += 1;
        }
        i = 0;
        for (double xx : x) {
            sum2 += Math.pow(xx - xBar, 2);
        }
        i = 0;
        for (double yy : y) {
            sum3 += Math.pow(yy - yBar, 2);
        }
        r = (sum1) / Math.sqrt(sum2 * sum3);
        r2 = Math.pow(r, 2);
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "TwoVarStats [xBar=" + xBar + ", sumX=" + sumX + ", sumX2=" + sumX2 + ", sX=" + sX + ", n=" + n
                + ", yBar=" + yBar + ", sumY=" + sumY + ", sumY2=" + sumY2 + ", sY=" + sY + ", sumXY=" + sumXY
                + ", minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + ", r=" + r + ", r2=" + r2
                + ", x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y) + "]";
    }

    /**
     * Gets the x bar.
     *
     * @return the x bar
     */
    public double getxBar() {
        return xBar;
    }

    /**
     * Sets the x bar.
     *
     * @param xBar the new x bar
     */
    public void setxBar(double xBar) {
        this.xBar = xBar;
    }

    /**
     * Gets the sum X.
     *
     * @return the sum X
     */
    public double getSumX() {
        return sumX;
    }

    /**
     * Sets the sum X.
     *
     * @param sumX the new sum X
     */
    public void setSumX(double sumX) {
        this.sumX = sumX;
    }

    /**
     * Gets the sum X 2.
     *
     * @return the sum X 2
     */
    public double getSumX2() {
        return sumX2;
    }

    /**
     * Sets the sum X 2.
     *
     * @param sumX2 the new sum X 2
     */
    public void setSumX2(double sumX2) {
        this.sumX2 = sumX2;
    }

    /**
     * Gets the s X.
     *
     * @return the s X
     */
    public double getsX() {
        return sX;
    }

    /**
     * Sets the s X.
     *
     * @param sX the new s X
     */
    public void setsX(double sX) {
        this.sX = sX;
    }

    /**
     * Gets the n.
     *
     * @return the n
     */
    public double getN() {
        return n;
    }

    /**
     * Sets the n.
     *
     * @param n the new n
     */
    public void setN(double n) {
        this.n = n;
    }

    /**
     * Gets the y bar.
     *
     * @return the y bar
     */
    public double getyBar() {
        return yBar;
    }

    /**
     * Sets the y bar.
     *
     * @param yBar the new y bar
     */
    public void setyBar(double yBar) {
        this.yBar = yBar;
    }

    /**
     * Gets the sum Y.
     *
     * @return the sum Y
     */
    public double getSumY() {
        return sumY;
    }

    /**
     * Sets the sum Y.
     *
     * @param sumY the new sum Y
     */
    public void setSumY(double sumY) {
        this.sumY = sumY;
    }

    /**
     * Gets the sum Y 2.
     *
     * @return the sum Y 2
     */
    public double getSumY2() {
        return sumY2;
    }

    /**
     * Sets the sum Y 2.
     *
     * @param sumY2 the new sum Y 2
     */
    public void setSumY2(double sumY2) {
        this.sumY2 = sumY2;
    }

    /**
     * Gets the s Y.
     *
     * @return the s Y
     */
    public double getsY() {
        return sY;
    }

    /**
     * Sets the s Y.
     *
     * @param sY the new s Y
     */
    public void setsY(double sY) {
        this.sY = sY;
    }

    /**
     * Gets the sum XY.
     *
     * @return the sum XY
     */
    public double getSumXY() {
        return sumXY;
    }

    /**
     * Sets the sum XY.
     *
     * @param sumXY the new sum XY
     */
    public void setSumXY(double sumXY) {
        this.sumXY = sumXY;
    }

    /**
     * Gets the min X.
     *
     * @return the min X
     */
    public double getMinX() {
        return minX;
    }

    /**
     * Sets the min X.
     *
     * @param minX the new min X
     */
    public void setMinX(double minX) {
        this.minX = minX;
    }

    /**
     * Gets the max X.
     *
     * @return the max X
     */
    public double getMaxX() {
        return maxX;
    }

    /**
     * Sets the max X.
     *
     * @param maxX the new max X
     */
    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    /**
     * Gets the min Y.
     *
     * @return the min Y
     */
    public double getMinY() {
        return minY;
    }

    /**
     * Sets the min Y.
     *
     * @param minY the new min Y
     */
    public void setMinY(double minY) {
        this.minY = minY;
    }

    /**
     * Gets the max Y.
     *
     * @return the max Y
     */
    public double getMaxY() {
        return maxY;
    }

    /**
     * Sets the max Y.
     *
     * @param maxY the new max Y
     */
    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }

    /**
     * Gets the r.
     *
     * @return the r
     */
    public double getR() {
        return r;
    }

    /**
     * Sets the r.
     *
     * @param r the new r
     */
    public void setR(double r) {
        this.r = r;
    }

    /**
     * Gets the r2.
     *
     * @return the r2
     */
    public double getR2() {
        return r2;
    }

    /**
     * Sets the r2.
     *
     * @param r2 the new r2
     */
    public void setR2(double r2) {
        this.r2 = r2;
    }

    /**
     * Gets the x.
     *
     * @return the x
     */
    public double[] getX() {
        return x;
    }

    /**
     * Sets the x.
     *
     * @param x the new x
     */
    public void setX(double[] x) {
        this.x = x;
    }

    /**
     * Gets the y.
     *
     * @return the y
     */
    public double[] getY() {
        return y;
    }

    /**
     * Sets the y.
     *
     * @param y the new y
     */
    public void setY(double[] y) {
        this.y = y;
    }


}
