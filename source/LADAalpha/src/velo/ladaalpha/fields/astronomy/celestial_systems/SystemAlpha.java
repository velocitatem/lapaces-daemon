package velo.ladaalpha.fields.astronomy.celestial_systems;

import velo.ladaalpha.fields.astronomy.Constants;
import velo.ladaalpha.fields.astronomy.Objects.Earth;
import velo.ladaalpha.fields.astronomy.Objects.TheMoon;
import velo.ladaalpha.fields.astronomy.Objects.TheSun;

// TODO: Auto-generated Javadoc

/**
 * The Class SystemAlpha.
 */
public class SystemAlpha extends CelestialSystem {

    /**
     * The moon.
     */
    private final TheMoon theMoon = new TheMoon();

    /**
     * The earth.
     */
    private final Earth earth = new Earth();

    /**
     * The sun.
     */
    private final TheSun theSun = new TheSun();


    /**
     * Gets the orbits of moon for day of year.
     *
     * @param day the day
     * @return the orbits of moon for day of year
     */
    public double getOrbitsOfMoonForDayOfYear(double day) {
        return (day / (theMoon.getTime_to_orbit_planet_years() * Constants.days_in_year));
    }

    /**
     * Radians of difference after N days.
     *
     * @param n the n
     * @return the double
     */
    public double radiansOfDifferenceAfterNDays(double n) {
        double c = (theMoon.getTime_to_orbit_planet_years() * Constants.days_in_year);
        return ((getOrbitsOfMoonForDayOfYear(n) % 1)) * (Math.PI * 2);
    }

    /**
     * Radians relative to J solstice.
     *
     * @param day the day
     * @return the double
     */
    public double radiansRelativeToJSolstice(double day) {

        return 0;
    }


}
