package velo.ladealpha.fields.astronomy.Objects;

import velo.ladealpha.fields.astronomy.Atmosphere_Density;
import velo.ladealpha.fields.astronomy.CelestialObjectComposition;
import velo.ladealpha.fields.astronomy.Moon;
import velo.ladealpha.fields.astronomy.Planet;

// TODO: Auto-generated Javadoc
/**
 * The Class TheMoon.
 */
public class TheMoon extends Moon {

	/**
	 * Instantiates a new the moon.
	 */
	public TheMoon() {
		super(
				1738,
				new Earth(),
				Atmosphere_Density.Thin,
				120,
				-160,
				384404,
				0.080848734,
				new CelestialObjectComposition(new Object[][] {{"", 0.0}}),
				735
			);
		
		// TODO Auto-generated constructor stub
	}
	
}
