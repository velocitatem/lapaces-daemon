package velo.ladenet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladenet.network.elements.Accuracy;

class AccuracyTest {

	double[][] outputs = {
			{0.7, 0.1, 0.2},
			{0.5, 0.1, 0.4},
			{0.02, 0.9, 0.08}		
	},
			targets = {
					{1.0, 0.0, 0.0},
					{0.0, 1.0 , 0.0},
					{0.0, 1.0 , 0.0}					
			};
	@Test
	void test() {
		assertEquals(2.0/3.0, Accuracy.accuracy(outputs, targets));
	}

}
