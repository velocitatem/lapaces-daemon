package velo.ladenet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladenet.network.elements.Layer;
import velo.ladenet.network.elements.ReluActivation;

class LayerForwardReluTest {

	@Test
	void test() {
		Layer layer = new Layer(3, 6);
		layer.forward(new double[][] {{2, 4, 6}});
		ReluActivation relu = new ReluActivation();
		relu.forward(layer.getOutput());	
	}

}
