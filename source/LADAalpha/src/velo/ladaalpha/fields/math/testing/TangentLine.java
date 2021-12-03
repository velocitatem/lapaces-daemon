package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.NumericalDifferentiation;

// TODO: Auto-generated Javadoc
/**
 * The Class TangentLine.
 */
class TangentLine {

	/**
	 * Test.
	 */
	@Test
	void test() {
		Equation eq = new Equation().equationFromString("4 * Math.pow(x, 2)");
		assertEquals(16.0, eq.compute(2));
		assertEquals(-15, (int)NumericalDifferentiation.tangentLine(eq, 2).getB());
	}

}
