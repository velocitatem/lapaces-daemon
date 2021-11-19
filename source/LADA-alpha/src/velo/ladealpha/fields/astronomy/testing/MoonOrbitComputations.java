package velo.ladealpha.fields.astronomy.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.astronomy.celestial_systems.SystemAlpha;

class MoonOrbitComputations {

	@Test
	void test() {
		SystemAlpha sysA = new SystemAlpha();
		assertEquals((int)sysA.getOrbitsOfMoonForDayOfYear(30), 1);
		assertEquals((int)sysA.radiansOfDifferenceAfterNDays(30), 0);
		assertEquals((int)sysA.radiansOfDifferenceAfterNDays(60), 0);
	}

}
