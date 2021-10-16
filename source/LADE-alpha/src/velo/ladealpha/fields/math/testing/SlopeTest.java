package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Slope;

class SlopeTest {

	@Test
	void test() {
		Slope y_1 = new Slope(2, -4);
		assertEquals(y_1.compute(0), -4);
		assertEquals(y_1.compute(4), 4);
	}

}
