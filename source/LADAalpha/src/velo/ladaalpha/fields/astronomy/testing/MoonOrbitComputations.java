package velo.ladaalpha.fields.astronomy.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.astronomy.celestial_systems.SystemAlpha;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class MoonOrbitComputations.
 */
class MoonOrbitComputations {

    /**
     * Test.
     */
    @Test
    void test() {
        SystemAlpha sysA = new SystemAlpha();
        assertEquals((int) sysA.getOrbitsOfMoonForDayOfYear(30), 1);
        assertEquals((int) sysA.radiansOfDifferenceAfterNDays(30), 0);
        assertEquals((int) sysA.radiansOfDifferenceAfterNDays(60), 0);
    }

}
