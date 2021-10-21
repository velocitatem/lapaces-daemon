package velo.ladealpha.fields.physics;

public class ComplexVector {
	private double A_x, A_y;
	private static double mod = 180/Math.PI; 
	public ComplexVector(double a_x, double a_y) {
		super();
		A_x = a_x;
		A_y = a_y;
	}
	public double getMagnitude() {
		return Math.sqrt(Math.pow(A_x, 2) + Math.pow(A_y, 2));
	}
	public static ComplexVector vectorGivenThetaAndMagnitude(double theta_radians, double magnitude) {
		double x = magnitude * (Math.cos(theta_radians)), y = magnitude * Math.sin(theta_radians);
		ComplexVector cvr = new ComplexVector(x, y);
		return cvr;
	}
	public double ThetaRadians() {
		return Math.atan(A_y/A_x);
	}	
	public double ThetaDegrees() {
		return ThetaRadians()*mod;
	}
}
