package velo.ladaalpha.fields.astronomy.Objects;

import velo.ladaalpha.fields.astronomy.Atmosphere_Density;
import velo.ladaalpha.fields.astronomy.CelestialObjectComposition;
import velo.ladaalpha.fields.astronomy.Planet;
import velo.ladaalpha.fields.astronomy.PlanetTypes;


// TODO: Auto-generated Javadoc

/**
 * The Class Earth.
 */
public class Earth extends Planet {


    /**
     * Instantiates a new earth.
     */
    public Earth() {
        super(
                6370, //
                23.5,
                new TheSun(),
                PlanetTypes.Terrestrial,
                1,
                0,
                Atmosphere_Density.Dense,
                50,
                -45,
                149597870,
                1,
                new CelestialObjectComposition(new Object[][]{
                        {"Oxygen", 47.0},
                        {"Silicon", 28.0},
                        {"Aluminum", 8.1},
                        {"Iron", 5.0},
                        {"Calcium", 3.6},
                        {"Sodium", 2.8},
                        {"Potassium", 2.6},
                        {"Magnesium", 2.1},
                        {"Others", 0.8}
                }),
                59724
        );
        // TODO Auto-generated constructor stub
    }

}
