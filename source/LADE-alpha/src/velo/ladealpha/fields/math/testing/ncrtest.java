package velo.ladealpha.fields.math.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import velo.ladealpha.fields.math.CombinationFormula;
import velo.ladealpha.fields.math.LMath;

class ncrtest {

	@Test
	void test() {
		assertEquals(84, (int)CombinationFormula.ncr(9, 6));
	}

}
