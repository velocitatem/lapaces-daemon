package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.NumericalIntegration;

class IntegrationTest {

	@Test
	void test() {
		// CHANGE FILE NAM
		double inte = NumericalIntegration.integrate(new Equation().equationFromString("Math.pow(2,x)"), 0, 1, 5);
		assertEquals(14, (int)(inte*10));
	}

}
