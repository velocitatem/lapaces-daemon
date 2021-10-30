package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;

public class Layer {
	private double[][] weights, output, inputs, dweights, dinputs;
	private double[] biases, dbiases;	
	public Layer(int inputs, int neurons) {
		weights = new double[inputs][neurons];
		biases = new double[neurons];
		for(int i = 0; i < inputs; i++) {
			for(int n = 0 ; n < neurons; n++) {
				weights[i][n] = Math.random() * 0.01;
			}
		}
		for(int n = 0 ; n < neurons;n+=1) {
			biases[n] = 0;
		}
		
	}
	public void forward(double[][] inputs) {
		this.inputs = inputs;
		this.output = LadeMath.addMatrxAndVector(LadeMath.dot(inputs, LadeMath.transpose(weights)), biases); // TODO add biases
	}
	public void backward(double[][] dvalues) {
		this.dweights = LadeMath.dot(LadeMath.transpose(inputs), dvalues);
		dbiases = new double[biases.length];
		int i =0;
		for(double[] row : dvalues) {
			dbiases[i] = LadeMath.vectorSum(row);
			i+=1;
		}
		this.dinputs = LadeMath.dot(dvalues, LadeMath.transpose(weights));
		
	}
	public double[][] getOutput() {
		return output;
	}
	
}
