package velo.ladealpha.fields.astronomy.Objects;

import java.awt.Color;

import velo.ladealpha.fields.astronomy.Star;
import velo.ladealpha.fields.astronomy.StellarSpectrum;

public class TheSun extends Star {
	public TheSun() {
		super(
				0.00001581250734, 
				-26.74, 
				 4.83, 
				 382.8, 
				 Color.WHITE, 
				 695700, 
				 StellarSpectrum.G
			);
	}
}
