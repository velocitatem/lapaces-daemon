package velo.ladaalpha.fields.math.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.math.CombinationFormula;

import static org.junit.jupiter.api.Assertions.assertEquals;

// TODO: Auto-generated Javadoc

/**
 * The Class ncrtest.
 */
class ncrtest {

    /**
     * Test.
     */
    @Test
    void test() {
        assertEquals(84, (int) CombinationFormula.ncr(9, 6));
    }

}
