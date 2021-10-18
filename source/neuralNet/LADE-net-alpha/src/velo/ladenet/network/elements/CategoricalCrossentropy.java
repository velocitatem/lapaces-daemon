package velo.ladenet.network.elements;

import velo.ladenet.math.LadeMath;

public class CategoricalCrossentropy extends Loss{
	
	@Override
	public double[][] forward(double[][] input, double[] y) {
		int sampleLength = input.length;
		double[][] clippedInput = LadeMath.clip(input);
		double loss = 0;
		for(int row = 0 ; row < input.length ; row += 1) {
			for(int col = 0 ; col < input[row].length ; col += 1) {
				double val = input[row][col];
				loss += (val*y[col]);
			}
		}
		return null;
	}
	
}
