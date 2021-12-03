package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.NumericalDifferentiation;

// TODO: Auto-generated Javadoc
/**
 * The Class EquationFromString.
 */
class EquationFromString {

	/**
	 * Test.
	 */
	@Test
	void test() {
		String eq = "Math.pow(2, x) + 2";
		double probe = 3.6, ex = 14.12573;
		Equation e = new Equation().equationFromString(eq);
		assertEquals((int)ex, (int)e.compute(probe));
		assertEquals(8, (int)NumericalDifferentiation.differentiate(e, 3.6));
	}

}
