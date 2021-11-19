package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.Equation;
import velo.ladaalpha.fields.math.LMath;
import velo.ladaalpha.fields.math.calculus.TaylorSeries;

class TaylorSeriesTest {

	Equation e = new Equation().equationFromString("x * Math.pow(x -2, 2)");
	@Test
	void test() {
		Equation ts = TaylorSeries.computeCenteredAt(e, 2);
		assertEquals(0.3749, LMath.round(ts.compute(1.5), 4));
	}

}
