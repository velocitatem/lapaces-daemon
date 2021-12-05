package velo.ladaalpha.fields.astronomy.Objects;

import velo.ladaalpha.fields.astronomy.Atmosphere_Density;
import velo.ladaalpha.fields.astronomy.CelestialObjectComposition;
import velo.ladaalpha.fields.astronomy.Moon;

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
                new CelestialObjectComposition(new Object[][]{{"", 0.0}}),
                735
        );

        // TODO Auto-generated constructor stub
    }

}
