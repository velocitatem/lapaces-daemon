package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.stats.LSRL;
import velo.ladaalpha.fields.math.stats.Regression;

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
		double[] x = {0, 1,2,3,4}, y = {0,6, 56, 216, 865.6};
		LinearFunction lf = Regression.LSRL(x, y);
		assertEquals(194, (int)lf.getM());
	}

}
