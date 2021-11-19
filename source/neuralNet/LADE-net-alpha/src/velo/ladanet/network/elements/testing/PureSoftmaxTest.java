package velo.ladanet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladanet.network.elements.SoftmaxActivation;

class PureSoftmaxTest {

	@Test
	void test() {
		double[][] input = {
				{1, 2, 3},				
		};
		SoftmaxActivation sac = new SoftmaxActivation();
		sac.forward(input);
		assertEquals(0.24472847105479764, sac.getOutput()[0][1]);
	}

}
