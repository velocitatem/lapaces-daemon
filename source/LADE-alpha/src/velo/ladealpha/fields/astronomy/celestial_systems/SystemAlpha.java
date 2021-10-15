package velo.ladealpha.fields.astronomy.celestial_systems;

import velo.ladealpha.fields.astronomy.Constants;
import velo.ladealpha.fields.astronomy.SpaceObject;
import velo.ladealpha.fields.astronomy.Objects.*;

public class SystemAlpha {
	private TheMoon theMoon = new TheMoon();
	private Earth earth = new Earth();
	
	public double getOrbitsOfMoonForDayOfYear(double day) {
		return (day / (theMoon.getTime_to_orbit_planet_years() * Constants.days_in_year));
	}
	
	public double radiansOfDifferenceAfterNDays(double n) {
		double c = (theMoon.getTime_to_orbit_planet_years() * Constants.days_in_year);
		return 	((getOrbitsOfMoonForDayOfYear(n) % 1)) * (Math.PI * 2) ;
	}
	
}
