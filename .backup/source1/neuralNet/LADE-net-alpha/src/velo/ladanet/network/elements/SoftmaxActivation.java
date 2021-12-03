package velo.ladanet.network.elements;

import velo.ladanet.math.LadeMath;
import velo.ladanet.math.MatrixOps;

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
