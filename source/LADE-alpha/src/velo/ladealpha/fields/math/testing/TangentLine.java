package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;

class TangentLine {

	@Test
	void test() {
		Equation eq = new Equation().equationFromString("4 * Math.pow(x, 2)");
		assertEquals(16.0, eq.compute(2));
		assertEquals(-16.0, NumericalDifferentiation.tangentLine(eq, 2).getB());
	}

}
