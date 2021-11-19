package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.LinearFunction;
import velo.ladaalpha.fields.math.operations.SystemOfLinearFunctions;

class LinearFunctionTest {

	@Test
	void test() {
		LinearFunction y_1 = new LinearFunction(2, -4); 
		assertEquals(y_1.compute(0), -4);
		assertEquals(y_1.compute(4), 4);
		LinearFunction y2 = new LinearFunction();
		y2.buildFromTwoPoints(6, 27, 19, 105);
		assertEquals((int)y2.getM(), 6);
		assertEquals((int)y2.getB(), -9);		
		SystemOfLinearFunctions sysofl = new SystemOfLinearFunctions(y_1, y2);
		double solx = 1.25, soly = -1.5;
		double[] sols = sysofl.solution();
		assertEquals(sols[0], solx);
		assertEquals(sols[1], soly);
	}

}
