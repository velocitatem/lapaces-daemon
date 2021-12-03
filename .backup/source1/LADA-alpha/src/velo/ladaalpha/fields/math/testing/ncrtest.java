package velo.ladaalpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.math.CombinationFormula;
import velo.ladaalpha.fields.math.LMath;

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
		assertEquals(84, (int)CombinationFormula.ncr(9, 6));
	}

}
