package velo.ladenet.network.elements;

public class Loss {
	public double[][] forward(double[][] input, double[] y) {
		
		return null;
	}
	private double[][] sample_losses;
	public void calculate(double[][] output, double[] y) {
		sample_losses  = forward(output, y);
	}
}
