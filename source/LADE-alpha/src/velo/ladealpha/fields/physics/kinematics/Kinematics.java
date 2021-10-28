package velo.ladealpha.fields.physics.kinematics;

// TODO: Auto-generated Javadoc
/**
 * The Class Kinematics.
 */
public class Kinematics {
	
	/**
	 * Displacement 1 D.
	 *
	 * @param y2 the y 2
	 * @param y1 the y 1
	 * @return the double
	 */
	public static double Displacement1D(double y2, double y1) {
		return y2-y1;
	}
	
	/**
	 * Displacement 2 D.
	 *
	 * @param deltaX the delta X
	 * @param deltaY the delta Y
	 * @return the double
	 */
	public static double Displacement2D(double deltaX, double deltaY) {
		return Math.sqrt((Math.pow(deltaX, 2)) + (Math.pow(deltaY, 2)));
	}
	
	/**
	 * Delta T.
	 *
	 * @param v_0 the v 0
	 * @param v the v
	 * @param t the t
	 * @return the double
	 */
	public static double DeltaT(double v_0, double v, double t) {
		return (0.5) * (v_0 + v) * t;
	}	
	
	/**
	 * Average speed.
	 *
	 * @param totalDistance the total distance
	 * @param time the time
	 * @return the double
	 */
	public static double averageSpeed(double totalDistance, double time) {
		return totalDistance/time;
	}
	
	/**
	 * Velocity.
	 *
	 * @param initial_velocity the initial velocity
	 * @param acceleration the acceleration
	 * @param time the time
	 * @return the double
	 */
	public static double velocity(double initial_velocity, double acceleration, double time) {
		return initial_velocity + (acceleration * time);
	}
	
	/**
	 * X.
	 *
	 * @param inital_x the inital x
	 * @param initial_velocity the initial velocity
	 * @param time the time
	 * @param acceleration the acceleration
	 * @return the double
	 */
	public static double x(double inital_x, double initial_velocity, double time, double acceleration) {
		return inital_x + initial_velocity*time + (0.5 * acceleration * Math.pow(time, 2));
	}
	
}
