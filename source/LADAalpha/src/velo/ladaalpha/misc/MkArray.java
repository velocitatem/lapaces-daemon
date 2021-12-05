package velo.ladaalpha.misc;

// TODO: Auto-generated Javadoc

/**
 * The Class MkArray.
 */
public class MkArray {

    /**
     * Incremental double array.
     *
     * @param start the start
     * @param end   the end
     * @return the double[]
     */
    public static double[] IncrementalDoubleArray(int start, int end) {
        double[] out = new double[end - start + 1];
        for (int i = start; i < end; i += 1) {
            out[i] = 1.0 * i;
        }
        return out;
    }
}
