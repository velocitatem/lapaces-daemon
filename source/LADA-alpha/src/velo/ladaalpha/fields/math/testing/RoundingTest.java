package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.LMath;

class RoundingTest {

	@Test
	void test() {
		double x = 6.12571275125;
		assertEquals(6.125, LMath.round(x, 3));
	}

}
