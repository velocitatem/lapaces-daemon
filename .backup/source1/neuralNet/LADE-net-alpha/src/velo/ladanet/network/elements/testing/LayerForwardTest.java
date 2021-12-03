package velo.ladanet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladanet.network.elements.Layer;

class LayerForwardTest {

	@Test
	void test() {
		Layer layer = new Layer(3, 6);
		layer.forward(new double[][] {{2, 4, 6}});
		assertEquals(layer.getOutput()[0].length, 6);
	}

}
