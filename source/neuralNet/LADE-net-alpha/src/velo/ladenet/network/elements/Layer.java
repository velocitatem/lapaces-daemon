package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;

public class Layer {
	private double[][] weights, output;
	private double[] biases;	
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
		this.output = LadeMath.dot(inputs, this.weights);
	}
	public double[][] getOutput() {
		return output;
	}
	
}
