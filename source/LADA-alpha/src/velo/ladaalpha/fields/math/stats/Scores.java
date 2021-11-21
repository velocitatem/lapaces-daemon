package velo.ladaalpha.fields.math.stats;

public class Scores {
	public static double zScore(double x, double mu, double sigma) {
		return (x-mu) / sigma;
	}
}
