package velo.ladealpha.ai.dl4j;

import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.learning.config.Sgd;
import org.nd4j.linalg.lossfunctions.LossFunctions;

public class DeepModel {
	private MultiLayerConfiguration config;
	private MultiLayerNetwork model;
	public DeepModel() {
		int numInputs = 5;
		int outputNum = 2;
		config = new NeuralNetConfiguration.Builder()	            
	            .activation(Activation.SIGMOID)
	            .weightInit(WeightInit.XAVIER)
	            .updater(new Sgd(0.1))
	            .l2(1e-4)
	            .list()
	            .layer(new DenseLayer.Builder().nIn(numInputs).nOut(3)
	                .build())
	            .layer(new DenseLayer.Builder().nIn(3).nOut(3)
	                .build())
	            .layer( new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
	                .activation(Activation.SOFTMAX)
	                .nIn(3).nOut(outputNum).build())
	            .build();
		this.model = new MultiLayerNetwork(config);		
	}
	public void initModel() {
		this.model.init();
	}
	public void train(DataSet set) {
		for(int i = 0 ; i < 1000; i += 1) {
			this.model.fit(set);
		}
	}
	
}
