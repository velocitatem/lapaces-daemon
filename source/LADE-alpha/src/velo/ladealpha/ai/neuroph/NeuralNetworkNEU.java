package velo.ladealpha.ai.neuroph;

import org.neuroph.core.Layer;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.nnet.Perceptron;

public class NeuralNetworkNEU {
	public NeuralNetworkNEU() {
		NeuralNetwork ann = new Perceptron(10, 3);
		Layer l = new Layer(),
				inputLayer = new Layer(),
				hiddenLayerOne = new Layer();
		ann.addLayer(0, l);
		ann.setInputNeurons(l.getNeurons());
		
	}
}
