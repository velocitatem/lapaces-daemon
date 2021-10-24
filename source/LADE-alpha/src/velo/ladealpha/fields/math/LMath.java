package velo.ladealpha.fields.math;

public class LMath {
	public static double round(double x, double p) {
		int m = (int) Math.pow(10, p);
		return ((double)(int)(x*m))/m;
	}
}
