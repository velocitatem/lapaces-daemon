package velo.ladanet.network.elements;

import velo.ladanet.math.LadeMath;

public class ReluActivation {
	private double[][] output, inputs, dinputs;
	public void forward(double[][] inputs) {
		this.inputs = inputs;
		this.output = LadeMath.maximum(inputs);
	}
	public void backward(double[][] dvalues) {
		this.dinputs = dvalues.clone();
		for(int r = 0 ; r < dinputs.length; r+=1) {
			double[] row = dinputs[r];
			for(int c = 0; c < row.length ; c += 1) {
				double val = this.inputs[r][c];
				if(val<=0) {
					dinputs[r][c] = 0;
				}
			}
		}
	}
	public double[][] getOutput() {
		return output;
	}	
}