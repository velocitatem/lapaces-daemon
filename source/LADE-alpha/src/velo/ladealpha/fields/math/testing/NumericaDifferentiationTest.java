package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.calculus.Limits;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;

class NumericaDifferentiationTest {
	double x = 7.5;

	class f extends Equation {
		@Override
		public double compute(double x) {
			return Math.tan((6 * x) / 2);
		}
	}

	@Test
	void test() {

		assertEquals(3, (int)NumericalDifferentiation.differentiate(new f(), x));

	}
	
	@Test
	void test2( ) {
		assertEquals(3,(int)NumericalDifferentiation.differentiate(new f()).compute(x));
	}

	@Test
	void highOrder() {
		System.out.println(NumericalDifferentiation.differentiate(
				new Equation().equationFromString("Math.pow(Math.sqrt(x), 4)"), 5, 3));
	}

}
