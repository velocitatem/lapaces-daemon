package velo.ladaalpha.fields.astronomy;

// TODO: Auto-generated Javadoc

/**
 * The Class Moon.
 *
 * @author velo
 */
public class Moon extends SpaceObject {

    /**
     * The radius.
     */
    private long radius;

    /**
     * The planet orbitted.
     */
    private Planet planet_orbitted;

    /**
     * The atmosphere density.
     */
    private Atmosphere_Density atmosphere_density;

    /**
     * The min temp c.
     */
    private int max_temp_c, min_temp_c;

    /**
     * The distance to orbitted planet.
     */
    private long distance_to_orbitted_planet;

    /**
     * The time to orbit planet years.
     */
    private double time_to_orbit_planet_years;

    /**
     * The composition.
     */
    private CelestialObjectComposition composition;


    /**
     * Instantiates a new moon.
     *
     * @param radius                      the radius
     * @param planet_orbitted             the planet orbitted
     * @param atmosphere_density          the atmosphere density
     * @param max_temp_c                  the max temp c
     * @param min_temp_c                  the min temp c
     * @param distance_to_orbitted_planet the distance to orbitted planet
     * @param time_to_orbit_planet_years  the time to orbit planet years
     * @param composition                 the composition
     * @param mass                        the mass
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
     * Gets the planet orbitted.
     *
     * @return the planet_orbitted
     */
    public Planet getPlanet_orbitted() {
        return planet_orbitted;
    }

    /**
     * Sets the planet orbitted.
     *
     * @param planet_orbitted the planet_orbitted to set
     */
    public void setPlanet_orbitted(Planet planet_orbitted) {
        this.planet_orbitted = planet_orbitted;
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
     * Gets the distance to orbitted planet.
     *
     * @return the distance_to_orbitted_planet
     */
    public long getDistance_to_orbitted_planet() {
        return distance_to_orbitted_planet;
    }

    /**
     * Sets the distance to orbitted planet.
     *
     * @param distance_to_orbitted_planet the distance_to_orbitted_planet to set
     */
    public void setDistance_to_orbitted_planet(long distance_to_orbitted_planet) {
        this.distance_to_orbitted_planet = distance_to_orbitted_planet;
    }

    /**
     * Gets the time to orbit planet years.
     *
     * @return the time_to_orbit_planet_years
     */
    public double getTime_to_orbit_planet_years() {
        return time_to_orbit_planet_years;
    }

    /**
     * Sets the time to orbit planet years.
     *
     * @param time_to_orbit_planet_years the time_to_orbit_planet_years to set
     */
    public void setTime_to_orbit_planet_years(double time_to_orbit_planet_years) {
        this.time_to_orbit_planet_years = time_to_orbit_planet_years;
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
