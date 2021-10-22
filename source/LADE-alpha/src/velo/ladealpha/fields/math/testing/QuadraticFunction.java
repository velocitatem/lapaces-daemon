package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuadraticFunction {

	@Test
	void test() {
		velo.ladealpha.fields.math.QuadraticFunction qf = new velo.ladealpha.fields.math.QuadraticFunction(-4, 3, 1);
		double[] roots = qf.roots();
		
		assertEquals(-0.25, roots[0]);
		assertEquals(1.0, roots[1]);
		assertEquals(qf.compute(0), 1);
	}

}
