package velo.ladenet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladenet.math.LadeMath;
import velo.ladenet.visual.Visualizer;

class Transposition {

	@Test
	void test() {
		double[][] matrix = {
				{1, 2, 3},
				{4, 5, 6}				
		},
				expected = {
						{1, 4},
						{2, 5},
						{3, 6}
				};		
		double[][] transposed = LadeMath.transpose(matrix);
		assertEquals(expected[2][1], transposed[2][1]);
	}

}
