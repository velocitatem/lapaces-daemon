package velo.ladealpha.fields.astronomy;

/**
 * @author velo
 *
 */
public class Moon extends SpaceObject {
	private long radius;
	private Planet planet_orbitted;
	private Atmosphere_Density atmosphere_density;
	private int max_temp_c, min_temp_c;
	private long distance_to_orbitted_planet;
	private double time_to_orbit_planet_years;
	private CelestialObjectComposition composition;
	
	
	/**
	 * @param radius
	 * @param planet_orbitted
	 * @param atmosphere_density
	 * @param max_temp_c
	 * @param min_temp_c
	 * @param distance_to_orbitted_planet
	 * @param time_to_orbit_planet_years
	 * @param composition
	 * @param mass
	 */
	public Moon(long radius, Planet planet_orbitted, Atmosphere_Density atmosphere_density, int max_temp_c,
			int min_temp_c, long distance_to_orbitted_planet, double time_to_orbit_planet_years,
			CelestialObjectComposition composition, long mass) {
		super(mass);
		this.radius = radius;
		this.planet_orbitted = planet_orbitted;
		this.atmosphere_density = atmosphere_density;
		this.max_temp_c = max_temp_c;
		this.min_temp_c = min_temp_c;
		this.distance_to_orbitted_planet = distance_to_orbitted_planet;
		this.time_to_orbit_planet_years = time_to_orbit_planet_years;
		this.composition = composition;
	}
	/**
	 * @return the radius
	 */
	public long getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(long radius) {
		this.radius = radius;
	}
	/**
	 * @return the planet_orbitted
	 */
	public Planet getPlanet_orbitted() {
		return planet_orbitted;
	}
	/**
	 * @param planet_orbitted the planet_orbitted to set
	 */
	public void setPlanet_orbitted(Planet planet_orbitted) {
		this.planet_orbitted = planet_orbitted;
	}
	/**
	 * @return the atmosphere_density
	 */
	public Atmosphere_Density getAtmosphere_density() {
		return atmosphere_density;
	}
	/**
	 * @param atmosphere_density the atmosphere_density to set
	 */
	public void setAtmosphere_density(Atmosphere_Density atmosphere_density) {
		this.atmosphere_density = atmosphere_density;
	}
	/**
	 * @return the max_temp_c
	 */
	public int getMax_temp_c() {
		return max_temp_c;
	}
	/**
	 * @param max_temp_c the max_temp_c to set
	 */
	public void setMax_temp_c(int max_temp_c) {
		this.max_temp_c = max_temp_c;
	}
	/**
	 * @return the min_temp_c
	 */
	public int getMin_temp_c() {
		return min_temp_c;
	}
	/**
	 * @param min_temp_c the min_temp_c to set
	 */
	public void setMin_temp_c(int min_temp_c) {
		this.min_temp_c = min_temp_c;
	}
	/**
	 * @return the distance_to_orbitted_planet
	 */
	public long getDistance_to_orbitted_planet() {
		return distance_to_orbitted_planet;
	}
	/**
	 * @param distance_to_orbitted_planet the distance_to_orbitted_planet to set
	 */
	public void setDistance_to_orbitted_planet(long distance_to_orbitted_planet) {
		this.distance_to_orbitted_planet = distance_to_orbitted_planet;
	}
	/**
	 * @return the time_to_orbit_planet_years
	 */
	public double getTime_to_orbit_planet_years() {
		return time_to_orbit_planet_years;
	}
	/**
	 * @param time_to_orbit_planet_years the time_to_orbit_planet_years to set
	 */
	public void setTime_to_orbit_planet_years(double time_to_orbit_planet_years) {
		this.time_to_orbit_planet_years = time_to_orbit_planet_years;
	}
	/**
	 * @return the composition
	 */
	public CelestialObjectComposition getComposition() {
		return composition;
	}
	/**
	 * @param composition the composition to set
	 */
	public void setComposition(CelestialObjectComposition composition) {
		this.composition = composition;
	}
	
}
