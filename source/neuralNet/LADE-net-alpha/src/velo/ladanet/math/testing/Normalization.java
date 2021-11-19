package velo.ladanet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladanet.math.LadeMath;

class Normalization {

	@Test
	void test() {
		double[][] mat = {
				{1, 4, 6},
				{5, 100, 19}				
		};
		double[][] norm = LadeMath.normalize(mat);
		// sum check
		assertEquals(Math.round(LadeMath.vectorSum(norm[0])), 1);
		assertEquals(Math.round(LadeMath.vectorSum(norm[1])), 1);
	}

}
