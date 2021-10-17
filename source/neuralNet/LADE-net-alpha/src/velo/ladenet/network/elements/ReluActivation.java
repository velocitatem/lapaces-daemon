package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;

public class ReluActivation {
	private double[] output;
	public void forward(double[] inputs) {
		this.output = LadeMath.max(inputs);
	}
	public double[] getOutput() {
		return output;
	}	
}
