package velo.ladanet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladanet.math.LadeMath;

class MaxTest {

	@Test
	void test() {
		double[][] vec = {{-0.5, 1, 0.0001, -5.5}};
		double[][] mod = LadeMath.maximum(vec);
		assertEquals(mod[0][0], 0.0);
		assertEquals(mod[0][3], 0.0);
	}

}

