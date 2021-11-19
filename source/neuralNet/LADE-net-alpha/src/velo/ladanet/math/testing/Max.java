package velo.ladanet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladanet.math.LadeMath;

class Max {

	@Test
	void test() {
		double[] mat = {-5, 199, 2};
		assertEquals(mat[1], LadeMath.max(mat));
	}

}
