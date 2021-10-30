package velo.ladenet.network.elements;

public class Loss {
	public double[] forward(double[][] input, double[][] y) {		
		return null;
	}
	private double[] sample_losses;
	public double calculate(double[][] output, double[][] y) {
		sample_losses  = forward(output, y);
		int i = 0;
		double sum = 0;
		for(double v : sample_losses) {			
			sum+=v;
			i+=1; 
		}
		double mean = sum / i;
		return mean;
	}
}
