package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class QuadraticFunction.
 */
class QuadraticFunction {

	/**
	 * Test.
	 */
	@Test
	void test() {
		velo.ladaalpha.fields.math.QuadraticFunction qf = new velo.ladaalpha.fields.math.QuadraticFunction(-4, 3, 1);
		double[] roots = qf.roots();
		
		assertEquals(-0.25, roots[0]);
		assertEquals(1.0, roots[1]);
		assertEquals(qf.compute(0), 1);
	}

}
