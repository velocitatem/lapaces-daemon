package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;

public class CategoricalCrossentropy extends Loss{
	
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
