package velo.ladealpha.fields.astronomy.celestial_systems;

import java.util.ArrayList;
import java.util.Date;

import velo.ladealpha.fields.astronomy.Constants;
import velo.ladealpha.fields.astronomy.SpaceObject;
import velo.ladealpha.fields.astronomy.Objects.*;
import velo.ladealpha.main.IMod;

// TODO: Auto-generated Javadoc
/**
 * The Class SystemAlpha.
 */
public class SystemAlpha extends CelestialSystem {
	
	/** The moon. */
	private TheMoon theMoon = new TheMoon();
	
	/** The earth. */
	private Earth earth = new Earth();
	
	/** The sun. */
	private TheSun theSun = new TheSun();	
	
	
	
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
		return 	((getOrbitsOfMoonForDayOfYear(n) % 1)) * (Math.PI * 2) ;
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
