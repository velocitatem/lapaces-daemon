 package velo.ladaalpha.misc;

public class MkArray {
	public static double[] IncrementalDoubleArray(int start, int end) {
		double[] out = new double[end-start+1];
		for(int i = start; i < end ; i+=1) {
			out[i] = 1.0*i;
		}
		return out;
	}
}
