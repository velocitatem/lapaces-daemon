package velo.ladealpha.fields.astronomy.celestial_systems;

import velo.ladealpha.fields.astronomy.SpaceObject;
import velo.ladealpha.fields.astronomy.Objects.*;

public class SystemAlpha {
	private TheMoon theMoon = new TheMoon();
	private Earth earth = new Earth();
	
	public double getOrbitsOfMoonForDayOfYear(int day) {
		return (day / (theMoon.getTime_to_orbit_planet_years() * 365.25));
	}
	
	public double radiansOfDifferenceAfterNDays(int n) {
		return (
				
				getOrbitsOfMoonForDayOfYear(n) 
				
				% 
				
				(theMoon.getTime_to_orbit_planet_years() * 365.25)
				
				) / (2*Math.PI);
	}
	
}
