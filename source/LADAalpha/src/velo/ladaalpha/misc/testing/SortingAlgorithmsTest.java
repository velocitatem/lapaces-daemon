package velo.ladaalpha.misc.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.misc.SortingAlgorithms;
import static org.junit.jupiter.api.Assertions.assertEquals;
// TODO: Auto-generated Javadoc

/**
 * The Class SortingAlgorithmsTest.
 */
class SortingAlgorithmsTest {

    /**
     * Gets the v.
     *
     * @return the v
     */
    double[] getv() {
        return new double[]{0, 0.4, -0.4, 2.5, -0.8, -1};
    }

    /**
     * Test.
     */
    @Test
    void test() {
        double[] vec = {0, 0.4, -0.4, 2.5, -0.8, -1};
        assertEquals(-1.0, SortingAlgorithms.bubbleSort(vec)[0]);

        vec = getv();

        assertEquals(-1.0, SortingAlgorithms.insertionSort(vec)[0]);

        vec = getv();

        assertEquals(-1.0, SortingAlgorithms.mergeSort(vec, 0, vec.length - 1)[0]);

        vec = getv();

        assertEquals(-1.0, SortingAlgorithms.selectionSort(vec)[0]);

        vec = getv();
    }

}
