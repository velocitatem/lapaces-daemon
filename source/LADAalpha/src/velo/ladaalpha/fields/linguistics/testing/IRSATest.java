package velo.ladaalpha.fields.linguistics.testing;

import org.junit.jupiter.api.Test;
import velo.ladaalpha.fields.linguistics.IRSAtranslator;

import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Auto-generated Javadoc

/**
 * The Class IRSATest.
 */
class IRSATest {

    /**
     * Test.
     */
    @Test
    void test() {
        String code = "BAW", code1 = "2.51";
        String c = IRSAtranslator.convert(code),
                c1 = IRSAtranslator.convert(code1);
        assertTrue(c.equals("Bravo Alpha Whiskey"));
        assertTrue(c1.equals("Two Decimal Five One"));
    }

}
