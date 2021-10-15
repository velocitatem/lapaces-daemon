package velo.ladealpha.fields.astronomy.Objects;

import java.util.ArrayList;
import java.util.HashMap;

import velo.ladealpha.fields.astronomy.Atmosphere_Density;
import velo.ladealpha.fields.astronomy.Planet;
import velo.ladealpha.fields.astronomy.PlanetTypes;
import velo.ladealpha.fields.astronomy.PlanetaryComposition;
import velo.ladealpha.fields.astronomy.SpaceObject;
import velo.ladealpha.fields.astronomy.Star;


public class Earth extends Planet {

	
	public Earth() {
		super(
				6370, // 
				new Star(),
				PlanetTypes.Terrestrial,
				1,
				0,
				Atmosphere_Density.Dense,
				50,
				-45,
				149597870,
				1,
				new PlanetaryComposition(new Object[][] {
					{"Oxygen", 47},
					{"Silicon", 28},
					{"Aluminum", 8.1},
					{"Iron", 5},
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
