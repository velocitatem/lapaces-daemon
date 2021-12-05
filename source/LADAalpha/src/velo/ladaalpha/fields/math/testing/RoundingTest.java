package velo.ladaalpha.fields.math.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.math.LMath;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class RoundingTest.
 */
class RoundingTest {

    /**
     * Test.
     */
    @Test
    void test() {
        double x = 6.12571275125;
        assertEquals(6.125, LMath.round(x, 3));
    }

}
