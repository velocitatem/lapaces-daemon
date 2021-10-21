package velo.ladealpha.fields.physics.kinematics;

public class Kinematics {
	public static double Displacement1D(double y2, double y1) {
		return y2-y1;
	}
	public static double Displacement2D(double deltaX, double deltaY) {
		return Math.sqrt((Math.pow(deltaX, 2)) + (Math.pow(deltaY, 2)));
	}
	public static double DeltaT(double v_0, double v, double t) {
		return (0.5) * (v_0 + v) * t;
	}	
	public static double averageSpeed(double totalDistance, double time) {
		return totalDistance/time;
	}
	public static double velocity(double initial_velocity, double acceleration, double time) {
		return initial_velocity + (acceleration * time);
	}
	public static double x(double inital_x, double initial_velocity, double time, double acceleration) {
		return inital_x + initial_velocity*time + (0.5 * acceleration * Math.pow(time, 2));
	}
	
}
