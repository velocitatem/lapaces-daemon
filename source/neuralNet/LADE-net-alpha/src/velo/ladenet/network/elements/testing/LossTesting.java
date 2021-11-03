package velo.ladenet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import javax.management.DescriptorKey;

import org.junit.jupiter.api.Test;

import velo.ladenet.math.LadeMath;
import velo.ladenet.network.elements.CategoricalCrossentropy;
import velo.ladenet.network.elements.Loss;

class LossTesting {

	double[][] outputs = {
			{0.7, 0.1, 0.2},
			{0.1, 0.5, 0.4},
			{0.02, 0.9, 0.08}		
	},
			targets = {
					{1.0, 0.0, 0.0},
					{0.0, 1.0 , 0.0},
					{0.0, 1.0 , 0.0}					
			};
	
	@Test	
	void catCrossEnt() {		
		CategoricalCrossentropy catLog = new CategoricalCrossentropy();
		double r = catLog.calculate(outputs, targets);
		assertEquals(0.38506088005216804, r);
	}

}
