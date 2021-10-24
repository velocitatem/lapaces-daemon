package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.calculus.Limits;

class LimitsTest {

	@Test
	void test() {
		class f extends Equation {  @Override public double compute(double x) { return ((x-4)*(x+9)) / (x-4);}} // has a removable hole discontinuity
		assertEquals(13.0, Limits.limit(new f(), 4));
	}

}
