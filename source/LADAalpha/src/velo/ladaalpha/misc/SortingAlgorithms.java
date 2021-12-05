package velo.ladaalpha.misc;

// TODO: Auto-generated Javadoc

/**
 * The Class SortingAlgorithms.
 */
public class SortingAlgorithms {

    /**
     * Insertion sort.
     *
     * @param arr the arr
     * @return the double[]
     */
    public static double[] insertionSort(double[] arr) {
        for (int x = 1; x < arr.length; x++) {
            double current = arr[x];
            int y = x - 1;
            while (y >= 0 && current < arr[y]) {
                arr[y + 1] = arr[y];
                y--;
            }
            arr[y + 1] = current;
        }
        return arr;
    }

    /**
     * Bubble sort.
     *
     * @param arr the arr
     * @return the double[]
     */
    public static double[] bubbleSort(double[] arr) {
        int n = arr.length;
        double tmp = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 1; y < (n - x); y++) {
                if (arr[y - 1] > arr[y]) {
                    // swap elements
                    tmp = arr[y - 1];
                    arr[y - 1] = arr[y];
                    arr[y] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * Selection sort.
     *
     * @param arr the arr
     * @return the double[]
     */
    public static double[] selectionSort(double[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            int indx = x;
            for (int y = x + 1; y < arr.length; y++) {
                if (arr[y] < arr[indx]) {
                    indx = y;
                }
            }
            double smallNumber = arr[indx];
            arr[indx] = arr[x];
            arr[x] = smallNumber;
        }
        return arr;
    }

    /**
     * Merge.
     *
     * @param array   the array
     * @param lowval  the lowval
     * @param midval  the midval
     * @param highval the highval
     */
    static void merge(double[] array, int lowval, int midval, int highval) {
        int x, y, k;
        double[] c = new double[highval - lowval + 1];
        k = 0;
        x = lowval;
        y = midval + 1;
        while (x <= midval && y <= highval) {
            if (array[x] <= array[y]) {
                c[k++] = array[x++];
            } else {
                c[k++] = array[y++];
            }
        }
        while (x <= midval) {
            c[k++] = array[x++];
        }
        while (y <= highval) {
            c[k++] = array[y++];
        }
        k = 0;
        for (x = lowval; x <= highval; x++) {
            array[x] = c[k++];
        }
    }

    /**
     * Merge sort.
     *
     * @param array   the array
     * @param lowval  the lowval
     * @param highval the highval
     * @return the double[]
     */
    public static double[] mergeSort(double[] array, int lowval, int highval) {
        if (highval - lowval + 1 > 1) {
            int midval = (lowval + highval) / 2;
            mergeSort(array, lowval, midval);
            mergeSort(array, midval + 1, highval);
            merge(array, lowval, midval, highval);
        }
        return array;
    }


}
