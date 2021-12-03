package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.calculus.Limits;

// TODO: Auto-generated Javadoc
/**
 * The Class LimitsTest.
 */
class LimitsTest {

	/**
	 * Test.
	 */
	@Test
	void test() {
		class f extends Equation {  @Override public double compute(double x) { return ((x-4)*(x+9)) / (x-4);}} // has a removable hole discontinuity
		assertEquals(13, (int)Limits.limit(new f(), 4));
	}

}
