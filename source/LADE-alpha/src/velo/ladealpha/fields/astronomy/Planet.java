package velo.ladealpha.fields.astronomy;

public class Planet extends SpaceObject {	
	
	/**
	 * @param radius
	 * @param star_orbitted
	 * @param type
	 * @param moons_n
	 * @param rings_n
	 * @param atmosphere_density
	 * @param max_temp_c
	 * @param min_temp_c
	 * @param distance_to_orbitted_star
	 * @param time_to_orbit_star_relative_to_earth
	 * @param composition
	 */
	public Planet(long radius, Star star_orbitted, PlanetTypes type, int moons_n, int rings_n,
			Atmosphere_Density atmosphere_density, int max_temp_c, int min_temp_c, long distance_to_orbitted_star,
			int time_to_orbit_star_relative_to_earth, PlanetaryComposition composition, long mass) {
		super(mass);
		this.radius = radius;
		this.star_orbitted = star_orbitted;
		this.type = type;
		this.moons_n = moons_n;
		this.rings_n = rings_n;
		this.atmosphere_density = atmosphere_density;
		this.max_temp_c = max_temp_c;
		this.min_temp_c = min_temp_c;
		this.distance_to_orbitted_star = distance_to_orbitted_star;
		this.time_to_orbit_star_relative_to_earth = time_to_orbit_star_relative_to_earth;
		this.composition = composition;
	}
	private long radius;
	private Star star_orbitted;
	private PlanetTypes type;
	private int moons_n;
	private int rings_n;
	private Atmosphere_Density atmosphere_density;
	private int max_temp_c, min_temp_c;
	private long distance_to_orbitted_star;
	private int time_to_orbit_star_relative_to_earth;
	private PlanetaryComposition composition;
	/**
	 * @return the star_orbitted
	 */
	public Star getStar_orbitted() {
		return star_orbitted;
	}
	/**
	 * @param star_orbitted the star_orbitted to set
	 */
	public void setStar_orbitted(Star star_orbitted) {
		this.star_orbitted = star_orbitted;
	}
	/**
	 * @return the type
	 */
	public PlanetTypes getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(PlanetTypes type) {
		this.type = type;
	}
	/**
	 * @return the moons_n
	 */
	public int getMoons_n() {
		return moons_n;
	}
	/**
	 * @param moons_n the moons_n to set
	 */
	public void setMoons_n(int moons_n) {
		this.moons_n = moons_n;
	}
	/**
	 * @return the rings_n
	 */
	public int getRings_n() {
		return rings_n;
	}
	/**
	 * @param rings_n the rings_n to set
	 */
	public void setRings_n(int rings_n) {
		this.rings_n = rings_n;
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
	 * @return the distance_to_orbitted_star
	 */
	public long getDistance_to_orbitted_star() {
		return distance_to_orbitted_star;
	}
	/**
	 * @param distance_to_orbitted_star the distance_to_orbitted_star to set
	 */
	public void setDistance_to_orbitted_star(long distance_to_orbitted_star) {
		this.distance_to_orbitted_star = distance_to_orbitted_star;
	}
	/**
	 * @return the time_to_orbit_star_relative_to_earth
	 */
	public int getTime_to_orbit_star_relative_to_earth() {
		return time_to_orbit_star_relative_to_earth;
	}
	/**
	 * @param time_to_orbit_star_relative_to_earth the time_to_orbit_star_relative_to_earth to set
	 */
	public void setTime_to_orbit_star_relative_to_earth(int time_to_orbit_star_relative_to_earth) {
		this.time_to_orbit_star_relative_to_earth = time_to_orbit_star_relative_to_earth;
	}
	/**
	 * @return the composition
	 */
	public PlanetaryComposition getComposition() {
		return composition;
	}
	/**
	 * @param composition the composition to set
	 */
	public void setComposition(PlanetaryComposition composition) {
		this.composition = composition;
	}
	
}
