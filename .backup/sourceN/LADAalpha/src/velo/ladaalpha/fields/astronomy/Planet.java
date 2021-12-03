package velo.ladaalpha.fields.astronomy;

// TODO: Auto-generated Javadoc
/**
 * The Class Planet.
 */
public class Planet extends SpaceObject {	
	
	/**
	 * The radius.
	 *
	 */
	

	private long radius;
	
	/**
	 * Instantiates a new planet.
	 *
	 * @param radius the radius
	 * @param tilt the tilt
	 * @param star_orbitted the star orbitted
	 * @param type the type
	 * @param moons_n the moons n
	 * @param rings_n the rings n
	 * @param atmosphere_density the atmosphere density
	 * @param max_temp_c the max temp c
	 * @param min_temp_c the min temp c
	 * @param distance_to_orbitted_star the distance to orbitted star
	 * @param time_to_orbit_star_years the time to orbit star years
	 * @param composition the composition
	 * @param mass the mass
	 */
	public Planet(long radius, double tilt, Star star_orbitted, PlanetTypes type, int moons_n, int rings_n,
			Atmosphere_Density atmosphere_density, int max_temp_c, int min_temp_c, long distance_to_orbitted_star,
			int time_to_orbit_star_years, CelestialObjectComposition composition, long mass) {		
		super(mass);
		this.radius = radius;
		this.tilt = tilt;
		this.star_orbitted = star_orbitted;
		this.type = type;
		this.moons_n = moons_n;
		this.rings_n = rings_n;
		this.atmosphere_density = atmosphere_density;
		this.max_temp_c = max_temp_c;
		this.min_temp_c = min_temp_c;
		this.distance_to_orbitted_star = distance_to_orbitted_star;
		this.time_to_orbit_star_years = time_to_orbit_star_years;
		this.composition = composition;
	}
	
	/** The tilt. */
	private double tilt;
	
	/** The star orbitted. */
	private Star star_orbitted;
	
	/** The type. */
	private PlanetTypes type;
	
	/** The moons n. */
	private int moons_n;
	
	/** The rings n. */
	private int rings_n;
	
	/** The atmosphere density. */
	private Atmosphere_Density atmosphere_density;
	
	/** The min temp c. */
	private int max_temp_c, min_temp_c;
	
	/** The distance to orbitted star. */
	private long distance_to_orbitted_star;
	
	/** The time to orbit star years. */
	private int time_to_orbit_star_years;
	
	/** The composition. */
	private CelestialObjectComposition composition;
	
	/**
	 * Gets the radius.
	 *
	 * @return the radius
	 */
	public long getRadius() {
		return radius;
	}
	
	/**
	 * Sets the radius.
	 *
	 * @param radius the radius to set
	 */
	public void setRadius(long radius) {
		this.radius = radius;
	}
	
	/**
	 * Gets the tilt.
	 *
	 * @return the tilt
	 */
	public double getTilt() {
		return tilt;
	}
	
	/**
	 * Sets the tilt.
	 *
	 * @param tilt the tilt to set
	 */
	public void setTilt(double tilt) {
		this.tilt = tilt;
	}
	
	/**
	 * Gets the star orbitted.
	 *
	 * @return the star_orbitted
	 */
	public Star getStar_orbitted() {
		return star_orbitted;
	}
	
	/**
	 * Sets the star orbitted.
	 *
	 * @param star_orbitted the star_orbitted to set
	 */
	public void setStar_orbitted(Star star_orbitted) {
		this.star_orbitted = star_orbitted;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public PlanetTypes getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(PlanetTypes type) {
		this.type = type;
	}
	
	/**
	 * Gets the moons n.
	 *
	 * @return the moons_n
	 */
	public int getMoons_n() {
		return moons_n;
	}
	
	/**
	 * Sets the moons n.
	 *
	 * @param moons_n the moons_n to set
	 */
	public void setMoons_n(int moons_n) {
		this.moons_n = moons_n;
	}
	
	/**
	 * Gets the rings n.
	 *
	 * @return the rings_n
	 */
	public int getRings_n() {
		return rings_n;
	}
	
	/**
	 * Sets the rings n.
	 *
	 * @param rings_n the rings_n to set
	 */
	public void setRings_n(int rings_n) {
		this.rings_n = rings_n;
	}
	
	/**
	 * Gets the atmosphere density.
	 *
	 * @return the atmosphere_density
	 */
	public Atmosphere_Density getAtmosphere_density() {
		return atmosphere_density;
	}
	
	/**
	 * Sets the atmosphere density.
	 *
	 * @param atmosphere_density the atmosphere_density to set
	 */
	public void setAtmosphere_density(Atmosphere_Density atmosphere_density) {
		this.atmosphere_density = atmosphere_density;
	}
	
	/**
	 * Gets the max temp c.
	 *
	 * @return the max_temp_c
	 */
	public int getMax_temp_c() {
		return max_temp_c;
	}
	
	/**
	 * Sets the max temp c.
	 *
	 * @param max_temp_c the max_temp_c to set
	 */
	public void setMax_temp_c(int max_temp_c) {
		this.max_temp_c = max_temp_c;
	}
	
	/**
	 * Gets the min temp c.
	 *
	 * @return the min_temp_c
	 */
	public int getMin_temp_c() {
		return min_temp_c;
	}
	
	/**
	 * Sets the min temp c.
	 *
	 * @param min_temp_c the min_temp_c to set
	 */
	public void setMin_temp_c(int min_temp_c) {
		this.min_temp_c = min_temp_c;
	}
	
	/**
	 * Gets the distance to orbitted star.
	 *
	 * @return the distance_to_orbitted_star
	 */
	public long getDistance_to_orbitted_star() {
		return distance_to_orbitted_star;
	}
	
	/**
	 * Sets the distance to orbitted star.
	 *
	 * @param distance_to_orbitted_star the distance_to_orbitted_star to set
	 */
	public void setDistance_to_orbitted_star(long distance_to_orbitted_star) {
		this.distance_to_orbitted_star = distance_to_orbitted_star;
	}
	
	/**
	 * Gets the time to orbit star years.
	 *
	 * @return the time_to_orbit_star_years
	 */
	public int getTime_to_orbit_star_years() {
		return time_to_orbit_star_years;
	}
	
	/**
	 * Sets the time to orbit star years.
	 *
	 * @param time_to_orbit_star_years the time_to_orbit_star_years to set
	 */
	public void setTime_to_orbit_star_years(int time_to_orbit_star_years) {
		this.time_to_orbit_star_years = time_to_orbit_star_years;
	}
	
	/**
	 * Gets the composition.
	 *
	 * @return the composition
	 */
	public CelestialObjectComposition getComposition() {
		return composition;
	}
	
	/**
	 * Sets the composition.
	 *
	 * @param composition the composition to set
	 */
	public void setComposition(CelestialObjectComposition composition) {
		this.composition = composition;
	}
	
}
