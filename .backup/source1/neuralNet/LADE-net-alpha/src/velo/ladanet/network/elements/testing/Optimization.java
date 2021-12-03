package velo.ladanet.network.elements.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import velo.ladanet.math.LadeMath;
import velo.ladanet.network.elements.ReluActivation;

class Optimization {

	@Test
	void test() {
		double[][] dvalues = {
				
				{1, 1, 1},
				{2, 2, 2},
				{3, 3, 3}
				
		},
				inputs = {
						{1, 2, 3, 2.5},
						{2, 5, -1, 2},
						{-1.5, 2.7, 3.3, -0.8}
				},
				weights = {
						{0.2, 0.8, -0.5, 1},
						{0.5, -0.91, 0.26, -0.5},
						{-0.26, -0.27, 0.17, 0.87}
				},
				biases = {{2, 3, 0.5}};
		
		weights = LadeMath.transpose(weights);
		
		double[][] out = LadeMath.addMatrxAndVector(LadeMath.dot(inputs, weights), biases[0]);
		ReluActivation ra = new ReluActivation();
		ra.forward(out);
		double[][] drelu = ra.getOutput();
		for(int r = 0 ; r < drelu.length; r+=1) {
			double[] row = drelu[r];
			for(int c = 0; c < row.length ; c += 1) {
				double val = row[c];
				if(val<=0) {
					drelu[r][c] = 0;
				}
			}
		}
		
		
		double[][] dinputs = LadeMath.dot(drelu, LadeMath.transpose(weights)),
				dweights = LadeMath.dot(LadeMath.transpose(inputs), drelu);
		
		double[] dbiases = new double[biases[0].length];
		
		System.out.println(drelu.length);
		
		int i =0;
		for(double[] row : drelu) {
			dbiases[i] = LadeMath.vectorSum(row);
			i+=1;
		}
		
		for(int v = 0 ; v < biases[0].length ; v += 1) {
			biases[0][v] += (-0.001 * dbiases[v]);
		}
		
		
		System.out.println(Arrays.toString(biases[0]));
		
		
		
		
		
		
		
	}

}
