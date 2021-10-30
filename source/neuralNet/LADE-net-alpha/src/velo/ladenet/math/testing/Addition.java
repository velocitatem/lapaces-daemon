package velo.ladenet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladenet.math.LadeMath;

class Addition {

	@Test
	void test() {
		double[][] inputs = {{1.0, 2.0, 3.0, 2.5},
		                     {2.0, 5.0, -1.0, 2.0},
		                     {-1.5, 2.7, 3.3, -0.8}},
				weights = {
						{0.2, 0.8, -0.5, 1.0},
						{0.5, -0.91, 0.26, -0.5},
						{-0.26, -0.27, 0.17, 0.87}
				};
		double[] biasess = {2, 3, 0.5};
		
		double[][] out = LadeMath.addMatrxAndVector(LadeMath.dot(inputs, LadeMath.transpose(weights)), biasess);
		assertEquals(1.21, out[0][1]);
	}

}
