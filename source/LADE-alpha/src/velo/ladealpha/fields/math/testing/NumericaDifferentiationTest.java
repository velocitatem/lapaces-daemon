package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.calculus.Limits;
import velo.ladealpha.fields.math.calculus.NumericalDifferentiation;

class NumericaDifferentiationTest {

	@Test
	void test() {
		double x = 7.5;
		class f extends Equation {
			@Override
			public double compute(double x) {
				return Math.tan((6*x) / 2);
			}
		}
		assertEquals(3.93359, NumericalDifferentiation.differentiate(new f(), x));
		
	}

}
