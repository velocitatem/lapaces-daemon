package velo.ladaalpha.fields.math;

// TODO: Auto-generated Javadoc

/**
 * The Class Line.
 */
public class Line {

    /**
     * The y 2.
     */
    private double x1, x2, y1, y2;

    /**
     * The f.
     */
    LinearFunction f;

    /**
     * Instantiates a new line.
     *
     * @param a the a
     * @param b the b
     */
    public Line(Point a, Point b) {
        x1 = a.getX();
        x2 = b.getX();
        y1 = a.getY();
        y2 = b.getY();
        computeFunction();
    }

    /**
     * Lerp.
     *
     * @param t the t
     * @param a the a
     * @param b the b
     * @return the double
     */
    private double lerp(double t, double a, double b) {
        return (1 - t) * a + t * b;
    }

    /**
     * Lerp.
     *
     * @param t the t
     * @return the point
     */
    public Point lerp(double t) {
        double x = lerp(t, x1, x2), y = lerp(t, y1, y2);
        return new Point(x, y);
    }

    /**
     * Compute function.
     */
    private void computeFunction() {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);
        f = new LinearFunction(m, b);
    }

    /**
     * Compute.
     *
     * @param x the x
     * @return the double
     */
    public double compute(double x) {
        return f.compute(x);
    }

    /**
     * Instantiates a new line.
     *
     * @param x1 the x 1
     * @param x2 the x 2
     * @param y1 the y 1
     * @param y2 the y 2
     */
    public Line(double x1, double x2, double y1, double y2) {
        super();
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        computeFunction();
    }

    /**
     * Gets the x1.
     *
     * @return the x1
     */
    public double getX1() {
        return x1;
    }

    /**
     * Sets the x1.
     *
     * @param x1 the new x1
     */
    public void setX1(double x1) {
        this.x1 = x1;
    }

    /**
     * Gets the x2.
     *
     * @return the x2
     */
    public double getX2() {
        return x2;
    }

    /**
     * Sets the x2.
     *
     * @param x2 the new x2
     */
    public void setX2(double x2) {
        this.x2 = x2;
    }

    /**
     * Gets the y1.
     *
     * @return the y1
     */
    public double getY1() {
        return y1;
    }

    /**
     * Sets the y1.
     *
     * @param y1 the new y1
     */
    public void setY1(double y1) {
        this.y1 = y1;
    }

    /**
     * Gets the y2.
     *
     * @return the y2
     */
    public double getY2() {
        return y2;
    }

    /**
     * Sets the y2.
     *
     * @param y2 the new y2
     */
    public void setY2(double y2) {
        this.y2 = y2;
    }

}
