package velo.ladenet.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladenet.math.LadeMath;

class DotProduct {

	@Test
	void test() {
		double[][] matrix = {
				{1, 2, 3},
				{4, 5, 6}				
		},
				matrix2 = {
						{1, 4},
						{2, 5},
						{3, 6}
				};
		LadeMath.dot(matrix, matrix2);
	}

}
