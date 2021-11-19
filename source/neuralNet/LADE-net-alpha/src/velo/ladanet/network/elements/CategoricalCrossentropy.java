package velo.ladanet.network.elements;

import velo.ladanet.math.LadeMath;

public class CategoricalCrossentropy extends Loss{
	
	
	@Override	
	public void backward(double[][] dvalues, double[][] y) {
		int samples = dvalues.length, labels = dvalues[0].length;
		super.dinputs = new double[samples][labels];
		for(int r = 0 ;r < dvalues.length ; r += 1) {			
			for(int c = 0 ; c < dvalues[r].length ; c += 1) {
				double d = dvalues[r][c], yy = y[r][c];
				super.dinputs[r][c] = ((-yy) / d) / samples;
			}
		}
	}
	
	
	
	@Override
	public double[] forward(double[][] input, double[][] y) {
		int sampleLength = input.length;
		double[][] clippedInput = LadeMath.clip(input);
		double[] loss = new double[sampleLength];
		for(int row = 0 ; row < clippedInput.length ; row += 1) {
			double o = 0;
			for(int col = 0 ; col < clippedInput[row].length ; col += 1) {
				double val = clippedInput[row][col];				
				o += (Math.log(val)*y[row][col]);
			}
			loss[row] = -o;
		}
		return loss;
	}
	
}
