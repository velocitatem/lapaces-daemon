package velo.ladanet.network.elements;

import java.util.ArrayList;
import java.util.Arrays;

public class Accuracy {
	public static double accuracy(double[][] output, double[][] y) {
		ArrayList<Integer> indecies = new ArrayList<Integer>(), indeciesY = new ArrayList<Integer>();
		for(double[] row : output) {
			int maxIndex = -1;
			Double maxVal = Double.NEGATIVE_INFINITY;
			int i = 0;
			for(double val : row) {
				if(val > maxVal) {
					maxVal = val;
					maxIndex = i;
				}
				i+=1;
			}
			indecies.add(maxIndex);
		}
		for(double[] row : y) {
			int maxIndex = -1;
			Double maxVal = Double.NEGATIVE_INFINITY;
			int i = 0;
			for(double val : row) {
				if(val > maxVal) {
					maxVal = val;
					maxIndex = i;
				}
				i+=1;
			}			
			indeciesY.add(maxIndex);
		}		
		int c = 0, i = 0;
		for(Integer index : indecies) {
			if(index==indeciesY.get(i)) {
				c+=1;
			}
			i+=1;
		}
		return (double)c/(double)i;
	}
}
