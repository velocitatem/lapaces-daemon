package velo.ladaalpha.fields.linguistics.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.linguistics.IRSAtranslator;

class IRSATest {

	@Test
	void test() {
		String code = "BAW", code1 = "2.51";
		String c = IRSAtranslator.convert(code),
				c1 =  IRSAtranslator.convert(code1);
		assertTrue(c.equals("Bravo Alpha Whiskey"));
		assertTrue(c1.equals("Two Decimal Five One"));
	}

}
