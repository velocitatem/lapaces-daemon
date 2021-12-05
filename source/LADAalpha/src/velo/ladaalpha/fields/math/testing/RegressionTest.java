package velo.ladaalpha.fields.math.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.stats.Regression;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class RegressionTest.
 */
class RegressionTest {

    /**
     * Lsrs.
     */
    @Test
    void lsrs() {
        double[] x = {0, 1, 2, 3, 4}, y = {0, 6, 56, 216, 865.6};
        LinearFunction lf = Regression.LSRL(x, y);
        assertEquals(194, (int) lf.getM());
    }

}
