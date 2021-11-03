package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;
import velo.ladenet.math.MatrixOps;

public class SoftmaxActivation {
	private double[][] output;
	
	public double[][] getOutput() {
		return output;
	}
 
	public void forward(double[][] input) {
		double[][] exp = LadeMath.exponentiate(input);
		double[][] norm = LadeMath.normalize(exp);
		this.output = norm;
	}
}
