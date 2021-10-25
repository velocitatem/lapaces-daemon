package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;

class EquationFromString {

	@Test
	void test() {
		String eq = "Math.pow(2, x) + 2";
		double probe = 3.6, ex = 14.12573;
		Equation e = new Equation().equationFromString(eq);
		assertEquals((int)ex, (int)e.compute(probe));
		assertEquals(8, (int)NumericalDifferentiation.differentiate(e, 3.6));
	}

}
