package velo.ladaalpha.fields.math.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.math.stats.DistributionDirections;
import velo.ladaalpha.fields.math.stats.Distributions;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class DistributionsTest.
 */
class DistributionsTest {

    /**
     * Test.
     */
    @Test
    void test() {
        double p = Distributions.PDF(1.5, DistributionDirections.LEQ);
        System.out.println(p);
        assertEquals(93, (int) (p * 100));
    }

}
