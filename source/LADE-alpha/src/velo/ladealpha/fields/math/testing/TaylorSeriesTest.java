package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.Equation;
import velo.ladealpha.fields.math.LMath;
import velo.ladealpha.fields.math.calculus.TaylorSeries;

class TaylorSeriesTest {

	Equation e = new Equation().equationFromString("x * Math.pow(x -2, 2)");
	@Test
	void test() {
		Equation ts = TaylorSeries.computeCenteredAt(e, 2);
		assertEquals(0.375, LMath.round(ts.compute(1.5), 4));
	}

}
