package velo.ladealpha.main;

import velo.ladealpha.fields.astronomy.celestial_systems.SystemAlpha;

public class Main {

	public static void main(String[] args) {
		SystemAlpha sysA = new SystemAlpha();
		System.out.println(sysA.radiansOfDifferenceAfterNDays(165));
	}
}
